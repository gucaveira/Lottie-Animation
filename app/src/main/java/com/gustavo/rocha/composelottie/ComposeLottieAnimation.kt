package com.gustavo.rocha.composelottie

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun ComposeLottieAnimation(modifier: Modifier, isSuccess: Boolean, isFailed: Boolean) {

    val clipSpecs = LottieClipSpec.Progress(
        min = if (isFailed) 0.499f else 0.282f,
        max = if (isSuccess) 0.44f else if (isFailed) 0.95f else 0.282f
    )

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_loading_success_failed))

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = if (isSuccess || isFailed) 1 else LottieConstants.IterateForever,
        clipSpec = clipSpecs
    )
}