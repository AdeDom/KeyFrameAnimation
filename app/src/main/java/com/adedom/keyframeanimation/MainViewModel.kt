package com.adedom.keyframeanimation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class MainState(
    val isLayout: Boolean = true,
)

class MainViewModel : ViewModel() {

    private val _state = MutableLiveData<MainState>().apply { value = MainState() }
    val state: LiveData<MainState>
        get() = _state

    fun changeLayout() {
        setState { copy(isLayout = !isLayout) }
    }

    private fun setState(reducer: MainState.() -> MainState) {
        _state.value = _state.value?.reducer()
    }

}
