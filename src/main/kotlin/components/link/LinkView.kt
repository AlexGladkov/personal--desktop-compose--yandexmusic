package components.link

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.tapGestureFilter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import extension.onHover

@Composable
fun LinkView(
        modifier: Modifier = Modifier,
        text: String,
        defaultColor: Color = Color.Black,
        hoverColor: Color = Color.Red,
        textStyle: TextStyle = TextStyle(),
        isSelected: Boolean = false,
        onClick: () -> Unit
) {
    val textColor = remember { mutableStateOf(defaultColor) }

    val mouseHover = Modifier.onHover { isHover ->
        textColor.value = if (isHover) {
            hoverColor
        } else {
            defaultColor
        }
    }

    val mouseClick = Modifier.tapGestureFilter {
        onClick.invoke()
    }

    Column {
        Text(
                modifier = modifier
                        .then(Modifier.padding(start = 16.dp, end = 16.dp))
                        .then(mouseHover)
                        .then(mouseClick),
                text = text,
                style = TextStyle(
                        color = textColor.value,
                        fontSize = textStyle.fontSize,
                        fontWeight = textStyle.fontWeight
                )
        )

        if (isSelected) {
            Divider(modifier = Modifier.padding(top = 4.dp).width(40.dp).align(Alignment.CenterHorizontally), color = Color.Red, thickness = 3.dp)
        }
    }
}