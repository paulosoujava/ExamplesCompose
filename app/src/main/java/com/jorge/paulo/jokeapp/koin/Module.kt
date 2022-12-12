package com.jorge.paulo.jokeapp.koin

import com.jorge.paulo.jokeapp.funcionalUseCase.GetSomeModelUseCase
import com.jorge.paulo.jokeapp.funcionalUseCase.SomeModelRepository
import org.koin.dsl.module

val appModule = module {

    single<GetSomeModelUseCase> {
        get<SomeModelRepository>()::getSomeModels
    }
}