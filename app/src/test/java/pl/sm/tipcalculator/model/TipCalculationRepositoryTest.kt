package pl.sm.tipcalculator.model

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TipCalculationRepositoryTest {

    lateinit var repository: TipCalculationRepository

    @Before
    fun setUp() {
        repository = TipCalculationRepository()
    }

    @Test
    fun testSaveTip() {
        val tip = TipCalculation(locationName = "Pancake Paradise",
                checkAmount = 100.0,
                tipPercentage = 25,
                tipAmount = 25.0,
                grandTotal = 125.0)

        repository.saveTipCalculation(tip)

        assertEquals(tip, repository.loadTipCalculationByName(tip.locationName))
    }

}