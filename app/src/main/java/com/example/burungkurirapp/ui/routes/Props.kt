package com.example.burungkurirapp.ui.routes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class RoutesProps(
    val name: String,
    val Path: String,
    val Icon: ImageVector,
    val Component: List<@Composable () -> Unit>
)