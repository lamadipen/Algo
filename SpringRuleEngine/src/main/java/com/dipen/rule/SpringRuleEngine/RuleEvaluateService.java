package com.dipen.rule.SpringRuleEngine;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * This custom rule engine evaluates the fields of the context object
 * with the rule provided in string format at runtime.
 *
 * The rule provided as string however should follow Java coding norms.
 *
 * In example provided below Product object is the context object
 * and the rules are applied in the fields of Product Object.
 *
 * You can load a list of rule from the database.
 *
 * References:
 * https://docs.spring.io/spring/docs/4.2.x/spring-framework-reference/html/expressions.html
 * https://www.baeldung.com/spring-expression-language
 */
@Service
public class RuleEvaluateService {
    List<Rule> rules = new ArrayList();

    public RuleEvaluateService() {
        this.rules.add(new Rule("name.equals('noodles')"));
        this.rules.add(new Rule("name.equals('sweet')"));
        this.rules.add(new Rule("age == 10"));
    }

    public String evaluateRules(Product productToEvaluate){
        String result = null;
        for (Rule rule : rules) {
            if (isRuleMatched(productToEvaluate, rule)) {
                result = "Rule Matched " + rule.getCondition();
                break;
            }
        }
        return result;
    }

    private boolean isRuleMatched(Product productToEvaluate, Rule rule) {
        if (null == rule || StringUtils.isEmpty(rule.getCondition())) {
            return false;
        }
        try {
            Boolean ruleMatched = RuleEngine.isRuleMatched(productToEvaluate, rule.getCondition(), Boolean.class);
            return (null == ruleMatched) ? false : ruleMatched;
        } catch (Exception exception) {
            return false;
        }
    }
}
