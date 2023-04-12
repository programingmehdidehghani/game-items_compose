package com.example.game_api_compose.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.game_api_compose.presentation.theme.ValoRed

@Composable
fun SearchBar(
   searchText: String,
   placeholderText: String = "",
   onSearchTextChanged: (String) -> Unit = {},
   border: BorderStroke = BorderStroke((0.5f).dp, ValoRed),
   backgroundColor: Color = MaterialTheme.colors.surface.copy(alpha = 0.7f),
   shapes: RoundedCornerShape = RoundedCornerShape(32.dp),
   onClearClick: () -> Unit = {}
){
   val showClearBottom

}