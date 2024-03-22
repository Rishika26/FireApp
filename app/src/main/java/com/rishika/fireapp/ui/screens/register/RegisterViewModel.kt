package com.rishika.fireapp.ui.screens.register

import androidx.lifecycle.ViewModel
import com.rishika.fireapp.service.AuthService
import com.rishika.fireapp.ui.screens.login.LoginEvent
import com.rishika.fireapp.ui.screens.login.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel(): ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()
    private val authService = AuthService()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            RegisterEvent.OnNavigateToLogin -> TODO()
            RegisterEvent.OnSaveUser -> {
                authService.register(state.value)
            }
            is RegisterEvent.SetConfirmPassword -> {
                _state.update { it.copy(confirmPassword = event.confirmPassword) }
            }
            is RegisterEvent.SetEmail -> {
                _state.update { it.copy(email = event.email) }
            }
            is RegisterEvent.SetPassword -> {
                _state.update { it.copy(password = event.password) }
            }
            is RegisterEvent.SetUsername -> {
                _state.update { it.copy(username = event.username) }
            }
        }
    }
}
