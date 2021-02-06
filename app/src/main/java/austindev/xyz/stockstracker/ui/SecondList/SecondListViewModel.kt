package austindev.xyz.stockstracker.ui.SecondList

import androidx.lifecycle.ViewModel
import austindev.xyz.stockstracker.data.SecondDataSource

class SecondListViewModel : ViewModel() {

    val myDataset = SecondDataSource().loadMoreDummyData()

}