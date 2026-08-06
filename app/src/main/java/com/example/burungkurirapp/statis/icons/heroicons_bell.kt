package com.example.burungkurirapp.statis.icons/*
MIT License

Copyright (c) Tailwind Labs, Inc.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val HeroiconsBell: ImageVector
    get() {
        if (_HeroiconsBell != null) return _HeroiconsBell!!
        
        _HeroiconsBell = ImageVector.Builder(
            name = "bell",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineJoin = StrokeJoin.Miter
            ) {
                moveTo(14.857f, 17.082f)
                arcToRelative(23.848f, 23.848f, 0f, false, false, 5.454f, -1.31f)
                arcTo(8.967f, 8.967f, 0f, false, true, 18f, 9.75f)
                verticalLineTo(9f)
                arcTo(6f, 6f, 0f, false, false, 6f, 9f)
                verticalLineToRelative(0.75f)
                arcToRelative(8.967f, 8.967f, 0f, false, true, -2.312f, 6.022f)
                curveToRelative(1.733f, 0.64f, 3.56f, 1.085f, 5.455f, 1.31f)
                moveToRelative(5.714f, 0f)
                arcToRelative(24.255f, 24.255f, 0f, false, true, -5.714f, 0f)
                moveToRelative(5.714f, 0f)
                arcToRelative(3f, 3f, 0f, true, true, -5.714f, 0f)
            }
        }.build()
        
        return _HeroiconsBell!!
    }

private var _HeroiconsBell: ImageVector? = null