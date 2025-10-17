package ua.androstav.nausafe.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import ua.androstav.nausafe.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root

        // Статичний список інструкцій
        val instructions = listOf(
            "🔥 Пожежа — негайно залиште приміщення, не користуйтесь ліфтом.",
            "🚨 Повітряна тривога — перейдіть до найближчого укриття.",
            "💉 Травма або нещасний випадок — зверніться до медпункту або зателефонуйте 103.",
            "⚡ Відключення електрики — залишайтесь спокійними, дотримуйтесь інструкцій адміністрації."
        )

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            instructions
        )
        binding.instructionList.adapter = adapter

        // Кнопка "Оновити" — просто показує оновлення списку (для прикладу)
        binding.btnRefresh.setOnClickListener {
            binding.instructionList.adapter = adapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
