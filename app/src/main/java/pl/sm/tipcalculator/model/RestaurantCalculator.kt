package pl.sm.tipcalculator.model

import java.math.RoundingMode

class RestaurantCalculator {
    fun calculateTip(checkAmount: Double, tipPercantage: Int): TipCalculation {

        val tipAmount = (checkAmount * (tipPercantage.toDouble() / 100.0))
                .toBigDecimal()
                .setScale(2, RoundingMode.HALF_UP)
                .toDouble()

        val grandTotal = checkAmount + tipAmount

        return TipCalculation(
                checkAmount = checkAmount,
                tipPercantage = tipPercantage,
                tipAmount = tipAmount,
                grandTotal = grandTotal
        )
    }
}