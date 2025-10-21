package ua.androstav.nausafe.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ua.androstav.nausafe.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)

        val contacts = listOf(
            Contact("ДСНС (пожежна служба)", "101"),
            Contact("Поліція", "102"),
            Contact("Швидка допомога", "103"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333"),
            Contact("Адміністрація НАУ", "+380442062333")
            // додаткові контакти...
        )

        binding.recyclerContacts.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerContacts.adapter = ContactsAdapter(contacts)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
