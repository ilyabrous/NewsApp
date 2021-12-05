package com.project.mvvmnewsapp.model.db.typeconverter

import androidx.room.TypeConverter
import com.project.mvvmnewsapp.model.util.Source


class SourceTypeConverter {

    @TypeConverter
    fun fromSource(source: Source) : String {
        return source.name
    }

    @TypeConverter
    fun toSource(name : String) : Source {
        return Source(name,name)
    }
}