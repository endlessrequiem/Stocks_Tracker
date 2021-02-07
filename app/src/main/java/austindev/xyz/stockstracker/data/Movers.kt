package austindev.xyz.stockstracker.data

import java.util.*

class Movers {
    private var actives: List<Active?>? = null
    private var gainers: List<Gainer?>? = null
    private var losers: List<Loser?>? = null
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    fun getActives(): List<Active?>? {
        return actives
    }

    fun setActives(actives: List<Active?>?) {
        this.actives = actives
    }

    fun getGainers(): List<Gainer?>? {
        return gainers
    }

    fun setGainers(gainers: List<Gainer?>?) {
        this.gainers = gainers
    }

    fun getLosers(): List<Loser?>? {
        return losers
    }

    fun setLosers(losers: List<Loser?>?) {
        this.losers = losers
    }

    fun getAdditionalProperties(): Map<String, Any>? {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}