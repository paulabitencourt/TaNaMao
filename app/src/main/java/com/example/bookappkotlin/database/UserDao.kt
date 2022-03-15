package com.example.bookappkotlin.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(userData: UserData)

    @Update
    suspend fun updateLoggedUserState(currentState: Boolean){

    }


    @Query("SELECT * FROM user_data ORDER BY id ASC")
    fun readAllData(): LiveData<List<UserData>>
}