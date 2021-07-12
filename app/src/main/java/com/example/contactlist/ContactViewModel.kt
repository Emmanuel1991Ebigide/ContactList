package com.example.contactlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ContactViewModel: ViewModel() {

    fun  addContactList (
        contactList: ContactModel,
        database: ContactDatabase){
        database.contactDao().addContactList(contactList)
    }
    fun getAllContactlists(database: ContactDatabase)
    : LiveData<List<ContactModel>> {
        return database.contactDao().getAllContactLists()

    }
}