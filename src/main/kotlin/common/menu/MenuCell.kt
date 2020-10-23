package common.menu

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import common.link.LinkView
import extension.onHover

data class MenuCellModel(val title: String, val isSelected: Boolean = false)

@Composable
fun MenuCell(model: MenuCellModel, modifier: Modifier = Modifier) {
    LinkView(
            modifier = modifier,
            text = model.title,
            textStyle = TextStyle(
                    fontSize = 16.sp
            ),
            onClick = {

            }
    )
}