package com.mungaicodes.minotes.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mungaicodes.minotes.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.mungaicodes.minotes.feature_note.presentation.notes.NotesScreen
import com.mungaicodes.minotes.feature_note.presentation.util.Screen
import com.mungaicodes.minotes.ui.theme.MiNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NotesScreen.route
                    ) {

                        composable(Screen.NotesScreen.route) {
                            NotesScreen(navHostController = navController)
                        }

                        composable(
                            Screen.AddEditNoteScreen.route +
                                    "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) { navBackStackEntry ->

                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = navBackStackEntry.arguments?.getInt("noteColor") ?: -1
                            )
                        }
                    }
                }
            }
        }
    }
}


