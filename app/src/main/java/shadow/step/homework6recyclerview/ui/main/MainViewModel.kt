package shadow.step.homework6recyclerview.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import shadow.step.homework6recyclerview.data.Note
import shadow.step.homework6recyclerview.data.NoteList.noteListItems
import kotlin.collections.ArrayList

class MainViewModel : ViewModel() {

    val noteLiveData = MutableLiveData<ArrayList<Note>>()

    init {
        noteLiveData.value = noteListItems
    }

}