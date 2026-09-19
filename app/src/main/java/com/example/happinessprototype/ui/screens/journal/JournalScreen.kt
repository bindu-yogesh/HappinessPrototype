package com.example.happinessprototype.ui.screens.journal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFFF7FBFC)
private val PrimaryBlue = Color(0xFF3B82F6)
private val DarkText = Color(0xFF172554)
private val GrayText = Color(0xFF64748B)

@Composable
fun JournalScreen(
    onBack: () -> Unit = {}
) {

    var journalText by remember {
        mutableStateOf("")
    }

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

            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = DarkText
                )
            }

            Text(
                text = "Journal",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "How was your day? ✨",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = DarkText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Write freely. This is your space to reflect.",
            fontSize = 15.sp,
            color = GrayText
        )

        Spacer(modifier = Modifier.height(28.dp))

        OutlinedTextField(
            value = journalText,
            onValueChange = {
                journalText = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            placeholder = {
                Text(
                    text = "What's on your mind today?",
                    color = GrayText
                )
            },
            shape = RoundedCornerShape(22.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Today's reflection",
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkText
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            ReflectionChip("Grateful")

            ReflectionChip("Peaceful")

            ReflectionChip("Proud")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                // Later we'll save the journal entry
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = journalText.isNotBlank(),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryBlue
            )
        ) {

            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Save"
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(
                text = "Save Reflection",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun ReflectionChip(
    text: String
) {

    Text(
        text = text,
        modifier = Modifier
            .background(
                Color.White,
                RoundedCornerShape(50.dp)
            )
            .padding(
                horizontal = 15.dp,
                vertical = 10.dp
            ),
        fontSize = 13.sp,
        color = DarkText
    )
}