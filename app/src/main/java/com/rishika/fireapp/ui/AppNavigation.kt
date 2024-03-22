package com.rishika.fireapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rishika.fireapp.ui.screens.login.LoginScreen
import com.rishika.fireapp.ui.screens.login.LoginViewModel
import com.rishika.fireapp.ui.screens.register.RegisterScreen
import com.rishika.fireapp.ui.screens.register.RegisterViewModel

enum class Screen(val route: String){
    Home("home"),
    Login("login"),
    Register("register"),
    Notes("notes"),
    Document("documents")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            val vm: LoginViewModel = viewModel()
            LoginScreen(state = vm.state.collectAsState().value, onEvent = vm::onEvent)
        }
        composable(Screen.Register.route){
            val vm: RegisterViewModel = viewModel()
            RegisterScreen(state = vm.state.collectAsState().value, onEvent = vm::onEvent)
        }
        composable(Screen.Home.route){

        }
        composable(Screen.Notes.route){

        }
        composable(Screen.Document.route){

        }

    }
}