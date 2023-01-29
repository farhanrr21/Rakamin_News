package com.myapp.rakaminnews.database

import androidx.room.TypeConverter
import com.myapp.rakaminnews.model.Sumber

class Converter {
    @TypeConverter
    fun fromSource(source: Sumber): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Sumber {
        return Sumber(name, name)
    }
}
