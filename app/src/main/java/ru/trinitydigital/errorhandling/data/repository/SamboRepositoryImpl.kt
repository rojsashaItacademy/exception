package ru.trinitydigital.errorhandling.data.repository

import retrofit2.Response
import ru.trinitydigital.errorhandling.data.interactors.SamboInteractor
import ru.trinitydigital.errorhandling.data.model.ProfileModel


interface SamboRepository {
    suspend fun loadUserProfile():ProfileModel?

}

class SamboRepositoryImpl(private val network: SamboInteractor) : SamboRepository {
    override suspend fun loadUserProfile(): ProfileModel? {
        return network.loadUserProfile()
    }

}