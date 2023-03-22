package com.codepath.articlesearch

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Each instance of an Entity data class represents a row in a table for articles in the app's database.

// Essentially, we're creating a "template" for each row in our future database table, by specifying the columns.
// (This is somewhat similar to the models we used when serializing JSON!)

class ArticleEntity {
    // all users need a unique ID to be identified within the table.
    // for this, we'll use a long to generate a unique iD
    @Entity(tableName = "article_table")
    data class ArticleEntity(
        @PrimaryKey(autoGenerate = true) val id: Long = 0,
        @ColumnInfo(name = "headline") val headline: String?,
        @ColumnInfo(name = "articleAbstract") val articleAbstract: String?,
        @ColumnInfo(name = "byline") val byline: String?,
        @ColumnInfo(name = "mediaImageUrl") val mediaImageUrl: String?
    )
}