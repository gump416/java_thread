package ezen.thread;

import java.util.Iterator;
import java.util.Random;

/**
 * 경주마
 * 
 * @author 송진호
 * @Date 2023. 1. 25.
 */
public class Horse extends Thread {
	// String name;

	public Horse() {
	}

	public Horse(String name) {
		super(name);
	}

	// 사용자 정의 스레드의 엔트리 포인트(실행 진입점)
	@Override
	public void run() {
		Random random = new Random();
		System.out.println(getName() + " 말 스타트~~~~~~~~~");

		for (int i = 1; i < 101; i++) {
			System.out.println(getName() + " 말" + i + "미터 전진...");
			try {
				Thread.sleep(random.nextInt(100)); // 0~499까지의 임의의값. sleep는 예외처리해야함
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(getName() + " 말 결승점 통과~~~~~~~~~");
	}

}
