package austindev.xyz.stockstracker.ui.FirstList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.adapter.MoverAdapter
import austindev.xyz.stockstracker.data.Gainer
import austindev.xyz.stockstracker.data.RetrofitClient
import austindev.xyz.stockstracker.data.RetrofitInterface
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstListFragment : Fragment() {

    private lateinit var firstListViewModel: FirstListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        firstListViewModel =
                ViewModelProvider(this).get(FirstListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_second, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)

        var myAPIService: RetrofitInterface =
                RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)

        val apiInterface: RetrofitInterface = RetrofitClient().getClient()!!.create(RetrofitInterface::class.java)


        apiInterface.getGainers()!!.enqueue(object : Call<List<Gainer?>?>, Callback<List<Gainer?>?> {
            override fun onResponse(call: Call<List<Gainer?>?>, response: Response<List<Gainer?>?>) {
                val myDataset = response.body()!!
                recyclerView.adapter = MoverAdapter(myDataset, this)

            }
            override fun onFailure(call: Call<List<Gainer?>?>?, t: Throwable?) {
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun clone(): Call<List<Gainer?>?> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<List<Gainer?>?> {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<List<Gainer?>?>) {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }
        })




        return root
    }


}