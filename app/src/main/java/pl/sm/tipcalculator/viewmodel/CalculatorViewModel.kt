package pl.sm.tipcalculator.viewmodel

import android.app.Application
import pl.sm.tipcalculator.R
import pl.sm.tipcalculator.model.RestaurantCalculator
import pl.sm.tipcalculator.model.TipCalculation

class CalculatorViewModel @JvmOverloads constructor(
        app: Application, val calculator: RestaurantCalculator = RestaurantCalculator()) : ObservableViewModel(app) {

    private var lastTipCalculated = TipCalculation()

    var inputCheckAmount = ""

    var inputTipPercentage = ""

    val outputCheckAmount get() = getApplication<Application>().getString(R.string.dollar_amount, lastTipCalculated.checkAmount)
    val outputTipAmount get() = getApplication<Application>().getString(R.string.dollar_amount, lastTipCalculated.tipAmount)
    val outputTotalDollarAmount get() = getApplication<Application>().getString(R.string.dollar_amount, lastTipCalculated.grandTotal)
    val locationName get() = lastTipCalculated.locationName

    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tc: TipCalculation) {
        lastTipCalculated = tc
        notifyChange()
    }

    fun saveCurrentTip(name: String) {

        val tipToSave = lastTipCalculated.copy(locationName = name)
        calculator.saveTipCalculation(tipToSave)

        updateOutputs(tipToSave)

    }


    fun calculateTip() {

        val checkAmount = inputCheckAmount.toDoubleOrNull()

        val tipPercentage = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPercentage != null) {
            updateOutputs(calculator.calculateTip(checkAmount, tipPercentage))

        }

    }

    fun clearInput() {
        inputCheckAmount = "0.00"
        inputTipPercentage = "0"
        notifyChange()
    }
}