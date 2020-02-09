package com.easyrules;


import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.YamlRuleDefinitionReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class EasyRulesApp {

    public static void main(String[] args) {
        Facts facts = new Facts();
        facts.put("rain", true);

//        Rules rules = new Rules();
//        rules.register(getProgrammaticRule());
//        rules.register(getMvelRule());

//        DefaultRulesEngine defaultRulesEngine = new DefaultRulesEngine();
//        defaultRulesEngine.fire(rules, facts);

        try {
            MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
            Rule weatherRule = ruleFactory.createRule(new FileReader("/Users/lamad/workspace/RulesEngineExample/src/main/resources/easyRule/weather-rule.yml"));

            Rules rules = new Rules();
            rules.register(weatherRule);

            DefaultRulesEngine defaultRulesEngine = new DefaultRulesEngine();
            defaultRulesEngine.fire(rules, facts);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static MVELRule getMvelRule() {
        return new MVELRule()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when("rain == true")
                .then("System.out.println(\"It rains, take an umbrella!\");");
    }

    private  static Rule getProgrammaticRule() {
        return new RuleBuilder()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when(facts -> facts.get("rain").equals(true))
                .then(facts -> System.out.println("It rains, take an umbrella!"))
                .build();
    }
}
