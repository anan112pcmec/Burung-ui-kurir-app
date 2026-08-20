package com.example.burungkurirapp.ui.GeneralReusable.SideBar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.burungkurirapp.ui.constant.color.*
import com.example.burungkurirapp.ui.constant.image.NotFoundIcons
import com.example.burungkurirapp.ui.routes.RoutesProps
import com.example.burungkurirapp.ui.section.HomeSectionRouting

data class SidebarNavItem(
    val id: String,
    val title: String,
    val icon: ImageVector,
    val onclick: () ->Unit = {}
)

class SideBar

@Composable
fun SideBar.Element(
    modifier: Modifier = Modifier,
    widthFraction: Float = 0.75f,
    selectedItemId: String = "profile",
    RoutingElement: NavHostController =  rememberNavController(),
    RoutesList: List<RoutesProps>,
    onItemSelect: (String) -> Unit = {}
) {
    val navItems: MutableList<SidebarNavItem> = mutableListOf()

    RoutesList.forEach { it ->
        navItems.add(SidebarNavItem(it.name.lowercase(), it.name.uppercase(), it.Icon?: NotFoundIcons, onclick = fun(){RoutingElement.navigate(it.Path)}))
    }

    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(widthFraction)
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc200))
            .padding(vertical = 16.dp),
    ) {
        Spacer(Modifier.height(20.dp))
        Column(modifier = Modifier.fillMaxWidth()
            .weight(1f),
            verticalArrangement = Arrangement.Top) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                navItems.forEach { item ->
                    val isSelected = item.id == selectedItemId

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(42.dp)
                            .background(
                                color = if (isSelected) Slate950 else Color.White,
                                shape = RoundedCornerShape(2.dp)
                            )
                            .border(
                                border = BorderStroke(
                                    1.dp,
                                    if (isSelected) Slate950 else Zinc200
                                ),
                                shape = RoundedCornerShape(2.dp)
                            )
                            .clickable {
                                item.onclick()
                                onItemSelect(item.id)
                            }
                            .padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (isSelected) Color.White else Zinc600,
                            modifier = Modifier.size(16.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = item.title,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            color = if (isSelected) Color.White else Slate950,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.Bottom

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Zinc100)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .background(Zinc50, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .clickable { onItemSelect("logout") }
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = "Keluar",
                    tint = Zinc600,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "KELUAR AKUN",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Zinc600,
                    letterSpacing = 0.5.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "@Kebijakan Burung",
                fontFamily = FontFamily.SansSerif,
                fontSize = 8.sp,
                color = Zinc400,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SidebarPreview() {
    SideBar().Element(widthFraction = 0.8f, RoutesList = HomeSectionRouting)
}