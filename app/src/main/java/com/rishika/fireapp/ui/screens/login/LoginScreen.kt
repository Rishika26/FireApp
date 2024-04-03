package com.rishika.fireapp.ui.screens.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    state: LoginState = LoginState(),
    onEvent: (LoginEvent) -> Unit = {},
    onNavigateToRegister: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
) {
    if (state.isLoginSuccess) {
        onNavigateToHome()
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.onPrimary,
                    MaterialTheme.colorScheme.primaryContainer,
                )
            )
        ),
        contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Login to Fire App", style = MaterialTheme.typography.headlineMedium)
            AnimatedVisibility(visible = state.error.isNotBlank()) {
                Text(text = state.error, color = Color.Red)

            }
            OutlinedTextField(value = state.email,
                onValueChange = {onEvent(LoginEvent.SetEmail(it))},
                placeholder = { Text("Email")}
            )

            OutlinedTextField(value = state.password,
                onValueChange = {onEvent(LoginEvent.SetPassword(it))},
                placeholder = { Text("Password")}
            )

            ElevatedButton(onClick = { onEvent(LoginEvent.OnLogin) },
                modifier = Modifier
                    .align(Alignment.Start)
                    .width(120.dp),
                shape = MaterialTheme.shapes.extraSmall,
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                enabled = !state.isLoading,
            ) {
                Text(text = "Login")
            }

            Row {
                Text(text = "Don't have an account?")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Register",
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.clickable { onNavigateToRegister() }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}