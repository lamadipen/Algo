package designpattern.factorypattern.dependencyInjection;

public class FactoryPatternExample {

    public RepositoryInterface getRepository(String name) {
        if (name.equals("database")) {
            return new DatabaseExample();
        } else if (name.equals("repo")) {
            return new RepositoryExample();
        }
        return null;
    }
}
