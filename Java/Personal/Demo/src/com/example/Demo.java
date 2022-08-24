package com.example;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.io.File;
import java.util.*;

import static java.lang.System.out;

public class Demo {
	private static Scanner keyboard = new Scanner(System.in);
	private static int[][] mat ={
			{0, 1, 2, 3},
			{4,	5, 6, 7},
			{8,	9, 10, 11},
			{12, 13, 14, 15}
	};

	public static void main(String[] args) throws Exception {
		Integer val = 10;

		int result1 = timesTwo(val);

		Integer result2 = result1;

		System.out.print(result2);
	}

	public static int timesTwo (int n)
	{

		return n * 2;

	}

	public static int hailstoneLength(int n)
	{
		if (n == 1) {
			return 1;
		}
		if (n % 2 == 0) {
			return hailstoneLength(n / 2) + 1;
		} else {
			return hailstoneLength((3*n) + 1) + 1;
		}
	}

	public static boolean isLongSeq(int n)
	{
		return hailstoneLength(n) > n;
	}

	public static double propLong(int n) {
		double count = 0;
		for (int i = 1; i <= n; i ++) {
			if (isLongSeq(i)) {
				count++;
			}
		}
		return count / n;
	}
}

class GameSpinner {
	private int sectors;
	private int length;

	private ArrayList<Integer> runs = new ArrayList<>();

	public GameSpinner(int sectors) {
		this.sectors = sectors;
	}

	public int spin() {
		int run = (int) (Math.random() * 4) + 1;
		runs.add(run);
		return run;
	}

	public int currentRun() {
		int count = 0;
		if (!runs.isEmpty()) {
			if (runs.size() == 1) {
				count = 1;
			} else {
				for (int i = 1; i <= runs.size() - 1; i++) {
					if (runs.get(i - 1).equals(runs.get(i))) {
						length = i;
						count++;
					} else {
						count = 1;
					}
				}
			}
		}
		return count;
	}
}

class HiddenWord {
	private String hiddenWord;
	private String[] hiddenLetters;

	public HiddenWord(String newWord) {
		this.hiddenWord = newWord;
		this.hiddenLetters = hiddenWord.split("");
	}

	public String getHint(String guess) {
		String answer = "";
		String[] letters = guess.split("");
		String[] answers = new String[hiddenLetters.length];
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < hiddenLetters.length; j++) {
				if (letters[i].equals(hiddenLetters[j])) {
					if (i == j) {
						answers[i] = letters[i];
					} else {
						answers[i] = "+";
					}
				} else {
					if (answers[i] == null) {
						answers[i] = "*";
					}
				}
			}

		}

		for (String s : answers) {
			answer += s;
		}
		return answer;
	}
}
