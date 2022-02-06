package com.greatlearning.assignement3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class skycraper {

	static Queue<Day> queueone = new LinkedList<>();
	static Queue<Day> tempqueue = new LinkedList<>();

	// Method Started to generate queue
	static void GenerateQueue(int days) {
		Day temp = null;

		for (int j = 1; j <= days; j++) {
			System.out.println("\nDay : " + j);
			while (!queueone.isEmpty()) {
				temp = queueone.peek();
				if (temp.day <= j) {
					System.out.print(temp.size + " ");
					queueone.poll();
				}

				else {
					break;
				}
			}
		}
	}

	// Method to insert in queue
	static void InsertQueue(Day d) {
		if (queueone.isEmpty())
			queueone.add(d);
		else {
			allTotempqueueone();
			Day d1;

			while (!tempqueue.isEmpty()) {
				d1 = tempqueue.peek();
				if (d1.size > d.size)
					queueone.add(tempqueue.poll());
				else {
					queueone.add(d);
					allToqueueone();
					d = null;
				}
			}

			if (d != null)
				queueone.add(d);
		}

	}

	// Method to copy all elements to temporary queue
	static void allToqueueone() {
		while (!tempqueue.isEmpty())
			queueone.add(tempqueue.poll());

	}

	// Method to copy all elements to temporary queue
	static void allTotempqueueone() {
		while (!queueone.isEmpty())
			tempqueue.add(queueone.poll());

	}

	// Created subclass for instance creation
	static class Day {
		int size;
		int day;

		Day(int s, int d) {
			size = s;
			day = d;
		}
	}

	// Main Method
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Day daily;

		System.out.println("Please Enter Number of Days : ");
		int days = sc.nextInt();
		int floorNum;

		for (int i = 1; i <= days; i++) {
			System.out.println("Please Enter Floor Size on Day : " + i);
			floorNum = sc.nextInt();
			daily = new Day(floorNum, i);
			InsertQueue(daily);
		}
		GenerateQueue(days);
		sc.close();
	}

}
