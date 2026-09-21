package com.example.happinessprototype.ui.screens.rewards

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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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

data class Reward(
    val icon: String,
    val title: String,
    val description: String,
    val points: Int,
    val unlocked: Boolean
)

@Composable
fun RewardsScreen(
    onBack: () -> Unit = {}
) {

    val rewards = remember {
        mutableStateListOf(
            Reward(
                icon = "🌱",
                title = "First Step",
                description = "Complete your first wellness activity.",
                points = 50,
                unlocked = true
            ),
            Reward(
                icon = "🔥",
                title = "7 Day Streak",
                description = "Take care of yourself for 7 days.",
                points = 100,
                unlocked = true
            ),
            Reward(
                icon = "📔",
                title = "Reflective Mind",
                description = "Write 5 journal reflections.",
                points = 150,
                unlocked = true
            ),
            Reward(
                icon = "🧘",
                title = "Mindful Soul",
                description = "Complete 10 mindfulness activities.",
                points = 200,
                unlocked = false
            ),
            Reward(
                icon = "🌟",
                title = "Happiness Champion",
                description = "Reach a happiness score of 90.",
                points = 300,
                unlocked = false
            )
        )
    }

    val unlockedCount = rewards.count { it.unlocked }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
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
                    text = "Rewards",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )
            }
        }

        item {

            Column {

                Text(
                    text = "Celebrate Your Progress 🎉",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Every positive step deserves a little celebration.",
                    fontSize = 14.sp,
                    color = GrayText
                )
            }
        }

        item {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(26.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {

                    Text(
                        text = "Your Happiness Points",
                        fontSize = 15.sp,
                        color = Color.White.copy(alpha = 0.85f)
                    )

                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )

                    Text(
                        text = "450",
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Text(
                        text = "Keep going and unlock more rewards! 🌟",
                        fontSize = 13.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        }

        item {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Level 4",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = DarkText,
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "$unlockedCount / ${rewards.size} unlocked",
                            fontSize = 12.sp,
                            color = GrayText
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    LinearProgressIndicator(
                        progress = {
                            unlockedCount.toFloat() / rewards.size.toFloat()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(9.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        color = PrimaryBlue,
                        trackColor = Color(0xFFE8EEF5)
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "You're making wonderful progress!",
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

        items(rewards) { reward ->

            RewardCard(
                reward = reward
            )
        }

        item {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SoftPurple
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "🌟 Keep Going!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkText
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Your wellbeing journey is made of small moments.",
                        fontSize = 13.sp,
                        color = GrayText
                    )
                }
            }
        }
    }
}

@Composable
private fun RewardCard(
    reward: Reward
) {

    val cardBackground =
        if (reward.unlocked) Color.White else Color(0xFFF1F5F9)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardBackground
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = reward.icon,
                modifier = Modifier
                    .size(58.dp)
                    .background(
                        if (reward.unlocked) {
                            SoftBlue
                        } else {
                            Color(0xFFE2E8F0)
                        },
                        RoundedCornerShape(18.dp)
                    )
                    .padding(12.dp),
                fontSize = 27.sp
            )

            Spacer(
                modifier = Modifier.width(15.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = reward.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (reward.unlocked) {
                        DarkText
                    } else {
                        GrayText
                    }
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = reward.description,
                    fontSize = 12.sp,
                    color = GrayText
                )

                Spacer(
                    modifier = Modifier.height(7.dp)
                )

                Text(
                    text = "+${reward.points} points",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue
                )
            }

            if (reward.unlocked) {

                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Unlocked",
                    tint = Color(0xFF22C55E),
                    modifier = Modifier.size(24.dp)
                )

            } else {

                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Locked",
                    tint = GrayText,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}