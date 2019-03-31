package com.kartheek.cricbuzz.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.kartheek.cricbuzz.db.entity.User
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertUser(user : User) : Long

    @Query("SELECT * FROM users WHERE  userId = :id")
    fun getUserById(id : String) : Single<User?>;

//    @Query("SELECT * FROM users WHERE  userId = :id")
//    fun getUserById(id : String) : User?;


    @Query("UPDATE users SET password = :newPwd WHERE userId = :userId")
    fun updatePassword(userId: String, newPwd: String);

    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<User>;

    @Query("SELECT * FROM users")
    abstract fun getUsers(): Single<List<User>>

    @Delete
    fun deleteAllUsers(user: User) : Int;
}
