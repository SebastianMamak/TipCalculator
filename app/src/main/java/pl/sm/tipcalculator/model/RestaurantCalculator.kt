package pl.sm.tipcalculator.model

import java.math.RoundingMode

class RestaurantCalculator {
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
}