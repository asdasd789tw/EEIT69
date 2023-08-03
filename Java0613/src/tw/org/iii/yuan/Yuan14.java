package tw.org.iii.yuan;

public class Yuan14 {

	public static void main(String[] args) {
		int[] a;
		a = new int[3]; // new在JAVA代表物件
		boolean[] b = new boolean[4];// JAVA的陣列給定型別、長度就不能更動了，且內容已給定初始值
		byte[] c = new byte[3];
		short[] d = new short[4];
		long[] e = new long[4];
		float[] f = new float[4];
		double[] g = new double[4];
		char[] h = new char[4];
		System.out.println(a.length);
		System.out.println(b.length);
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		System.out.println(b[3]);
		System.out.println("----");
		System.out.println(c[0]);
		System.out.println("----");
		System.out.println(d[0]);
		System.out.println("----");
		System.out.println(f[0]);
		System.out.println("----");
		System.out.println(g[0]);
		System.out.println("----");
		System.out.println(h[0]);
		System.out.println("----");
		System.out.println(e[0]);
		System.out.println("----");
		a[0]=20;
		a[1]=30;
		a[2]=40;				
		for(int i = 0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		System.out.println("----");
		for(int v:a) {
			System.out.println(v);
		}//for-each
				
	}

}
