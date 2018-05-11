package cn.tedu.note.controller;

import java.util.Random;

public class Demo {
	private static final int BEGIN = 1333;
	private static final long END = 1421;
	public static void main(String[] args) {
		String[] num = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",};
		Random random = new Random();
		int i = random.nextInt(27);

		char first = '位';
		int firstE = 23;
		for (int j = BEGIN; j < END; j++) {
			System.out.println((char)j+"******"+j);
		}
	}

	public static void printEnglish() {
		int firstEnglish, lastEnglish;
		char firstE = 'A', lastE = 'Z';
		//region
		//获取首字母与末字母的值
		//endregion

		firstEnglish = (int) firstE;
		lastEnglish = (int) lastE;

		System.out.println("英文字母表： ");
		for (int i = firstEnglish; i <= lastEnglish; ++i) {
			char uppercase, lowercase;
			uppercase = (char) i;
			lowercase = (char) (i + 32);

			System.out.print("\"" + uppercase + "\"" + ",");
		}

		System.out.println();
	}

}
