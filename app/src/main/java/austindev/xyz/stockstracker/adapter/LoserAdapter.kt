package austindev.xyz.stockstracker.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.data.StocksObject
import austindev.xyz.stockstracker.ui.loserList.LoserListFragment

class LoserAdapter (
    private var context: LoserListFragment,
    private var gainsList: List<StocksObject?>?


    ): RecyclerView.Adapter<LoserAdapter.LoserViewHolder>() {

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        class LoserViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val mStandardName: TextView = view.findViewById(R.id.standardName)
            val mLastPrice: TextView = view.findViewById(R.id.lastPrice)
            val mPriceChange: TextView = view.findViewById(R.id.priceChange)
            val mExchangeName: TextView = view.findViewById(R.id.exchangeName)
            val mPerformanceID: TextView = view.findViewById(R.id.performanceID)
            val mVolume: TextView = view.findViewById(R.id.volume)
            val mPercentChange: TextView = view.findViewById(R.id.percentChange)


        }

        /**
         * Create new views (invoked by the layout manager)
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoserViewHolder {
            // create a new view
            val adapterLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)

            return LoserViewHolder(adapterLayout).listen()
        }

        /**
         * Replace the contents of a view (invoked by the layout manager)
         */
        override fun onBindViewHolder(holder: LoserViewHolder, position: Int) {
            val item = gainsList!![position]
            Log.d("HEY", position.toString())

            val stanName = item?.standardName.toString()
            val tick = item?.ticker.toString()
            val exchangeName = item?.exchange.toString()
            val lastPri = item?.lastPrice.toString()
            val priChange = item?.priceChange.toString()
            val perChange = item?.percentChange.toString()
            val perID = item?.performanceId.toString()
            val vol = item?.volume.toString()

            val xcName = context.resources.getString(R.string.exchangeName)
            val lp = context.resources.getString(R.string.lastPrice)
            val priCh = context.resources.getString(R.string.priceChange)
            val perCh = context.resources.getString(R.string.percentChange)
            val performID = context.resources.getString(R.string.performanceID)
            val volString = context.resources.getString(R.string.volume)

            val nameTickFormatted = "$stanName ($tick)"
            val excFormatted = "$xcName $exchangeName"
            val lpFormatted = "$lp $$lastPri"
            val priceChangeFormatted = "$priCh $$priChange"
            val percentChangeFormatted = "$perCh $perChange%"
            val performanceIDFormatted = "$performID $perID"
            val volFormatted = "$volString $vol"


            holder.mStandardName.text = nameTickFormatted
            holder.mExchangeName.text = excFormatted
            holder.mLastPrice.text = lpFormatted
            holder.mPriceChange.text = priceChangeFormatted
            holder.mPercentChange.text = percentChangeFormatted
            holder.mPerformanceID.text = performanceIDFormatted
            holder.mVolume.text = volFormatted

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
