package com.example.roomconnectionsandmigrations.data.typeConverters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class PhotoTypeConverter {

    @TypeConverter
    fun toBitmapFromByteArray(byteArray: ByteArray):Bitmap{
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }

    @TypeConverter
    fun fromBitmapToByteArray(bitmap: Bitmap):ByteArray{
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, outputStream)
        return outputStream.toByteArray()
    }
}