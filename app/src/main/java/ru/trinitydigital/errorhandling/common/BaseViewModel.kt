package ru.trinitydigital.errorhandling.common

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import retrofit2.HttpException
import ru.trinitydigital.errorhandling.data.model.ResultWrapper
import java.io.IOException
import java.net.UnknownHostException

abstract class BaseViewModel : ViewModel() {

    public val errorData = MutableLiveData<ErrorTypes>()

    protected val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        run {
            when (exception) {
                is UnknownHostException -> errorData.postValue(ErrorTypes.NETWORK_FAILED)
                is IOException -> errorData.postValue(ErrorTypes.IO_ERROR)
                is HttpException -> {
                    if (exception.code() == 401) {
                        errorData.postValue(ErrorTypes.AUTH_ERROR)
                    }
                }
            }
        }
    }

    protected fun handleRequest(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        listener: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch(dispatcher + exceptionHandler) {
            try {
                listener.invoke(this)
            } catch (t: Throwable) {
                exceptionHandler.handleException(dispatcher, t)
                t.printStackTrace()
            }
        }
    }
}

enum class ErrorTypes() {
    NETWORK_FAILED,
    IO_ERROR,
    AUTH_ERROR
}

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apicall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apicall.invoke())
        } catch (t: Throwable) {
            when (t) {
                is HttpException -> {
                    val code = t.code()
                    val message = t.message()
                    ResultWrapper.HttpError(code, message)
                }
                is IOException -> ResultWrapper.NetworkError
                else -> ResultWrapper.HttpError(null, null)
            }
        }
    }
}