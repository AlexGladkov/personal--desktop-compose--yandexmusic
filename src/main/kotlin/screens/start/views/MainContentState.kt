package screens.start.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Tab
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
import common.cover.CoverCell
import common.cover.CoverCellModel
import components.link.LinkView
import extension.imageFile
import java.io.File

data class MainContentModel(val firstName: String, val userImage: String)

@Composable
fun MainContentState() {
    val mainContentModel = MainContentModel(firstName = "Алексей", userImage = "${Enviroment.imageSource}\\user_img_test.jpg")
    val menuItems = listOf("Все", "Новые релизы", "Чарт", "Настроения и жанры", "Для детей")
    val currentItem = remember { mutableStateOf("Все".toUpperCase()) }

    ScrollableColumn(modifier = Modifier.fillMaxSize().padding(32.dp)) {
        Text(
                text = "Главное",
                modifier = Modifier.padding(top = 16.dp),
                style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 48.sp
                )
        )

        Row(modifier = Modifier.padding(top = 24.dp).height(50.dp)) {
            menuItems
                    .map { it.toUpperCase() }
                    .map { title ->
                        LinkView(
                                text = title,
                                isSelected = currentItem.value == title,
                                onClick = {
                                    currentItem.value = title
                                })
                    }
        }

        Row(modifier = Modifier.padding(top = 2.dp)) {
            Image(imageFile(File(mainContentModel.userImage)),
                    modifier = Modifier.size(width = 40.dp, height = 40.dp),
                    contentScale = ContentScale.Crop)

            Text(modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterVertically),
                    style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp),
                    text = "Умные плейлисты для вас, ${mainContentModel.firstName}"
            )
        }

        val testCoverData = ArrayList<CoverCellModel>().apply {
            add(CoverCellModel(
                    imageUrl = "${Enviroment.imageSource}\\ic_temp_cover.jpg",
                    imageTitle = "Плейлист дня",
                    imageTitleAlignment = Alignment.TopStart,
                    coverTitle = "Плейлист дня",
                    imageTitleColor = Color.White,
                    coverSubtitle = "Каждый ваш день - новый. Каждый день - ваш",
                    lastUpdate = "Обновлен вчера")
            )
            add(CoverCellModel(
                    imageUrl = "${Enviroment.imageSource}\\ic_temp_cover_2.jpg",
                    imageTitle = "Дежавю",
                    imageTitleAlignment = Alignment.Center,
                    coverTitle = "Дежавю",
                    imageTitleColor = Color.White,
                    coverSubtitle = "Вы еще не слушали эти треки, но, похоже, они вам понравятся",
                    lastUpdate = "Обновлен вчера")
            )
        }
        Row(
                modifier = Modifier.padding(top = 16.dp)
        ) {
            testCoverData.map { item -> CoverCell(item) }
        }
    }
}