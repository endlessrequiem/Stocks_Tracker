package austindev.xyz.stockstracker.api

import austindev.xyz.stockstracker.data.StocksObject
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("https://my-json-server.typicode.com/endlessrequiem/Stocks_Tracker/gainers/")
    fun getGainers(): Call<List<StocksObject?>?>?

    @GET("https://my-json-server.typicode.com/endlessrequiem/Stocks_Tracker/actives/")
    fun getActives(): Call<List<StocksObject?>?>?

    @GET("https://my-json-server.typicode.com/endlessrequiem/Stocks_Tracker/losers/")
    fun getLosers(): Call<List<StocksObject?>?>?

}