package com.example.game_api_compose.presentation.agent.agentDetail

import android.widget.TableLayout
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.game_api_compose.common.components.HeaderText
import com.example.game_api_compose.presentation.theme.ValoRed
import com.example.game_api_compose.presentation.theme.ValoWhite
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.example.game_api_compose.R
import com.example.game_api_compose.common.components.ErrorText
import com.example.game_api_compose.data.model.agents.Ability
import com.example.game_api_compose.presentation.theme.ValoLightBlue
import com.google.accompanist.pager.ExperimentalPagerApi


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
                    modifier = Modifier.fillMaxSize(),
                    imageModel = it.role?.displayIcon,
                    circularReveal = CircularReveal(),
                    alpha = 0.2f
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GlideImage(
                        modifier = Modifier.size(300.dp),
                        imageModel = it.fullPortrait,
                        circularReveal = CircularReveal(),
                        contentDescription = stringResource(R.string.desc_agent_image)
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

            HeaderText(header = stringResource(R.string.title_description))

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp
                ),
                text = it.description,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.size(24.dp))
            
            HeaderText(header = stringResource(R.string.title_abilities))

            Spacer(modifier = Modifier.size(8.dp))

            TabLayout(it.abilities)
        }

        if (state.error.isNotBlank()) ErrorText(
            state.error,
            Modifier.align(Alignment.CenterHorizontally)
        )
            
        if (state.isLoading){
           CircularProgressIndicator(
               modifier = Modifier.align(Alignment.CenterHorizontally),
               color = Color.White
           )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(
    abilities: List<Ability>
){
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Card(
        backgroundColor = ValoLightBlue,
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(20.dp)
            )
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
    ) {
        Column(
            TabRow(selectedTabIndex = ) {
                
            }
        ) {

        }

    }
}