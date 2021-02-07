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
        recyclerView.adapter = MoverAdapter(this, firstListViewModel.getData())

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

        return root
    }


}