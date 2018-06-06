package pl.sm.tipcalculator.model

class TipCalculationRepository {

    private val savedTips = mutableMapOf<String, TipCalculation>()

    fun saveTipCalculation(tip: TipCalculation) {
        savedTips[tip.locationName] = tip
    }

    fun loadTipCalculationByName(locationName: String) : TipCalculation? {
        return savedTips[locationName]
    }

}
