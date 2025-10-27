package ua.androstav.nausafe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Instruction::class], version = 2, exportSchema = false)
abstract class InstructionDatabase : RoomDatabase() {
    abstract fun instructionDao(): InstructionDao

    companion object {
        @Volatile
        private var INSTANCE: InstructionDatabase? = null

        fun getDatabase(context: Context): InstructionDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InstructionDatabase::class.java,
                    "instruction_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}