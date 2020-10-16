package common.header

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.menu.MenuCell
import common.menu.MenuCellModel

@Composable
fun HeaderView() {
    val height = 70.dp
    val menuItems = mutableListOf(
            MenuCellModel("Главная", isSelected = true),
            MenuCellModel("Подкасты"),
            MenuCellModel("Жанры"),
            MenuCellModel("Радио")
    )

    Row(modifier = Modifier.fillMaxWidth() + Modifier.height(height)) {
//        val image = imageResource("D:\\Development\\Compose\\desktopSample\\assets\\ic_logo.png")
//        Image(image, modifier = Modifier.size(width = 300.dp, height = height))
        TextField(
                value = "",
                modifier = Modifier.width(300.dp)
                        .then(Modifier.height(height - 16.dp))
                        .then(Modifier.align(Alignment.CenterVertically))
                        .then(Modifier.padding(end = 24.dp)),
                placeholder = {
                    Text(
                            text = "Трек, альбом, исполнитель, подкаст"
                    )
                },
                onValueChange = {

                })

        menuItems.map { MenuCell(it, modifier = Modifier.align(Alignment.CenterVertically)) }
    }
}