package com.example.happinessprototype.ui.screens.rewards

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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
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
private val SoftYellow = Color(0xFFFFF7DF)
private val SoftBlue = Color(0xFFEAF4FF)
private val SoftGreen = Color(0xFFEAF8F1)

data class Achievement(
    val emoji: String,
    val title: String,
    val description: String,
    val completed: Boolean
)

@Composable
fun RewardsScreen(
    onBack: () -> Unit = {}
) {

    val achievements = listOf(
        Achievement(
            "🌱",
            "First Step",
            "Complete your first wellness activity",
            true
        ),
        Achievement(
            "🔥",
            "7 Day Streak",
            "Take care of yourself for 7 days",
            true
        ),
        Achievement(
            "📔",
            "Reflection Master",
            "Write 5 journal entries",
            false
        ),
        Achievement(
            "💙",
            "Positive Mind",
            "Complete 20 wellness activities",
            false
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

            Text(
                text = "Rewards",
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

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Celebrate your progress 🎉",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Every small step towards happiness counts.",
                    fontSize = 14.sp,
                    color = GrayText
                )
            }

            // Points card
            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(26.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = SoftYellow
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(22.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "⭐",
                            modifier = Modifier
                                .size(65.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                                .padding(15.dp),
                            fontSize = 30.sp
                        )

                        Spacer(modifier = Modifier.width(17.dp))

                        Column {

                            Text(
                                text = "Happiness Points",
                                fontSize = 14.sp,
                                color = GrayText
                            )

                            Spacer(modifier = Modifier.height(3.dp))

                            Text(
                                text = "1,240",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                color = DarkText
                            )

                            Text(
                                text = "Keep going! You're doing great.",
                                fontSize = 12.sp,
                                color = GrayText
                            )
                        }
                    }
                }
            }

            // Level
            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Level 4",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = DarkText
                            )

                            Text(
                                text = "1,240 / 1,500 XP",
                                fontSize = 12.sp,
                                color = GrayText
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        LinearProgressIndicator(
                            progress = { 0.83f },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(9.dp)
                                .clip(RoundedCornerShape(50.dp)),
                            color = PrimaryBlue,
                            trackColor = SoftBlue
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "260 XP to reach Level 5",
                            fontSize = 12.sp,
                            color = GrayText
                        )
                    }
                }
            }

            item {

                Text(
                    text = "Achievements",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )
            }

            items(achievements) { achievement ->

                AchievementCard(achievement)
            }
        }
    }
}

@Composable
private fun AchievementCard(
    achievement: Achievement
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (achievement.completed) {
                SoftGreen
            } else {
                Color.White
            }
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = achievement.emoji,
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(12.dp),
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = achievement.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = achievement.description,
                    fontSize = 12.sp,
                    color = GrayText
                )
            }

            if (achievement.completed) {

                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Completed",
                    tint = Color(0xFF16A34A),
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}