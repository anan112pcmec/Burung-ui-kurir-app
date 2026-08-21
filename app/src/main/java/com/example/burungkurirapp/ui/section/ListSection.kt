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
import com.example.burungkurirapp.ui.constant.enum.STatusPengiriman
import com.example.burungkurirapp.ui.constant.prefix.AuthSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.DetailsSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.HomeSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.LandingSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.RiwayatSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.TugasSectionPrefix
import com.example.burungkurirapp.ui.constant.types.AlamatKurir
import com.example.burungkurirapp.ui.constant.types.BidKurirData
import com.example.burungkurirapp.ui.constant.types.InformasiKendaraanKurir
import com.example.burungkurirapp.ui.constant.types.InformasiKurir
import com.example.burungkurirapp.ui.constant.types.Kurir
import com.example.burungkurirapp.ui.constant.types.NotificationKurir
import com.example.burungkurirapp.ui.constant.types.Pengiriman
import com.example.burungkurirapp.ui.constant.types.RekeningKurir
import com.example.burungkurirapp.ui.routes.RoutesProps
import com.example.burungkurirapp.ui.section.Auth.page.Login.LoginPage
import com.example.burungkurirapp.ui.section.Auth.page.SignUp.SignUpPage
import com.example.burungkurirapp.ui.section.Details.page.Alamat.DetailsAlamatPage
import com.example.burungkurirapp.ui.section.Details.page.Bid.DetailsBidPage
import com.example.burungkurirapp.ui.section.Details.page.InformasiKendaraanKurir.DetailsInformasiKendaraanKurirPage
import com.example.burungkurirapp.ui.section.Details.page.InformasiKurir.DetailsInformasiKurirPage
import com.example.burungkurirapp.ui.section.Details.page.Pengiriman.DetailsPengirimanPage
import com.example.burungkurirapp.ui.section.Details.page.Rekening.DetailsRekeningPage
import com.example.burungkurirapp.ui.section.Historical.page.Aktivitas.HistoricalAktivitasPage
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
import com.example.burungkurirapp.ui.section.Home.page.Home.HomePage
import com.example.burungkurirapp.ui.section.Home.page.Home.TugasDaftarBidPage
import com.example.burungkurirapp.ui.section.Home.page.Privasi.PrivasiPage
import com.example.burungkurirapp.ui.section.Home.page.Profile.ProfilePage
import com.example.burungkurirapp.ui.section.Home.page.Rekening.RekeningPage
import com.example.burungkurirapp.ui.section.Landing.page.LandingPagePage
import com.example.burungkurirapp.ui.section.Home.page.Overview.OverviewPage
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.TugasPengirimanPage
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.TugasPengirimanProps

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
        Component = listOf({ TugasDaftarBidPage() })
    ),
    RoutesProps(
        name = "Pengiriman",
        Path = "$TugasSectionPrefix/Pengiriman",
        Icon = null,
        Component = listOf({ TugasPengirimanPage(TugasPengirimanProps(
            Id = 1001L,
            IdTransaksi = 50021L,
            IdSeller = 301L,
            NamaSeller = "Toko Berkah Jaya",
            IdPengguna = 102,
            NamaPengguna = "Budiansyah",
            IdAlamatGudang = 101L,
            NamaAlamatGudang = "Gudang Utama Karawang",
            LongAlamatGudang = 107.3023,
            LatAlamatGudang = -6.3155,
            IdAlamatPengguna = 205L,
            NamaAlamatPengguna = "Perumahan Teluk Jambe Blok A No. 12",
            LongAlamatPengguna = 107.3112,
            LatAlamatPengguna = -6.3201,
            IdBarangInduk = 9988L,
            NamaBarangInduk = "Paket Elektronik - Speaker Bluetooth",
            IdKategoriBarang = 12L,
            NamaKategoriBarang = "Elektronik",
            UrlFotoKategoriBarang = listOf(
                "https://example.com/images/speaker1.jpg",
                "https://example.com/images/speaker2.jpg"
            ),
            IdKurir = 88L,
            KodeOrderSistem = "ORD-2026-0820-001",
            Catatan = "Harap hubungi penerima sebelum sampai di lokasi.",
            BeratBarang = 1500,
            KendaraanRequired = "Motor",
            JenisPengiriman = "Instant",
            JarakTempuh = "4.5 km",
            KurirPaid = 15000L,
            Status = STatusPengiriman.SAMPAI
        )) })
    )
)

