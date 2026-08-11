package com.example.burungkurirapp.ui.page.Profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal500
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc300
import com.example.burungkurirapp.ui.constant.color.Zinc400
import com.example.burungkurirapp.ui.constant.color.Zinc50
import com.example.burungkurirapp.ui.constant.color.Zinc500
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc950




@Preview(showBackground = true)
@Composable
fun ProfilePage() {
    // ─── STATE MANAGEMENT ───
    var isEdit by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("FAIZ HANNAN HAKIM") }
    var username by remember { mutableStateOf("@faizhannan") }
    var email by remember { mutableStateOf("faiz.hannan@mail.com") }
    var description by remember { mutableStateOf("Driver motor berpengalaman, siap antar paket cepat, aman, dan tepat waktu.") }
    var note by remember { mutableStateOf("Kepercayaan Anda adalah prioritas. Setiap kilometer adalah komitmen untuk mengantar paket dengan aman dan tepat waktu.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // ─── 1. HEADER PROFIL (AVATAR, IDENTITAS & EDIT BUTTON) ───
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Avatar Frame Bulat dengan Border Thin Zinc200
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(Zinc950)
                        .border(BorderStroke(1.dp, Zinc200), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "FH",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Nama & Subtitle Detail
                Column(modifier = Modifier.weight(1f)) {
                    if (isEdit) {
                        BasicTextField(
                            value = name,
                            onValueChange = { name = it },
                            textStyle = TextStyle(
                                color = Slate950,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                letterSpacing = 0.5.sp
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Zinc50, RoundedCornerShape(2.dp))
                                .border(BorderStroke(1.dp, Zinc300), RoundedCornerShape(2.dp))
                                .padding(4.dp)
                        )
                    } else {
                        Text(
                            text = name,
                            color = Slate950,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            letterSpacing = 0.5.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "MOTOR • REGULER • #KR-082",
                        color = Zinc400,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 9.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Tombol Edit / Save Minimalis
            Box(
                modifier = Modifier
                    .background(if (isEdit) Slate950 else Color.White, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .clickable { isEdit = !isEdit }
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Text(
                    text = if (isEdit) "SAVE" else "EDIT",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.sp,
                    color = if (isEdit) Color.White else Slate950
                )
            }
        }

        // ─── 2. DETIL DOKUMEN & AKUN ───
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "INFORMASI AKUN",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Zinc400,
                letterSpacing = 1.sp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Zinc50, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ProfileInfoRow(
                    label = "USERNAME",
                    value = username,
                    isEdit = isEdit,
                    onValueChange = { username = it }
                )
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

                ProfileInfoRow(
                    label = "EMAIL",
                    value = email,
                    isEdit = isEdit,
                    onValueChange = { email = it }
                )
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

                ProfileInfoRow(label = "STATUS KURIR", value = "ONLINE", isEdit = false, onValueChange = {}, isBadge = true)
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

                ProfileInfoRow(label = "RATING OPERASIONAL", value = "4.8 ★", isEdit = false, onValueChange = {})
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

                ProfileInfoRow(label = "VERIFIKASI ID", value = "TERVERIFIKASI", isEdit = false, onValueChange = {})
            }
        }

        // ─── 3. CARD BIO / DESKRIPSI ───
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "DESKRIPSI OPERASIONAL",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Zinc400,
                letterSpacing = 1.sp
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, if (isEdit) Zinc400 else Zinc200), RoundedCornerShape(2.dp))
                    .padding(12.dp)
            ) {
                if (isEdit) {
                    BasicTextField(
                        value = description,
                        onValueChange = { description = it },
                        textStyle = TextStyle(
                            fontSize = 11.sp,
                            color = Slate950,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily.SansSerif
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Text(
                        text = description,
                        fontSize = 11.sp,
                        color = Zinc600,
                        lineHeight = 16.sp
                    )
                }
            }
        }

        // ─── 4. CARD MOTIVASI / NOTE ───
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "CATATAN HARIAN",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Zinc400,
                letterSpacing = 1.sp
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Zinc50, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, if (isEdit) Zinc400 else Zinc200), RoundedCornerShape(2.dp))
                    .padding(12.dp)
            ) {
                if (isEdit) {
                    BasicTextField(
                        value = note,
                        onValueChange = { note = it },
                        textStyle = TextStyle(
                            fontSize = 11.sp,
                            fontStyle = FontStyle.Italic,
                            color = Slate950,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily.SansSerif
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Text(
                        text = "\"$note\"",
                        fontSize = 11.sp,
                        fontStyle = FontStyle.Italic,
                        color = Zinc500,
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileInfoRow(
    label: String,
    value: String,
    isEdit: Boolean,
    onValueChange: (String) -> Unit,
    isBadge: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontFamily = FontFamily.SansSerif,
            color = Zinc400,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )

        if (isBadge) {
            Box(
                modifier = Modifier.background(Teal500, RoundedCornerShape(2.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                Text(
                    text = value,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 8.sp,
                    color = Color.White
                )
            }
        } else if (isEdit) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    color = Slate950,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                ),
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc300), RoundedCornerShape(2.dp))
                    .padding(horizontal = 6.dp, vertical = 4.dp)
            )
        } else {
            Text(
                text = value,
                fontFamily = FontFamily.SansSerif,
                color = Slate950,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
        }
    }
}