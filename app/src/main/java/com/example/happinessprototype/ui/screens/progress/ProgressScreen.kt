package com.example.happinessprototype.ui.screens.progress

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
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
fun ProgressScreen(
    happinessScore: Int = 78,
    onBack: () -> Unit = {}
) {
    val progressMessage = when {
        happinessScore >= 90 -> "You're feeling amazing! Keep it going! 🌟"
        happinessScore >= 75 -> "You're doing great! Keep taking care of yourself. 💙"
        happinessScore >= 60 -> "You're having a good day. Keep going! 🌿"
        happinessScore >= 45 -> "Take some time to care for yourself today. 💙"
        else -> "It's okay to have difficult days. Be kind to yourself. 💙"
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp,
            bottom = 30.dp
        ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBack
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = DarkText
                    )
                }

                Text(
                    text = "My Progress",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )
            }
        }

        item {
            Column {
                Text(
                    text = "Your Happiness Journey 🌱",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Small steps every day can make a big difference.",
                    fontSize = 14.sp,
                    color = GrayText
                )
            }
        }

        // Current happiness score
        item {
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Current Happiness",
                        fontSize = 15.sp,
                        color = GrayText
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = happinessScore.toString(),
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .background(SoftBlue)
                            .padding(30.dp),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryBlue
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = progressMessage,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = DarkText
                    )
                }
            }
        }

        // Weekly overview
        item {
            Text(
                text = "Weekly Overview",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Text(
                        text = "This Week",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = DarkText
                    )

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    WeeklyMoodRow("Mon", 72)
                    WeeklyMoodRow("Tue", 80)
                    WeeklyMoodRow("Wed", 68)
                    WeeklyMoodRow("Thu", 84)
                    WeeklyMoodRow("Fri", 76)
                    WeeklyMoodRow("Sat", 82)

                    // Today's score comes from Mood Check-in
                    WeeklyMoodRow("Today", happinessScore)
                }
            }
        }

        // Statistics
        item {
            Text(
                text = "Your Statistics",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                ProgressStatCard(
                    modifier = Modifier.weight(1f),
                    value = "7",
                    title = "Day Streak",
                    icon = "🔥",
                    background = SoftYellow
                )

                ProgressStatCard(
                    modifier = Modifier.weight(1f),
                    value = "24",
                    title = "Activities",
                    icon = "🌱",
                    background = SoftGreen
                )
            }
        }

        // Weekly average
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SoftPurple
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "📈",
                        fontSize = 32.sp
                    )

                    Spacer(
                        modifier = Modifier.width(15.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Current Score",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = DarkText
                        )

                        Spacer(
                            modifier = Modifier.height(3.dp)
                        )

                        Text(
                            text = "$happinessScore / 100",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )

                        Text(
                            text = "Based on your latest mood check-in.",
                            fontSize = 12.sp,
                            color = GrayText
                        )
                    }
                }
            }
        }

        // Positive habits
        item {
            Text(
                text = "Positive Habits",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    HabitRow(
                        icon = "🧘",
                        title = "Mindfulness",
                        progress = 0.8f,
                        percentage = "80%"
                    )

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    HabitRow(
                        icon = "📔",
                        title = "Journaling",
                        progress = 0.65f,
                        percentage = "65%"
                    )

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    HabitRow(
                        icon = "🌿",
                        title = "Wellness Activities",
                        progress = 0.75f,
                        percentage = "75%"
                    )
                }
            }
        }

        // Encouragement
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SoftBlue
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Keep Going! 🌟",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkText
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Every small step towards your wellbeing matters.",
                        fontSize = 13.sp,
                        color = GrayText
                    )
                }
            }
        }
    }
}

@Composable
private fun WeeklyMoodRow(
    day: String,
    score: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = day,
                modifier = Modifier.width(45.dp),
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = DarkText
            )

            LinearProgressIndicator(
                progress = { score / 100f },
                modifier = Modifier
                    .weight(1f)
                    .height(8.dp)
                    .clip(RoundedCornerShape(10.dp)),
                color = PrimaryBlue,
                trackColor = Color(0xFFE8EEF5)
            )

            Spacer(
                modifier = Modifier.width(10.dp)
            )

            Text(
                text = score.toString(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = GrayText
            )
        }
    }
}

@Composable
private fun ProgressStatCard(
    modifier: Modifier,
    value: String,
    title: String,
    icon: String,
    background: Color
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = background
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = icon,
                fontSize = 25.sp
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = value,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )

            Text(
                text = title,
                fontSize = 11.sp,
                color = GrayText
            )
        }
    }
}

@Composable
private fun HabitRow(
    icon: String,
    title: String,
    progress: Float,
    percentage: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = icon,
            fontSize = 24.sp
        )

        Spacer(
            modifier = Modifier.width(12.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkText
                )

                Text(
                    text = percentage,
                    fontSize = 12.sp,
                    color = GrayText
                )
            }

            Spacer(
                modifier = Modifier.height(7.dp)
            )

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.dp)
                    .clip(RoundedCornerShape(10.dp)),
                color = PrimaryBlue,
                trackColor = Color(0xFFE8EEF5)
            )
        }
    }
}