package com.rishika.fireapp.ui.screens.register

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rishika.fireapp.ui.screens.login.LoginEvent
import com.rishika.fireapp.ui.screens.login.LoginScreen
import com.rishika.fireapp.ui.screens.login.LoginState

@Composable
fun RegisterScreen(
    state: RegisterState = RegisterState(),
    onEvent: (RegisterEvent) -> Unit = {},
    onBack: () -> Unit = {},
) {
    if (state.isRegisterSuccess){
        onBack()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            IconButton(onClick = { onBack() },
                modifier = Modifier.background(
                    MaterialTheme.colorScheme.onTertiary,
                    MaterialTheme.shapes.small
                )
                ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                
            }
            Text(text = "Create free account", style = MaterialTheme.typography.headlineMedium)
            AnimatedVisibility(visible = state.error.isNotBlank()) {
                Text(text = state.error, color = Color.Red)

            }
            OutlinedTextField(
                value = state.email,
                onValueChange = {onEvent(RegisterEvent.SetEmail(it))},
                placeholder = { Text("Email")},
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null)}
                )

            OutlinedTextField(
                value = state.username,
                onValueChange = {onEvent(RegisterEvent.SetUsername(it))},
                placeholder = { Text("Username")},
                leadingIcon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)}
            )

            OutlinedTextField(
                value = state.password,
                onValueChange = {onEvent(RegisterEvent.SetPassword(it))},
                placeholder = { Text("Password")},
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null)}
            )

            OutlinedTextField(
                value = state.confirmPassword,
                onValueChange = {onEvent(RegisterEvent.SetConfirmPassword(it))},
                placeholder = { Text("Confirm Password")},
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null)}
            )
            Row {
                Button(
                    onClick = { onEvent(RegisterEvent.OnSaveUser) },
                    shape = MaterialTheme.shapes.extraSmall,
                    enabled = !state.isLoading,
                    ) {
                    if(state.isLoading){
                        Text(text = "Registering...")
                    } else {
                        Text(text = "Register")
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen()
}