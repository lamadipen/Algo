package com.dipen.rule.SpringRuleEngine;

public class Rule {
    private String condition;

    public Rule() {
    }

    public Rule(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
