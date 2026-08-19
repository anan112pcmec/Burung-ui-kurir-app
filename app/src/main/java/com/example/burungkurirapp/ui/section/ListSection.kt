package com.example.burungkurirapp.ui.section

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.HistoryToggleOff
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhonelinkLock
import androidx.compose.material.icons.filled.QueryStats
import androidx.compose.material.icons.filled.Settings
import com.example.burungkurirapp.ui.constant.prefix.AuthSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.HomeSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.LandingSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.RiwayatSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.TugasSectionPrefix
import com.example.burungkurirapp.ui.routes.RoutesProps
import com.example.burungkurirapp.ui.section.Auth.page.Login.LoginPage
import com.example.burungkurirapp.ui.section.Auth.page.SignUp.SignUpPage
import com.example.burungkurirapp.ui.section.Historical.page.Alamat.HistoricalAlamatPage
import com.example.burungkurirapp.ui.section.Historical.page.Informasi.HistoricalInformasiPage
import com.example.burungkurirapp.ui.section.Historical.page.Option.HistoricalOptionPage
import com.example.burungkurirapp.ui.section.Historical.page.Option.OptionProps
import com.example.burungkurirapp.ui.section.Historical.page.Pengiriman.HistoricalPengirimanPage
import com.example.burungkurirapp.ui.section.Historical.page.Profile.HistoricalProfilePage
import com.example.burungkurirapp.ui.section.Historical.page.Rekening.HistoricalRekeningPage
import com.example.burungkurirapp.ui.section.History.HistoricalBidPage
import com.example.burungkurirapp.ui.section.Home.page.Alamat.AlamatPage
import com.example.burungkurirapp.ui.section.Home.page.DokumenInformasi.DokumenInformasiPage
import com.example.burungkurirapp.ui.section.Home.page.DokumenKendaraan.DokumenKendaraanPage
import com.example.burungkurirapp.ui.section.Home.page.Home.DaftarBidPage
import com.example.burungkurirapp.ui.section.Home.page.Home.HomePage
import com.example.burungkurirapp.ui.section.Home.page.Privasi.PrivasiPage
import com.example.burungkurirapp.ui.section.Home.page.Profile.ProfilePage
import com.example.burungkurirapp.ui.section.Home.page.Rekening.RekeningPage
import com.example.burungkurirapp.ui.section.Landing.page.LandingPagePage
import com.example.burungkurirapp.ui.section.Home.page.Overview.OverviewPage

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

val RiwayatSectionRouting: List<RoutesProps> = listOf(
    RoutesProps(
        name = "Option",
        Path = "$RiwayatSectionPrefix/",
        Icon = Icons.Default.HistoryToggleOff,
        Component = listOf({ HistoricalOptionPage(option = listOf(
            OptionProps(
                nama = "Riwayat Pengiriman",
                path = "history_pengiriman",
                icon = Icons.Default.LocalShipping
            ),
            OptionProps(
                nama = "Riwayat Pencairan Saldo",
                path = "history_pencairan",
                icon = Icons.Default.Payments
            ),
            OptionProps(
                nama = "Log Aktivitas Kurir",
                path = "history_aktivitas",
                icon = Icons.Default.History
            ),
            OptionProps(
                nama = "Riwayat Bid",
                path = "history_bid",
                icon = Icons.Default.Gavel
            ),
            OptionProps(
                nama = "Riwayat Informasi Kendaraan",
                path = "history_kendaraan",
                icon = Icons.Default.DirectionsCar
            ),
            OptionProps(
                nama = "Riwayat Informasi Kurir",
                path = "history_kurir",
                icon = Icons.Default.Person
            ),
            OptionProps(
                nama = "Riwayat Profile",
                path = "history_profile",
                icon = Icons.Default.AccountCircle
            ),
            OptionProps(
                nama = "Riwayat Rekening",
                path = "history_rekening",
                icon = Icons.Default.AccountBalance
            ),
            OptionProps(
                nama = "Riwayat Alamat",
                path = "history_alamat",
                icon = Icons.Default.LocationOn
            )
        )) })
    ),

    RoutesProps(
        name = "Alamat",
        Path = "$RiwayatSectionPrefix/Alamat",
        Icon = Icons.Default.LocationOn,
        Component = listOf({ HistoricalAlamatPage () })
    ),
    RoutesProps(
        name = "Informasi",
        Path = "$RiwayatSectionPrefix/Informasi",
        Icon = Icons.Default.LocationOn,
        Component = listOf({ HistoricalInformasiPage () })
    ),
    RoutesProps(
        name = "Bid",
        Path = "$RiwayatSectionPrefix/Bid",
        Icon = Icons.Default.LocalOffer, // Menggunakan penawaran/tag untuk bid
        Component = listOf({ HistoricalBidPage() })
    ),

    RoutesProps(
        name = "Pengiriman",
        Path = "$RiwayatSectionPrefix/Pengiriman",
        Icon = Icons.Default.LocalShipping, // Menggunakan truk/pengiriman logistik
        Component = listOf({ HistoricalPengirimanPage() })
    ),
    RoutesProps(
        name = "Profile",
        Path = "$RiwayatSectionPrefix/Profile",
        Icon = Icons.Default.Person, // Menggunakan profil pengguna/kurir
        Component = listOf({ HistoricalProfilePage() })
    ),
    RoutesProps(
        name = "Rekening",
        Path = "$RiwayatSectionPrefix/Rekening",
        Icon = Icons.Default.AccountBalanceWallet, // Menggunakan dompet/rekening keuangan
        Component = listOf({ HistoricalRekeningPage() })
    )
)
