package ezen.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		List<String> list = new Vector<>(); //2000개가 저장됨. add()가 synchronized 처리되있기때문.
//		List<String> list = new ArrayList<>(); //저장값이 들쭉날쭉, 비동기라서..동시에저장해서 문제생긴것.

		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					list.add("이름 " + i);
				}
			}
		};

		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					list.add("이름 " + i);
				}
			}
		};

		threadA.start();
		threadB.start();

		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int size = list.size();
		System.out.println("저장된 총 객체 수 : " + size);
	}

}
