package com.example.burungkurirapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.burungkurirapp.ui.page.GeneralReusable.NavFooter.NavFooter
import com.example.burungkurirapp.ui.page.GeneralReusable.NavFooter.NavFooterPage
import com.example.burungkurirapp.ui.page.GeneralReusable.NavHeader.NavHeaderPage
import com.example.burungkurirapp.ui.page.Home.Home
import com.example.burungkurirapp.ui.page.Home.Homepage
import com.example.burungkurirapp.ui.routes.KurirAppsRouting
import com.example.burungkurirapp.ui.routes.RoutesProps

// Blok Konstanta
val DefaultRoutes: String = "/"
val FooterElementValue: NavFooter = NavFooter()
val HomeElementValue: Home = Home()
val ApplicationRouting: List<RoutesProps> = listOf(
    RoutesProps("/", listOf(
        { Homepage() },
    ))
)

// Blok UI
@Preview(showBackground = true)
@Composable
fun BurungKurirAppWrapper(): Unit {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 1. Header di bagian atas
        NavHeaderPage { }

        // 2. Konten utama / Routing di teng
        // PERBAIKAN: Tambahkan Modifier.weight(1f) agar NavHost mengambil sisa ruang layar
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            KurirAppsRouting(
                startDestination = DefaultRoutes,
                props = ApplicationRouting
            )
        }

        // 3. Footer di bagian bawah
        NavFooterPage { }
    }
}