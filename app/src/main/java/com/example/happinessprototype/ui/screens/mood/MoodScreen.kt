package com.example.happinessprototype.ui.screens.mood

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
private val SelectedBackground = Color(0xFFEAF4FF)

@Composable
fun MoodScreen(
    onBack: () -> Unit = {},
    onMoodSelected: (Int, String) -> Unit = { _, _ -> }
) {
    var selectedMood by remember {
        mutableStateOf("")
    }

    val moods = listOf(
        Triple("😄", "Amazing", 95),
        Triple("🙂", "Good", 80),
        Triple("😐", "Okay", 65),
        Triple("😔", "Low", 45),
        Triple("😢", "Sad", 30)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {

        // Top bar
        Row(
            modifier = Modifier.fillMaxWidth(),
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
                text = "Mood Check-in",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )
        }

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        // Heading
        Text(
            text = "How are you feeling today?",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = DarkText
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Take a moment to check in with yourself.",
            fontSize = 15.sp,
            color = GrayText
        )

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        // Mood options
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            moods.forEach { (emoji, mood, score) ->

                val isSelected = selectedMood == mood

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .background(
                            if (isSelected) {
                                SelectedBackground
                            } else {
                                Color.White
                            }
                        )
                        .clickable {
                            selectedMood = mood
                        }
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Emoji
                    Text(
                        text = emoji,
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(
                                Color(0xFFF5F7FA)
                            )
                            .padding(10.dp),
                        fontSize = 27.sp
                    )

                    Spacer(
                        modifier = Modifier.width(16.dp)
                    )

                    // Mood name
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = mood,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = DarkText
                        )

                        Spacer(
                            modifier = Modifier.height(2.dp)
                        )

                        Text(
                            text = "Happiness score: $score",
                            fontSize = 12.sp,
                            color = GrayText
                        )
                    }

                    // Selected check
                    if (isSelected) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selected",
                            tint = PrimaryBlue
                        )
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        // Continue button
        Button(
            onClick = {
                val selected = moods.firstOrNull {
                    it.second == selectedMood
                }

                if (selected != null) {
                    onMoodSelected(
                        selected.third,
                        selected.second
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = selectedMood.isNotEmpty(),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryBlue
            )
        ) {
            Text(
                text = "Continue",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}