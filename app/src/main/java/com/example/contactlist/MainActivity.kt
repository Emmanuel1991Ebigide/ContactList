package com.example.contactlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    private lateinit var myContactList: MutableList<ContactModel>
    private lateinit var viewModel: ContactViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        myContactList = mutableListOf()

        myContactAdapter = ContactAdapter(myContactList){
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("contactName", it.contactName)
            intent.putExtra("primaryNumber", it.primaryNumber)
            startActivity(intent)
        }
        binding.recyclerView.adapter = myContactAdapter

        val db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contact-database"
        ).allowMainThreadQueries().build()

        viewModel.getAllContactlists(db).observe(this, {
            myContactAdapter = ContactAdapter(it){
             val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("contactName", it.contactName)
                intent.putExtra("primaryNumber", it.primaryNumber)
            }
            binding.recyclerView.adapter = myContactAdapter
            myContactAdapter.notifyDataSetChanged()
        })

        binding.button.setOnClickListener {
            val name: String = binding.editText.text.toString()
            val number: String = binding.editText2.text.toString()

            val contactlist = ContactModel(name, number)
            viewModel.addContactList(contactlist, db)

            myContactAdapter.notifyDataSetChanged()
        }
    }
}