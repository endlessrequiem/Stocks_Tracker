package austindev.xyz.stockstracker.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.data.Gainer
import austindev.xyz.stockstracker.ui.FirstList.FirstListFragment
import retrofit2.Call

class MoverAdapter(
    private var context: FirstListFragment,
    private var moverList: Call<List<Gainer?>?>?

): RecyclerView.Adapter<MoverAdapter.MoverViewHolder>() {



    private val list = moverList?.execute()?.body()

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class MoverViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)

    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoverViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MoverViewHolder(adapterLayout).listen()
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: MoverViewHolder, position: Int) {
        val item = list!![position]
        val name = item?.getStandardName()
        holder.textView.text = name
        //holder.imageView.setImageResource(item.imageResourceId)

    }


    override fun getItemCount() = list!!.size

    //Set what happens when you click on individual item
    //AdapterPosition is the position of the item clicked
    private fun <T : RecyclerView.ViewHolder> T.listen(): T {
        itemView.setOnClickListener {
            Log.d("Item No:", adapterPosition.toString())

        }
        return this
    }

}

