package austindev.xyz.stockstracker.data

import austindev.xyz.stockstracker.R
import austindev.xyz.stockstracker.model.DummyData

/**
 * [Datasource] generates a list of [DummyData]
 */
class Datasource() {

    fun loadDummyData(): List<DummyData> {
        return listOf<DummyData>(
                DummyData(R.string.first, R.drawable.image1),
                DummyData(R.string.second, R.drawable.image2),
                DummyData(R.string.third, R.drawable.image3),
                DummyData(R.string.fourth, R.drawable.image4),
                DummyData(R.string.fifth, R.drawable.image5),
                DummyData(R.string.sixth, R.drawable.image6),
                DummyData(R.string.seventh, R.drawable.image7),
                DummyData(R.string.eigth, R.drawable.image8),
                DummyData(R.string.ninth, R.drawable.image9),
                DummyData(R.string.tenth, R.drawable.image10)
        )
    }
}

