package ru.trinitydigital.errorhandling.di

import org.koin.androidx.viewmodel.dsl.viewModel
import ru.trinitydigital.errorhandling.data.interactors.SamboInteractor
import ru.trinitydigital.errorhandling.data.interactors.SamboInteractorImpl
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.trinitydigital.errorhandling.data.remote.CoursesService
import ru.trinitydigital.errorhandling.data.remote.RetrofitBuilder
import ru.trinitydigital.errorhandling.data.repository.SamboRepository
import ru.trinitydigital.errorhandling.data.repository.SamboRepositoryImpl
import ru.trinitydigital.errorhandling.ui.MainViewModel


val viewModelModule: Module = module {
    viewModel { MainViewModel(get()) }
}


val repositoryModule: Module = module {
    single<SamboRepository> { SamboRepositoryImpl(get()) }
}

val apiModule: Module = module {
    single<CoursesService> { RetrofitBuilder.buildRetrofit() }
    single<SamboInteractor> { SamboInteractorImpl(get()) }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)