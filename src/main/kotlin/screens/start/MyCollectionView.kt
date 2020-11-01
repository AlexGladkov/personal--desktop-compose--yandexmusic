package screens.start

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.header.HeaderView
import common.player.PlayerView
import screens.start.views.UserHeaderView.UserHeaderModel
import screens.start.views.UserHeaderView.UserHeaderView
import screens.start.views.track.TrackCell
import screens.start.views.track.TrackModel

@ExperimentalFoundationApi
@Composable
fun MyCollectionView() {
    val testData = mutableListOf(
            TrackModel(imageUrl = "Empty", trackName = "Summertime Sadness", artistName = "Lana Del Ray"),
            TrackModel(imageUrl = "Empty", trackName = "Snowman", artistName = "Wys"),
            TrackModel(imageUrl = "Empty", trackName = "The Diary of Jane", artistName = "Breaking Benjamin"),
            TrackModel(imageUrl = "Empty", trackName = "Upset", artistName = "Gashi")
    )

    val toastState = remember { mutableStateOf("") }
    val averageScrollSize = 80.dp
    val state = rememberScrollState(0f)

    Scaffold(
            topBar = { HeaderView() },
            bottomBar = { PlayerView() },
            bodyContent = {
                Column {
                    UserHeaderView(UserHeaderModel(userName = "Алексей Гладков"))

                    Box(
                            modifier = Modifier.fillMaxSize()
                    ) {
                        ScrollableColumn(modifier = Modifier.fillMaxSize().padding(end = 24.dp), state) {
                            if (toastState.value.isNotBlank()) {
                                Text(
                                        text = toastState.value,
                                        modifier = Modifier.align(Alignment.CenterHorizontally) + Modifier.padding(16.dp),
                                )
                            }
                            testData.forEach { trackModel ->
                                TrackCell(
                                        modifier = Modifier.height(averageScrollSize),
                                        trackModel = trackModel,
                                        onTap = {
                                            toastState.value = it.artistName
                                        })
                            }
                        }

                        VerticalScrollbar(
                                modifier = Modifier.align(Alignment.CenterEnd)
                                        .fillMaxHeight(),
                                adapter = rememberScrollbarAdapter(state)
                        )
                    }
                }
            })
}