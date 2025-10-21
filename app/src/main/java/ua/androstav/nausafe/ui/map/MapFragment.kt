package ua.androstav.nausafe.ui.map

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.androstav.nausafe.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val root = binding.root

        // Кнопка відкриття карти в Google Maps
        binding.btnOpenMaps.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://maps.google.com/?q=Національний+авіаційний+університет,+Київ")
            }
            startActivity(mapIntent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
