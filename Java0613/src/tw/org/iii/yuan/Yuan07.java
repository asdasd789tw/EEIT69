package tw.org.iii.yuan;

import java.util.Scanner;

public class Yuan07 {

	public static void main(String[] args) {
		double temp = Math.random();
		int score = (int) (temp * 101); // 亂數產生0~100分的成績，101用於產生101個數字
		System.out.println(score);

		if (score >= 90) {
			System.out.printf("你的分數為%d，評價為A\n",score);
		} else if (score >= 80) {
			System.out.printf("你的分數為%d，評價為B\n",score);
		} else if (score >= 70) {
			System.out.printf("你的分數為%d，評價為C\n",score);
		} else if (score >= 60) {
			System.out.printf("你的分數為%d，評價為D\n",score);
		} else {
			System.out.printf("你的分數為%d，評價為E\n",score);
		}

		System.out.println("Game Over");// 判斷成績是否達到及格分數60分

	}

}
