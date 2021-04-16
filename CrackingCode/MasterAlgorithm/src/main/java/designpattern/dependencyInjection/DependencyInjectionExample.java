package designpattern.dependencyInjection;

public class DependencyInjectionExample {

    RepositoryInterface repositoryExample;

    public DependencyInjectionExample(RepositoryInterface repositoryExample) {
        this.repositoryExample = repositoryExample;
    }

    public void callRepository() {
        repositoryExample.print();
        ;
    }


}
