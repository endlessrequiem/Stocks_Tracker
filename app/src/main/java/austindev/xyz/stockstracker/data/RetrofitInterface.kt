package austindev.xyz.stockstracker.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterface {

    @Headers("x-rapidapi-key: 220eccff1emsh0077a33886d04fdp13d889jsna69e19283301", "x-rapidapi-host: morning-star.p.rapidapi.com")
    @GET("https://morning-star.p.rapidapi.com/market/v2/get-movers/")
    fun getGainers(): Call<List<Gainer?>?>?
}