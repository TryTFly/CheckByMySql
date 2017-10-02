package com.y.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

		/**
		 * È¥³ý"\\s*|\t|\r|\n"
		 * @param str
		 * @return
		 */
		public String replace(String str) {
			String dest = "";
			if (str!=null) {
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(str);
				dest = m.replaceAll("\n");
			}
			return dest;
		}
	
}
