package austindev.xyz.stockstracker.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterface {

    @GET("https://raw.githubusercontent.com/endlessrequiem/Stocks_Tracker/master/data.json/")
    fun getGainers(): Call<List<Gainer?>?>?
}