package austindev.xyz.stockstracker

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    var currTicker: SharedPreferences? = null
    var currLastPrice: SharedPreferences? = null
    var currPriceChange: SharedPreferences? = null
    var currPercentageChange: SharedPreferences? = null
    var currStanName: SharedPreferences? = null
    var currExchangeName: SharedPreferences? = null
    var currVolume: SharedPreferences? = null
    var currPerformanceID: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        currTicker = getSharedPreferences(
            getString(R.string.ticker_key), MODE_PRIVATE
        )
        currLastPrice = getSharedPreferences(
            getString(R.string.lastPrice_key), MODE_PRIVATE
        )
        currPriceChange = getSharedPreferences(
            getString(R.string.priceChange_key), MODE_PRIVATE
        )
        currPercentageChange = getSharedPreferences(
            getString(R.string.percentageChange_key), MODE_PRIVATE
        )
        currStanName = getSharedPreferences(
            getString(R.string.stanName_key), MODE_PRIVATE
        )
        currExchangeName = getSharedPreferences(
            getString(R.string.exchangeStanName_key), MODE_PRIVATE
        )
        currVolume = getSharedPreferences(
            getString(R.string.volume_key), MODE_PRIVATE
        )
        currPerformanceID = getSharedPreferences(
            getString(R.string.performanceID_key), MODE_PRIVATE
        )

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_gainer,
                R.id.navigation_losers,
                R.id.navigation_actives,
                R.id.navigation_stock_info
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }


}

