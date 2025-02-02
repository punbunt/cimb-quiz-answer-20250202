package service;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CIMBQuizServiceTest {

    @Test
    public void testGetWaysToClimb() {
        //1. ways = steps
        Assertions.assertEquals(1, CIMBQuiz.getWaysToClimb(1));
        Assertions.assertEquals(2, CIMBQuiz.getWaysToClimb(2));
        Assertions.assertEquals(3, CIMBQuiz.getWaysToClimb(3));

        //2. ways != steps
        Assertions.assertEquals(21, CIMBQuiz.getWaysToClimb(7));
        Assertions.assertEquals(34, CIMBQuiz.getWaysToClimb(8));
        Assertions.assertEquals(10946, CIMBQuiz.getWaysToClimb(20));

        //3. steps <= 0, invalid case
        Assertions.assertEquals(0, CIMBQuiz.getWaysToClimb(0));
        Assertions.assertEquals(0, CIMBQuiz.getWaysToClimb(-1));
    }

    @Test
    public void testGetMaxProfit() {
        //1. index of max number of arrays < index of min number
        Assertions.assertEquals(5, CIMBQuiz.getMaxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        //2. index of max number > index of min number
        Assertions.assertEquals(9, CIMBQuiz.getMaxProfit(new int[]{4, 2, 5, 1, 10}));
        //3. no max number after found min number
        Assertions.assertEquals(0, CIMBQuiz.getMaxProfit(new int[]{7, 6, 4, 3, 1}));
        //4. prices consist of minus number
        Assertions.assertEquals(10, CIMBQuiz.getMaxProfit(new int[]{3, -1, -6, 4}));

        //5. validate prices = null
        Assertions.assertEquals(0, CIMBQuiz.getMaxProfit(new int[]{}));
    }

    @Test
    public void testCompareVersion() {
        //1. version1 > version2
        Assertions.assertEquals(1, CIMBQuiz.compareVersion("3.0.1", "3.0.0"));
        Assertions.assertEquals(1, CIMBQuiz.compareVersion("1.1", "1.0.0"));
        //2. version1 < version2
        Assertions.assertEquals(-1, CIMBQuiz.compareVersion("2.0.1.2.1", "3.0.0"));
        Assertions.assertEquals(-1, CIMBQuiz.compareVersion("0.1", "1.1"));
        //3. version1 = version2
        Assertions.assertEquals(0, CIMBQuiz.compareVersion("4.1.2", "4.1.2"));
        Assertions.assertEquals(0, CIMBQuiz.compareVersion("1.01", "1.001"));
        Assertions.assertEquals(0, CIMBQuiz.compareVersion("1.0", "1.0.0"));
    }

}
