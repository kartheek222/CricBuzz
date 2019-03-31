package com.kartheek.cricbuzz.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ColumnInfo
import android.support.annotation.NonNull
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "userId")
    var userName: String,

    @NonNull
    @ColumnInfo(name = "name")
    var fullName: String,

    @NonNull
    @ColumnInfo(name = "password")
    var password: String) {
}
