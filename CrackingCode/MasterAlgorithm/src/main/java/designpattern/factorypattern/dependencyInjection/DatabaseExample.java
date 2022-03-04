package designpattern.factorypattern.dependencyInjection;

public class DatabaseExample implements RepositoryInterface {

    public void print() {
        System.out.println("Print from Data");
    }
}
