package com.rishika.fireapp.ui.screens.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val error: String = "",
    val isLoading: Boolean = false,
    val isLoginSuccess: Boolean = false
)
