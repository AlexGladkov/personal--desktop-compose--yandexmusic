package screens.auth

import androidx.compose.runtime.mutableStateOf
import data.remote.auth.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import screens.auth.models.AuthEvents
import screens.auth.models.AuthViewState
import java.util.regex.Matcher
import java.util.regex.Pattern

class AuthViewModel(private val authRepository: AuthRepository) {
    private val viewModelScope = CoroutineScope(Dispatchers.IO)
    private var currentEmail = ""
    private var currentPassword = ""

    var authViewState = mutableStateOf(AuthViewState())

    fun obtainEvent(authEvents: AuthEvents) {
        when (authEvents) {
            is AuthEvents.EmailChanged -> updateEmail(authEvents.newValue)
            is AuthEvents.PasswordChanged -> updatePassword(authEvents.newValue)
            is AuthEvents.LoginClick -> performLogin()
        }
    }

    private fun updateEmail(email: String) {
        currentEmail = email
        updateButtonState()
    }

    private fun updatePassword(password: String) {
        currentPassword = password
        updateButtonState()
    }

    private fun updateButtonState() {
        val emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = emailPattern.matcher(currentEmail)
        val isEmailValid = matcher.find()

        authViewState.value = authViewState.value.copy(
                isButtonEnabled = isEmailValid && currentPassword.isNotBlank()
        )
    }

    private fun performLogin() {
        viewModelScope.launch {
            val result = authRepository.performLogin(currentEmail, currentPassword)

            withContext(Dispatchers.Main) {

            }
        }
    }
}