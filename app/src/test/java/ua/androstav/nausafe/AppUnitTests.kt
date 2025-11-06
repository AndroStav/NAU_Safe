package ua.androstav.nausafe

import org.junit.Assert.assertEquals
import org.junit.Test
import ua.androstav.nausafe.data.ContactEntity
import ua.androstav.nausafe.data.Instruction
import ua.androstav.nausafe.ui.contacts.ContactsAdapter
import ua.androstav.nausafe.ui.home.InstructionAdapter

class AppUnitTests {

    @Test
    fun instructionAdapter_itemCount_isCorrect() {
        val items = listOf(
            Instruction(title = "Пожежа", content = "Інструкція"),
            Instruction(title = "Тривога", content = "Інструкція")
        )
        val adapter = InstructionAdapter(items)
        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun contactsAdapter_itemCount_isCorrect() {
        val contacts = listOf(
            ContactEntity(name = "Поліція", phone = "102"),
            ContactEntity(name = "Пожежна", phone = "101")
        )
        val adapter = ContactsAdapter(contacts)
        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun contactEntity_data_isCorrect() {
        val contact = ContactEntity(name = "Швидка", phone = "103")
        assertEquals("Швидка", contact.name)
        assertEquals("103", contact.phone)
    }

    @Test
    fun instructionEntity_data_isCorrect() {
        val instr = Instruction(title = "Тривога", content = "Що робити...")
        assertEquals("Тривога", instr.title)
        assertEquals("Що робити...", instr.content)
    }

    @Test
    fun tabs_haveCorrectNames() {
        val expected = listOf("Інструкції", "Карта", "Контакти")
        val actual = listOf("Інструкції", "Карта", "Контакти")
        assertEquals(expected, actual)
    }
}
