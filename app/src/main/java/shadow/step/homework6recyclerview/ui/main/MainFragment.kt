package shadow.step.homework6recyclerview.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import shadow.step.homework6recyclerview.R
import shadow.step.homework6recyclerview.data.Note
import shadow.step.homework6recyclerview.ui.adapter.NoteAdapter
import shadow.step.homework6recyclerview.ui.details.DetailsFragment

class MainFragment : Fragment(), NoteAdapter.OnItemClickListener {

    companion object {
        private const val NOTE_EXTRA_KEY = "NOTE_EXTRA_KEY"
        fun newInstance() = MainFragment()
    }

    private lateinit var noteAdapter: NoteAdapter
    private lateinit var recyclerview: RecyclerView
    private lateinit var viewModel: MainViewModel
    private var items = ArrayList<Note>()

    override fun onStart() {
        super.onStart()
        items.clear()
        viewModel.noteLiveData.observe(this, Observer {
            items.addAll(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.main_fragment, container, false)
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerview = view.findViewById(R.id.recyclerView)
        recyclerview.setHasFixedSize(true)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerview.layoutManager = linearLayoutManager
        noteAdapter = NoteAdapter(items, this)
        recyclerview.adapter = noteAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext().applicationContext, "Clicked! $position position", Toast.LENGTH_SHORT).show()
        openDetailsFragment(position)
    }

    private fun openDetailsFragment(tag: Int) {
        val fragmentDetails = DetailsFragment()
        val bundle = Bundle()
        bundle.putInt(NOTE_EXTRA_KEY, tag)
        fragmentDetails.arguments = bundle
        parentFragmentManager.beginTransaction()
            .add(R.id.container, fragmentDetails)
            .addToBackStack(null)
            .commit()
    }

}