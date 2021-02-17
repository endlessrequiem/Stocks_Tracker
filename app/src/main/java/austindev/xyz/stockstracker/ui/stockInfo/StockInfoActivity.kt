package austindev.xyz.stockstracker.ui.stockInfo

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import austindev.xyz.stockstracker.R

class StockInfoActivity : AppCompatActivity() {

    private lateinit var stockItemViewModel: StockInfoViewModel

    var currTicker: SharedPreferences? = null
    var currLastPrice: SharedPreferences? = null
    var currPriceChange: SharedPreferences? = null
    var currPercentageChange: SharedPreferences? = null
    var currExchangeStanName: SharedPreferences? = null
    var currVolume: SharedPreferences? = null
    var currPerformanceID: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stock_info_activity)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = getString(R.string.title_stock_info)
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tickerView : TextView = findViewById(R.id.tickerView)
        val lastPriceView : TextView = findViewById(R.id.lastPriceView)
        val priceChangeView : TextView = findViewById(R.id.priceChangeView)
        val percentChangeView : TextView = findViewById(R.id.percentChangeView)
        val stanNameAndExchangeView : TextView = findViewById(R.id.stanNameAndExchangeView)
        val volumeView : TextView = findViewById(R.id.volumeView)
        val performanceIdView : TextView = findViewById(R.id.performanceIdView)
        val priceChangeGraphic : ImageView = findViewById(R.id.arrowPriceGraphicView)
        val percentageChangeGraphic : ImageView = findViewById(R.id.arrowPercentGraphicView)

        currTicker = getSharedPreferences(getString(R.string.ticker_key), MODE_PRIVATE)
        currLastPrice = getSharedPreferences(getString(R.string.lastPrice_key), MODE_PRIVATE)
        currPriceChange = getSharedPreferences(getString(R.string.priceChange_key), MODE_PRIVATE)
        currPercentageChange = getSharedPreferences(getString(R.string.percentageChange_key), MODE_PRIVATE)
        currExchangeStanName = getSharedPreferences(getString(R.string.exchangeStanName_key), MODE_PRIVATE)
        currVolume = getSharedPreferences(getString(R.string.volume_key), MODE_PRIVATE)
        currPerformanceID = getSharedPreferences(getString(R.string.performanceID_key), MODE_PRIVATE)

        val ticker = currTicker?.getString(getString(R.string.ticker_key), resources.getString(R.string.ticker_default))
        val lastPrice = currLastPrice?.getString(getString(R.string.lastPrice_key), resources.getString(R.string.lastPrice_default))
        val priceChange = currPriceChange?.getString(getString(R.string.priceChange_key), resources.getString(R.string.priceChange_default))
        val percentageChange = currPercentageChange?.getString(getString(R.string.percentageChange_key), resources.getString(R.string.percentageChange_default))
        val stanName = currExchangeStanName?.getString(getString(R.string.exchangeStanName_key), resources.getString(R.string.exchangeStanName_default))
        val volume = currVolume?.getString(getString(R.string.volume_key), resources.getString(R.string.volume_default))
        val performanceID = currPerformanceID?.getString(getString(R.string.performanceID_key), resources.getString(R.string.performanceID_default))
        val volumeLabel = getString(R.string.volume)
        val pIdLabel = getString(R.string.performanceID)


        val lastPriFormatted = "$$lastPrice"
        var priceChangeFormatted = " ($+$priceChange)"
        var percentChangeFormatted = "$percentageChange%"
        val formattedVolume = "$volumeLabel $volume"
        val formattedPerformanceID = "$pIdLabel $performanceID"

        val priceChangeCheck = priceChange?.toDouble()
        if (priceChangeCheck!! < 0) {
            priceChangeView.setTextColor(Color.RED)
            priceChangeGraphic.setImageResource(R.mipmap.ic_loss_foreground)
            priceChangeFormatted = " ($$priceChange)"

        } else {
            priceChangeView.setTextColor(Color.parseColor("#558B2F"))
            priceChangeGraphic.setImageResource(R.mipmap.ic_gain_foreground)
        }

        val percentageChangeCheck = percentageChange?.toDouble()
        if (percentageChangeCheck!! < 0) {
            percentChangeView.setTextColor(Color.RED)
            percentageChangeGraphic.setImageResource(R.mipmap.ic_loss_foreground)
        } else {
            percentChangeView.setTextColor(Color.parseColor("#558B2F"))
            percentageChangeGraphic.setImageResource(R.mipmap.ic_gain_foreground)
            percentChangeFormatted = "+$percentageChange%"
        }


        tickerView.text = ticker
        lastPriceView.text = lastPriFormatted
        priceChangeView.text  = priceChangeFormatted
        percentChangeView.text = percentChangeFormatted
        stanNameAndExchangeView.text = stanName
        volumeView.text = formattedVolume
        performanceIdView.text = formattedPerformanceID


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}