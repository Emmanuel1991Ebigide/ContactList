package com.example.contactlist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
    interface ContactDAO {
        @Insert
        fun addContactList(ContactItem: ContactModel)

        @Query("SELECT * FROM contactmodel")
        fun getAllContactLists(): LiveData<List<ContactModel>>

        @Delete
        fun delete(Contact_list: ContactModel)
}