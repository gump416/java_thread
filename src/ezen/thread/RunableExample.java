package ezen.thread;

import java.awt.Dimension;
import java.awt.Toolkit;

public class RunableExample {

	public static void main(String[] args) {
		System.out.println("메인스레드 실행됨..");
		
		SomeTask task = new SomeTask(); //가장많이쓰는방법, 독립적으로실행하는 Runnable을 구현한 클래스를 만들고
		Thread thread = new Thread(task); // Thread를 불러서 결합,start는 Thread에만 있기 때문
//		Thread thread = new Thread(new SomeTask()); 
		
		thread.start();
		
		//익명객체 활용(이벤트처리처럼..)
		Thread thread2 =  new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit(); //Calendar.getInstance();처럼 생성되있는거 호출
				Dimension dim = toolkit.getScreenSize(); //각 모니터의 화면사이즈(폭, 높이) 내용 가져와서 동적으로 설정, 중요!!
				for (int i = 0; i < 10; i++) {
					toolkit.beep(); //잘몰눌렀을때 삐삐삐.. 소리울리게 하는 메소드, 재미로..중요 X
				}
			}
		});
		thread2.start();
		
		System.out.println("메인스레드 종료됨..");
		
		
	}

}
