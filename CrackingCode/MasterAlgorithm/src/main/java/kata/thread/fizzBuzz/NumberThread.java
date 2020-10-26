package kata.thread.fizzBuzz;

public class NumberThread extends FizzBuzzThread {
    public NumberThread(int max, boolean div3, boolean div5, String toPrint) {
        super(max, div3, div5, null);
    }

    @Override
    public void print() {
        System.out.println(current);
    }
}
