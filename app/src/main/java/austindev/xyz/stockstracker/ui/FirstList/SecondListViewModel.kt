package austindev.xyz.stockstracker.ui.FirstList

import androidx.lifecycle.ViewModel
import austindev.xyz.stockstracker.data.Datasource

class SecondListViewModel : ViewModel() {

    val myDataset = Datasource().loadDummyData()

}