package com.core_ui.components

import Colors
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TopAppBar(
    title: String?,
    showAppBarContent: Boolean,
    onBackAction: (() -> Unit)? = null,
    iconActions: @Composable RowScope.() -> Unit
) {
    TopAppBar(
        contentColor = Colors.tertiary,
        backgroundColor = Colors.background,
        title = {
            Crossfade(showAppBarContent && title != null) { show ->
                if (show) Text(text = title!!)
            }
        },
        navigationIcon = if (onBackAction != null) {
            {
                IconButton(onClick = { onBackAction.invoke() }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "arrow back",
                        tint = Colors.primary
                    )
                }
            }
        } else {
            null
        },
        actions = iconActions,
        elevation = 0.dp
    )
}

private val AppBarHeight = 56.dp
