package austindev.xyz.stockstracker.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterface {


    @GET("https://morning-star.p.rapidapi.com/market/v2/get-movers/")
    fun getGainers(): Call<List<Gainer?>?>?

}