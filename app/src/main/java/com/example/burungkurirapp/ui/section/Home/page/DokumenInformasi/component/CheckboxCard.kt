package com.example.burungkurirapp.ui.section.Home.page.DokumenInformasi.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc400

@Composable
fun CheckboxCard(
    label: String,
    isCheck: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Row(
        modifier = Modifier
            .height(38.dp)
            .background(Color.White, RoundedCornerShape(2.dp))
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
            .clickable{onCheckedChange(!isCheck)}
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = label,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 11.sp,
            color = Slate950
        )
        Spacer(Modifier.width(8.dp))
        Checkbox(
            checked = isCheck,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Slate950,
                uncheckedColor = Zinc400,
                checkmarkColor = Color.White
            ),
            modifier = Modifier.size(12.dp)
        )
    }
}