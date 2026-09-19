package com.example.happinessprototype.ui.screens.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFFF7FBFC)
private val PrimaryBlue = Color(0xFF3B82F6)
private val DarkText = Color(0xFF172554)
private val GrayText = Color(0xFF64748B)
private val SoftBlue = Color(0xFFEAF4FF)

data class CommunityPost(
    val name: String,
    val avatar: String,
    val time: String,
    val message: String,
    val likes: Int
)

@Composable
fun CommunityScreen(
    onBack: () -> Unit = {}
) {

    var postText by remember {
        mutableStateOf("")
    }

    val posts = listOf(
        CommunityPost(
            "Aarav",
            "A",
            "10 min ago",
            "Completed my morning walk today. Feeling really good! 🌿",
            18
        ),
        CommunityPost(
            "Maya",
            "M",
            "32 min ago",
            "Remember to take a little break when you need one. 💙",
            25
        ),
        CommunityPost(
            "Riya",
            "R",
            "1 hr ago",
            "Today I wrote down three things I'm grateful for. ✨",
            31
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {

        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = DarkText
                )
            }

            Column {

                Text(
                    text = "Community",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Text(
                    text = "A space to share positivity",
                    fontSize = 12.sp,
                    color = GrayText
                )
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                start = 20.dp,
                end = 20.dp,
                bottom = 30.dp
            ),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            item {

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Share something positive 💙",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "BY",
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(SoftBlue)
                                .padding(11.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        OutlinedTextField(
                            value = postText,
                            onValueChange = {
                                postText = it
                            },
                            modifier = Modifier.weight(1f),
                            placeholder = {
                                Text(
                                    text = "Write something...",
                                    fontSize = 13.sp
                                )
                            },
                            shape = RoundedCornerShape(16.dp),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        postText = ""
                                    },
                                    enabled = postText.isNotBlank()
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Send,
                                        contentDescription = "Post",
                                        tint = PrimaryBlue
                                    )
                                }
                            }
                        )
                    }
                }
            }

            item {

                Text(
                    text = "Positive moments",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )
            }

            items(posts) { post ->

                CommunityPostCard(post)
            }
        }
    }
}

@Composable
private fun CommunityPostCard(
    post: CommunityPost
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = post.avatar,
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(SoftBlue)
                        .padding(12.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {

                    Text(
                        text = post.name,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkText
                    )

                    Text(
                        text = post.time,
                        fontSize = 11.sp,
                        color = GrayText
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = post.message,
                fontSize = 14.sp,
                color = DarkText,
                lineHeight = 21.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Like",
                    tint = PrimaryBlue,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "${post.likes} likes",
                    fontSize = 12.sp,
                    color = GrayText
                )
            }
        }
    }
}