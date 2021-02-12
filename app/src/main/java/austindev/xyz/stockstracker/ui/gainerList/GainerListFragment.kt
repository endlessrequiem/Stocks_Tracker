package austindev.xyz.stockstracker.ui.gainerList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.adapter.GainerAdapter
import austindev.xyz.stockstracker.data.Gainer
import austindev.xyz.stockstracker.data.GainerData
import austindev.xyz.stockstracker.data.RetrofitClient
import austindev.xyz.stockstracker.data.RetrofitInterface
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GainerListFragment : Fragment() {

    private lateinit var gainerListViewModel: GainerListViewModel

    private val myAPIService: RetrofitInterface =
            RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)


    private val apiInterface: RetrofitInterface = myAPIService


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        gainerListViewModel =
                ViewModelProvider(this).get(GainerListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gainer, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)


        apiInterface.getGainers()!!.enqueue(object : Callback<List<GainerData?>?> {

            override fun onResponse(call: Call<List<GainerData?>?>, response: Response<List<GainerData?>?>) {
                val myDataset = response.body()!!.toList()
                recyclerView.adapter = GainerAdapter(this@GainerListFragment, myDataset)

                Log.d("HEY", myDataset.toString())
            }

            override fun onFailure(call: Call<List<GainerData?>?>, t: Throwable) {
                Log.d("HEY", "IT FAILED")
                t.printStackTrace()
            }


            fun clone(): Call<List<Gainer?>?> {
                TODO("Not yet implemented")
            }

            fun execute(): Response<List<Gainer?>?> {
                TODO("Not yet implemented")
            }

            fun enqueue(callback: Callback<List<Gainer?>?>) {
                TODO("Not yet implemented")
            }

            fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            fun cancel() {
                TODO("Not yet implemented")
            }

            fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            fun request(): Request {
                TODO("Not yet implemented")
            }


        })

        return root
    }

}