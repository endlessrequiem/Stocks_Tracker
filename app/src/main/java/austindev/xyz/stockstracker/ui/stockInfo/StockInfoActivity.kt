package austindev.xyz.stockstracker.ui.stockInfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import austindev.xyz.stockstracker.R

class StockInfoActivity : AppCompatActivity() {

    private lateinit var stockItemViewModel: StockInfoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stock_info_activity)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = getString(R.string.title_stock_info)
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}