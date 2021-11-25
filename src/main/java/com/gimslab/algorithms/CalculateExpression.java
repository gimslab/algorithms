package com.gimslab.algorithms;

import java.util.Arrays;
import java.util.StringTokenizer;

public class CalculateExpression {

	private int calculate(String exprParam) {
		System.out.println(exprParam);
		String expr = exprParam.replaceAll(" ", "");
		expr = expr.replaceAll("-", "+-");
		String[] tokens = expr.split("\\+");
		int sum = 0;
		for (String token : tokens) {
			if (!token.isEmpty())
				sum += Integer.parseInt(token);
		}
		return sum;
	}

	public static void main(String[] args) {
		CalculateExpression c = new CalculateExpression();
		System.out.println(c.calculate("1 +2-3+5"));
		System.out.println(c.calculate("-2+5 - 3"));
		System.out.println(c.calculate("-2+5*3")); // 13 // TODO
	}
}
