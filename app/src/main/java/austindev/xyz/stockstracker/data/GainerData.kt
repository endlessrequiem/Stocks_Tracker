package austindev.xyz.stockstracker.data

data class GainerData(val exchange: String?,
                      val lastPrice: Double?,
                      val percentChange: Double?,
                      val performanceId: String?,
                      val priceChange: Double?,
                      val standardName: String?,
                      val ticker: String?,
                      val volume: Double?)
