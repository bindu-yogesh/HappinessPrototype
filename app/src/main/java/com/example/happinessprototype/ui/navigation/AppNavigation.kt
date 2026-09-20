package com.example.happinessprototype.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        // HOME
        composable(Routes.HOME) {
            HomeScreen(
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