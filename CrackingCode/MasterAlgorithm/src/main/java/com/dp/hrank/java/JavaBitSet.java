package com.dp.hrank.java;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class JavaBitSet {
    public static void main(String[] args) {

        //java7Solution();

//        java8Solution();

        bitSetIndividualTest();

    }

    private static void bitSetIndividualTest() {
        BitSet[] bitSets = new BitSet[]{new BitSet(5), new BitSet(5)};

        Map<String, BiConsumer<Integer, Integer>> ops = new HashMap<>();

        ops.put("AND", (index1, index2) -> bitSets[index1 - 1].and(bitSets[index2 - 1]));
        ops.put("OR", (index1, index2) -> bitSets[index1 - 1].or(bitSets[index2 - 1]));
        ops.put("XOR", (index1, index2) -> bitSets[index1 - 1].xor(bitSets[index2 - 1]));
        ops.put("SET", (index1, index2) -> bitSets[index1 - 1].set(index2));
        ops.put("FLIP", (index1, index2) -> bitSets[index1 - 1].flip(index2));


        //ops.get("AND").accept(1,2 );
//        ops.get("OR").accept(1,2 );
//        ops.get("XOR").accept(1,2 );
        ops.get("SET").accept(1,4 );
     //   ops.get("SET").accept(2,4 );

        ops.get("XOR").accept(1,2 );
        System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
    }

    private static void java8Solution() {
        Scanner sc = new Scanner(System.in);
        int bitsetLength = sc.nextInt();
        int numOfOperation = sc.nextInt();

        BitSet[] bitSets = new BitSet[]{new BitSet(bitsetLength), new BitSet(bitsetLength)};

        Map<String, BiConsumer<Integer, Integer>> ops = new HashMap<>();

        ops.put("AND", (index1, index2) -> bitSets[index1 - 1].and(bitSets[index2 - 1]));
        ops.put("OR", (index1, index2) -> bitSets[index1 - 1].or(bitSets[index2 - 1]));
        ops.put("XOR", (index1, index2) -> bitSets[index1 - 1].xor(bitSets[index2 - 1]));
        ops.put("SET", (index1, index2) -> bitSets[index1 - 1].set(index2));
        ops.put("FLIP", (index1, index2) -> bitSets[index1 - 1].flip(index2));

        for (int i = 0; i < numOfOperation; i++) {
            ops.get(sc.next()).accept(sc.nextInt(), sc.nextInt());
            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
        }
    }

    private static void java7Solution() {
        Scanner sc = new Scanner(System.in);
        int bitsetLength = sc.nextInt();
        int numOfOperation = sc.nextInt();

        BitSet bitSetA = new BitSet(bitsetLength);
        BitSet bitSetB = new BitSet(bitsetLength);
        BitSet[] bitSets = new BitSet[3];
        bitSets[1] = bitSetA;
        bitSets[2] = bitSetB;

        for (int i = 0; i < numOfOperation; i++) {
            String action = sc.next();
            int bitsetIndicator = sc.nextInt();
            int index = sc.nextInt();

            switch (action) {
                case "AND":
                    bitSets[bitsetIndicator].and(bitSets[index]);
                    break;
                case "SET":
                    bitSets[bitsetIndicator].set(index);
                    break;
                case "FLIP":
                    bitSets[bitsetIndicator].flip(index);
                    break;
                case "OR":
                    bitSets[bitsetIndicator].or(bitSets[index]);
                    break;
                case "XOR":
                    bitSets[bitsetIndicator].xor(bitSets[index]);
                    break;
            }
            System.out.printf("%d %d%n", bitSets[1].cardinality(), bitSets[2].cardinality());
        }
    }

}

/**
 * Java's BitSet class implements a vector of bit values (i.e.:  () or  ()) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of  is called a set bit.
 * <p>
 * Given  BitSets,  and , of size  where all bits in both BitSets are initialized to , perform a series of  operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.
 * <p>
 * Input Format
 * <p>
 * The first line contains  space-separated integers,  (the length of both BitSets  and ) and  (the number of operations to perform), respectively.
 * The  subsequent lines each contain an operation in one of the following forms:
 * <p>
 * AND
 * OR
 * XOR
 * FLIP
 * SET
 * In the list above,  is the integer  or , where  denotes  and  denotes .
 * is an integer denoting a bit's index in the BitSet corresponding to .
 * <p>
 * For the binary operations , , and , operands are read from left to right and the BitSet resulting from the operation replaces the contents of the first operand. For example:
 * <p>
 * AND 2 1
 * is the left operand, and  is the right operand. This operation should assign the result of  to .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * After each operation, print the respective number of set bits in BitSet  and BitSet  as  space-separated integers on a new line.
 * <p>
 * Sample Input
 * <p>
 * 5 4
 * AND 1 2
 * SET 1 4
 * FLIP 2 2
 * OR 2 1
 * Sample Output
 * <p>
 * 0 0
 * 1 0
 * 1 1
 * 1 2
 * Explanation
 * <p>
 * Initially: , , , and . At each step, we print the respective number of set bits in  and  as a pair of space-separated integers on a new line.
 * <p>
 * <p>
 * <p>
 * ,
 * The number of set bits in  and  is .
 * <p>
 * <p>
 * Set  to  ().
 * , .
 * The number of set bits in  is  and  is .
 * <p>
 * <p>
 * Flip  from  () to  ().
 * , .
 * The number of set bits in  is  and  is .
 * <p>
 * <p>
 * .
 * , .
 * The number of set bits in  is  and  is .
 */
