package screens.auth.models

sealed class AuthEvents {
    data class EmailChanged(val newValue: String) : AuthEvents()
    data class PasswordChanged(val newValue: String) : AuthEvents()
    object LoginClick : AuthEvents()
}