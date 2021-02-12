package austindev.xyz.stockstracker.adapter

import austindev.xyz.stockstracker.ui.gainerList.GainerListFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.data.DummyData
import austindev.xyz.stockstracker.ui.loserList.LoserListFragment

/**
 * Adapter for the [RecyclerView] in [LoserListFragment]. Displays [DummyData] data object.
 */
class SecondAdapter(
        private val context: GainerListFragment,
        private val dataset: List<DummyData>
): RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class SecondViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.standardName)

    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return SecondViewHolder(adapterLayout).listen()
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)

    }


    override fun getItemCount() = dataset.size

    //Set what happens when you click on individual item
    //AdapterPosition is the position of the item clicked
    private fun <T : RecyclerView.ViewHolder> T.listen(): T {
        itemView.setOnClickListener {
            Log.d("Item No:", adapterPosition.toString())

        }
        return this
    }

}
