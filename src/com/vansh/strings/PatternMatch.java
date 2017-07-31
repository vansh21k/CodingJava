package com.vansh.strings;

public class PatternMatch {
	
	public static void main(String[] args) {
		System.out.println(strStr("a", "a"));
	}
	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0 && haystack.length() ==0) {
			return 0;
		} else if (needle.length() == 0 && haystack.length() != 0) {
			return 0;
		} else if (haystack.length() == 0 && needle.length()!=0){
            return -1;
        }
		
		for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				// match the whole string and return i
				int k;
				for (k = 0; k < needle.length(); ++k) {
					if (!(k + i < haystack.length() && haystack.charAt(i + k) == needle.charAt(k))) {
						break;
					}
				}
				if (k == needle.length()) {
					return i;
				}

			}
		}
		return -1;
	}


}
