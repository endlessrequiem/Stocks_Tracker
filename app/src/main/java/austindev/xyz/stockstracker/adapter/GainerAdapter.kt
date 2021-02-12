package austindev.xyz.stockstracker.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.data.GainerData
import austindev.xyz.stockstracker.ui.FirstList.FirstListFragment

class GainerAdapter(
        private var gainsList: List<GainerData?>?


): RecyclerView.Adapter<GainerAdapter.GainerViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    class GainerViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val mStandardName: TextView = view.findViewById(R.id.standardName)
        val mLastPrice: TextView = view.findViewById(R.id.lastPrice)
        val mPriceChange: TextView = view.findViewById(R.id.priceChange)
        val mTicker: TextView = view.findViewById(R.id.tickerPidVolume)

    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GainerViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return GainerViewHolder(adapterLayout).listen()
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: GainerViewHolder, position: Int) {
        val item = gainsList!![position]
        Log.d("HEY", position.toString())

        val stanName = item?.standardName.toString()
        val lastPri = item?.lastPrice.toString()
        val priChange = item?.priceChange.toString() + item?.percentChange.toString()
        val tick = item?.ticker.toString() + item?.volume.toString() + item?.performanceId.toString()



        holder.mStandardName.text = stanName
        holder.mLastPrice.text = lastPri
        holder.mPriceChange.text =  priChange
        holder.mTicker.text = tick

    }

    override fun getItemCount(): Int {
        return gainsList!!.size
    }

    //Set what happens when you click on individual item
    //AdapterPosition is the position of the item clicked
    private fun <T : RecyclerView.ViewHolder> T.listen(): T {
        itemView.setOnClickListener {
            Log.d("Item No:", adapterPosition.toString())

        }
        return this
    }

}