val RiwayatSectionRouting: List<RoutesProps> = listOf(
    // 1. Root / Option Page
    RoutesProps(
        name = "Option",
        Path = "$RiwayatSectionPrefix/", // Menggunakan prefix utama
        Icon = Icons.Default.HistoryToggleOff,
        Component = listOf({
            HistoricalOptionPage(option = listOf(
                OptionProps(
                    nama = "Riwayat Pengiriman",
                    path = "$RiwayatSectionPrefix/Pengiriman",
                    icon = Icons.Default.LocalShipping
                ),
                OptionProps(
                    nama = "Log Aktivitas Kurir",
                    path = "$RiwayatSectionPrefix/Aktivitas",
                    icon = Icons.Default.History
                ),
                OptionProps(
                    nama = "Riwayat Bid",
                    path = "$RiwayatSectionPrefix/Bid",
                    icon = Icons.Default.Gavel
                ),
                OptionProps(
                    nama = "Riwayat Informasi Kendaraan",
                    path = "$RiwayatSectionPrefix/Informasi",
                    icon = Icons.Default.DirectionsCar
                ),
                OptionProps(
                    nama = "Riwayat Informasi Kurir",
                    path = "$RiwayatSectionPrefix/Informasi",
                    icon = Icons.Default.Person
                ),
                OptionProps(
                    nama = "Riwayat Profile",
                    path = "$RiwayatSectionPrefix/Profile",
                    icon = Icons.Default.AccountCircle
                ),
                OptionProps(
                    nama = "Riwayat Rekening",
                    path = "$RiwayatSectionPrefix/Rekening",
                    icon = Icons.Default.AccountBalance
                ),
                OptionProps(
                    nama = "Riwayat Alamat",
                    path = "$RiwayatSectionPrefix/Alamat",
                    icon = Icons.Default.LocationOn
                )
            ))
        })
    ),

    // 2. Detail Pages
    RoutesProps(
        name = "Alamat",
        Path = "$RiwayatSectionPrefix/Alamat",
        Icon = Icons.Default.LocationOn,
        Component = listOf({ HistoricalAlamatPage() })
    ),
    RoutesProps(
        name = "Informasi",
        Path = "$RiwayatSectionPrefix/Informasi",
        Icon = Icons.Default.Info, // Diubah agar lebih pas dengan informasi
        Component = listOf({ HistoricalInformasiPage() })
    ),
    RoutesProps(
        name = "Aktivitas",
        Path = "$RiwayatSectionPrefix/Aktivitas",
        Icon = Icons.Default.History,
        Component = listOf({ HistoricalAktivitasPage( listOf(
            NotificationKurir(
                IdKurir = 1,
                Pengirim = "Logistik Hub Jakarta",
                Judul = "Paket Telah Diserahterimakan",
                Pesan = "Kurir telah berhasil menyerahkan paket kepada penerima di alamat tujuan utama.",
                Pop = 1.0f,
                Archive = false,
                Inbox = true,
                Activity = true,
                CreatedAt = "10:45",
                ExpiredAt = "2026-12-31",
                Data = NotificationKurir.DataInfo(
                    Metadata = mapOf("resi" to "JP123456789"),
                    Special = "express"
                )
            ),
            NotificationKurir(
                IdKurir = 2,
                Pengirim = "Sistem Otomasi",
                Judul = "Pembaruan Rute Perjalanan",
                Pesan = "Terdapat pengalihan rute karena adanya perbaikan jalan di sekitar wilayah Jakarta Selatan.",
                Pop = 0.5f,
                Archive = false,
                Inbox = true,
                Activity = true,
                CreatedAt = "Kemarin",
                ExpiredAt = "2026-12-31",
                Data = NotificationKurir.DataInfo(
                    Metadata = mapOf("zone" to "B"),
                    Special = false
                )
            ),
        ))})
    ),
    RoutesProps(
        name = "Bid",
        Path = "$RiwayatSectionPrefix/Bid",
        Icon = Icons.Default.LocalOffer,
        Component = listOf({ HistoricalBidPage() })
    ),
    RoutesProps(
        name = "Pengiriman",
        Path = "$RiwayatSectionPrefix/Pengiriman",
        Icon = Icons.Default.LocalShipping,
        Component = listOf({ HistoricalPengirimanPage() })
    ),
    RoutesProps(
        name = "Profile",
        Path = "$RiwayatSectionPrefix/Profile",
        Icon = Icons.Default.Person,
        Component = listOf({ HistoricalProfilePage() })
    ),
    RoutesProps(
        name = "Rekening",
        Path = "$RiwayatSectionPrefix/Rekening",
        Icon = Icons.Default.AccountBalanceWallet,
        Component = listOf({ HistoricalRekeningPage() }) // Koma sudah ditambahkan di sini
    )
)

