package screens.auth.models

data class AuthViewState(
    val emailError: String? = null,
    val passwordError: String? = null,
    val isButtonEnabled: Boolean = false
)