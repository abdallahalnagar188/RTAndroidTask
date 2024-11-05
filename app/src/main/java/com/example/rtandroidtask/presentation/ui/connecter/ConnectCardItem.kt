package com.example.rtandroidtask.presentation.ui.connecter

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.rtandroidtask.R
import com.example.rtandroidtask.data.models.ConnectItemModel
import com.example.rtandroidtask.presentation.theme.ExamateTheme
import com.example.rtandroidtask.presentation.ui.common.fontBold

@Composable
internal fun ConnectCardItem(
    itemModel: ConnectItemModel
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.white)),
        shape = ExamateTheme.shapes.large,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp), // Changed here
            verticalArrangement = Arrangement.spacedBy(10.dp) // Changed here
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 7.dp), // Changed here
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp) // Changed here
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
                modifier = Modifier.padding(horizontal = 7.dp), // Changed here
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp) // Changed here
            ) {
                itemModel.userInfo.forEach {
                    ConnectTextItem(icon = it.icon!!, title = it.title)
                }
            }
        }
    }
}

@Composable
private fun BodyTitleItem(
    name: String,
    target: String,
    items: List<String>,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp) // Changed here
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp) // Changed here
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Start,
                fontFamily = fontBold,
                color = ExamateTheme.color.primary600,
                fontSize = 15.sp
            )
            Box(
                modifier = Modifier
                    .clip(ExamateTheme.shapes.medium)
                    .width(110.dp) // Changed here
                    .height(35.dp) // Changed here
                    .padding(4.dp) // Changed here
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
            color = ExamateTheme.color.gray,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp), // Changed here
        ) {
            items.forEach {
                Box(
                    modifier = Modifier
                        .clip(ExamateTheme.shapes.medium)
                        .width(55.dp) // Changed here
                        .height(20.dp) // Changed here
                        .padding(2.dp) // Changed here
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
private fun ConnectTextItem(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .padding(3.dp) // Changed here
            .height(30.dp), // Changed here
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp) // Changed here
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(16.dp)
        ) // Changed here
        Text(
            text = title,
            style = ExamateTheme.typography.medium12,
            color = ExamateTheme.color.primary200
        )
    }
}

