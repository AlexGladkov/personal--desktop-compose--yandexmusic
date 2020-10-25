package common.player

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import common.Enviroment
import components.imageIcon.ImageIcon
import components.link.LinkView
import extension.imageFile
import java.io.File

@Composable
fun PlayerView() {
    val isPlaying = mutableStateOf(false)
    val isFavorite = mutableStateOf(false)

    Column {
        Row {
            ImageIcon(imagePath = "${Enviroment.imageSource}\\baseline_skip_previous_black_18dp.png",
                    modifier = Modifier.padding(start = 24.dp)
                            .then(Modifier.align(Alignment.CenterVertically)),
                    onClick = {

                    })
            ImageIcon(imagePath = "${Enviroment.imageSource}\\baseline_play_arrow_black_18dp.png",
                    modifier = Modifier.align(Alignment.CenterVertically)
                            .then(Modifier.padding(start = 8.dp)),
                    onClick = {

                    })
            ImageIcon(imagePath = "${Enviroment.imageSource}\\baseline_skip_next_black_18dp.png",
                    modifier = Modifier.padding(start = 8.dp)
                            .then(Modifier.align(Alignment.CenterVertically)),
                    onClick = {

                    })
            Image(imageFile(File("${Enviroment.imageSource}\\ic_temp_cover.jpg")),
                    modifier = Modifier.size(80.dp, 80.dp)
                            .then(Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)))

            Column(modifier = Modifier.align(Alignment.CenterVertically).then(Modifier.padding(start = 4.dp))) {
                LinkView(text = "Gagaru", textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                ), onClick = {

                })
                LinkView(text = "Synkro",
                        modifier = Modifier.padding(top = 2.dp),
                        textStyle = TextStyle(
                                color = Color.Black,
                        ), onClick = {

                })
            }

            Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                if (isFavorite.value) {
                    ImageIcon(imagePath = "${Enviroment.imageSource}\\baseline_favorite_black_18dp.png",
                            modifier = Modifier.padding(start = 14.dp),
                            size = 28.dp,
                            onClick = {

                            })
                } else {
                    ImageIcon(imagePath = "${Enviroment.imageSource}\\baseline_favorite_border_black_18dp.png",
                            modifier = Modifier.padding(start = 14.dp),
                            size = 28.dp,
                            onClick = {

                            })
                }

                ImageIcon(imagePath = "${Enviroment.imageSource}\\baseline_add_black_18dp.png",
                        modifier = Modifier.padding(start = 8.dp),
                        size = 28.dp,
                        onClick = {

                        })
                ImageIcon(imagePath = "${Enviroment.imageSource}\\baseline_share_black_18dp.png",
                        modifier = Modifier.padding(start = 8.dp),
                        size = 28.dp,
                        onClick = {

                        })
                ImageIcon(imagePath = "${Enviroment.imageSource}\\baseline_block_black_18dp.png",
                        modifier = Modifier.padding(start = 8.dp),
                        size = 28.dp,
                        onClick = {

                        })
            }
        }
    }
}