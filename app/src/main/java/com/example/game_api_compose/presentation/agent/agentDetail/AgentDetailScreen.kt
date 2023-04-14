package com.example.game_api_compose.presentation.agent.agentDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.game_api_compose.presentation.theme.ValoRed
import com.example.game_api_compose.presentation.theme.ValoWhite
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun AgentDetailScreen(
    viewModel: AgentDetailViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
         horizontalAlignment = Alignment.CenterHorizontally
    ) {

        state.agent?.let {
            Box(
                modifier = Modifier
                    .background(
                        color = ValoRed,
                        shape = RoundedCornerShape(
                            bottomStart = 32.dp,
                            bottomEnd = 32.dp
                        )
                    )
                    .padding(24.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
               GlideImage(
                   modifier = Modifier.size(300.dp),
                   imageModel = it.fullPortrait,
                   circularReveal = CircularReveal(),
                   contentDescription = stringResource(R.string.default_error_message)
               )
                
                Spacer(modifier = Modifier.size(24.dp))

                Text(
                    text = it.displayName,
                    style = MaterialTheme.typography.h4
                )

                Spacer(modifier = Modifier.size(12.dp))

                Text(
                    text = it.role?.displayName.orEmpty(),
                    style = MaterialTheme.typography.h5
                )
            }
        }

        Spacer(modifier = Modifier.size(24.dp))

    }

}