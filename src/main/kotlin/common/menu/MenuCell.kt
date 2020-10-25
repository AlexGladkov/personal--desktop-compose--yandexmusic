package common.menu

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import components.link.LinkView

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