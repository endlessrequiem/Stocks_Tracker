package austindev.xyz.stockstracker.data

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("https://raw.githubusercontent.com/endlessrequiem/Stocks_Tracker/master/data.json/")
    fun getGainers(): Call<List<Gainer?>?>?
}