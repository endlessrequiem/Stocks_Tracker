package austindev.xyz.stockstracker.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterface {

    @GET("")
    fun getGainers(): Call<List<Gainer?>?>?
}