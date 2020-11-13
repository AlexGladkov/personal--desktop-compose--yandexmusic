package screens.start

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import common.header.HeaderView
import common.player.PlayerView
import screens.start.views.MainContentModel
import screens.start.views.MainContentState

sealed class ContentState {
    object Main : ContentState()
    object Podcasts : ContentState()
    object Genres : ContentState()
    object Radio : ContentState()
}

@ExperimentalFoundationApi
@Composable
fun MyCollectionView() {
    val contentState: MutableState<ContentState> = remember { mutableStateOf(ContentState.Main) }

    Scaffold(
            topBar = {
                HeaderView(onMenuClick = {
                    contentState.value = it
                })
            },
            bottomBar = { PlayerView() },
            bodyContent = {
                Column {
                    Box(
                            modifier = Modifier.fillMaxSize()
                    ) {
                        when (contentState.value) {
                            is ContentState.Main -> MainContentState()
                            is ContentState.Genres -> stubScreen("Genres")
                            is ContentState.Podcasts -> stubScreen("Podcasts")
                            is ContentState.Radio -> stubScreen("Radio")
                        }
                    }
                }
            })
}

@Composable
fun stubScreen(screenName: String) {
    Text(
            "Hello $screenName"
    )
}

