package tw.org.iii.yuan;

public class Yuan02 {
	public static void main(String[] args) {
		byte var1 = 12;
		byte var2 = 13;
		byte var22 = (byte)(var1 + var2) ;//Type mismatch : cannot convert from int to byte
		System.out.println(var22);
		//byte var21 = var1 + 1 ;//Type mismatch : cannot convert from int to byte
		//運算後會將值放入int,便無法放入byte中
		int var5 = 50;
		long var6 = 90;
		long var7=var5+var6;
		System.out.println(var7);
		byte a = 127 ;
		//a += 1;//+= 是自己本身在進行位元運算，並沒有運算完之後放入int之中
		a++;
		System.out.println(a);
	}
}
