package com.jorge.paulo.jokeapp.funcionalUseCase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class SomeModel(val id: String, val name: String)

data class Answer<T, U>(val list: List<T>, val str: U)


interface SomeModelRepository {
    suspend fun getSomeModels()= SomeModel("12", "TESTE")
}

typealias GetSomeModelUseCase = suspend () -> SomeModel
fun provideViewModel(someModelRepository: SomeModelRepository): SomeViewModel {
    return SomeViewModel(someModelRepository::getSomeModels)
}
class SomeViewModel(private val  getSomeModelUseCase: GetSomeModelUseCase) : ViewModel() {
    fun load() {
        viewModelScope.launch {
            val result = getSomeModelUseCase()
            // Do something with the result
        }
    }
}