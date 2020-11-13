package common.cover

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import common.Enviroment
import extension.imageFile
import extension.onHover
import java.io.File

data class CoverCellModel(val imageUrl: String, val imageTitle: String, val coverTitle: String,
                          val coverSubtitle: String, val lastUpdate: String, val imageTitleAlignment: Alignment,
                          val imageTitleColor: Color)

@Composable
fun CoverCell(model: CoverCellModel) {
    val defaultTextColor = Color.DarkGray
    val defaultFontSize = 14.sp
    val titleColor = remember { mutableStateOf(defaultTextColor) }

    Column(modifier = Modifier.padding(8.dp).width(210.dp).height(210.dp)) {
        Box(modifier = Modifier.width(200.dp).height(200.dp)) {
            Image(imageFile(File(model.imageUrl)),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop)

            Text(
                    modifier = Modifier.align(model.imageTitleAlignment).padding(6.dp),
                    text = model.imageTitle,
                    style = TextStyle(
                            color = model.imageTitleColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                    )
            )
        }

        Text(
                modifier = Modifier.padding(top = 8.dp).onHover {
                    titleColor.value = if (it) Color.Red else defaultTextColor
                },
                text = model.coverTitle,
                style = TextStyle(
                        color = titleColor.value,
                        fontSize = defaultFontSize,
                )
        )

        Text(
                modifier = Modifier.padding(top = 8.dp),
                text = model.coverSubtitle,
                style = TextStyle(
                        color = titleColor.value,
                        fontSize = defaultFontSize,
                )
        )

        Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 24.dp),
                text = model.lastUpdate,
                style = TextStyle(
                        color = titleColor.value,
                        fontSize = defaultFontSize,
                )
        )
    }
}