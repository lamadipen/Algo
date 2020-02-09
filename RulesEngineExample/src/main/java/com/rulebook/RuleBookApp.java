package com.rulebook;

import com.deliveredtechnologies.rulebook.Fact;
import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;

public class RuleBookApp {
    public static void main(String[] args) {
//        RuleBook<Object> ruleBook = getDefaultRuleBook();
//        ruleBook.run(new FactMap());
        RuleBook<Object> customRuleBook = getCustomRuleBook();
        NameValueReferableMap factMap = new FactMap();
        factMap.setValue("hello", "Test");
        factMap.setValue("world", "World-value");
        customRuleBook.run(factMap);
    }

    private static RuleBook<Object> getDefaultRuleBook() {
        return RuleBookBuilder.create()
                .addRule(rule -> rule.withNoSpecifiedFactType()
                        .then(f -> System.out.println("Hello"))
                )
                .addRule(rule -> rule.withNoSpecifiedFactType()
                        .then(f -> System.out.println("world"))
                ).build();
    }

    private static RuleBook<Object> getCustomRuleBook() {
        return RuleBookBuilder.create()
                .addRule(rule -> rule.withFactType(String.class)
                        .when(f -> f.containsKey("hello"))
                        .then(f -> System.out.println(f.get("hello")))
                )
                .addRule(rule -> rule.withFactType(String.class)
                        .using("world")
                        .then(System.out::println)
                ).build();
    }


    private static RuleBook<Object> sendEmailRules() {
        return RuleBookBuilder.create()
                .addRule(rule -> rule.withFactType(String.class)
                        .when(fact -> fact.containsKey("hello"))
                        .then(fact -> System.out.println(fact.get("hello")))
                )
                .addRule(rule -> rule.withFactType(String.class)
                        .using("world")
                        .then(System.out::println)
                )
                .addRule(rule -> rule.withFactType(String.class)
                        .when(fact -> fact.containsKey("hello"))
                        .then(fact -> System.out.println(fact.get("hello")))
                )
                .addRule(rule -> rule.withFactType(String.class)
                        .when(fact -> fact.containsKey("hello"))
                        .then(fact -> System.out.println(fact.get("hello")))
                ).build();
    }


}
