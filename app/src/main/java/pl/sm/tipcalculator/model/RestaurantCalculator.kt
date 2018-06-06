package pl.sm.tipcalculator.model

import android.arch.lifecycle.LiveData
import java.math.RoundingMode

class RestaurantCalculator(val repository: TipCalculationRepository = TipCalculationRepository()
) {
    fun calculateTip(checkAmount: Double, tipPercentage: Int): TipCalculation {

        val tipAmount = (checkAmount * (tipPercentage.toDouble() / 100.0))
                .toBigDecimal()
                .setScale(2, RoundingMode.HALF_UP)
                .toDouble()

        val grandTotal = checkAmount + tipAmount

        return TipCalculation(
                checkAmount = checkAmount,
                tipPercentage = tipPercentage,
                tipAmount = tipAmount,
                grandTotal = grandTotal
        )
    }

    fun saveTipCalculation(tc: TipCalculation) {
        repository.saveTipCalculation(tc)
    }

    fun loadTipCalculationByLocationName(locationName: String) : TipCalculation? {
        return repository.loadTipCalculationByName(locationName)
    }

    fun loadSavedTipCalculations() : LiveData<List<TipCalculation>> {
        return repository.loadSavedTipCalculations()
    }

}