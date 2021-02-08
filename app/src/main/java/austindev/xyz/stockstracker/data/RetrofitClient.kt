package austindev.xyz.stockstracker.data

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val BASE_URL =
                "https://github.com/endlessrequiem/Stocks_Tracker/blob/[main|master]/db.json/"
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