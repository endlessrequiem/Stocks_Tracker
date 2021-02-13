package austindev.xyz.stockstracker.api

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    var retrofit: Retrofit? = null
        fun getClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl("https://my-json-server.typicode.com/endlessrequiem/Stocks_Tracker/gainers/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            Log.d("Client", "GAINER CLIENT LOADED")

            return retrofit
        }
}