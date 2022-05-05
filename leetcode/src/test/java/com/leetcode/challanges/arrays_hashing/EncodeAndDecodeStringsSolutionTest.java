package com.leetcode.challanges.arrays_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncodeAndDecodeStringsSolutionTest {

    @Test
    void encodeTest1() {
        String encode = EncodeAndDecodeStringsSolution.encode(Arrays.asList(new String[]{"lint", "code", "love", "you"}));
        Assertions.assertEquals("4#lint4#code4#love3#you",encode);

        List<String> decode = EncodeAndDecodeStringsSolution.decode(encode);
        Assertions.assertEquals(Arrays.asList(new String[]{"lint", "code", "love", "you"}),decode);
    }

    @Test
    void decodeTest1() {

    }
}