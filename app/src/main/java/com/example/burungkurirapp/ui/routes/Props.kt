package com.example.burungkurirapp.ui.routes

import androidx.compose.runtime.Composable

data class RoutesProps(
    val Path: String,
    val Component: List<@Composable () -> Unit>
)