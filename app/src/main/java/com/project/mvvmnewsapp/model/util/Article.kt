package com.project.mvvmnewsapp.model.util


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.project.mvvmnewsapp.model.db.typeconverter.SourceTypeConverter
import com.project.mvvmnewsapp.model.util.Source

@Entity(
    tableName = "articles"
)

data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String? = null,
    val content: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val source: Source = Source(),
    val title: String = "",
    val url: String = "",
    val urlToImage: String = ""
)