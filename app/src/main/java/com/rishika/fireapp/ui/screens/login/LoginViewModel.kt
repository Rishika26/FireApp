package com.rishika.fireapp.ui.screens.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel():ViewModel(){
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onEvent(event: LoginEvent){
        when(event){
            LoginEvent.OnLogin -> TODO()
            LoginEvent.OnNavigateToRegister -> TODO()
            is LoginEvent.SetEmail -> TODO()
            is LoginEvent.SetPassword -> TODO()
        }
    }
}
