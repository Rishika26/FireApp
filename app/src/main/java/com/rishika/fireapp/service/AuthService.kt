package com.rishika.fireapp.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.rishika.fireapp.ui.screens.login.LoginState
import com.rishika.fireapp.ui.screens.register.RegisterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class AuthService(
    private val auth: FirebaseAuth = Firebase.auth,
) {
    fun login(state: MutableStateFlow<LoginState>) {
        auth.signInWithEmailAndPassword(state.value.email, state.value.password)
            .addOnFailureListener {
                state.update { state ->
                    state.copy(error = it.message ?: "An error occured", isLoading = false)
                }
            }.addOnSuccessListener {
                state.update { state ->
                    state.copy(isLoginSuccess = true, isLoading = false, error = "")
                }
            }
    }

    fun register(state: MutableStateFlow<RegisterState>) {
        auth.createUserWithEmailAndPassword(state.value.email, state.value.password)
            .addOnFailureListener {
                state.update { state ->
                    state.copy(error = it.message ?: "An error occured", isLoading = false)
                }
            }.addOnSuccessListener {
                state.update { state ->
                    state.copy(isRegisterSuccess = true, isLoading = false, error = "")
                }
                val profileUpdates = userProfileChangeRequest { displayName = state.value.username }
                it.user?.updateProfile(profileUpdates)
            }

    }

    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }

    fun logout() {
        auth.signOut()
    }

}

