package com.example.rtandroidtask.presentation.extensions

import android.annotation.SuppressLint
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role


@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.noIndicationClickable(
    interactionSource: MutableInteractionSource? = null,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: ()->Unit
) = composed {
    clickable(
        interactionSource = interactionSource ?: remember { MutableInteractionSource() },
        indication = null,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = onClick
    )
}



@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.rippleClickable(
    interactionSource: MutableInteractionSource? = null,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: ()->Unit
) = composed {
    clickable(
        interactionSource = interactionSource ?: remember { MutableInteractionSource() },
        indication = LocalIndication.current,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = onClick
    )
}

fun Modifier.clippedRippleClickable(
    interactionSource: MutableInteractionSource? = null,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    clipShape: Shape? = CircleShape,
    onClick: ()->Unit
) = composed {
    if (clipShape == null) { this } else { clip(clipShape) }.clickable(
        interactionSource = interactionSource ?: remember { MutableInteractionSource() },
        indication = LocalIndication.current,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = onClick
    )
}