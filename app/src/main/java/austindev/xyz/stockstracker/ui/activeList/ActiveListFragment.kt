package austindev.xyz.stockstracker.ui.activeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import austindev.xyz.stockstracker.R


class ActiveListFragment : Fragment() {

    private lateinit var activeListViewModel: ActiveListViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        activeListViewModel =
                ViewModelProvider(this).get(ActiveListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_active, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)



        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)


        return root
    }
}