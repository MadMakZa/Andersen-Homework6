package shadow.step.homework6recyclerview.data

import android.widget.ImageView
import com.squareup.picasso.Picasso
import shadow.step.homework6recyclerview.R

object ImageLoader {
    fun loadImageFromWebServer(img: ImageView): ImageView {
        val url = "https://picsum.photos/200"
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .resize(75,75)
            .into(img)
        return img
    }
}