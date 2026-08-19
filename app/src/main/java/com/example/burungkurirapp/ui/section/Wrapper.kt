package com.example.burungkurirapp.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.burungkurirapp.ui.GeneralReusable.NavFooter.NavFooterPage
import com.example.burungkurirapp.ui.GeneralReusable.NavHeader.NavHeader
import com.example.burungkurirapp.ui.GeneralReusable.NavHeader.ReusableHeader
import com.example.burungkurirapp.ui.GeneralReusable.SideBar.Element
import com.example.burungkurirapp.ui.GeneralReusable.SideBar.SideBar
import com.example.burungkurirapp.ui.constant.prefix.AuthSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.HomeSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.LandingSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.RiwayatSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.TugasSectionPrefix
import com.example.burungkurirapp.ui.routes.RoutesProps
import com.example.burungkurirapp.ui.routes.Routing

class UiFlowState(val navController: NavHostController) {
    var isSidebarOpen by mutableStateOf(false)
    var rnPrefix by mutableStateOf(LandingSectionPrefix)
    var rnRouting by mutableStateOf(LandingSectionRouting)
}

val LocalUiFlowState = compositionLocalOf<UiFlowState> {
    error("UiFlowState belum di-provide!")
}

@Composable
fun rememberUiFlowState(
    navController: NavHostController = rememberNavController()
): UiFlowState {
    return remember { UiFlowState(navController) }
}

data class SectionRouting(val Prefix: String, val Routing: List<RoutesProps>)

val SideBar: SideBar = SideBar()
val NavHeader: NavHeader = NavHeader()

@Composable
fun BurungKurirAppWrapper() {
    // Langsung sediakan state global sejak awal menggunakan CompositionLocalProvider
    CompositionLocalProvider(LocalUiFlowState provides rememberUiFlowState()) {
        val state = LocalUiFlowState.current

        val navBackStackEntry by state.navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: LandingSectionPrefix

        val sectionRouter: List<SectionRouting> = remember {
            listOf(
                SectionRouting(HomeSectionPrefix, HomeSectionRouting),
                SectionRouting(AuthSectionPrefix, AuthSectionRouting),
                SectionRouting(LandingSectionPrefix, LandingSectionRouting),
                SectionRouting(TugasSectionPrefix, TugasSectionRouting),
                SectionRouting(RiwayatSectionPrefix, RiwayatSectionRouting)
            )
        }

        // Deteksi prefix dan routing aktif
        sectionRouter.forEach { section ->
            if (currentRoute == section.Prefix || currentRoute.startsWith("${section.Prefix}/")) {
                state.rnPrefix = section.Prefix
                state.rnRouting = section.Routing
            }
        }

        // Gabungkan semua rute untuk didaftarkan ke NavHost
        val allRoutes = remember { sectionRouter.flatMap { it.Routing } }

        Box(modifier = Modifier.fillMaxSize()) {

            // ─── 1. TATA LETAK UTAMA (HEADER, KONTEN, FOOTER) ───
            Column(modifier = Modifier.fillMaxSize()) {

                // Header
                NavHeader.ReusableHeader(
                    headerType = state.rnPrefix,
                    OpenSideBar = { state.isSidebarOpen = !state.isSidebarOpen },
                    navigation = state.navController
                )

                // Konten Utama (NavHost)
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Routing(
                        navController = state.navController,
                        startDestination = LandingSectionPrefix,
                        props = allRoutes
                    )
                }

                // Footer
                if (state.rnPrefix != LandingSectionPrefix && state.rnPrefix != AuthSectionPrefix) {
                    NavFooterPage(RoutingElement = state.navController)
                }
            }

            // ─── 2. SIDEBAR OVERLAY ───
            if (state.isSidebarOpen) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.4f))
                        .clickable { state.isSidebarOpen = false }
                )

                SideBar.Element(
                    widthFraction = 0.75f,
                    onItemSelect = { state.isSidebarOpen = false },
                    RoutingElement = state.navController,
                    RoutesList = state.rnRouting
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BurungKurirAppWrapperPreview() {
    BurungKurirAppWrapper()
}