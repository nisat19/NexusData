package com.github.dkharrat.nexusdata.predicate.parser;

import com.github.dkharrat.nexusdata.predicate.ConstantExpression;
import com.github.dkharrat.nexusdata.predicate.Expression;

import static com.github.dkharrat.nexusdata.predicate.parser.PredicateParser.TokenType;

public class ConstantParselet implements PrefixParselet<TokenType,Expression<?>> {
    @Override
    public Expression<?> parse(Parser<TokenType,Expression<?>> parser, Token<TokenType> token) {

        String valueStr = token.getText();
        Object value;

        if (valueStr.equalsIgnoreCase("true")) {
            value = true;
        } else if (valueStr.equalsIgnoreCase("false")) {
            value = false;
        } else if (valueStr.equalsIgnoreCase("null")) {
            value = null;
        } else if (valueStr.startsWith("\"")) {
            value = valueStr.substring(1,valueStr.length()-1);   // remove quotes from string
        } else {
            value = Integer.parseInt(valueStr);
        }

        return new ConstantExpression(value);
    }
}
