package org.stathry.jdkdeep.util;

/**
 * TODO
 * @author dongdaiming
 * @date 2018年1月8日
 */
public class ArrayUtils {

	private ArrayUtils() {}
	
	public static byte[] joinBytes(byte[] a1, byte[] a2) {
		byte[] a = new byte[a1.length + a2.length]; 
		System.arraycopy(a1, 0, a, 0, a1.length);
		System.arraycopy(a2, 0, a, a1.length, a2.length);
		return a;
	}
	
}
