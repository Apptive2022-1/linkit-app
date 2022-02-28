package com.example.linkit.domain.utils

import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.example.linkit.LinkItApp
import com.example.linkit.domain.model.Size

object BitmapConverter {
    private val defaultSize = Size(128f, 128f)

    fun resizeIcon(bitmap: Bitmap): Bitmap {
        val targetWidth = defaultSize.width.toInt()
        val ratio:Float = targetWidth.toFloat() / bitmap.width
        val targetHeight:Int = (bitmap.height * ratio).toInt()

        return Bitmap.createScaledBitmap(
            bitmap, targetWidth, targetHeight, true
        )
    }
}