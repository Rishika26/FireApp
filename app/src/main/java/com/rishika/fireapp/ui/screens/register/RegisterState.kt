package com.rishika.fireapp.ui.screens.register

data class RegisterState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val username: String = "",
    var error: String = "",
    var isLoading: Boolean = false,
    var isRegisterSuccess: Boolean = false,
)
