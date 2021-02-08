package austindev.xyz.stockstracker.ui.FirstList

import android.util.Log
import androidx.lifecycle.ViewModel
import austindev.xyz.stockstracker.data.RetrofitClient
import austindev.xyz.stockstracker.data.RetrofitInterface
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList
import austindev.xyz.stockstracker.data.Gainer as Gainer

class FirstListViewModel : ViewModel() {

    val myAPIService: RetrofitInterface =
            RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)

    var myDataset: List<Gainer?> = ArrayList()
    private val apiInterface: RetrofitInterface = myAPIService



    fun run() {
        Log.d("HEY", "Giving it a try")

        apiInterface.getGainers()?.enqueue(object : Callback<List<Gainer?>?> {

            override fun onResponse(call: Call<List<Gainer?>?>, response: Response<List<Gainer?>?>) {
                myDataset = response.body()!!.toList()
                Log.d("HEY", "IT WORKED")


            }

            override fun onFailure(call: Call<List<Gainer?>?>, t: Throwable) {
                Log.d("HEY", "IT FAILED")
                t.printStackTrace()
            }


            fun clone(): Call<List<Gainer?>?> {
                TODO("Not yet implemented")
            }

            fun execute(): Response<List<Gainer?>?> {
                TODO("Not yet implemented")
            }

            fun enqueue(callback: Callback<List<Gainer?>?>) {
                TODO("Not yet implemented")
            }

            fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            fun cancel() {
                TODO("Not yet implemented")
            }

            fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            fun request(): Request {
                TODO("Not yet implemented")
            }


        }) as Nothing?
    }



}