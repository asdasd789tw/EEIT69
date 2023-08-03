package tw.org.iii.yuan;

public class Yuan99 {

	public static void main(String[] args) {
//		for(int i=1;i<10;i++) {
//			for(int j=1;j<10;j++) {
//				System.out.printf("%d * %d = %d\n",i,j,i*j);
//			}
//		}
		final int START = 2 ;
		final int ROWS = 2 ;
		final int COLS = 4 ;
		for (int k = 0; k < ROWS ; k++) {
			for (int j = 1; j < 10; j++) {
				for (int i = START; i < (START+COLS); i++) {
					int newi = i + k * COLS;
					System.out.printf("%d * %d = %d\t", newi, j, newi * j);
				}
				System.out.println();
			}
			System.out.println("--------------");

		}
	}
}
