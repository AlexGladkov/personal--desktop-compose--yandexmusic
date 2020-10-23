package extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageAsset
import androidx.compose.ui.graphics.asImageAsset
import org.jetbrains.skija.Image
import java.io.File

fun imageFromFile(file: File): ImageAsset {
    return Image.makeFromEncoded(file.readBytes()).asImageAsset()
}

@Composable
fun imageFile(file: File): ImageAsset {
    return remember(file) { imageFromFile(file) }
}