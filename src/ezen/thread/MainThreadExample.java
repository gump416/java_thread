package ezen.thread;

/**
 * JVM(Process)은 내부적으로 main이라는 이름의 스레드를 생성하고, main스레드는 main()메소드를 실행한다.
 * 
 * @author 송진호
 * @Date 2023. 1. 25.
 */
public class MainThreadExample {

	//main 스레드에 의해 최초 실행되는 엔트리포인트(실행진입점)
	public static void main(String[] args) { // 버추얼머신에의해서 자동생성되는 main스레드
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName() + "메인스레드에 의해 프로그램 시작됨.."); // 스레드는 하나의 실행단위로 생각하자
		int x = 10;

		for (int i = 0; i < 100; i++) {
			System.out.println(mainThread.getName() + " 스레드에서" + (i + 1) + " 출력");

			if (i == 50) {
				// 음악재생..
				System.out.println("음악재생~~");
				//사용자 정의 스레드 생성 및 실행
				MusicPlayer musicPlayer = new MusicPlayer();
//				musicPlayer.run(); //다이렉트로 호출불가(싱글스레드형식으로돌아감)
				musicPlayer.start(); // 동시에돌아감, 동시성프로그램, 멀티스레드, 스레드스케줄러를 호출해서 실행됨
			}
		}
		
		System.out.println("메인스레드 종료됨..");

	}

}
