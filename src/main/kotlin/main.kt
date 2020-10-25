import androidx.compose.desktop.Window
import androidx.compose.foundation.Text
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.Dialog
import screens.auth.AuthView
import screens.start.StartView

fun main() =
        Window(title = "Yandex.Music", size = IntSize(1200, 800)) {
            val isUserAuthorized = remember { mutableStateOf(false) }

            if (isUserAuthorized.value) {
                StartView()
            } else {
                AuthView()
            }
        }