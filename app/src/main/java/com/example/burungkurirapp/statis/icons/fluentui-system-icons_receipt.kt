package com.example.burungkurirapp.statis.icons/*
MIT License

Copyright (c) 2020 Microsoft Corporation

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FluentuiSystemIconsReceipt: ImageVector
    get() {
        if (_FluentuiSystemIconsReceipt != null) return _FluentuiSystemIconsReceipt!!
        
        _FluentuiSystemIconsReceipt = ImageVector.Builder(
            name = "receipt",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(3f, 5.25f)
                curveTo(3f, 4.00736f, 4.00736f, 3f, 5.25f, 3f)
                horizontalLineTo(14.75f)
                curveTo(15.9926f, 3f, 17f, 4.00736f, 17f, 5.25f)
                verticalLineTo(14f)
                horizontalLineTo(21f)
                verticalLineTo(17.75f)
                curveTo(21f, 19.5449f, 19.5449f, 21f, 17.75f, 21f)
                horizontalLineTo(6.25f)
                curveTo(4.45507f, 21f, 3f, 19.5449f, 3f, 17.75f)
                verticalLineTo(5.25f)
                close()
                moveTo(17f, 19.5f)
                horizontalLineTo(17.75f)
                curveTo(18.7165f, 19.5f, 19.5f, 18.7165f, 19.5f, 17.75f)
                verticalLineTo(15.5f)
                horizontalLineTo(17f)
                verticalLineTo(19.5f)
                close()
                moveTo(5.25f, 4.5f)
                curveTo(4.83579f, 4.5f, 4.5f, 4.83579f, 4.5f, 5.25f)
                verticalLineTo(17.75f)
                curveTo(4.5f, 18.7165f, 5.2835f, 19.5f, 6.25f, 19.5f)
                horizontalLineTo(15.5f)
                verticalLineTo(5.25f)
                curveTo(15.5f, 4.83579f, 15.1642f, 4.5f, 14.75f, 4.5f)
                horizontalLineTo(5.25f)
                close()
                moveTo(7.25f, 7f)
                curveTo(6.83579f, 7f, 6.5f, 7.33579f, 6.5f, 7.75f)
                curveTo(6.5f, 8.16421f, 6.83579f, 8.5f, 7.25f, 8.5f)
                horizontalLineTo(12.75f)
                curveTo(13.1642f, 8.5f, 13.5f, 8.16421f, 13.5f, 7.75f)
                curveTo(13.5f, 7.33579f, 13.1642f, 7f, 12.75f, 7f)
                horizontalLineTo(7.25f)
                close()
                moveTo(6.5f, 11.75f)
                curveTo(6.5f, 11.3358f, 6.83579f, 11f, 7.25f, 11f)
                horizontalLineTo(12.75f)
                curveTo(13.1642f, 11f, 13.5f, 11.3358f, 13.5f, 11.75f)
                curveTo(13.5f, 12.1642f, 13.1642f, 12.5f, 12.75f, 12.5f)
                horizontalLineTo(7.25f)
                curveTo(6.83579f, 12.5f, 6.5f, 12.1642f, 6.5f, 11.75f)
                close()
                moveTo(7.25f, 15f)
                curveTo(6.83579f, 15f, 6.5f, 15.3358f, 6.5f, 15.75f)
                curveTo(6.5f, 16.1642f, 6.83579f, 16.5f, 7.25f, 16.5f)
                horizontalLineTo(10.25f)
                curveTo(10.6642f, 16.5f, 11f, 16.1642f, 11f, 15.75f)
                curveTo(11f, 15.3358f, 10.6642f, 15f, 10.25f, 15f)
                horizontalLineTo(7.25f)
                close()
            }
        }.build()
        
        return _FluentuiSystemIconsReceipt!!
    }

private var _FluentuiSystemIconsReceipt: ImageVector? = null