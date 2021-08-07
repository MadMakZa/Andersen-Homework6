package shadow.step.homework6recyclerview.ui.details

import androidx.lifecycle.ViewModel
import shadow.step.homework6recyclerview.data.Note
import shadow.step.homework6recyclerview.data.NoteList.noteListItems

class DetailsViewModel : ViewModel() {

    fun changeDataInNote(index: Int, note: Note){
        noteListItems[index] = note
    }
}