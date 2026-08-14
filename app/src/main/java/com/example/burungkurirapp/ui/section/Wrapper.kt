package com.example.burungkurirapp.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhonelinkLock
import androidx.compose.material.icons.filled.QueryStats
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.burungkurirapp.ui.GeneralReusable.NavFooter.NavFooterPage
import com.example.burungkurirapp.ui.GeneralReusable.NavHeader.NavHeaderPage
import com.example.burungkurirapp.ui.GeneralReusable.SideBar.Element
import com.example.burungkurirapp.ui.GeneralReusable.SideBar.SideBar
import com.example.burungkurirapp.ui.routes.RoutesProps
import com.example.burungkurirapp.ui.section.Home.page.Alamat.AlamatPage
import com.example.burungkurirapp.ui.section.Home.page.DokumenInformasi.DokumenInformasiPage
import com.example.burungkurirapp.ui.section.Home.page.DokumenKendaraan.DokumenKendaraanPage
import com.example.burungkurirapp.ui.section.Home.page.Home.HomePage
import com.example.burungkurirapp.ui.section.Home.page.HomeSectionWrapper
import com.example.burungkurirapp.ui.section.Home.page.Privasi.PrivasiPage
import com.example.burungkurirapp.ui.section.Home.page.Profile.ProfilePage
import com.example.burungkurirapp.ui.section.Home.page.Rekening.RekeningPage
import com.example.burungkurirapp.ui.section.Overview.OverviewPage



val HomeSectionRouting: List<RoutesProps> = listOf(
    RoutesProps(
        name = "Beranda",
        Path = "/home/",
        Icon = Icons.Default.Home,
        Component = listOf({
            HomePage()
        })
    ),
    RoutesProps(
        name = "Profil",
        Path = "/home/Profil",
        Icon = Icons.Default.Person,
        Component = listOf({ ProfilePage() })
    ),
    RoutesProps(
        name = "Dokumen Kendaraan",
        Path = "/home/DokumenKendaraan",
        Icon = Icons.Default.DirectionsCar,
        Component = listOf({ DokumenKendaraanPage() })
    ),
    RoutesProps(
        name = "Dokumen Informasi",
        Path = "/home/DokumenInformasi",
        Icon = Icons.Default.Info,
        Component = listOf({ DokumenInformasiPage() })
    ),
    RoutesProps(
        name = "Alamat",
        Path = "/home/Alamat",
        Icon = Icons.Default.LocationOn,
        Component = listOf({ AlamatPage() })
    ),
    RoutesProps(
        name = "Privasi",
        Path = "/home/Privasi",
        Icon = Icons.Default.PhonelinkLock,
        Component = listOf({ PrivasiPage() })
    ),
    RoutesProps(
        name = "Rekening",
        Path = "/home/Rekening",
        Icon = Icons.Default.AccountBalanceWallet,
        Component = listOf({ RekeningPage() })
    ),
    RoutesProps(
        name = "Overview",
        Path = "/home/Overview",
        Icon = Icons.Default.QueryStats,
        Component = listOf({ OverviewPage() })
    )
)

class UiFlowState {
    var isSidebarOpen by mutableStateOf(false)
    var rnPrefix by mutableStateOf("")
    var rnSection by mutableStateOf(@Composable (){})

    var rnRouting by mutableStateOf(listOf<RoutesProps>())
}

@Composable
fun rememberUiFlowState(): UiFlowState {
    return remember { UiFlowState() }
}

data class SectionRouting(val El: @Composable () ->Unit, val Prefix: String, val Routing: List<RoutesProps>)

val SideBar: SideBar = SideBar()

@Preview(showBackground = true)
@Composable
fun BurungKurirAppWrapper(){
    var navController: NavHostController = rememberNavController()
    var state: UiFlowState = rememberUiFlowState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    val SectionRouter: List<SectionRouting> = listOf(
        SectionRouting({HomeSectionWrapper(navController, HomeSectionRouting, "/home")}, "/home", HomeSectionRouting)
    )

    Box(modifier = Modifier.fillMaxSize()) {

        // ─── 1. TATA LETAK UTAMA (HEADER, KONTEN, FOOTER) ───
        Column(modifier = Modifier.fillMaxSize()) {

            // Header
            NavHeaderPage(
                OpenSideBar = { state.isSidebarOpen = true }
            ) {
                state.isSidebarOpen = !state.isSidebarOpen // Toggle Sidebar
            }

            // Konten Utama
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                SectionRouter.forEach { section ->
                    if (currentRoute == section.Prefix || currentRoute.startsWith("${section.Prefix}/")) {
                        state.rnPrefix = section.Prefix
                        state.rnSection = section.El
                        state.rnRouting = section.Routing
                    }
                }
                state.rnSection()
            }

            // Footer (Tetap terkunci di bawah)
            NavFooterPage(RoutingElement = navController)
        }

        // ─── 2. SIDEBAR OVERLAY ───
        if (state.isSidebarOpen) {
            // Backdrop gelap saat sidebar terbuka
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
                    .clickable { state.isSidebarOpen = false }
            )

            // Elemen Sidebar Melayang di Atas
            SideBar.Element(
                widthFraction = 0.75f,
                onItemSelect = { state.isSidebarOpen = false },
                RoutingElement = navController,
                RoutesList = state.rnRouting
            )
        }
    }


}