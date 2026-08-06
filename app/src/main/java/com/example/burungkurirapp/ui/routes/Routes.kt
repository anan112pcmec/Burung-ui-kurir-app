package com.example.burungkurirapp.ui.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun KurirAppsRouting(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    props: List<RoutesProps>
) {
    // NavHost berfungsi sebagai wadah penampil halaman berdasarkan route (Path)
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Melakukan looping pada list routes yang Anda berikan
        props.forEach { route ->
            composable(route.Path) {
                // Menjalankan Composable sesuai dengan Path-nya
                val componentServe: (components: List<@Composable (() -> Unit)>) -> @Composable () -> Unit =  { components -> {
                    components.forEach { component -> component() }
                }}

                componentServe(route.Component)
            }
        }
    }
}