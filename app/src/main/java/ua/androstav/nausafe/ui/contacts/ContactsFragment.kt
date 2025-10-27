package ua.androstav.nausafe.ui.contacts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ua.androstav.nausafe.databinding.FragmentContactsBinding
import ua.androstav.nausafe.ui.contacts.ContactsAdapter

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ContactsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)

        binding.recyclerContacts.layoutManager = LinearLayoutManager(requireContext())

        viewModel.allContacts.observe(viewLifecycleOwner) { contacts ->
            binding.recyclerContacts.adapter = ContactsAdapter(contacts)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
