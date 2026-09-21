package com.example.happinessprototype.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.happinessprototype.ui.screens.community.CommunityScreen
import com.example.happinessprototype.ui.screens.home.HomeScreen
import com.example.happinessprototype.ui.screens.journal.JournalScreen
import com.example.happinessprototype.ui.screens.mood.MoodScreen
import com.example.happinessprototype.ui.screens.profile.ProfileScreen
import com.example.happinessprototype.ui.screens.progress.ProgressScreen
import com.example.happinessprototype.ui.screens.rewards.RewardsScreen
import com.example.happinessprototype.ui.screens.settings.SettingsScreen
import com.example.happinessprototype.ui.screens.wellness.WellnessScreen

object Routes {
    const val HOME = "home"
    const val MOOD = "mood"
    const val WELLNESS = "wellness"
    const val JOURNAL = "journal"
    const val PROGRESS = "progress"
    const val COMMUNITY = "community"
    const val REWARDS = "rewards"
    const val PROFILE = "profile"
    const val SETTINGS = "settings"
}

data class BottomNavItem(
    val route: String,
    val label: String
)

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {

    var happinessScore by remember {
        mutableIntStateOf(78)
    }

    val bottomNavItems = listOf(
        BottomNavItem(
            Routes.HOME,
            "Home"
        ),
        BottomNavItem(
            Routes.WELLNESS,
            "Wellness"
        ),
        BottomNavItem(
            Routes.JOURNAL,
            "Journal"
        ),
        BottomNavItem(
            Routes.COMMUNITY,
            "Community"
        ),
        BottomNavItem(
            Routes.REWARDS,
            "Rewards"
        )
    )

    val navBackStackEntry =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        navBackStackEntry.value?.destination?.route

    val showBottomBar =
        bottomNavItems.any {
            it.route == currentRoute
        }

    Scaffold(
        bottomBar = {

            if (showBottomBar) {

                NavigationBar {

                    bottomNavItems.forEach { item ->

                        NavigationBarItem(
                            selected = currentRoute == item.route,

                            onClick = {

                                navController.navigate(item.route) {

                                    popUpTo(Routes.HOME) {
                                        saveState = true
                                    }

                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },

                            icon = {

                                when (item.route) {

                                    Routes.HOME -> {
                                        Icon(
                                            imageVector = Icons.Default.Home,
                                            contentDescription = "Home"
                                        )
                                    }

                                    Routes.WELLNESS -> {
                                        Icon(
                                            imageVector = Icons.Default.Favorite,
                                            contentDescription = "Wellness"
                                        )
                                    }

                                    Routes.JOURNAL -> {
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = "Journal"
                                        )
                                    }

                                    Routes.COMMUNITY -> {
                                        Icon(
                                            imageVector = Icons.Default.People,
                                            contentDescription = "Community"
                                        )
                                    }

                                    Routes.REWARDS -> {
                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Rewards"
                                        )
                                    }
                                }
                            },

                            label = {
                                Text(item.label)
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = androidx.compose.ui.Modifier.padding(
                paddingValues
            )
        ) {

            // HOME
            composable(Routes.HOME) {

                HomeScreen(
                    happinessScore = happinessScore,

                    onMoodClick = {
                        navController.navigate(Routes.MOOD)
                    },

                    onWellnessClick = {
                        navController.navigate(Routes.WELLNESS)
                    },

                    onJournalClick = {
                        navController.navigate(Routes.JOURNAL)
                    },

                    onCommunityClick = {
                        navController.navigate(Routes.COMMUNITY)
                    },

                    onRewardsClick = {
                        navController.navigate(Routes.REWARDS)
                    },

                    onProfileClick = {
                        navController.navigate(Routes.PROFILE)
                    }
                )
            }

            // MOOD
            composable(Routes.MOOD) {

                MoodScreen(

                    onBack = {
                        navController.popBackStack()
                    },

                    onMoodSelected = { score, _ ->

                        happinessScore = score

                        navController.popBackStack()
                    }
                )
            }

            // WELLNESS
            composable(Routes.WELLNESS) {

                WellnessScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            // JOURNAL
            composable(Routes.JOURNAL) {

                JournalScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            // PROGRESS
            composable(Routes.PROGRESS) {

                ProgressScreen(
                    happinessScore = happinessScore,

                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            // COMMUNITY
            composable(Routes.COMMUNITY) {

                CommunityScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            // REWARDS
            composable(Routes.REWARDS) {

                RewardsScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            // PROFILE
            composable(Routes.PROFILE) {

                ProfileScreen(
                    onBack = {
                        navController.popBackStack()
                    },

                    onSettings = {
                        navController.navigate(Routes.SETTINGS)
                    },

                    onProgress = {
                        navController.navigate(Routes.PROGRESS)
                    }
                )
            }

            // SETTINGS
            composable(Routes.SETTINGS) {

                SettingsScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}