val DetailsSectionRouting: List<RoutesProps> = listOf(
    RoutesProps(
        name = "Alamat",
        Path = "$DetailsSectionPrefix/Alamat",
        Icon = null,
        Component = listOf({ DetailsAlamatPage(AlamatKurir(
            Id = 1,
            IdKurir = 101,
            PanggilanAlamat = "Rumah Utama",
            NomorTelephone = "081234567890",
            NamaAlamat = "Jl. Sudirman No. 45, RT 01/RW 02",
            Provinsi = "DKI Jakarta",
            Kota = "Jakarta Selatan",
            KodeNegara = "ID",
            KodePos = "12190",
            Deskripsi = "Catatan: Pagar warna hitam, sebelah minimarket.",
            Longitude = 106.827153,
            Latitude = -6.229728,
            CreatedAt = "2026-06-01T08:00:00Z",
            UpdatedAt = "2026-06-01T08:00:00Z"
        )) })
    ),
    RoutesProps(
        name = "Bid",
        Path = "$DetailsSectionPrefix/Bid",
        Icon = null,
        Component = listOf({ DetailsBidPage(
            BidKurirData(
                Id = 1,
                IdKurir = 101,
                JenisPengiriman = "SameDay",
                Mode = "Motor",
                Provinsi = "DKI Jakarta",
                Kota = "Jakarta Selatan",
                IsEkspedisi = false,
                Alamat = "Gudang Utama Jakarta Selatan",
                Longitude = 106.827153,
                Latitude = -6.229728,
                MaxKg = 50,
                SlotTersisa = 3,
                Dimulai = "2026-06-01T08:00:00Z",
                Selesai = "2026-06-01T18:00:00Z",
                CreatedAt = "2026-06-01T07:00:00Z",
                UpdatedAt = "2026-06-01T07:00:00Z",

            )
        ) })
    ),
    RoutesProps(
        name = "Informasi Kendaraan Kurir",
        Path = "$DetailsSectionPrefix/InformasiKendaraanKurir",
        Icon = null,
        Component = listOf({ DetailsInformasiKendaraanKurirPage(
            InformasiKendaraanKurir(
                Id = 1,
                IdKurir = 101,
                JenisKendaraan = "Sepeda Motor",
                NamaKendaraan = "Honda Beat CBS ISS",
                RodaKendaraan = "2",
                InformasiStnk = true,
                InformasiBpkb = true,
                NomorRangka = "MH1JM211XMK123456",
                NomorMesin = "JM21E-1123456",
                Status = "Aktif",
                CreatedAt = "2026-06-01T08:00:00Z",
                UpdatedAt = "2026-06-01T08:00:00Z",
                fotoKendaraan = "https://picsum.photos/seed/motor/400/300",
                fotoBpkb = "https://picsum.photos/seed/bpkb/400/300",
                fotoSTNK = "https://picsum.photos/seed/stnk/400/300"
            )
        ) })
    ),
    RoutesProps(
        name = "Informasi Kurir",
        Path = "$DetailsSectionPrefix/InformasiKurir",
        Icon = null,
        Component = listOf({ DetailsInformasiKurirPage(
            Kurir(
                Id = 101,
                Nama = "Budi Santoso",
                Username = "budisantoso",
                Email = "budi.santoso@email.com",
                Jenis = "Ekspres",
                PasswordHash = "\$2a\$12\$e8...mockedHashValue...",
                Deskripsi = "Kurir berpengalaman wilayah Jakarta Selatan.",
                StatusKurir = "Aktif",
                StatusBid = "Tersedia",
                VerifierKurir = true,
                TipeKendaraan = "Motor",
                CreatedAt = "2026-01-10T08:00:00Z",
                UpdatedAt = "2026-06-01T08:00:00Z"
            ),
            InformasiKurir(
            Id = 1,
            IdKurir = 101,
            TanggalLahir = "1998-08-17",
            Alasan = "Lengkap dan terverifikasi",
            InformasiKtp = true,
            InformasiSim = true,
            Status = "Verified",
            CreatedAt = "2026-06-01T08:00:00Z",
            UpdatedAt = "2026-06-01T08:00:00Z",
            urlFotoKtp = "https://picsum.photos/seed/ktp/400/300",
            urlFotoSim = "https://picsum.photos/seed/sim/400/300"
        )
        ) })
    ),
    RoutesProps(
        name = "Pengiriman",
        Path = "$DetailsSectionPrefix/Pengiriman",
        Icon = null,
        Component = listOf({ DetailsPengirimanPage(
            Pengiriman(
                Id = 501,
                IdTransaksi = 9001,
                IdSeller = 202,
                IdAlamatGudang = 301,
                IdAlamatPengguna = 401,
                IdKurir = 101,
                BeratBarang = 5,
                KendaraanRequired = "Motor",
                JenisPengiriman = "SameDay",
                JarakTempuh = "4.5 km",
                KurirPaid = "15000",
                Status = "Pending",
                CreatedAt = "2026-06-01T07:30:00Z",
                Transaksi = null,      // Bisa diisi instance dummy Transaksi jika ada
                AlamatGudang = null,   // Bisa diisi instance dummy AlamatGudang jika ada
                AlamatPengguna = null  // Bisa diisi instance dummy AlamatPengguna jika ada
            )
        ) })
    ),
    RoutesProps(
        name = "Rekening",
        Path = "$DetailsSectionPrefix/Rekening",
        Icon = null,
        Component = listOf({ DetailsRekeningPage(
            RekeningKurir(
                Id = 1,
                IdKurir = 101,
                NamaBank = "BCA",
                NomorRekening = "1234567890",
                PemilikRekening = "Budi Santoso",
                CreatedAt = "2026-06-01T08:00:00Z",
                UpdatedAt = "2026-06-19T08:00:00Z",

                // Total Keseluruhan (All-time)
                PengirimanDisbursmentCount = 120,
                PemasukanTotal = 2400000L,
                DisbursmentGagalCount = 2,
                PendingDisbursmentAmount = 50000L,

                // Data Per Hari Ini (Today)
                PengirimanDisbursmentCountHariIni = 4,
                PemasukanTotalHariIni = 80000L,
                DisbursmentGagalCountHariIni = 0,
                PendingDisbursmentAmountHariIni = 0L,

                // Data Per Minggu Ini (This Week)
                PengirimanDisbursmentCountMingguIni = 25,
                PemasukanTotalMingguIni = 500000L,
                DisbursmentGagalCountMingguIni = 1,
                PendingDisbursmentAmountMingguIni = 20000L,

                // Data Per Bulan Ini (This Month)
                PengirimanDisbursmentCountBulanIni = 95,
                PemasukanTotalBulanIni = 1900000L,
                DisbursmentGagalCountBulanIni = 2,
                PendingDisbursmentAmountBulanIni = 30000L,

                // Data Per Tahun Ini (This Year)
                PengirimanDisbursmentCountTahunIni = 120,
                PemasukanTotalTahunIni = 2400000L,
                DisbursmentGagalCountTahunIni = 2,
                PendingDisbursmentAmountTahunIni = 50000L,

                listPengirimanTerkaitRek = listOf(Pengiriman(
                    Id = 501,
                    IdTransaksi = 9001,
                    IdSeller = 202,
                    IdAlamatGudang = 301,
                    IdAlamatPengguna = 401,
                    IdKurir = 101,
                    BeratBarang = 5,
                    KendaraanRequired = "Motor",
                    JenisPengiriman = "SameDay",
                    JarakTempuh = "4.5 km",
                    KurirPaid = "15000",
                    Status = "Pending",
                    CreatedAt = "2026-06-01T07:30:00Z",
                    Transaksi = null,      // Bisa diisi instance dummy Transaksi jika ada
                    AlamatGudang = null,   // Bisa diisi instance dummy AlamatGudang jika ada
                    AlamatPengguna = null  // Bisa diisi instance dummy AlamatPengguna jika ada
                ))
            )
        ) })
    ),
)