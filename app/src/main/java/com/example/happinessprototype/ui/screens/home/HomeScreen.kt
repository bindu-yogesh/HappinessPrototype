package com.example.happinessprototype.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.NotificationsNone
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

private val SoftBlue = Color(0xFFEAF4FF)
private val SoftGreen = Color(0xFFEAF8F1)
private val SoftYellow = Color(0xFFFFF7DF)
private val SoftPurple = Color(0xFFF3EEFF)

@Composable
fun HomeScreen(
    happinessScore: Int = 78,
    onMoodClick: () -> Unit = {},
    onWellnessClick: () -> Unit = {},
    onJournalClick: () -> Unit = {},
    onCommunityClick: () -> Unit = {},
    onRewardsClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp,
            top = 20.dp,
            bottom = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        item {
            Header(
                onProfileClick = onProfileClick
            )
        }

        item {
            HappinessCard(
                happinessScore = happinessScore
            )
        }

        item {
            SectionTitle(
                title = "Today's Wellness",
                subtitle = "Small steps towards a happier you"
            )
        }

        item {
            WellnessCard(
                icon = "😊",
                title = "How are you feeling?",
                description = "Take a moment to check in with yourself.",
                background = SoftYellow,
                onClick = onMoodClick
            )
        }

        item {
            WellnessCard(
                icon = "🌿",
                title = "Today's Activity",
                description = "A small activity can make a big difference.",
                background = SoftGreen,
                onClick = onWellnessClick
            )
        }

        item {
            SectionTitle(
                title = "Evening",
                subtitle = "Reflect, relax and recharge"
            )
        }

        item {
            WellnessCard(
                icon = "🌙",
                title = "Journal your thoughts",
                description = "Write down what's on your mind.",
                background = SoftPurple,
                onClick = onJournalClick
            )
        }
    }
}

@Composable
private fun Header(
    onProfileClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Good Morning 👋",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Take a moment for yourself today.",
                fontSize = 14.sp,
                color = GrayText
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.NotificationsNone,
                    contentDescription = "Notifications",
                    tint = DarkText
                )
            }

            Text(
                text = "BY",
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(SoftBlue)
                    .clickable {
                        onProfileClick()
                    }
                    .wrapContentSize(Alignment.Center),
                color = PrimaryBlue,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun HappinessCard(
    happinessScore: Int
) {
    val happinessMessage = when {
        happinessScore >= 90 -> "You're feeling amazing! 💙"
        happinessScore >= 75 -> "You're doing great! 💙"
        happinessScore >= 60 -> "You're having a good day! 🌿"
        happinessScore >= 45 -> "Take some time for yourself. 💙"
        else -> "It's okay to have difficult days. 💙"
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Your Happiness",
                    fontSize = 16.sp,
                    color = GrayText
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {

                    Text(
                        text = happinessScore.toString(),
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryBlue
                    )

                    Text(
                        text = " / 100",
                        fontSize = 15.sp,
                        color = GrayText
                    )
                }

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = happinessMessage,
                    fontSize = 13.sp,
                    color = GrayText
                )
            }

            Text(
                text = "$happinessScore%",
                modifier = Modifier
                    .size(76.dp)
                    .clip(CircleShape)
                    .background(SoftBlue)
                    .wrapContentSize(Alignment.Center),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryBlue
            )
        }
    }
}

@Composable
private fun SectionTitle(
    title: String,
    subtitle: String
) {
    Column {

        Text(
            text = title,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = DarkText
        )

        Spacer(
            modifier = Modifier.height(3.dp)
        )

        Text(
            text = subtitle,
            fontSize = 13.sp,
            color = GrayText
        )
    }
}

@Composable
private fun WellnessCard(
    icon: String,
    title: String,
    description: String,
    background: Color,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(22.dp),
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
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = icon,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(background)
                    .wrapContentSize(Alignment.Center),
                fontSize = 28.sp
            )

            Spacer(
                modifier = Modifier.width(15.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkText
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = description,
                    fontSize = 13.sp,
                    color = GrayText
                )
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Open",
                tint = GrayText
            )
        }
    }
}