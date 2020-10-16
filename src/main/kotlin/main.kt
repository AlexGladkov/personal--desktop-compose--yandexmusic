import androidx.compose.desktop.Window
import androidx.compose.ui.unit.IntSize
import screens.start.StartView

fun main() = Window(title = "Compose for Desktop", size = IntSize(1200, 800)) {
    StartView()
}