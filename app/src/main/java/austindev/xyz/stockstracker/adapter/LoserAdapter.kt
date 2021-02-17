package austindev.xyz.stockstracker.adapter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.MainActivity
import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.data.StocksObject
import austindev.xyz.stockstracker.ui.loserList.LoserListFragment
import austindev.xyz.stockstracker.ui.stockInfo.StockInfoActivity
import java.text.DecimalFormat

class LoserAdapter(
    private var context: LoserListFragment,
    private var gainsList: List<StocksObject?>?


): RecyclerView.Adapter<LoserAdapter.LoserViewHolder>() {


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    class LoserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val mStandardName: TextView = view.findViewById(R.id.tickerName)
        val mLastPrice: TextView = view.findViewById(R.id.lastPrice)
        val mPriceChange: TextView = view.findViewById(R.id.priceChange)
        val mExchangeName: TextView = view.findViewById(R.id.standardNameAndExchange)
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
        val volumeString = item?.volume.toString()
        val performanceIdString = item?.performanceId.toString()


        val exchangeStanName = "$stanName ($exchangeName)"
        val lastPriFormatted = "$$lastPri"
        var priceChangeFormatted = " ($+$priChange)"
        var percentChangeFormatted = "$perChange%"


        val pcDouble = item?.priceChange
        if (pcDouble != null && pcDouble < 0) {
            holder.mPriceChange.setTextColor(Color.RED)
            holder.mPriceGraphic.setImageResource(R.mipmap.ic_loss_foreground)
            priceChangeFormatted = " ($$priChange)"
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
            percentChangeFormatted = "+$perChange%"

        }


        holder.mStandardName.text = tick
        holder.mLastPrice.text = lastPriFormatted
        holder.mPercentChange.text = percentChangeFormatted
        holder.mPriceChange.text = priceChangeFormatted
        holder.mExchangeName.text = exchangeStanName

        holder.itemView.setOnClickListener { v ->
            Log.d("Item No:", position.toString())

            val currTickerEditor : SharedPreferences?= context.activity?.getSharedPreferences(context.getString(R.string.ticker_key),
                Context.MODE_PRIVATE)
            currTickerEditor?.edit()?.putString(context.getString(R.string.ticker_key), tick)?.apply()

            val currLastPriceEditor : SharedPreferences?= context.activity?.getSharedPreferences(context.getString(R.string.lastPrice_key),
                Context.MODE_PRIVATE)
            currLastPriceEditor?.edit()?.putString(context.getString(R.string.lastPrice_key), item?.lastPrice.toString())?.apply()

            val currPercentageChangeEditor : SharedPreferences?= context.activity?.getSharedPreferences(context.getString(R.string.percentageChange_key),
                Context.MODE_PRIVATE)
            currPercentageChangeEditor?.edit()?.putString(context.getString(R.string.percentageChange_key), item?.percentChange.toString())?.apply()

            val currPriceChangeEditor: SharedPreferences? = context.activity?.getSharedPreferences(context.getString(R.string.priceChange_key),
                Context.MODE_PRIVATE)
            currPriceChangeEditor?.edit()?.putString(context.getString(R.string.priceChange_key), item?.priceChange.toString())?.apply()

            val currExchangeStanNameEditor: SharedPreferences? = context.activity?.getSharedPreferences(context.getString(R.string.exchangeStanName_key),
                Context.MODE_PRIVATE)
            currExchangeStanNameEditor?.edit()?.putString(context.getString(R.string.exchangeStanName_key), exchangeStanName)?.apply()

            val currVolumeEditor: SharedPreferences? = context.activity?.getSharedPreferences(context.getString(R.string.volume_key),
                Context.MODE_PRIVATE)
            currVolumeEditor?.edit()?.putString(context.getString(R.string.volume_key), volumeString)?.apply()

            val currPerformanceIDEditor: SharedPreferences? = context.activity?.getSharedPreferences(context.getString(R.string.performanceID_key),
                Context.MODE_PRIVATE)
            currPerformanceIDEditor?.edit()?.putString(context.getString(R.string.performanceID_key), performanceIdString)?.apply()

            val intent = Intent(v.context, StockInfoActivity::class.java)
            v.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return gainsList!!.size
    }

    //Set what happens when you click on individual item
    //AdapterPosition is the position of the item clicked
    private fun <T : RecyclerView.ViewHolder> T.listen(): T {
        itemView.setOnClickListener {
            //Log.d("Item No:", adapterPosition.toString())


        }
        return this
    }

}