package ua.androstav.nausafe.ui.contacts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.androstav.nausafe.data.AppDB
import ua.androstav.nausafe.data.ContactEntity
import ua.androstav.nausafe.data.ContactRepository

class ContactsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository
    val allContacts: LiveData<List<ContactEntity>>

    init {
        val dao = AppDB.getDatabase(application).contactDao()
        repository = ContactRepository(dao)
        allContacts = repository.allContacts

        viewModelScope.launch(Dispatchers.IO) {
            if (repository.getAllOnce().isEmpty()) {
                val defaultContacts = listOf(
                    ContactEntity(name = "Пожежна служба", phone = "101"),
                    ContactEntity(name = "Поліція", phone = "102"),
                    ContactEntity(name = "Швидка допомога", phone = "103")
                )
                repository.insertAll(defaultContacts)
            }
        }
    }
}
