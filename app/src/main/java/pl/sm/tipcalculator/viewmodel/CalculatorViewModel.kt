package pl.sm.tipcalculator.viewmodel

import android.app.Application
import pl.sm.tipcalculator.R
import pl.sm.tipcalculator.model.RestaurantCalculator
import pl.sm.tipcalculator.model.TipCalculation

class CalculatorViewModel @JvmOverloads constructor(
        app: Application, val calculator: RestaurantCalculator = RestaurantCalculator()) : ObservableViewModel(app) {

    var inputCheckAmount = ""

    var inputTipPercentage = ""

    var outputCheckAmount = ""
    var outputTipAmount = ""
    var outputTotalDollarAmount = ""

    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tc: TipCalculation) {
        outputCheckAmount = getApplication<Application>().getString(R.string.dollar_amount, tc.checkAmount)
        outputTipAmount = getApplication<Application>().getString(R.string.dollar_amount, tc.tipAmount)
        outputTotalDollarAmount = getApplication<Application>().getString(R.string.dollar_amount, tc.grandTotal)
    }


    fun calculateTip() {

        val checkAmount = inputCheckAmount.toDoubleOrNull()

        val tipPercentage = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPercentage != null) {
            updateOutputs(calculator.calculateTip(checkAmount, tipPercentage))
            clearInput()
        }

    }

    fun clearInput() {
        inputCheckAmount = "0.00"
        inputTipPercentage = "0"
        notifyChange()
    }
}