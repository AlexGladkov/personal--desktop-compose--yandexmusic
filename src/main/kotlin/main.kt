import androidx.compose.desktop.Window
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.IntSize
import screens.auth.AuthView
import screens.start.MyCollectionView

@ExperimentalFoundationApi
fun main() =
        Window(title = "Yandex.Music", size = IntSize(1200, 800)) {
            val isUserAuthorized = remember { mutableStateOf(false) }

            if (isUserAuthorized.value) {
                MyCollectionView()
            } else {
                AuthView()
            }
        }