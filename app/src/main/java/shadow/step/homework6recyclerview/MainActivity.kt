package shadow.step.homework6recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import shadow.step.homework6recyclerview.data.Note
import shadow.step.homework6recyclerview.data.NoteList
import shadow.step.homework6recyclerview.ui.main.MainFragment
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        addItems()
    }
    private fun addItems() {
        for (n in 1..100) {
            val randomNumber = Random()
            NoteList.noteListItems.add(
                Note(
                R.drawable.ic_launcher_background,
                "Name$n",
                "LastName$n",
                "+7(981)${randomNumber.nextInt(9999999)}", n)
            )
        }
    }
}