package ru.trinitydigital.errorhandling.ui

import androidx.lifecycle.MutableLiveData
import ru.trinitydigital.errorhandling.common.BaseViewModel
import ru.trinitydigital.errorhandling.data.model.ProfileModel
import ru.trinitydigital.errorhandling.data.repository.SamboRepository

class MainViewModel(private val repository: SamboRepository) : BaseViewModel() {

    val user = MutableLiveData<ProfileModel>()

    fun loadUser() {
        handleRequest {
            val result = repository.loadUserProfile()
            user.postValue(result)
        }
    }
}