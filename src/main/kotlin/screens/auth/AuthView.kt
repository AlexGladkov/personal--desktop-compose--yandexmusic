package screens.auth

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import common.Palette
import data.Application
import data.remote.auth.AuthRepositoryImpl
import screens.auth.models.AuthEvents

@Composable
fun AuthView() {
    val authViewModel = AuthViewModel(
            authRepository = AuthRepositoryImpl(
                    authRemote = Application.getInstance().authRemote,
                    userRemote = Application.getInstance().userRemote
            )
    )

    val emailState = mutableStateOf(TextFieldValue(""))
    val passwordState = mutableStateOf(TextFieldValue(""))

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.align(Alignment.Center).then(Modifier.width(300.dp))) {
                TextField(
                        emailState.value,
                        backgroundColor = Color.Transparent,
                        label = { Text("Email") },
                        placeholder = {
                            Text("Введите ваш email")
                        },
                        activeColor = Color(Palette.primaryColor),
                        modifier = Modifier.padding(top = 24.dp).then(Modifier.fillMaxWidth()),
                        onValueChange = {
                            emailState.value = it
                            authViewModel.obtainEvent(AuthEvents.EmailChanged(newValue = it.text))
                        }
                )

                TextField(
                        passwordState.value,
                        backgroundColor = Color.Transparent,
                        label = { Text("Пароль") },
                        placeholder = {
                            Text("Введите ваш пароль")
                        },
                        activeColor = Color(Palette.primaryColor),
                        modifier = Modifier.padding(top = 16.dp).then(Modifier.fillMaxWidth()),
                        onValueChange = {
                            passwordState.value = it
                            authViewModel.obtainEvent(AuthEvents.PasswordChanged(newValue = it.text))
                        }
                )

                Button(onClick = {
                    authViewModel.obtainEvent(AuthEvents.LoginClick)
                },
                        enabled = authViewModel.authViewState.value.isButtonEnabled,
                        modifier = Modifier.padding(top = 24.dp).then(Modifier.align(Alignment.CenterHorizontally)),
                        content = {
                            Text("Авторизоваться")
                        })
            }
        }
    }
}