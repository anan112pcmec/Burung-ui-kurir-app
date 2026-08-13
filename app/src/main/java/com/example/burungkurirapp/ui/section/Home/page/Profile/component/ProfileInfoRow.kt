package com.example.burungkurirapp.ui.section.Home.page.Profile.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal500
import com.example.burungkurirapp.ui.constant.color.Zinc300
import com.example.burungkurirapp.ui.constant.color.Zinc400


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