package com.cdk.leeteasy;

import org.junit.Assert;
import org.junit.Test;

/**
 Given a valid (IPv4) IP address, return a defanged version of that IP address.

 A defanged IP address replaces every period "." with "[.]".

 Example 1:

 Input: address = "1.1.1.1"
 Output: "1[.]1[.]1[.]1"
 Example 2:

 Input: address = "255.100.50.0"
 Output: "255[.]100[.]50[.]0"


 Constraints:

 The given address is a valid IPv4 address.
 * */
public class DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        int length = address.length();
        char[] chars = new char[length + 6];
        int pointer = chars.length - 1;
        for(int i= length-1; i >= 0; i--){
            char value = address.charAt(i);
            if(value == '.'){
                chars[pointer--] = ']';
                chars[pointer--] = '.';
                chars[pointer--] = '[';
            }else{
                chars[pointer--] = value;
            }
        }
        return new String(chars);
    }

    @Test
    public void defangIpAddrTest(){
        Assert.assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
        Assert.assertEquals("255[.]100[.]50[.]0", defangIPaddr("255.100.50.0"));
    }
}
