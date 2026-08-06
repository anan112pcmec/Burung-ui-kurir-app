package com.example.burungkurirapp.ui

import androidx.compose.runtime.Composable
import com.example.burungkurirapp.ui.page.GeneralReusable.NavFooter.Element
import com.example.burungkurirapp.ui.page.GeneralReusable.NavFooter.NavFooter
import com.example.burungkurirapp.ui.page.GeneralReusable.NavHeader.Element
import com.example.burungkurirapp.ui.page.GeneralReusable.NavHeader.NavHeader
import com.example.burungkurirapp.ui.page.Home.HomePage
import com.example.burungkurirapp.ui.routes.KurirAppsRouting
import com.example.burungkurirapp.ui.routes.RoutesProps

// Blok Konstanta
val DefaultRoutes: String = "/"
val HeaderElementValue: NavHeader = NavHeader()
val FooterElementValue: NavFooter = NavFooter()
val ApplicationRouting: List<RoutesProps> = listOf(
    RoutesProps("/", listOf(
        {HomePage()}
    ))
)

//Blok UI
@Composable
fun BurungKurirAppWrapper(): Unit{
    HeaderElementValue.Element()
    KurirAppsRouting(
        startDestination = DefaultRoutes,
        props = ApplicationRouting
    )
    FooterElementValue.Element()

}