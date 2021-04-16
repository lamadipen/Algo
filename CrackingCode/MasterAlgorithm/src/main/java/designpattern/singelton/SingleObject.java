package designpattern.singelton;

public class SingleObject {

    int data;
    static SingleObject singleObject = new SingleObject(1);

    private SingleObject(int data) {
        this.data = data;
    }

    public static SingleObject getInstance() {
        return singleObject;
    }
}
