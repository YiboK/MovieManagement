package Util;

/**
 * String tool class
 * @author 18223
 *
 */
public class StringUtil {

	/**
	 * judge if string is empty
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * judge if string is not empty
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (!(str == null || "".equals(str.trim()))) {
			return true;
		} else {
			return false;
		}
	}
}
