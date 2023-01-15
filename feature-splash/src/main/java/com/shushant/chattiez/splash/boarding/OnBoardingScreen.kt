package com.shushant.chattiez.splash.boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shushant.chatiez.feature.splash.R
import com.shushant.common.compose.textBrush
import com.shushant.common.compose.theme.*
import com.shushant.common.compose.ui.ComposeCircularProgressBar
import com.shushant.resource.ChatIcons

@Composable
fun OnBoardingScreen(
    bgImage: ChatIcons,
    illustration: ChatIcons,
    title: String,
    subtitle: String,
    value: Int,
    skipClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = bgImage.drawable),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(text = stringResource(R.string.skip),
            style = Typography.bodyLarge,
            textAlign = TextAlign.Right,
            color = textColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 54.dp, end = 14.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    skipClick.invoke()
                })

        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 10.dp)
                .padding(top = 164.dp)
        ) {
            Image(
                painter = painterResource(id = illustration.drawable),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(282.dp)
            )

            Text(
                text = title,
                style = Typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .textBrush(
                        Brush.linearGradient(
                            colors = listOf(
                                GradientStart, GradientEnd
                            ), tileMode = TileMode.Mirror
                        )
                    )
                    .fillMaxWidth()
                    .padding(top = 50.dp)
            )
            Text(
                text = subtitle,
                style = Typography.titleSmall,
                color = textColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                textAlign = TextAlign.Center,
            )
        }
        CirclePagination(value)
    }
}

@Composable
fun BoxScope.CirclePagination(value: Int) {
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(44.dp)
    ) {
        ComposeCircularProgressBar(
            size = 60.dp,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.BottomCenter),
            dataUsage = (value * 50).toFloat(),
            text = value.toString(),
        )
    }
}
