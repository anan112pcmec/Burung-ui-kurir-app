package com.example.burungkurirapp.ui.section

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhonelinkLock
import androidx.compose.material.icons.filled.QueryStats
import com.example.burungkurirapp.ui.constant.prefix.AuthSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.HomeSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.LandingSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.TugasSectionPrefix
import com.example.burungkurirapp.ui.routes.RoutesProps
import com.example.burungkurirapp.ui.section.Auth.page.Login.LoginPage
import com.example.burungkurirapp.ui.section.Auth.page.SignUp.SignUpPage
import com.example.burungkurirapp.ui.section.Home.page.Alamat.AlamatPage
import com.example.burungkurirapp.ui.section.Home.page.DokumenInformasi.DokumenInformasiPage
import com.example.burungkurirapp.ui.section.Home.page.DokumenKendaraan.DokumenKendaraanPage
import com.example.burungkurirapp.ui.section.Home.page.Home.DaftarBidPage
import com.example.burungkurirapp.ui.section.Home.page.Home.HomePage
import com.example.burungkurirapp.ui.section.Home.page.Privasi.PrivasiPage
import com.example.burungkurirapp.ui.section.Home.page.Profile.ProfilePage
import com.example.burungkurirapp.ui.section.Home.page.Rekening.RekeningPage
import com.example.burungkurirapp.ui.section.Landing.page.LandingPagePage
import com.example.burungkurirapp.ui.section.Overview.OverviewPage

var LandingSectionRouting: List<RoutesProps> = listOf(
    RoutesProps(
        name="Landing Page",
        Path = "$LandingSectionPrefix",
        Icon = Icons.Default.People,
        Component = listOf({ LandingPagePage(

        ) })
    )
)

val AuthSectionRouting: List<RoutesProps> = listOf(
    RoutesProps(
        name = "Login",
        Path = "$AuthSectionPrefix/Login",
        Icon = Icons.Default.Login,
        Component = listOf({ LoginPage() })
    ),

    RoutesProps(
        name = "SignUp",
        Path = "$AuthSectionPrefix/SignUp",
        Icon = Icons.Default.Info,
        Component = listOf({ SignUpPage() })
    )
)

val HomeSectionRouting: List<RoutesProps> = listOf(
    RoutesProps(
        name = "Beranda",
        Path = "$HomeSectionPrefix/Home",
        Icon = Icons.Default.Home,
        Component = listOf({
            HomePage()
        })
    ),
    RoutesProps(
        name = "Profil",
        Path = "$HomeSectionPrefix/Profil",
        Icon = Icons.Default.Person,
        Component = listOf({ ProfilePage() })
    ),
    RoutesProps(
        name = "Dokumen Kendaraan",
        Path = "$HomeSectionPrefix/DokumenKendaraan",
        Icon = Icons.Default.DirectionsCar,
        Component = listOf({ DokumenKendaraanPage() })
    ),
    RoutesProps(
        name = "Dokumen Informasi",
        Path = "$HomeSectionPrefix/DokumenInformasi",
        Icon = Icons.Default.Info,
        Component = listOf({ DokumenInformasiPage() })
    ),
    RoutesProps(
        name = "Alamat",
        Path = "$HomeSectionPrefix/Alamat",
        Icon = Icons.Default.LocationOn,
        Component = listOf({ AlamatPage() })
    ),
    RoutesProps(
        name = "Privasi",
        Path = "$HomeSectionPrefix/Privasi",
        Icon = Icons.Default.PhonelinkLock,
        Component = listOf({ PrivasiPage() })
    ),
    RoutesProps(
        name = "Rekening",
        Path = "$HomeSectionPrefix/Rekening",
        Icon = Icons.Default.AccountBalanceWallet,
        Component = listOf({ RekeningPage() })
    ),
    RoutesProps(
        name = "Overview",
        Path = "$HomeSectionPrefix/Overview",
        Icon = Icons.Default.QueryStats,
        Component = listOf({ OverviewPage() })
    )
)

val TugasSectionRouting: List<RoutesProps> = listOf(
    RoutesProps(
        name = "Daftar Bid",
        Path = "$TugasSectionPrefix/Daftar-Bid",
        Icon = Icons.Default.QueryStats,
        Component = listOf({ DaftarBidPage() })
    )
)
