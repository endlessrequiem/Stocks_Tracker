package austindev.xyz.stockstracker.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.data.StocksObject
import austindev.xyz.stockstracker.ui.loserList.LoserListFragment
import java.text.DecimalFormat

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
            val mPercentChange: TextView = view.findViewById(R.id.percentChange)
            val mPercentGraphic: ImageView = view.findViewById(R.id.percentGraphic)
            val mPriceGraphic: ImageView = view.findViewById(R.id.priceGraphic)


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
            val df = DecimalFormat("###0.00")

            val stanName = item?.standardName
            val tick = item?.ticker
            val exchangeName = item?.exchange
            val lastPri = df.format(item?.lastPrice)
            val priChange = df.format(item?.priceChange)
            val perChange = item?.percentChange.toString()
            val perID = item?.performanceId
            val vol = item?.volume.toString()

            val xcName = context.resources.getString(R.string.exchangeName)

            val exchangeStanName = "$stanName ($exchangeName)"
            val priceChangeFormatted = "$$priChange"
            val percentChangeFormatted = "$perChange%"


            val pcDouble = item?.priceChange
            if (pcDouble != null && pcDouble < 0) {
                holder.mPriceChange.setTextColor(Color.RED)
                holder.mPriceGraphic.setImageResource(R.mipmap.ic_loss_foreground)
            } else {
                holder.mPriceChange.setTextColor(Color.parseColor("#558B2F"))
                holder.mPriceGraphic.setImageResource(R.mipmap.ic_gain_foreground)

            }
            val percentDouble = item?.percentChange
            if (percentDouble != null && percentDouble < 0) {
                holder.mPercentChange.setTextColor(Color.RED)
                holder.mPercentGraphic.setImageResource(R.mipmap.ic_loss_foreground)

            } else {
                holder.mPercentChange.setTextColor(Color.parseColor("#558B2F"))
                holder.mPercentGraphic.setImageResource(R.mipmap.ic_gain_foreground)
            }


            holder.mStandardName.text = tick
            holder.mExchangeName.text = exchangeStanName
            holder.mLastPrice.text = lastPri
            holder.mPriceChange.text = priceChangeFormatted
            holder.mPercentChange.text = percentChangeFormatted

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
