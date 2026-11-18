package com.example.gamespace.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gamespace.data.GameModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameLibraryScreen(games: List<GameModel>, onGameClick: (GameModel) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("HyperGame Space - Library") }) }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize().padding(padding).padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(games) { game ->
                Card(
                    modifier = Modifier.aspectRatio(0.85f).clickable { onGameClick(game) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = game.appName, style = Material3Theme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = game.profile.name, style = Material3Theme.typography.labelSmall, color = Material3Theme.colorScheme.primary)
                    }
                }
            }
        }
    }
}
