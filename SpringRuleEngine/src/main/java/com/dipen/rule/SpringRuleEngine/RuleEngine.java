package com.dipen.rule.SpringRuleEngine;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class RuleEngine {
    public static <T> T isRuleMatched(Object contextObject, String condition, Class<T> resultType) {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(condition);
        return expression.getValue(contextObject, resultType);
    }
}
