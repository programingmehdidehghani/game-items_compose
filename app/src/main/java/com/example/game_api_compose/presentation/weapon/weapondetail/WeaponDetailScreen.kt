package com.example.game_api_compose.presentation.weapon.weapondetail

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
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.example.game_api_compose.R
import com.example.game_api_compose.common.components.HeaderText
import com.example.game_api_compose.common.components.LinearProgress


@Composable
fun WeaponDetailScreen(
    viewModel: WeaponDetailViewModel = hiltViewModel()
){

    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        state.weapon?.let {
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    GlideImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp, vertical = 24.dp),
                        imageModel = it.displayIcon,
                        circularReveal = CircularReveal(),
                        contentDescription = stringResource(R.string.desc_weapon_image)
                    )

                    Spacer(modifier = Modifier.size(12.dp))

                    Text(
                        text = it.category.orEmpty().replace("EEquippableCategory::",""),
                        style = MaterialTheme.typography.h5
                    )
                }
            }
            Spacer(modifier = Modifier.size(24.dp))
            
            HeaderText(header = stringResource(R.string.title_damage_range))

            Spacer(modifier = Modifier.size(16.dp))

            it.weaponStats?.damageRanges?.getOrNull(0)?.let { damageRange ->
                Column(
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp)
                ) {
                   damageRange.headDamage?.div(200)?.let { it1 ->
                       LinearProgress(
                           header = stringResource(R.string.text_head),
                           progress = it1.toFloat(),
                           progressString = damageRange.headDamage.toString()
                       )
                   }

                    damageRange.bodyDamage?.toFloat()?.div(200)?.let { it1->
                        LinearProgress(
                            header = stringResource(R.string.text_body),
                            progress = it1,
                            progressString = damageRange.bodyDamage.toString()
                        )
                    }

                    damageRange.legDamage?.div(200)?.let { it1 ->
                        LinearProgress(
                            header = stringResource(id = R.string.text_leg),
                            progress = it1.toFloat(),
                            progressString = damageRange.legDamage.toString()
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(16.dp))
            
            HeaderText(header = )
        }

    }

}