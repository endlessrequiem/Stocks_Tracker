package austindev.xyz.stockstracker.data

import java.util.*

class Active {
    private var exchange: String? = null
    private var lastPrice: Double? = null
    private var percentChange: Double? = null
    private var performanceId: String? = null
    private var priceChange: Double? = null
    private var standardName: String? = null
    private var ticker: String? = null
    private var volume: Double? = null
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    fun getExchange(): String? {
        return exchange
    }

    fun setExchange(exchange: String?) {
        this.exchange = exchange
    }

    fun getLastPrice(): Double? {
        return lastPrice
    }

    fun setLastPrice(lastPrice: Double?) {
        this.lastPrice = lastPrice
    }

    fun getPercentChange(): Double? {
        return percentChange
    }

    fun setPercentChange(percentChange: Double?) {
        this.percentChange = percentChange
    }

    fun getPerformanceId(): String? {
        return performanceId
    }

    fun setPerformanceId(performanceId: String?) {
        this.performanceId = performanceId
    }

    fun getPriceChange(): Double? {
        return priceChange
    }

    fun setPriceChange(priceChange: Double?) {
        this.priceChange = priceChange
    }

    fun getStandardName(): String? {
        return standardName
    }

    fun setStandardName(standardName: String?) {
        this.standardName = standardName
    }

    fun getTicker(): String? {
        return ticker
    }

    fun setTicker(ticker: String?) {
        this.ticker = ticker
    }

    fun getVolume(): Double? {
        return volume
    }

    fun setVolume(volume: Double?) {
        this.volume = volume
    }

    fun getAdditionalProperties(): Map<String, Any>? {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }

}