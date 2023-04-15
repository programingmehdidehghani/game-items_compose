package com.example.game_api_compose.presentation.map.maps

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.game_api_compose.domain.model.Map

@Composable
fun MapItem(
    map: Map,
    onItemClick: (String) -> Unit
){
    Card(
        modifier = Modifier
            .clickable { onItemClick(map.uuid.orEmpty()) }
            .fillMaxWidth()
            .padding(16.dp)
    ) {

    }

}