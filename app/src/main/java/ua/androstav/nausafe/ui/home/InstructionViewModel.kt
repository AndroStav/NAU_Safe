package ua.androstav.nausafe.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.androstav.nausafe.data.Instruction
import ua.androstav.nausafe.data.InstructionDatabase
import ua.androstav.nausafe.data.InstructionRepository

class InstructionViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: InstructionRepository
    val allInstructions: LiveData<List<Instruction>>

    init {
        val dao = InstructionDatabase.getDatabase(application).instructionDao()
        repository = InstructionRepository(dao)
        allInstructions = repository.allInstructions

        // Попереднє заповнення бази (лише при першому запуску)
        viewModelScope.launch(Dispatchers.IO) {
            if (repository.getAllOnce().isEmpty()) {
                val defaultInstructions = listOf(
                    Instruction(title = "Тривога", content = "Як діяти під час повітряної тривоги"),
                    Instruction(title = "Пожежа", content = "Як поводитися у випадку пожежі"),
                    Instruction(title = "Перша допомога", content = "Як надати першу допомогу")
                )
                repository.insertAll(defaultInstructions)
            }
        }
    }
}
