package austindev.xyz.stockstracker.ui.FirstList

import androidx.lifecycle.ViewModel
import austindev.xyz.stockstracker.data.Gainer
import austindev.xyz.stockstracker.data.RetrofitClient
import austindev.xyz.stockstracker.data.RetrofitInterface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call

class FirstListViewModel : ViewModel() {


    fun getData(): Call<List<Gainer?>?>? {
        val myAPIService: RetrofitInterface =
            RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)
        val call: Call<List<Gainer?>?>? = myAPIService.getGainers()

        return call
    }
}