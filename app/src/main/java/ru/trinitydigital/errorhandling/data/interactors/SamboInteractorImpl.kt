package ru.trinitydigital.errorhandling.data.interactors

import retrofit2.Response
import ru.trinitydigital.errorhandling.data.model.ProfileModel
import ru.trinitydigital.errorhandling.data.remote.CoursesService

interface SamboInteractor {

    suspend fun loadUserProfile(): ProfileModel?
}

class SamboInteractorImpl(private val service: CoursesService) : SamboInteractor {
    override suspend fun loadUserProfile(): ProfileModel? {
        return service.loadUserProfile()
    }
}