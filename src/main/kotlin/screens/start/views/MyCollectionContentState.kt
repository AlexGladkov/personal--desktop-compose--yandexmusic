package screens.start.views

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import screens.start.views.UserHeaderView.UserHeaderModel
import screens.start.views.UserHeaderView.UserHeaderView
import screens.start.views.track.TrackCell
import screens.start.views.track.TrackModel

@Composable
fun MyCollectionContentState(scrollModifier: Modifier = Modifier) {
    val testData = mutableListOf(
            TrackModel(imageUrl = "Empty", trackName = "Summertime Sadness", artistName = "Lana Del Ray"),
            TrackModel(imageUrl = "Empty", trackName = "Snowman", artistName = "Wys"),
            TrackModel(imageUrl = "Empty", trackName = "The Diary of Jane", artistName = "Breaking Benjamin"),
            TrackModel(imageUrl = "Empty", trackName = "Upset", artistName = "Gashi")
    )

    val toastState = remember { mutableStateOf("") }
    val averageScrollSize = 80.dp
    val state = rememberScrollState(0f)

    ScrollableColumn(modifier = Modifier.fillMaxSize().padding(end = 24.dp), state) {
        UserHeaderView(UserHeaderModel(userName = "Алексей Гладков"))

        if (toastState.value.isNotBlank()) {
            Text(
                    text = toastState.value,
                    modifier = Modifier.align(Alignment.CenterHorizontally) + Modifier.padding(16.dp),
            )
        }

        testData.map { trackModel ->
            TrackCell(
                    modifier = Modifier.height(averageScrollSize),
                    trackModel = trackModel,
                    onTap = {
                        toastState.value = it.artistName
                    })
        }
    }

    VerticalScrollbar(
            modifier = scrollModifier.fillMaxHeight(),
            adapter = rememberScrollbarAdapter(state)
    )
}