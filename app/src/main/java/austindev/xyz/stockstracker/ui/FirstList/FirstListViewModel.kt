package austindev.xyz.stockstracker.ui.FirstList

import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import austindev.xyz.stockstracker.data.Gainer
import austindev.xyz.stockstracker.data.RetrofitClient
import austindev.xyz.stockstracker.data.RetrofitInterface
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FirstListViewModel : ViewModel() {
        /*
        var myAPIService: RetrofitInterface =
            RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)

        var apiInterface: RetrofitInterface = RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)


        var myDataset = apiInterface.getGainers()!!.enqueue(object : Call<List<Gainer?>?>, Callback<List<Gainer?>?> {
                        override fun onResponse(call: Call<List<Gainer?>?>, response: Response<List<Gainer?>?>) {
                                val myDataset = response.body()!!
                        }
                        override fun onFailure(call: Call<List<Gainer?>?>?, t: Throwable?) {
                        }

                override fun isCanceled(): Boolean {
                        TODO("Not yet implemented")
                }

                override fun clone(): Call<List<Gainer?>?> {
                        TODO("Not yet implemented")
                }

                override fun execute(): Response<List<Gainer?>?> {
                        TODO("Not yet implemented")
                }

                override fun enqueue(callback: Callback<List<Gainer?>?>) {
                        TODO("Not yet implemented")
                }

                override fun isExecuted(): Boolean {
                        TODO("Not yet implemented")
                }

                override fun cancel() {
                        TODO("Not yet implemented")
                }

                override fun request(): Request {
                        TODO("Not yet implemented")
                }
        })

         */



}