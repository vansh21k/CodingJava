package com.vansh.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenParanethesis {
	public static void main(String[] args) {
		GenParanethesis test = new GenParanethesis();
		test.generateParenthesis(3);
	}
	public List<String> generateParenthesis(int n) {
		Set<String> toReturn = generateParenthesisHelper(n);
        List<String> set = new ArrayList<>();
        set.addAll(toReturn);
        return set;		
    }

	private Set<String> generateParenthesisHelper(int n) {
		Set<String> toReturn = new HashSet<>();
		if (n == 0) {
        		return toReturn;
        } else if (n == 1) {
        		toReturn.add("()");
        		return toReturn;
        }
		Set<String> temp = generateParenthesisHelper(n-1);
		// generate all possible paranethisation
		for (String each: temp) {
			toReturn.add("()" + each);
			for (int i = 0 ; i < each.length(); ++i) {
				toReturn.add(generateThisParanthesis(each,i));
			}
		}
		return toReturn;
	}

	private String generateThisParanthesis(String str, int i) {
		String before = str.substring(0, i);
		String after = str.substring(i);
		return before + "()" + after;
	}
}
