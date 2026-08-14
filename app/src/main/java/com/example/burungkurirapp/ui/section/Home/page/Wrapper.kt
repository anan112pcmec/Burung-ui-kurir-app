package com.example.burungkurirapp.ui.section.Home.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhonelinkLock
import androidx.compose.material.icons.filled.QueryStats
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.burungkurirapp.ui.section.Home.page.DokumenInformasi.DokumenInformasiPage
import com.example.burungkurirapp.ui.section.Home.page.DokumenKendaraan.DokumenKendaraanPage
import com.example.burungkurirapp.ui.GeneralReusable.NavFooter.NavFooterPage
import com.example.burungkurirapp.ui.GeneralReusable.NavHeader.NavHeaderPage
import com.example.burungkurirapp.ui.GeneralReusable.SideBar.Element
import com.example.burungkurirapp.ui.GeneralReusable.SideBar.SideBar
import com.example.burungkurirapp.ui.section.Home.page.Alamat.AlamatPage
import com.example.burungkurirapp.ui.section.Home.page.Privasi.PrivasiPage
import com.example.burungkurirapp.ui.section.Home.page.Profile.ProfilePage
import com.example.burungkurirapp.ui.section.Home.page.Rekening.RekeningPage
import com.example.burungkurirapp.ui.routes.Routing
import com.example.burungkurirapp.ui.routes.RoutesProps
import com.example.burungkurirapp.ui.section.Home.page.Home.HomePage
import com.example.burungkurirapp.ui.section.Overview.OverviewPage



@Composable
fun HomeSectionWrapper(navController: NavHostController, RoutingEl: List<RoutesProps>, Prefix: String) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Routing(
                    navController = navController,
                    startDestination = Prefix,
                    props = RoutingEl
                )
            }
}