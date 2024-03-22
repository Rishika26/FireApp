package com.rishika.fireapp.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.rishika.fireapp.ui.screens.login.LoginState
import com.rishika.fireapp.ui.screens.register.RegisterState

class AuthService(
    private val auth: FirebaseAuth = Firebase.auth,
) {
    fun login(state: LoginState) {
        auth.signInWithEmailAndPassword(state.email, state.password)
            .addOnFailureListener {
                state.error = it.message ?: "An error occured"
                state.isLoading = false
            }.addOnSuccessListener {
                state.isLoading = false
                state.error = ""
                state.isLoginSuccess = true
            }
    }

    fun register(state: RegisterState) {
        auth.createUserWithEmailAndPassword(state.email, state.password)
            .addOnFailureListener {
                state.error = it.message ?: "An error occured"
                state.isLoading = false
            }.addOnSuccessListener {
                state.isLoading = false
                state.error = ""
                state.isRegisterSuccess = true
                val profileUpdates = userProfileChangeRequest { displayName = state.username }
                it.user?.updateProfile(profileUpdates)
            }

    }

    fun isUserLoggedIn():Boolean{
        return auth.currentUser != null
    }

}
