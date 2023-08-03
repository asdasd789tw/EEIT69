package tw.org.iii.yuan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Yuan52 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/rx.csv");
			BufferedReader breader = new BufferedReader(reader);
			String line,line1;
			while ((line = breader.readLine()) != null) {
				try {
					String[] row = line.split(",");
					String[] row1 = row[10].split("、");
//					System.out.println(row1[1]);
					if(row1[1].equals("星期二上午看診")) {
						System.out.printf("%s,%s\n",row[1],row[3]);
					}
//					line1=row[10].substring(8,15);
//					System.out.println(line1);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("test");
				}

				
			}
			reader.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}


	}

}
