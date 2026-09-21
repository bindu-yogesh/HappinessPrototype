package com.example.happinessprototype.ui.screens.journal

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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
private val SoftPurple = Color(0xFFF3EEFF)
private val SoftBlue = Color(0xFFEAF4FF)

data class JournalEntry(
    val text: String,
    val feeling: String
)

@Composable
fun JournalScreen(
    onBack: () -> Unit = {}
) {
    var journalText by remember {
        mutableStateOf("")
    }

    var selectedFeeling by remember {
        mutableStateOf("")
    }

    val entries = remember {
        mutableStateListOf<JournalEntry>()
    }

    val feelings = listOf(
        "😊 Happy",
        "😌 Calm",
        "😐 Okay",
        "😔 Low",
        "💭 Thoughtful"
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
                .padding(
                    horizontal = 12.dp,
                    vertical = 10.dp
                ),
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
                text = "Journal",
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Heading
            item {

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Write it down ✍️",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Take a moment to reflect on your thoughts and feelings.",
                    fontSize = 14.sp,
                    color = GrayText
                )
            }

            // Journal input card
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
                            .padding(18.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Write",
                                tint = PrimaryBlue,
                                modifier = Modifier.size(20.dp)
                            )

                            Spacer(
                                modifier = Modifier.width(8.dp)
                            )

                            Text(
                                text = "Today's reflection",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = DarkText
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(14.dp)
                        )

                        OutlinedTextField(
                            value = journalText,
                            onValueChange = {
                                journalText = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            placeholder = {
                                Text(
                                    text = "How was your day? What is on your mind?",
                                    color = GrayText
                                )
                            },
                            shape = RoundedCornerShape(18.dp)
                        )

                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )

                        Text(
                            text = "How are you feeling?",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = DarkText
                        )

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            feelings.chunked(2).forEach { rowFeelings ->

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {

                                    rowFeelings.forEach { feeling ->

                                        val isSelected =
                                            selectedFeeling == feeling

                                        Text(
                                            text = feeling,
                                            modifier = Modifier
                                                .weight(1f)
                                                .background(
                                                    if (isSelected) {
                                                        SoftBlue
                                                    } else {
                                                        Color(0xFFF8FAFC)
                                                    },
                                                    RoundedCornerShape(14.dp)
                                                )
                                                .clickable {
                                                    selectedFeeling = feeling
                                                }
                                                .padding(
                                                    horizontal = 10.dp,
                                                    vertical = 12.dp
                                                ),
                                            fontSize = 13.sp,
                                            fontWeight = if (isSelected) {
                                                FontWeight.Bold
                                            } else {
                                                FontWeight.Normal
                                            },
                                            color = if (isSelected) {
                                                PrimaryBlue
                                            } else {
                                                DarkText
                                            }
                                        )
                                    }

                                    if (rowFeelings.size == 1) {
                                        Spacer(
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(18.dp)
                        )

                        Button(
                            onClick = {

                                if (journalText.isNotBlank()) {

                                    entries.add(
                                        JournalEntry(
                                            text = journalText.trim(),
                                            feeling = selectedFeeling
                                        )
                                    )

                                    journalText = ""
                                    selectedFeeling = ""
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            enabled = journalText.isNotBlank(),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PrimaryBlue
                            )
                        ) {

                            Text(
                                text = "Save Reflection",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Saved entries heading
            item {

                Text(
                    text = "Your Reflections",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )
            }

            // Empty state
            if (entries.isEmpty()) {

                item {

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(22.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SoftPurple
                        )
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "📖",
                                fontSize = 34.sp
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "No reflections yet",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = DarkText
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Your saved thoughts will appear here.",
                                fontSize = 13.sp,
                                color = GrayText
                            )
                        }
                    }
                }

            } else {

                // Saved entries
                items(
                    items = entries
                ) { entry ->

                    JournalEntryCard(
                        entry = entry,
                        onDelete = {
                            entries.remove(entry)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun JournalEntryCard(
    entry: JournalEntry,
    onDelete: () -> Unit
) {

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
                .padding(18.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Reflection",
                    modifier = Modifier.weight(1f),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue
                )

                IconButton(
                    onClick = onDelete
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = GrayText
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = entry.text,
                fontSize = 15.sp,
                color = DarkText,
                lineHeight = 22.sp
            )

            if (entry.feeling.isNotEmpty()) {

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = entry.feeling,
                    modifier = Modifier
                        .background(
                            SoftBlue,
                            RoundedCornerShape(12.dp)
                        )
                        .padding(
                            horizontal = 12.dp,
                            vertical = 7.dp
                        ),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryBlue
                )
            }
        }
    }
}