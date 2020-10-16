package screens.start.views.track

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.tapGestureFilter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageAsset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TrackCell(trackModel: TrackModel, onTap: (TrackModel) -> Unit) {
    Row(modifier = Modifier.tapGestureFilter {
        onTap(trackModel)
    } + Modifier.fillMaxWidth()) {
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