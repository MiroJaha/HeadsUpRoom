package com.example.headsuproom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Information::class],version = 1, exportSchema = false)
abstract class CelebrityDatabase : RoomDatabase() {

    abstract fun celebrityDao(): CelebrityDao

    companion object{
        @Volatile //writes to this field are immediately visible to other threads
        var instance: CelebrityDatabase?= null

        fun getInstance(context: Context): CelebrityDatabase{
            if (instance!=null)
                return instance!!
            synchronized(this){ //protection from concurrent execution on multiple threads
                instance= Room.databaseBuilder(context.applicationContext,CelebrityDatabase::class.java,"HeadsUp")
                    .fallbackToDestructiveMigration() //Destroy old database on version change
                    .build()
            }
            return instance!!
        }
    }
}