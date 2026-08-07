package com.example.burungkurirapp.statis.icons/*
Font Awesome Free License
-------------------------

Font Awesome Free is free, open source, and GPL friendly. You can use it for
commercial projects, open source projects, or really almost whatever you want.
Full Font Awesome Free license: https://fontawesome.com/license/free.

# Icons: CC BY 4.0 License (https://creativecommons.org/licenses/by/4.0/)
In the Font Awesome Free download, the CC BY 4.0 license applies to all icons
packaged as SVG and JS file types.

# Fonts: SIL OFL 1.1 License (https://scripts.sil.org/OFL)
In the Font Awesome Free download, the SIL OFL license applies to all icons
packaged as web and desktop font files.

# Code: MIT License (https://opensource.org/licenses/MIT)
In the Font Awesome Free download, the MIT license applies to all non-font and
non-icon files.

# Attribution
Attribution is required by MIT, SIL OFL, and CC BY licenses. Downloaded Font
Awesome Free files already contain embedded comments with sufficient
attribution, so you shouldn't need to do anything additional when using these
files normally.

We've kept attribution comments terse, so we ask that you do not actively work
to remove them from files, especially code. They're a great way for folks to
learn about Font Awesome.

# Brand Icons
All brand icons are trademarks of their respective owners. The use of these
trademarks does not indicate endorsement of the trademark holder by Font
Awesome, nor vice versa. **Please do not use brand logos for any purpose except
to represent the company, product, or service to which they refer.**
*/
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FontAwesomeShippingFast: ImageVector
    get() {
        if (_FontAwesomeShippingFast != null) return _FontAwesomeShippingFast!!
        
        _FontAwesomeShippingFast = ImageVector.Builder(
            name = "shipping-fast",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 640f,
            viewportHeight = 512f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(624f, 352f)
                horizontalLineToRelative(-16f)
                verticalLineTo(243.9f)
                curveToRelative(0f, -12.7f, -5.1f, -24.9f, -14.1f, -33.9f)
                lineTo(494f, 110.1f)
                curveToRelative(-9f, -9f, -21.2f, -14.1f, -33.9f, -14.1f)
                horizontalLineTo(416f)
                verticalLineTo(48f)
                curveToRelative(0f, -26.5f, -21.5f, -48f, -48f, -48f)
                horizontalLineTo(112f)
                curveTo(85.5f, 0f, 64f, 21.5f, 64f, 48f)
                verticalLineToRelative(48f)
                horizontalLineTo(8f)
                curveToRelative(-4.4f, 0f, -8f, 3.6f, -8f, 8f)
                verticalLineToRelative(16f)
                curveToRelative(0f, 4.4f, 3.6f, 8f, 8f, 8f)
                horizontalLineToRelative(272f)
                curveToRelative(4.4f, 0f, 8f, 3.6f, 8f, 8f)
                verticalLineToRelative(16f)
                curveToRelative(0f, 4.4f, -3.6f, 8f, -8f, 8f)
                horizontalLineTo(40f)
                curveToRelative(-4.4f, 0f, -8f, 3.6f, -8f, 8f)
                verticalLineToRelative(16f)
                curveToRelative(0f, 4.4f, 3.6f, 8f, 8f, 8f)
                horizontalLineToRelative(208f)
                curveToRelative(4.4f, 0f, 8f, 3.6f, 8f, 8f)
                verticalLineToRelative(16f)
                curveToRelative(0f, 4.4f, -3.6f, 8f, -8f, 8f)
                horizontalLineTo(8f)
                curveToRelative(-4.4f, 0f, -8f, 3.6f, -8f, 8f)
                verticalLineToRelative(16f)
                curveToRelative(0f, 4.4f, 3.6f, 8f, 8f, 8f)
                horizontalLineToRelative(208f)
                curveToRelative(4.4f, 0f, 8f, 3.6f, 8f, 8f)
                verticalLineToRelative(16f)
                curveToRelative(0f, 4.4f, -3.6f, 8f, -8f, 8f)
                horizontalLineTo(64f)
                verticalLineToRelative(128f)
                curveToRelative(0f, 53f, 43f, 96f, 96f, 96f)
                reflectiveCurveToRelative(96f, -43f, 96f, -96f)
                horizontalLineToRelative(128f)
                curveToRelative(0f, 53f, 43f, 96f, 96f, 96f)
                reflectiveCurveToRelative(96f, -43f, 96f, -96f)
                horizontalLineToRelative(48f)
                curveToRelative(8.8f, 0f, 16f, -7.2f, 16f, -16f)
                verticalLineToRelative(-32f)
                curveToRelative(0f, -8.8f, -7.2f, -16f, -16f, -16f)
                close()
                moveTo(160f, 464f)
                curveToRelative(-26.5f, 0f, -48f, -21.5f, -48f, -48f)
                reflectiveCurveToRelative(21.5f, -48f, 48f, -48f)
                reflectiveCurveToRelative(48f, 21.5f, 48f, 48f)
                reflectiveCurveToRelative(-21.5f, 48f, -48f, 48f)
                close()
                moveToRelative(320f, 0f)
                curveToRelative(-26.5f, 0f, -48f, -21.5f, -48f, -48f)
                reflectiveCurveToRelative(21.5f, -48f, 48f, -48f)
                reflectiveCurveToRelative(48f, 21.5f, 48f, 48f)
                reflectiveCurveToRelative(-21.5f, 48f, -48f, 48f)
                close()
                moveToRelative(80f, -208f)
                horizontalLineTo(416f)
                verticalLineTo(144f)
                horizontalLineToRelative(44.1f)
                lineToRelative(99.9f, 99.9f)
                verticalLineTo(256f)
                close()
            }
        }.build()
        
        return _FontAwesomeShippingFast!!
    }

private var _FontAwesomeShippingFast: ImageVector? = null