package shadow.step.homework6recyclerview.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shadow.step.homework6recyclerview.R
import shadow.step.homework6recyclerview.data.ImageLoader
import shadow.step.homework6recyclerview.data.Note

class NoteAdapter(private val noteList: MutableList<Note>,
                  private val listener: OnItemClickListener)
    : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fragment, parent, false)
        return NoteViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return noteList.size
    }
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = noteList[position]
        holder._name.text = currentNote.name
        holder._lastName.text = currentNote.lastName
        holder._phoneNumber.text = currentNote.phoneNumber
        holder._image = ImageLoader.loadImageFromWebServer(holder._image)
    }

    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var _image: ImageView = itemView.findViewById(R.id.ivImage) as ImageView
        val _name: TextView = itemView.findViewById(R.id.tvName) as TextView
        val _lastName: TextView = itemView.findViewById(R.id.tvLastName) as TextView
        val _phoneNumber: TextView = itemView.findViewById(R.id.tvNumber) as TextView

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onItemClick(position = absoluteAdapterPosition)
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}