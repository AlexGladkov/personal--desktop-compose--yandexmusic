package screens.start.views.UserHeaderView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import common.Enviroment
import extension.imageFile
import java.io.File

data class UserHeaderModel(val userName: String)

@Composable
fun UserHeaderView(model: UserHeaderModel) {
    Row(modifier = Modifier.padding(24.dp).height(224.dp)) {
        Image(imageFile(File("${Enviroment.imageSource}\\user_img_test.jpg")),
                modifier = Modifier.size(width = 200.dp, height = 200.dp),
                contentScale = ContentScale.Crop)

        Column(modifier = Modifier.padding(start = 24.dp, end = 24.dp)) {
            Text("Моя коллекция".toUpperCase(),
                    style = TextStyle(
                            color = Color.Gray,
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp)
            )
            Text(model.userName,
                    modifier = Modifier.weight(weight = 1f),
                    style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 36.sp
                    )
            )

            Row(modifier = Modifier.padding(bottom = 24.dp)) {
                makeRandomButtonView()
                makeRadioButtonView(modifier = Modifier.weight(weight = 1f))
                makeSettingsButtonView()
            }
        }
    }
}

@Composable
private fun makeRandomButtonView() {
    Button(
            modifier = Modifier.padding(end = 8.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = {

            },
            content = {
                makeButtonText("Вперемешку")
            }
    )
}

@Composable
private fun makeRadioButtonView(modifier: Modifier) =
        Box(modifier = modifier) {
            Button(
                    shape = RoundedCornerShape(16.dp),
                    onClick = {

                    },
                    content = {
                        makeButtonText("Радио")
                    }
            )
        }


@Composable
private fun makeSettingsButtonView() {
    Button(
            shape = RoundedCornerShape(16.dp),
            onClick = {

            },
            content = {
                makeButtonText("Настройки")
            }
    )
}

@Composable
private fun makeButtonText(value: String) {
    Text(text = value,
            style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Medium
            )
    )
}