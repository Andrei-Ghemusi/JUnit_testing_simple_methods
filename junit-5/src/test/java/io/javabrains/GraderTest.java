package io.javabrains;

import org.junit.jupiter.api.*;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Running Grader")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GraderTest {

    Grader grader;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo =testInfo;
        this.testReporter =testReporter;
        grader = new Grader();
        testReporter.publishEntry(format("Running %s with tags %s ", testInfo.getDisplayName(), testInfo.getTags()));
    }

    @Nested
    @DisplayName("First tests")
    @Tag("First")
    class EndInNine {

        @Test
        void fiftyNineShouldReturnF(){
            assertEquals('F', grader.determineLetterGrade(59));
        }

        @Test
        void sixtyNineShouldReturnD(){
            assertEquals('D', grader.determineLetterGrade(69));
        }

        @Test
        void seventyNineShouldReturnC(){
            assertEquals('C', grader.determineLetterGrade(79));
        }

        @Test
        void eightyNineShouldReturnB(){
            assertEquals('B', grader.determineLetterGrade(89));
        }

        @Test
        void ninetyNineShouldReturnA(){
            assertEquals('A', grader.determineLetterGrade(99));
        }

    }

    @Nested
    @Tag("Second")
    @DisplayName("Edge tests")
    class EndingInZero{

        @Test
        void zeroShouldReturnF() {
            assertEquals('F', grader.determineLetterGrade(0));
        }

        @Test
        void sixtyShouldReturnD() {
            assertEquals('D', grader.determineLetterGrade(60));
        }

        @Test
        void seventyShouldReturnC() {
            assertEquals('C', grader.determineLetterGrade(70));
        }

        @Test
        void eightyShouldReturnB(){
            assertEquals('B', grader.determineLetterGrade(80));
        }

        @Test
        void ninetyShouldReturnA() {
            assertEquals('A', grader.determineLetterGrade(90));
        }

        @Test
        void negativeOneShouldReturnIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class,
                    ()-> { // lambda here
                        grader.determineLetterGrade(-1);
                    });
        }

    }
}