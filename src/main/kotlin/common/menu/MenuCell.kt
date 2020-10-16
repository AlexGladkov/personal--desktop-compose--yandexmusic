package common.menu

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MenuCellModel(val title: String, val isSelected: Boolean = false)

@Composable
fun MenuCell(model: MenuCellModel, modifier: Modifier = Modifier) {
    Text(
            text = model.title,
            modifier = modifier
                    .then(Modifier.padding(start = 16.dp, end = 16.dp)),
            style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
            )
    )
}