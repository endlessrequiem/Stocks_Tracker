package austindev.xyz.stockstracker.data

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("https://github.com/endlessrequiem/Stocks_Tracker/blob/[main|master]/db.json/")
    fun getGainers(): Call<List<Gainer?>?>?

}