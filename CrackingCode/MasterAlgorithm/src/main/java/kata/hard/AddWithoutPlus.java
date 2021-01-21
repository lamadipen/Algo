package kata.hard;

public class AddWithoutPlus {

    public double addRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;

        return addRecursive(sum, carry);
    }

    public double addIterative(int a, int b) {
        while (b > 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
