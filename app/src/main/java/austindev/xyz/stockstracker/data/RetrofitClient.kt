package austindev.xyz.stockstracker.data

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
        val BASE_URL =
                "https://morning-star.p.rapidapi.com/market/v2/get-movers/"
        var retrofit: Retrofit? = null
        fun getClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            Log.d("Client", "CLIENT LOADED")

            return retrofit
        }

}