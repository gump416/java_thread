package ezen.thread;

import java.util.Iterator;

public class SomeTask implements Runnable { //쓰레드가 독립적으로 실행되려면 반드시 Runnable구현, run()메소드만 있음
//	String name; //Thread를 상속받은게아니라 이름없음
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " : "+ i);
		}
	}
}
