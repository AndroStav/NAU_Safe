package ua.androstav.nausafe.ui.contacts

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.androstav.nausafe.databinding.ItemContactBinding

class ContactsAdapter(private val contacts: List<Contact>) :
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
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${contact.phone}")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = contacts.size
}
