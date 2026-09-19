package com.example.happinessprototype.ui.screens.home

import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
fun HomeScreen() {

    Scaffold(
        containerColor = Background,

        bottomBar = {
            HomeBottomNavigation()
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp,
                bottom = 24.dp
            ),

            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            item {
                Header()
            }

            item {
                HappinessCard()
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
                    background = SoftYellow
                )
            }

            item {
                WellnessCard(
                    icon = "🌿",
                    title = "Today's Activity",
                    description = "A small activity can make a big difference.",
                    background = SoftGreen
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
                    background = SoftPurple
                )
            }
        }
    }
}
@Composable
private fun Header() {

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
                    .wrapContentSize(Alignment.Center),

                color = PrimaryBlue,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Composable
private fun HappinessCard() {

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
                        text = "78",
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
                    text = "You're doing great! 💙",
                    fontSize = 13.sp,
                    color = GrayText
                )
            }

            Text(
                text = "78%",
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
    background: Color
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },

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
@Composable
private fun HomeBottomNavigation() {

    NavigationBar(
        containerColor = Color.White
    ) {

        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Home"
                )
            },
            label = {
                Text("Home")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Wellness"
                )
            },
            label = {
                Text("Wellness")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Journal"
                )
            },
            label = {
                Text("Journal")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.People,
                    contentDescription = "Community"
                )
            },
            label = {
                Text("Community")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Rewards"
                )
            },
            label = {
                Text("Rewards")
            }
        )
    }
}