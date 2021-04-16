package designpattern.dependencyInjection;

import org.junit.Test;

public class DependencyInjectionExampleTest {

    @Test
    public void callRepository() {
        DependencyInjectionExample dependencyInjectionExample = new DependencyInjectionExample(new RepositoryExample());
        dependencyInjectionExample.callRepository();
    }
}