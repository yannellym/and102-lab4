package com.codepath.articlesearch

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//Data access objects (DAOs) defines and provides methods that your app can use to query,
//update, insert, and delete data in our created database. Think of the DAO as a messenger
//who goes between your app and the database. With Room, we'll represent the DAO using an Interface.
//
//What functions will we need for our application?
//
//Once we fetch data from the server, we will definitely need to insert new data into our table.
//We will need a way to get all of those entries from the database to display.
//We don't want to cache things in the database that are stale, so every time we get fresh data,
//we will need to clear out all older entries.
//So we need a insert, a get, and a delete function.
@Dao
interface ArticleDao {
    @Query("SELECT * FROM article_table")
    fun getAll(): Flow<List<ArticleEntity>>

    @Insert
    fun insertAll(articles: List<ArticleEntity>)

    @Query("DELETE FROM article_table")
    fun deleteAll()
}



//Adding a Flow List (from kotlinx.coroutines.flow) creates an asynchronous data stream that
//sequentially emits values and completes normally or with an exception. What does this mean?
//We can use this getAll() function to listen to any database changes and update our UI! This
//is way easier than checking for new data ourselves or adding function calls to lifecycle
//changes or network calls. We will use this a bit later.