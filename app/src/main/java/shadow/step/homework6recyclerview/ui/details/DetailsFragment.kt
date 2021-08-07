package shadow.step.homework6recyclerview.ui.details

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import shadow.step.homework6recyclerview.MainActivity
import shadow.step.homework6recyclerview.R
import shadow.step.homework6recyclerview.data.Note
import shadow.step.homework6recyclerview.data.NoteList.noteListItems
import shadow.step.homework6recyclerview.ui.main.MainFragment

class DetailsFragment : Fragment() {

    companion object {
        private const val NOTE_EXTRA_KEY = "NOTE_EXTRA_KEY"
        fun newInstance() = DetailsFragment()
    }

    private lateinit var viewModel: DetailsViewModel
    private lateinit var editName: EditText
    private lateinit var editLastName: EditText
    private lateinit var editPhoneNumber: EditText
    private lateinit var buttonSave: Button
    private var noteId: Int? = 0
    private lateinit var currentNote: Note

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        editName = activity?.findViewById(R.id.etName)!!
        editLastName = activity?.findViewById(R.id.etLastName)!!
        editPhoneNumber = activity?.findViewById(R.id.etPhoneNumber)!!
        buttonSave = activity?.findViewById(R.id.btnSave)!!
        noteId = arguments?.getInt(NOTE_EXTRA_KEY)

        loadContact(noteId!!)
        saveChanges()
    }

    private fun loadContact(noteId: Int){
        editName.setText(noteListItems[noteId].name)
        editLastName.setText(noteListItems[noteId].lastName)
        editPhoneNumber.setText(noteListItems[noteId].phoneNumber)
        currentNote = noteListItems[noteId]

    }
    private fun saveChanges(){
        buttonSave.setOnClickListener {
            currentNote.name = editName.text.toString()
            currentNote.lastName = editLastName.text.toString()
            currentNote.phoneNumber = editPhoneNumber.text.toString()
            viewModel.changeDataInNote(noteId!!, currentNote)
            activity?.onBackPressed()
        }
    }

}