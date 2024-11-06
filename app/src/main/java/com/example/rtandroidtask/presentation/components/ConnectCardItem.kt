package com.example.rtandroidtask.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.rtandroidtask.data.models.ConnectItemModel
import com.example.rtandroidtask.presentation.theme.ExamateTheme

@Composable
internal fun ConnectCardItem(
    itemModel: ConnectItemModel
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = ExamateTheme.color.white),
        shape = ExamateTheme.shapes.large,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ProfilePicture(
                    image = itemModel.image,
                    size = 70
                )
                BodyTitleItem(
                    name = itemModel.userName,
                    target = itemModel.target,
                    items = itemModel.languages
                )
            }
            Row(
                modifier = Modifier.padding(horizontal = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                itemModel.userInfo.forEach {
                    ConnectTextItem(icon = it.icon!!, title = it.title)
                }
            }
        }
    }

}


@Composable
private fun ProfilePicture(
    modifier: Modifier = Modifier,
    image: Any? = null,
    size: Int,
    contentScale: ContentScale = ContentScale.Crop,
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        contentDescription = "Profile Picture",
        contentScale = contentScale,
        loading = {
            CircularProgressIndicator()
        },
        modifier = modifier
            .clip(CircleShape)
            .background(ExamateTheme.color.primary600)
            .size(size.dp)
    )

}

@Composable
private fun BodyTitleItem(
    name: String,
    target: String,
    items: List<String>,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Start,
                style = ExamateTheme.typography.bold18,
                color = ExamateTheme.color.primary600
            )
            Box(
                modifier = Modifier
                    .clip(ExamateTheme.shapes.medium)
                    .width(100.dp)
                    .height(30.dp)
                    .padding(2.dp)
                    .background(ExamateTheme.color.primary600),
                contentAlignment = Center
            ) {
                Text(
                    text = "Targeting: $target",
                    style = ExamateTheme.typography.medium14,
                    color = ExamateTheme.color.white,
                )
            }
        }
        Text(
            text = "Last seen online: Yesterday",
            textAlign = TextAlign.Start,
            style = ExamateTheme.typography.medium14,
            color = ExamateTheme.color.primary200,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items.forEach {
                Box(
                    modifier = Modifier
                        .clip(ExamateTheme.shapes.medium)
                        .width(55.dp)
                        .height(20.dp)
                        .padding(2.dp)
                        .background(ExamateTheme.color.secondary400),
                    contentAlignment = Center
                ) {
                    Text(
                        text = it,
                        style = ExamateTheme.typography.medium10,
                        color = ExamateTheme.color.primary600,
                    )
                }
            }
        }
    }
}

@Composable
private fun ConnectTextItem(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .padding(3.dp)
            .height(30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Icon(imageVector = icon, contentDescription = title, modifier = Modifier.size(16.dp))
        Text(text = title, style = ExamateTheme.typography.medium12, color = ExamateTheme.color.primary200)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreivewItem() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        BodyTitleItem(
            name = "Omar",
            target = "B2",
            items = listOf("English", "Arabic", "French")
        )
    }
}