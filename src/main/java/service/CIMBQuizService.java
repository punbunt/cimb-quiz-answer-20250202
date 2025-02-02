package service;


public class CIMBQuizService {

    public static void main(String[] args) {
        //Quiz 1
        int steps = 9;
        System.out.println("Quiz 1: possible ways to climb up is equal to " + CIMBQuiz.getWaysToClimb(steps));
        //Quiz 2
        int[] prices = {11, 6, 5, 24, 12, 7, 6, 8, 100};
        System.out.println("Quiz 2: max profit is equal to " + CIMBQuiz.getMaxProfit(prices));
        //Quiz 3
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println("Quiz 3: The result of compare version is " + CIMBQuiz.compareVersion(version1, version2));
    }
}
