package service;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CIMBQuiz {

    public static int getWaysToClimb(int steps) {
        //validate whether step is less than one
        if (steps <= 0) {
            return 0;
        }
        //notice the relation of steps and possible ways
        //When steps = 1, ways = 1
        //When steps = 2, ways = 2
        //When steps = 3, ways = 3
        //When steps = 4, ways = 5 ---> 3+2
        //When steps = 5, ways = 8 ---> 5+3
        //When steps = 6, ways = 13 ---> 8+5
        //When steps = 7, ways = 21 ---> 13+8
        //When steps = 8, ways = 34 ---> 21+13
        if (steps < 4) {
            return steps;
        }
        int possibleWays = getWaysToClimb(steps - 2) + getWaysToClimb(steps - 1);
        return possibleWays;
    }

    public static int getMaxProfit(int[] prices) {
        //0. check prices empty or not
        if (prices.length == 0) {
            return 0;
        }
        //1. sort to get minPrice
        int[] sortPrices = Arrays.stream(prices).sorted().toArray();
        int minPrice = sortPrices[0];
        int maxPrice = minPrice;
        //System.out.println("minPrice = " + minPrice);
        for (int i = 0; i < prices.length; i++) {
            //2. start to find maxPrice after arrived index of minPrice
            if (prices[i] == minPrice) {
                for (int u = i; u < prices.length; u++) {
                    if (prices[u] > minPrice) {
                        if (prices[u] > maxPrice) {
                            maxPrice = prices[u];
                        }
                        //System.out.println("maxPrice = " + maxPrice);
                    }
                }
            }
        }
        int maxProfit = maxPrice - minPrice;
        return maxProfit;
    }

    public static int compareVersion(String version1, String version2) {
        //1. split each parameter by dot to get their length
        String[] v1StringList = version1.split("\\.");
        String[] v2StringList = version2.split("\\.");
        //2. remove leading zero
        String newV1String = Arrays.stream(v1StringList).map(s -> s.equals("0") ? s : s.replaceFirst("^0+", "")).collect(Collectors.joining("."));
        String newV2String = Arrays.stream(v2StringList).map(s -> s.equals("0") ? s : s.replaceFirst("^0+", "")).collect(Collectors.joining("."));

        //3. parse to int to compare
        int v1Int = Integer.parseInt(newV1String.replace(".", ""));
        int v2Int = Integer.parseInt(newV2String.replace(".", ""));
        //4. adjust number of digit
        int diffLength = Math.abs(v1StringList.length - v2StringList.length);
        if (v1Int < v2Int) {
            v1Int = (int) Math.pow(10, diffLength) * v1Int;
        } else {
            v2Int = (int) Math.pow(10, diffLength) * v2Int;
        }
        //5. compare then return
        if (v1Int == v2Int) {
            return 0;
        }
        return v1Int > v2Int ? 1 : -1;
    }
}
