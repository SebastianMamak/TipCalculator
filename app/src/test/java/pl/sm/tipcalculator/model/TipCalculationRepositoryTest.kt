package pl.sm.tipcalculator.model

import android.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class TipCalculationRepositoryTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

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

    }

    @Test
    fun testLoadSavedTipCalculations() {
        val tip1 = TipCalculation(locationName = "Pancake Paradise",
                checkAmount = 100.0,
                tipPercentage = 25,
                tipAmount = 25.0,
                grandTotal = 125.0)

        val tip2 = TipCalculation(locationName = "Cheesecake Factory",
                checkAmount = 100.0,
                tipPercentage = 25,
                tipAmount = 25.0,
                grandTotal = 125.0)

        repository.saveTipCalculation(tip1)
        repository.saveTipCalculation(tip2)

        repository.loadSavedTipCalculations().observeForever {
            tipCalculations -> assertEquals(2, tipCalculations?.size)
        }


    }

}