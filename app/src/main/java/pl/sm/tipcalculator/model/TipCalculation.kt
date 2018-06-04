package pl.sm.tipcalculator.model

data class TipCalculation(
        val checkAmount: Double = 0.0,
        val tipPercantage: Int = 0,
        val tipAmount: Double = 0.0,
        val grandTotal: Double = 0.0
)