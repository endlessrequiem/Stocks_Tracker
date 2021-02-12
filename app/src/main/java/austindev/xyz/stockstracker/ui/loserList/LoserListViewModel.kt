package austindev.xyz.stockstracker.ui.loserList

import androidx.lifecycle.ViewModel
import austindev.xyz.stockstracker.data.SecondDataSource

class LoserListViewModel : ViewModel() {

    val myDataset = SecondDataSource().loadMoreDummyData()

}