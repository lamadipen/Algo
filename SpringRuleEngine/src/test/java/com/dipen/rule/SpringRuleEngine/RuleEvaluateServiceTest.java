package com.dipen.rule.SpringRuleEngine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RuleEvaluateServiceTest {

    @Test
    public void evaluateRulesTestRuleMathc1() {
        RuleEvaluateService ruleEvaluateService = new RuleEvaluateService();
        Product product = new Product("sweet", 10);
        String result = ruleEvaluateService.evaluateRules(product);
        Assertions.assertEquals("Rule Matched name.equals('sweet')", result);
    }

    @Test
    public void evaluateRulesTestRuleMatch2() {
        RuleEvaluateService ruleEvaluateService = new RuleEvaluateService();
        Product product = new Product("hello", 10);
        String result = ruleEvaluateService.evaluateRules(product);
        Assertions.assertEquals("Rule Matched age == 10", result);
    }


    @Test
    public void evaluateRulesTestRuleMatchFail1() {
        RuleEvaluateService ruleEvaluateService = new RuleEvaluateService();
        Product product = new Product("hello", 0);
        String result = ruleEvaluateService.evaluateRules(product);
        Assertions.assertNull(result);
    }
}