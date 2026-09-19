package com.example.happinessprototype.ui.screens.progress

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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

@Composable
fun ProgressScreen(
    onBack: () -> Unit = {}
) {

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
                text = "Your Progress",
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
                    text = "Your happiness journey 💙",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Small steps are creating positive changes.",
                    fontSize = 14.sp,
                    color = GrayText
                )
            }

            // Happiness score
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
                                text = "Happiness Score",
                                fontSize = 15.sp,
                                color = GrayText
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Row(
                                verticalAlignment = Alignment.Bottom
                            ) {

                                Text(
                                    text = "78",
                                    fontSize = 42.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryBlue
                                )

                                Text(
                                    text = " / 100",
                                    fontSize = 14.sp,
                                    color = GrayText
                                )
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "+8% from last week",
                                fontSize = 13.sp,
                                color = Color(0xFF16A34A)
                            )
                        }

                        Text(
                            text = "78%",
                            modifier = Modifier
                                .size(78.dp)
                                .clip(CircleShape)
                                .background(SoftBlue)
                                .padding(22.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )
                    }
                }
            }

            // Weekly mood
            item {

                Text(
                    text = "Weekly Mood",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )
            }

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 15.dp,
                                vertical = 22.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        MoodDay("Mon", "😊", true)
                        MoodDay("Tue", "🙂", true)
                        MoodDay("Wed", "😄", true)
                        MoodDay("Thu", "🙂", true)
                        MoodDay("Fri", "😐", true)
                        MoodDay("Sat", "😄", true)
                        MoodDay("Sun", "😊", true)
                    }
                }
            }

            // Streak
            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    StatCard(
                        modifier = Modifier.weight(1f),
                        emoji = "🔥",
                        value = "7",
                        title = "Day Streak",
                        background = SoftYellow
                    )

                    StatCard(
                        modifier = Modifier.weight(1f),
                        emoji = "🌱",
                        value = "24",
                        title = "Activities",
                        background = SoftGreen
                    )
                }
            }

            // Positive habits
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

                        Text(
                            text = "Positive Habits",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = DarkText
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        HabitRow("🧘", "Mindfulness", "5 sessions")
                        HabitRow("🚶", "Movement", "4 sessions")
                        HabitRow("📔", "Journaling", "6 entries")
                    }
                }
            }
        }
    }
}

@Composable
private fun MoodDay(
    day: String,
    emoji: String,
    completed: Boolean
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = emoji,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = day,
            fontSize = 11.sp,
            color = if (completed) DarkText else GrayText
        )
    }
}

@Composable
private fun StatCard(
    modifier: Modifier,
    emoji: String,
    value: String,
    title: String,
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
                .padding(18.dp)
        ) {

            Text(
                text = emoji,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )

            Text(
                text = title,
                fontSize = 12.sp,
                color = GrayText
            )
        }
    }
}

@Composable
private fun HabitRow(
    emoji: String,
    title: String,
    subtitle: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = emoji,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.width(14.dp))

        Column {

            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = DarkText
            )

            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = GrayText
            )
        }
    }
}