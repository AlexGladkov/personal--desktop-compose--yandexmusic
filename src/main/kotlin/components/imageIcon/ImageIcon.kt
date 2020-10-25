package components.imageIcon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import extension.imageFile
import extension.onHover
import java.io.File

@Composable
fun ImageIcon(
        imagePath: String,
        modifier: Modifier,
        size: Dp = 32.dp,
        onClick: ((Boolean) -> Unit)? = null
) {
    val alpha = remember { mutableStateOf(0.3f) }
    val isClicked = remember { mutableStateOf(false) }

    Image(imageFile(File(imagePath)),
            modifier = modifier
                    .then(Modifier.size(size))
                    .then(Modifier.onHover {
                        if (it) alpha.value = 1f else alpha.value = 0.3f
                    })
                    .then(Modifier.clickable {
                        isClicked.value = !isClicked.value
                        onClick?.invoke(isClicked.value)
                    }),
            alpha = alpha.value)
}