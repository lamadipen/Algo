package com.dp.cci.parallelthread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelThreadTest {

    @Test
    public void parallelTest() {
        List<Integer> amount = new ArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            amount.add(i);
        }

        long startTime = System.currentTimeMillis();
        List<Integer> collect = amount
                .stream()
                .parallel()
                .map(integer -> multiply(integer))
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();

        System.out.println("Delta Time:: " + (endTime - startTime));
    }

    private Integer multiply(Integer integer){
        try {
            //Thread.sleep(1);
            return integer * 2;
        } catch (Exception ex) {
        }
        return 1;
    }



}
