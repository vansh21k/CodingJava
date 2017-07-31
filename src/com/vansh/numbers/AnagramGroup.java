package com.vansh.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGroup {
	public static void main(String[] args) {
		AnagramGroup t = new AnagramGroup();
		t.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
	}
	
	String getKey(String val) {
		char[] charArray = val.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> anagramGroups = new ArrayList<>();
		HashMap<String, List<String>> anagramMap = new HashMap<>();
		for (String each: strs) {
			String temp = getKey(each);
			if (!anagramMap.containsKey(temp)){
				anagramMap.put(temp, new ArrayList<>());
			}
			List<String> tempList = anagramMap.get(temp);
			tempList.add(each);
		}
		for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
			anagramGroups.add(entry.getValue());
		}
		return anagramGroups;
	}
}
