package io.javabrains;
import org.junit.jupiter.api.*;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


@DisplayName("running MathUtils")
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // this makes an instance once per class
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    void beforeAllInit(){ // this needs to be static if we don't use the @TestInstance because it runs before we have any instance
        System.out.println("This runs before all");
    }


    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo =testInfo;
        this.testReporter =testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry(format("Running %s with tags %s ", testInfo.getDisplayName(), testInfo.getTags()));
    }

    @AfterEach
    void cleanUp(){
        System.out.println("Cleaning up...");
    }

    @Nested
    @DisplayName("add method")
    @Tag("Math")
    class SumTest {
        @Test
        @DisplayName("adding two positive numbers")
        void testAddPositiveNumbers(){
            assertEquals(4, mathUtils.add(2,2), "should the right sum");
        }

        @Test
        @DisplayName("adding two negative numbers")
        void testAddNegativeNumbers(){
            int expected = -5;
            int actual = mathUtils.add(-3,-2);
            assertEquals(expected, actual, ()-> "should return sum" + expected + "but it returns" + actual);
        }
    }


    @DisplayName("Test calculating rectangle area.")
    @RepeatedTest(3)
    @Tag("Math")
    void testRectangleArea(RepetitionInfo repetitionInfo){
        assertEquals(42, mathUtils.rectangleArea(6,7), () -> "ERROR: wrong rectangle area on repetition" + repetitionInfo.getCurrentRepetition());
    }

    @Test
    @DisplayName("Multiplying method")
    @Tag("Math")
    void testMultiply(){
        assertAll(
                () -> assertEquals(4,mathUtils.multiply(2,2)),
                () -> assertEquals(10,mathUtils.multiply(2,5)),
                () -> assertEquals(49,mathUtils.multiply(7,7))
        );
    }


    @Test
    @DisplayName("Test dividing by zero.")
    @Tag("Math")
    void divideByZero(){
        boolean isServerUp = true;
        assumeTrue(isServerUp); // if this turns out false, then the test won't run
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(10, 0));
    }

    @Test
    @DisplayName("Method should not run")
    @Disabled
    @Tag("Fail")
    void testMeantToFail(){
        fail("This test should be disabled");
    }




}