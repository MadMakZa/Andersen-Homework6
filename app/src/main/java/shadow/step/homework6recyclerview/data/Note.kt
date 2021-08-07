package shadow.step.homework6recyclerview.data


data class Note(
    val image: Int,
    var name: String = "",
    var lastName: String = "",
    var phoneNumber: String = "",
    val idNote: Int = 0
)

object NoteList {
    val noteListItems = ArrayList<Note>()
}
