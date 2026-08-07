package com.example.burungkurirapp.ui.helper

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

interface Layout {
    val content: List<@Composable () -> Unit>
    val fraction: Float

    fun validation(): Boolean = fraction <= 1f
}

abstract class LayoutRowItem(
    override val fraction: Float,
    override val content: List<@Composable () -> Unit>,
    val verticalPos: Alignment.Vertical = Alignment.CenterVertically,
    val horizontalPos: Arrangement.Horizontal = Arrangement.Start
) : Layout

@Composable
fun LayoutingRowCompose(props: LayoutRowItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = props.horizontalPos,
        verticalAlignment = props.verticalPos
    ) {
        props.content.forEach { composable ->
            Box(modifier = Modifier.fillMaxWidth(props.fraction)) {
                composable()
            }
        }
    }
}

abstract class LayoutColumnItem(
    override val fraction: Float,
    override val content: List<@Composable () -> Unit>,
    val horizontalPos: Alignment.Horizontal = Alignment.Start,
    val verticalPos: Arrangement.Vertical = Arrangement.Top
) : Layout

@Composable
fun LayoutingColumnCompose(props: LayoutColumnItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = props.horizontalPos,
        verticalArrangement = props.verticalPos
    ) {
        props.content.forEach { composable ->
            Box(modifier = Modifier.fillMaxWidth(props.fraction)) {
                composable()
            }
        }
    }
}