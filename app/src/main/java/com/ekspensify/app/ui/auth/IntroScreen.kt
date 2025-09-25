package com.ekspensify.app.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ekspensify.app.R
import com.ekspensify.app.components.FilledButton
import com.ekspensify.app.components.VerticalSpace
import com.ekspensify.app.data.model.IntroPages
import com.ekspensify.app.navigation.LoginScreenRoute
import com.ekspensify.app.navigation.RegisterScreenRoute
import com.ekspensify.app.utils.singleClick

@Composable
fun IntroScreen(navController: NavHostController) {
    val introPages = remember { IntroPages.getPages() }
    val pagerState = rememberPagerState(
        pageCount = { introPages.size },
        initialPage = 0,
        initialPageOffsetFraction = 0f,
    )
    val textModifier = Modifier.padding(vertical = 17.dp)
    val btnModifier = Modifier.padding(horizontal = 20.dp)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(vertical = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.weight(1f))

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = true,
            flingBehavior = PagerDefaults.flingBehavior(state = pagerState),
            snapPosition = SnapPosition.Center
        ) { page ->
            PageView(introPages[page], modifier = Modifier.fillMaxWidth())
        }
//        Spacer(Modifier.weight(1f))
        VerticalSpace(30.dp)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pagerState.pageCount) {
                PageIndicator(pagerState.currentPage == it)
            }
        }
        VerticalSpace(30.dp)
        FilledButton(
            text = stringResource(R.string.sign_up),
            onClick = singleClick {
                navController.navigate(RegisterScreenRoute)
            },
            textModifier = textModifier,
            modifier = btnModifier
        )
        VerticalSpace(30.dp)
        FilledButton(
            text = stringResource(R.string.login),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary,
            ),
            onClick = singleClick {
                navController.navigate(LoginScreenRoute)
            },
            textModifier = textModifier,
            modifier = btnModifier
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun PageIndicator(isSelected: Boolean) {
    Box(
        Modifier
            .padding(6.dp)
            .size(if (isSelected) 10.dp else 5.dp)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.secondary,
            )
    )
}

@Composable
fun PageView(introPages: IntroPages, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(introPages.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Modernized: add a subtle surface/card behind texts for emphasis
        androidx.compose.material3.Surface(
            tonalElevation = 2.dp,
            shape = androidx.compose.material3.MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(introPages.titleRes),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 26.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(introPages.descriptionRes),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    ),
                    minLines = 2,
                    maxLines = 3,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }

}