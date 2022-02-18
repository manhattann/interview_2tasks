package com.task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringFormulaUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"0*0", "0+0", "10-10"})
    void givenMathematicalFormulaShouldReturnZero(String formula) {
        //given
        //when
        double v = StringFormulaUtils.solveFormula(formula);
        //then
        assertEquals(0d, v);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1*1", "0+1", "10/10", "10/10/1/1/1"})
    void givenMathematicalFormulaShouldReturnOne(String formula) {
        //given
        //when
        double v = StringFormulaUtils.solveFormula(formula);
        //then
        assertEquals(1d, v);
    }

}
