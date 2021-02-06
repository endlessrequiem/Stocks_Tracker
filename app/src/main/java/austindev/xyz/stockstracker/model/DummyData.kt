
package austindev.xyz.stockstracker.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * [DummyData] is the data class to represent the Affirmation text and imageResourceId
 */
data class DummyData(
        @StringRes val stringResourceId: Int,
        @DrawableRes val imageResourceId: Int
)