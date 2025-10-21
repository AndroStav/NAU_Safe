package ua.androstav.nausafe.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.androstav.nausafe.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerInstructions)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        val instructions = listOf(
            Instruction("Пожежа", "Як діяти під час пожежі"),
            Instruction("Повітряна тривога", "Правила поведінки під час тривоги"),
            Instruction("Перша допомога", "Основні дії при пораненнях"),
            Instruction("Перша допомога", "Основні дії при пораненнях"),
            Instruction("Перша допомога", "Основні дії при пораненнях"),
            Instruction("Перша допомога", "Основні дії при пораненнях"),
            Instruction("Перша допомога", "Основні дії при пораненнях"),
            Instruction("Перша допомога", "Основні дії при пораненнях"),
            Instruction("Перша допомога", "Основні дії при пораненнях"),
            Instruction("Перша допомога", "Основні дії при пораненнях"),
            Instruction("Перша допомога", "Основні дії при пораненнях"),
            Instruction("Перша допомога10", "Основні дії при пораненнях")
            // додаткові інструкції...
        )

        recycler.adapter = InstructionAdapter(instructions)
        return view
    }
}
