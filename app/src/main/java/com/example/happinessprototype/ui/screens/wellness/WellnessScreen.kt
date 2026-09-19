package com.example.happinessprototype.ui.screens.wellness

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun WellnessScreen(
    onBack: () -> Unit = {}
) {

    val activities = listOf(
        Triple("🧘", "Breathing", "Relax your mind in 5 minutes"),
        Triple("🚶", "Take a Walk", "Move your body and refresh"),
        Triple("🎵", "Listen to Music", "Take a peaceful music break"),
        Triple("📝", "Reflect", "Write down something positive")
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

            Text(
                text = "Wellness",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                start = 20.dp,
                end = 20.dp,
                bottom = 30.dp
            ),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            item {

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Take care of yourself 🌿",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Small actions can make a big difference.",
                    fontSize = 14.sp,
                    color = GrayText
                )
            }

            // Today's recommendation
            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFEAF8F1)
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "🌿",
                            modifier = Modifier
                                .size(65.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White)
                                .padding(14.dp),
                            fontSize = 32.sp
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "Today's Recommendation",
                                fontSize = 13.sp,
                                color = GrayText
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "5-Minute Breathing",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = DarkText
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Slow down and give yourself a moment.",
                                fontSize = 13.sp,
                                color = GrayText
                            )
                        }
                    }
                }
            }

            item {

                Column {

                    Text(
                        text = "Quick Activities",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkText
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Choose something that feels right for you.",
                        fontSize = 13.sp,
                        color = GrayText
                    )
                }
            }

            items(activities) { activity ->

                ActivityCard(
                    emoji = activity.first,
                    title = activity.second,
                    description = activity.third
                )
            }
        }
    }
}

@Composable
private fun ActivityCard(
    emoji: String,
    title: String,
    description: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = emoji,
                modifier = Modifier
                    .size(55.dp)
                    .clip(RoundedCornerShape(17.dp))
                    .background(Color(0xFFF3F7FF))
                    .padding(11.dp),
                fontSize = 27.sp
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkText
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = description,
                    fontSize = 13.sp,
                    color = GrayText
                )
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Open",
                tint = PrimaryBlue
            )
        }
    }
}