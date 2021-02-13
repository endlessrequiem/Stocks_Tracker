package austindev.xyz.stockstracker.ui.gainerList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.adapter.GainerAdapter
import austindev.xyz.stockstracker.api.RetrofitClient
import austindev.xyz.stockstracker.api.RetrofitInterface
import austindev.xyz.stockstracker.data.*
import com.google.android.material.snackbar.Snackbar
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
        val root = inflater.inflate(R.layout.fragment_active, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
        val loadingProgressBar: ProgressBar = root.findViewById(R.id.progressBar)
        val noConnectionScreen: LinearLayout = root.findViewById(R.id.noConnection)



        apiInterface.getGainers()!!.enqueue(object : Callback<List<StocksObject?>?> {

            override fun onResponse(call: Call<List<StocksObject?>?>, response: Response<List<StocksObject?>?>) {
                val myDataset = response.body()!!.toList()
                recyclerView.adapter = GainerAdapter(this@GainerListFragment, myDataset)
                loadingProgressBar.visibility = View.INVISIBLE

            }


            override fun onFailure(call: Call<List<StocksObject?>?>, t: Throwable) {
                loadingProgressBar.visibility = View.INVISIBLE
                noConnectionScreen.visibility = View.VISIBLE
                Snackbar.make(loadingProgressBar, getString(R.string.load_failed), Snackbar.LENGTH_LONG).show()
                t.printStackTrace()
            }


        })

        return root
    }

}