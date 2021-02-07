package austindev.xyz.stockstracker.ui.FirstList

import androidx.lifecycle.ViewModel
import austindev.xyz.stockstracker.data.Gainer
import austindev.xyz.stockstracker.data.RetrofitClient
import austindev.xyz.stockstracker.data.RetrofitInterface
import retrofit2.Call

class FirstListViewModel : ViewModel() {

        var myAPIService: RetrofitInterface =
            RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)
        var call: Call<List<Gainer?>?>? = myAPIService.getGainers()

        val myDataset = call

}