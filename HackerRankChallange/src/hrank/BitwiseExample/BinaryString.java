package hrank.BitwiseExample;

/**
 * Created by dipen on 3/13/2017.
 */
class BinaryString {

    BinaryString(String string){
        for( byte b : string.getBytes() ){
            System.out.print(Integer.toBinaryString(b) + " ");
        }
        System.out.println();
    }

    BinaryString(Integer integer){
        System.out.println(Integer.toBinaryString(integer));
    }

    public static void main(String[] args) {
        new BinaryString("HackerRank");
        new BinaryString(8675309);
    }
}


