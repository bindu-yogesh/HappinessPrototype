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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

data class WellnessActivity(
    val icon: String,
    val title: String,
    val description: String,
    val duration: String
)

@Composable
fun WellnessScreen(
    onBack: () -> Unit = {}
) {

    val activities = listOf(
        WellnessActivity(
            icon = "🧘",
            title = "Mindful Breathing",
            description = "Take a few slow breaths and focus on the present moment.",
            duration = "2 min"
        ),
        WellnessActivity(
            icon = "🌿",
            title = "Nature Break",
            description = "Step outside and spend a few peaceful minutes in nature.",
            duration = "5 min"
        ),
        WellnessActivity(
            icon = "💭",
            title = "Positive Reflection",
            description = "Think of three things that made you smile today.",
            duration = "3 min"
        ),
        WellnessActivity(
            icon = "🚶",
            title = "Short Walk",
            description = "Take a gentle walk and give your mind some fresh air.",
            duration = "10 min"
        ),
        WellnessActivity(
            icon = "❤️",
            title = "Gratitude Moment",
            description = "Think about someone or something you are grateful for.",
            duration = "3 min"
        )
    )

    val completedActivities = remember {
        mutableStateListOf<String>()
    }

    val completedCount = completedActivities.size

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            start = 20.dp,
            end = 20.dp,
            bottom = 30.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
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
                    text = "Wellness",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )
            }
        }

        item {

            Column {

                Text(
                    text = "Take Care of You 🌿",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Small activities that can help you feel better.",
                    fontSize = 14.sp,
                    color = GrayText
                )
            }
        }

        item {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SoftGreen
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "🌱",
                        fontSize = 34.sp
                    )

                    Spacer(
                        modifier = Modifier.width(15.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Today's Wellness",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = DarkText
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = "$completedCount of ${activities.size} activities completed",
                            fontSize = 13.sp,
                            color = GrayText
                        )
                    }
                }
            }
        }

        item {

            Text(
                text = "Choose an Activity",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )
        }

        items(activities) { activity ->

            val completed =
                completedActivities.contains(activity.title)

            ActivityCard(
                activity = activity,
                completed = completed,
                onComplete = {

                    if (!completed) {
                        completedActivities.add(activity.title)
                    }
                }
            )
        }

        item {

            val background =
                if (completedCount == activities.size) {
                    SoftYellow
                } else {
                    SoftPurple
                }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = background
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = if (completedCount == activities.size) {
                            "Amazing! 🎉"
                        } else {
                            "A Little Reminder 💙"
                        },
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkText
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = if (completedCount == activities.size) {
                            "You've completed all today's wellness activities!"
                        } else {
                            "You don't have to do everything. Start with one small step."
                        },
                        fontSize = 13.sp,
                        color = GrayText
                    )
                }
            }
        }
    }
}

@Composable
private fun ActivityCard(
    activity: WellnessActivity,
    completed: Boolean,
    onComplete: () -> Unit
) {

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
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = activity.icon,
                modifier = Modifier
                    .size(58.dp)
                    .background(
                        if (completed) {
                            SoftGreen
                        } else {
                            SoftBlue
                        },
                        RoundedCornerShape(18.dp)
                    )
                    .padding(12.dp),
                fontSize = 27.sp
            )

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = activity.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkText
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = activity.description,
                    fontSize = 12.sp,
                    color = GrayText
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = activity.duration,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryBlue
                )
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            if (completed) {

                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Completed",
                    tint = Color(0xFF22C55E),
                    modifier = Modifier.size(25.dp)
                )

            } else {

                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "Complete",
                    tint = GrayText,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            onComplete()
                        }
                )
            }
        }
    }
}