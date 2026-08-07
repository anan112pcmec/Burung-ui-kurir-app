package com.example.burungkurirapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.burungkurirapp.ui.page.GeneralReusable.NavFooter.NavFooterPage
import com.example.burungkurirapp.ui.page.GeneralReusable.NavHeader.NavHeaderPage
import com.example.burungkurirapp.ui.page.GeneralReusable.SideBar.Element
import com.example.burungkurirapp.ui.page.GeneralReusable.SideBar.SideBar
import com.example.burungkurirapp.ui.page.Home.Homepage


val SideBarVaLues: SideBar = SideBar()

@Preview(showBackground = true)
@Composable
fun BurungKurirAppWrapper() {
    var isSidebarOpen by remember { mutableStateOf(false) }

    // Box Utama sebagai wadah tumpukan (Stacking)
    Box(modifier = Modifier.fillMaxSize()) {

        // ─── 1. TATA LETAK UTAMA (HEADER, KONTEN, FOOTER) ───
        Column(modifier = Modifier.fillMaxSize()) {

            // Header
            NavHeaderPage {
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
                Homepage(namaKurir = "Faiz")
            }

            // Footer (Tetap terkunci di bawah)
            NavFooterPage { }
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
                onItemSelect = { isSidebarOpen = false }
            )
        }
    }
}