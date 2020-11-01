package screens.start.views.track

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.tapGestureFilter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageAsset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TrackCell(modifier: Modifier = Modifier, trackModel: TrackModel, onTap: (TrackModel) -> Unit) {
    val backgroundColor = mutableStateOf(Color.White)
    val mouseTap = Modifier.tapGestureFilter { onTap(trackModel) }

    Card(modifier = modifier.then(mouseTap).then(Modifier.fillMaxWidth()),
            backgroundColor = backgroundColor.value) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                    asset = ImageAsset(width = 60, height = 60),
            )

            Column {
                Text(
                        text = trackModel.artistName,
                        style = TextStyle(
                                color = Color.DarkGray,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                        )
                )
                Text(
                        text = trackModel.trackName,
                        style = TextStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                        )
                )
            }
        }
    }
}