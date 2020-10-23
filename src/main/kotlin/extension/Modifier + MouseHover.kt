package extension

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerMoveFilter

fun Modifier.onHover(hasHover: (Boolean) -> Unit): Modifier = composed {
    val isHover = remember { mutableStateOf(false) }
    hasHover.invoke(isHover.value)

    pointerMoveFilter(
            onEnter = { isHover.value = true; true },
            onExit = { isHover.value = false; true }
    )
}