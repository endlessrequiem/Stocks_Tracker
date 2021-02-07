package austindev.xyz.stockstracker.ui.FirstList

import android.os.Build
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import austindev.xyz.stockstracker.adapter.MoverAdapter
import austindev.xyz.stockstracker.data.Gainer
import austindev.xyz.stockstracker.data.RetrofitClient
import austindev.xyz.stockstracker.data.RetrofitInterface
import com.google.android.material.tabs.TabLayout
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FirstListViewModel : ViewModel() {
    val myAPIService: RetrofitInterface =
            RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)
    lateinit var myDataset: List<Gainer>


    var apiInterface: RetrofitInterface = RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)

    fun run() {
        var tryResp = apiInterface.getGainers()?.enqueue(object : Callback<List<Gainer?>?> {

            override fun onResponse(call: Call<List<Gainer?>?>, response: Response<List<Gainer?>?>) {
                myDataset = (response.body() as List<Gainer>?)!!
            }

            override fun onFailure(call: Call<List<Gainer?>?>, t: Throwable) {
                Log.d("HEY", "IT FAILED")

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


        })
    }



}