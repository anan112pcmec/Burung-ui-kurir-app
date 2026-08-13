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
import com.example.burungkurirapp.ui.routes.KurirAppsRouting
import com.example.burungkurirapp.ui.routes.RoutesProps
import com.example.burungkurirapp.ui.section.Home.page.Home.HomePage
import com.example.burungkurirapp.ui.section.Overview.OverviewPage


val SideBarVaLues: SideBar = SideBar()

val DefaultRoutes: String = "/"

val ApplicationRouting: List<RoutesProps> = listOf(
    RoutesProps(
        name = "Beranda",
        Path = "/",
        Icon = Icons.Default.Home,
        Component = listOf({
            HomePage(
            )
        })
    ),
    RoutesProps(
        name = "Profil",
        Path = "/Profil",
        Icon = Icons.Default.Person,
        Component = listOf({ ProfilePage() })
    ),
    RoutesProps(
        name = "Dokumen Kendaraan",
        Path = "/DokumenKendaraan",
        Icon = Icons.Default.DirectionsCar,
        Component = listOf({ DokumenKendaraanPage() })
    ),
    RoutesProps(
        name = "Dokumen Informasi",
        Path = "/DokumenInformasi",
        Icon = Icons.Default.Info,
        Component = listOf({ DokumenInformasiPage() })
    ),
    RoutesProps(
        name = "Alamat",
        Path = "/Alamat",
        Icon = Icons.Default.LocationOn,
        Component = listOf({ AlamatPage() })
    ),
    RoutesProps(
        name = "Privasi",
        Path = "/Privasi",
        Icon = Icons.Default.PhonelinkLock,
        Component = listOf({ PrivasiPage() })
    ),
    RoutesProps(
        name = "Rekening",
        Path = "/Rekening",
        Icon = Icons.Default.AccountBalanceWallet,
        Component = listOf({ RekeningPage() })
    ),
    RoutesProps(
        name = "Overview",
        Path = "/Overview",
        Icon = Icons.Default.QueryStats,
        Component = listOf({ OverviewPage() })
    )
)

@Composable
fun BurungKurirAppWrapper() {
    var isSidebarOpen by remember { mutableStateOf(false) }
    val navController: NavHostController = rememberNavController() // navController ada di sini

    // Box Utama sebagai wadah tumpukan (Stacking)
    Box(modifier = Modifier.fillMaxSize()) {

        // ─── 1. TATA LETAK UTAMA (HEADER, KONTEN, FOOTER) ───
        Column(modifier = Modifier.fillMaxSize()) {

            // Header
            NavHeaderPage(
                OpenSideBar = { isSidebarOpen = true }
            ) {
                isSidebarOpen = !isSidebarOpen // Toggle Sidebar
            }

            // Konten Utama
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                // Untuk @Preview, panggil langsung Hompagenya agar kelihatan
                // Di runtime produksi, ganti kembali dengan KurirAppsRouting(...)
                KurirAppsRouting(
                    navController = navController,
                    startDestination = "/",
                    props = ApplicationRouting
                )
            }

            // Footer (Tetap terkunci di bawah)
            NavFooterPage(RoutingElement = navController)
        }

        // ─── 2. SIDEBAR OVERLAY ───
        if (isSidebarOpen) {
            // Backdrop gelap saat sidebar terbuka
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
                    .clickable { isSidebarOpen = false }
            )

            // Elemen Sidebar Melayang di Atas
            SideBarVaLues.Element(
                widthFraction = 0.75f,
                onItemSelect = { isSidebarOpen = false },
                RoutingElement = navController,
                RoutesList = ApplicationRouting
            )
        }
    }
}
@Preview(showBackground = true, name = "NGENTOT")
@Composable
fun BurungKurirAppWrapperPreview() {
    var isSidebarOpen by remember { mutableStateOf(false) }
    val navController: NavHostController = rememberNavController() // navController ada di sini

    // Box Utama sebagai wadah tumpukan (Stacking)
    Box(modifier = Modifier.fillMaxSize()) {

        // ─── 1. TATA LETAK UTAMA (HEADER, KONTEN, FOOTER) ───
        Column(modifier = Modifier.fillMaxSize()) {

            // Header
            NavHeaderPage(
                OpenSideBar = fun(){isSidebarOpen = true}
            ) {
                isSidebarOpen = !isSidebarOpen // Toggle Sidebar
            }

            // Konten Utama
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                // Untuk @Preview, panggil langsung Hompagenya agar kelihatan
                // Di runtime produksi, ganti kembali dengan KurirAppsRouting(...)
                HomePage(
                )
            }

            // Footer (Tetap terkunci di bawah)
            NavFooterPage(RoutingElement = navController)
        }

        // ─── 2. SIDEBAR OVERLAY ───
        if (isSidebarOpen) {
            // Backdrop gelap saat sidebar terbuka
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
                    .clickable { isSidebarOpen = false }
            )

            // Elemen Sidebar Melayang di Atas
            SideBarVaLues.Element (
                widthFraction = 0.75f,
                onItemSelect = { isSidebarOpen = false },
                RoutesList = ApplicationRouting
            )
        }
    }
}