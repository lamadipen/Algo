package com.shailesh;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CustomSortedArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.moves(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {
    /*
     * Complete the 'moves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int moves(List<Integer> arr) {
        // Write your code here
        int moves = 0;

        if (arr.isEmpty()) {
            return moves;
        }
        //even
        int left = 0;

        //odd
        int right = arr.size() - 1;

        while (left < right) {
            if (isEven(arr, left)) {
                left++;
            } else if (!isEven(arr, right)) {
                right--;
            } else {
                int odd = arr.get(left);
                int even = arr.get(right);

                arr.remove(left);
                arr.add(left, even);
                arr.remove(right);
                arr.add(right, odd);

                left++;
                right--;

                moves++;
            }
        }
        return moves;
    }

    private static boolean isEven(List<Integer> arr, int index) {
        return arr.get(index) % 2 == 0;
    }
}