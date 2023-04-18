package ezen.thread;

import java.util.Iterator;

/**
 * 메인스레드(cpu)와 별개로 동작하는 음악재생 스레드(cpu)
 * @author 송진호
 * @Date	2023. 1. 25.
 */
public class MusicPlayer extends Thread{
	//String name; //name이라는 속성이 기본적으로 제공됨, setName()으로 변경가능. 설정안하면 자동이름부여받음.
	
	public MusicPlayer() {} //null로 초기화되는게 아니라 스레드는 Thread-0 이런식으로 번호로 이름이 부여되있음.
	
	public MusicPlayer(String name) {
		super(name);
	}
	
	
	//사용자 정의 스레드의 엔트리 포인트(실행 진입점)
	@Override
	public void run() { //스레드의 main임. 즉 스레드의 엔트리포인트 실행은  start()메소드로..
		Thread thread = Thread.currentThread();
		//음악재생 코드...
		for (int i = 0; i < 50; i++) {
			System.out.println(thread.getName() + " : 음악재생 : " + (i+1));
		}
	}
//	스레드 스케줄러 실행
//	start(){} //안보이지만 정의되어있음.
	
}
