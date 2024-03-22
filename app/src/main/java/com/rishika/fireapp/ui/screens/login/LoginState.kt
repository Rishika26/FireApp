package com.rishika.fireapp.ui.screens.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    var error: String = "",
    var isLoading: Boolean = false,
    var isLoginSuccess: Boolean = false
)
