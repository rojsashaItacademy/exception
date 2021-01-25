package ru.trinitydigital.errorhandling.common

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.trinitydigital.errorhandling.common.ErrorTypes.*

abstract class BaseActivity : AppCompatActivity() {

    protected fun setupViewModel(vm: BaseViewModel?) {
        vm?.errorData?.observe(this, { error ->
            when (error) {
                IO_ERROR -> ioException()
                NETWORK_FAILED -> networkException()
                AUTH_ERROR -> authException()
                else -> {
                }
            }

        })
    }

    fun ioException() {
        Toast.makeText(this, "network error", Toast.LENGTH_LONG).show()
    }

    fun authException() {
        Toast.makeText(this, "auth", Toast.LENGTH_LONG).show()
    }

    fun networkException() {
        Toast.makeText(this, "network error", Toast.LENGTH_LONG).show()
    }
}