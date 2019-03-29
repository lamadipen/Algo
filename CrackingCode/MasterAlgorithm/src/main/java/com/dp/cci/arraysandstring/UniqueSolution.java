package com.dp.cci.arraysandstring;

public class UniqueSolution {

    public static boolean isUniqueAscii(String string) {
        boolean[] ascii = new boolean[128];

        for(int i = 0 ; i < string.length(); i++){
            int index = string.charAt(i);

            if(ascii[index]){
                return false;
            }
            ascii[index] = true;
        }
        return true;
    }

    public static boolean isUniqueBitoperator(String string) {
        int checker = 0;
        for (int i = 0; i < string.length(); i++) {
            int val = string.charAt(i) - 'a';

            int i1 = 1 << val;
            int bit = checker & i1;
            if(bit > 0 ){
                return false;
            }
            int result = checker |= (1 << val);
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isUniqueAscii("Apple"));
//        System.out.println(isUniqueAscii("god"));

        System.out.println(isUniqueBitoperator("aple"));
    }


}
