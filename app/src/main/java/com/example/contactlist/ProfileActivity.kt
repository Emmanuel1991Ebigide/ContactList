package com.example.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactlist.databinding.ActivityMainBinding
import com.example.contactlist.databinding.ActivityProfileBinding

private lateinit var binding: ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileName.text = intent.getStringExtra("contactName")
        binding.profileNumber.text = intent.getStringExtra("primaryNumber")
    }
}