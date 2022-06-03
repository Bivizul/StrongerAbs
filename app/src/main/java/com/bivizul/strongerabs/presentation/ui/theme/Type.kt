package com.bivizul.strongerabs.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.bivizul.strongerabs.R

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        color = Color(R.color.white),
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    h2 = TextStyle(
        color =  Color.White,
        fontFamily = FontFamily(Font(R.font.arialroundedmtbold)),
        fontSize = 32.sp,
    ),
    button = TextStyle(
        color =  Color.White,
        fontFamily = FontFamily(Font(R.font.arialroundedmtbold)),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Left,
    ),
    body1 = TextStyle(
        color =  Color.White,
        fontFamily = FontFamily(Font(R.font.arialroundedmtbold)),
        fontSize = 14.sp
    ),

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)