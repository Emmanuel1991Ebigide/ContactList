package com.example.contactlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlist.databinding.ContactlistBinding

class ContactAdapter (
    val contactlist: List<ContactModel>,
    val clickerFnx: (ContactModel) -> Unit
        ) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ContactlistBinding)
         : RecyclerView.ViewHolder(binding.root){

         fun bind(contactlist: ContactModel){
             binding.contactName.text = contactlist.contactName
             binding.primaryNumber.text =  contactlist.primaryNumber
             binding.root.setOnClickListener{
                 clickerFnx(contactlist)
             }
         }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ContactlistBinding =
            ContactlistBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactlist.get(position))
    }

    override fun getItemCount() = contactlist.size


 }
