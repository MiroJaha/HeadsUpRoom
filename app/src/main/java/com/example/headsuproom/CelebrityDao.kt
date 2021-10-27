package com.example.headsuproom

import androidx.room.*

@Dao
interface CelebrityDao {

    @Query("SELECT * FROM Celebrities ORDER BY pk ASC")
    fun gettingAllCelebrities(): List<Information>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNewCelebrity(celebrity: Information)

    @Delete
    fun deleteCelebrity(celebrity: Information)

    @Update
    fun updateCelebrity(celebrity: Information)

}