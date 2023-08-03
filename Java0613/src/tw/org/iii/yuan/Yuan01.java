package tw.org.iii.yuan;

public class Yuan01 {
	/*
	 * Brad01 OK
	 */
	public static void main(String[] args) {
		byte var1;
		var1 = 123;
		System.out.println(var1);
		byte var2 = -128; //輸入128時 Type mismatch : cannot convert from int to byte
		System.out.println(var2);//未定義var2時 The local variable var2 may not have been initialized
		short var3 = 32767;//命名規則 首字[a-zA-Z$_]第二字以後[a-zA-Z0-9$_]
		System.out.println(var3);
	}

}
