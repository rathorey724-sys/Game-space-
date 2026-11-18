package com.example.gamespace.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val voiceEffects = listOf("Normal", "Robot", "Deep Monster", "Chipmunk", "Alien", "Echo", "Cave", "Radio", "Ghost", "Child")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoiceStudioScreen() {
    var selectedEffect by remember { mutableStateOf("Normal") }
    var pitch by remember { mutableFloatStateOf(1.0f) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Voice Changer Studio") }) }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            Text("Select Voice Effect", style = Material3Theme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(voiceEffects) { effect ->
                    FilterChip(
                        selected = selectedEffect == effect,
                        onClick = { selectedEffect = effect },
                        label = { Text(effect) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text("Pitch Adjustment: ${String.format("%.1f", pitch)}")
            Slider(
                value = pitch,
                onValueChange = { pitch = it },
                valueRange = 0.5f..2.0f
            )
        }
    }
}
