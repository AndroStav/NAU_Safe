package ua.androstav.nausafe.ui.contacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import ua.androstav.nausafe.data.ContactEntity
import ua.androstav.nausafe.databinding.ItemContactBinding
import ua.androstav.nausafe.utils.FileLogger

class ContactsAdapter(private val contacts: List<ContactEntity>) :
    RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.binding.contactName.text = contact.name
        holder.binding.contactPhone.text = contact.phone

        holder.binding.buttonCall.setOnClickListener {
            // Логування ключової дії: спроба дзвінка
            FileLogger.log(holder.itemView.context, "ACTION", "User tapped CALL to: ${contact.name} (${contact.phone})")

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:${contact.phone}".toUri()
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = contacts.size
}