package kata.hard;

import java.math.BigInteger;

public class MissingTwoSolution {

    /**
     * This solution has over flow issue so we are using BigInteger
     * but still it has limitation
     *
     * @param arr
     * @return
     */
    public int findMissingOneNumberWithProduct(int[] arr) {
        BigInteger productTillN = getProductTillN(arr.length + 1);
        BigInteger productCurrent = new BigInteger("1");

        for (int i = 0; i < arr.length; i++) {
            productCurrent = productCurrent.multiply(new BigInteger(arr[i] + ""));
        }
        return productTillN.divide(productCurrent).intValue();
    }

    private BigInteger getProductTillN(int n) {
        BigInteger productCurrent = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            productCurrent = productCurrent.multiply(new BigInteger(i + ""));
        }
        return productCurrent;
    }


    /**
     * This solution slows the  over flow issue
     * then upper solution  but still it has limitation
     *
     * @param arr
     * @return
     */
    public int findMissingOneNumberWithSum(int[] arr) {
        int length = arr.length + 1;
        BigInteger sumTillN = new BigInteger(length * (length + 1) / 2 + "");
        BigInteger currentSum = new BigInteger("0");

        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum.add(new BigInteger(arr[i] + ""));
        }
        return sumTillN.subtract(currentSum).intValue();
    }

    public int[] findMissingTwoNumberWithSum(int[] arr) {
        int maxValue = arr.length + 2;
        int squareSumTillN = getSquareSumTillN(maxValue, 2);
        int totalSumTillN = maxValue * (maxValue + 1) / 2;

        for (int i = 0; i < arr.length; i++) {
            squareSumTillN -= arr[i] * arr[i];
            totalSumTillN -= arr[i];
        }

        return sloveEquation(totalSumTillN, squareSumTillN);
    }

    private int[] sloveEquation(int totalSumTillN, int squareSumTillN) {
        /**
         *  ax^2 + bx +c
         *  x = [-b + -sqrt(b^2) - 4ac)]
         *  In this case, it has to be a+ not a-
         * */
        int a = 2;
        int b = -2 * totalSumTillN;
        int c = totalSumTillN * totalSumTillN - squareSumTillN;

        double part1 = -1 * b;
        double part2 = Math.sqrt(b * b - 4 * a * c);
        double part3 = 2 * a;

        int solutionX = (int) ((part1 + part2) / part3);
        int solutionY = totalSumTillN - solutionX;
        int[] solutions = {solutionX, solutionY};

        return solutions;
    }

    private int getSquareSumTillN(int maxValue, int power) {
        int sum = 0;
        for (int i = 0; i <= maxValue; i++) {
            sum += Math.pow(i, power);
        }
        return sum;
    }
}


