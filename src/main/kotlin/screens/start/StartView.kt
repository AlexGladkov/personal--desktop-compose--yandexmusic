package screens.start

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.header.HeaderView
import common.player.PlayerView
import screens.start.views.track.TrackCell
import screens.start.views.track.TrackModel

@Composable
fun StartView() {
    val testData = mutableListOf(
            TrackModel(imageUrl = "Empty", trackName = "Summertime Sadness", artistName = "Lana Del Ray"),
            TrackModel(imageUrl = "Empty", trackName = "Snowman", artistName = "Wys"),
            TrackModel(imageUrl = "Empty", trackName = "The Diary of Jane", artistName = "Breaking Benjamin"),
            TrackModel(imageUrl = "Empty", trackName = "Upset", artistName = "Gashi")
    )

    val toastState = remember { mutableStateOf("") }

    Scaffold(
            topBar = { HeaderView() },
            bottomBar = { PlayerView() },
            bodyContent = {
                ScrollableColumn(modifier = Modifier.fillMaxSize()) {
                    if (toastState.value.isNotBlank()) {
                        Text(
                                text = toastState.value,
                                modifier = Modifier.align(Alignment.CenterHorizontally) + Modifier.padding(16.dp),
                        )
                    }
                    testData.forEach { trackModel ->
                        TrackCell(
                                trackModel = trackModel,
                                onTap = {
                                    toastState.value = it.artistName
                                })
                    }
                }
            })
}