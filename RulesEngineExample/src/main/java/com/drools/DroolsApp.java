package com.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsApp {
    private static KieContainer kieContainer;

    public static void main(String[] args) {
        kieContainer = KieServices.Factory.get().getKieClasspathContainer();

        Product gold = getProductDiscount(new Product("gold", 0));
        System.out.println(gold);
        Product diamond = getProductDiscount(new Product("diamond", 0));
        System.out.println(diamond);

    }

    private static Product getProductDiscount(Product product) {
        KieSession rulesSession = kieContainer.newKieSession("rulesSession");
        rulesSession.insert(product);
        rulesSession.fireAllRules();
        rulesSession.dispose();
        return product;
    }
}
