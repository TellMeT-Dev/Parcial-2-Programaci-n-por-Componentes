package com.example.parcial.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.parcial.data.enums.TypeScreen
import com.example.parcial.viewmodels.TripViewModel
import com.example.parcial.views.screens.HomeScreen
import com.example.parcial.views.theme.ParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ParcialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var currentScreen by remember { mutableStateOf(TypeScreen.HOME) }

                    val tripViewModel: TripViewModel by viewModels()
                    val model by tripViewModel.model.collectAsState()

                    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        when (currentScreen) {
                            TypeScreen.HOME -> {
                                HomeScreen(
                                    trips = model,
                                    onClickGame = {
                                    },
                                    onClickMultiplayer = {
                                    }
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}