package designpattern.factorypattern.dependencyInjection;

import org.junit.Test;

public class FactoryPatternExampleTest {

    @Test
    public void getRepository() {
        FactoryPatternExample factoryPatternExample = new FactoryPatternExample();

        RepositoryInterface database = factoryPatternExample.getRepository("database");
        RepositoryInterface repo = factoryPatternExample.getRepository("repo");
    }
}