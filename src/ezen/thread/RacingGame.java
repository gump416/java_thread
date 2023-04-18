package ezen.thread;

public class RacingGame {

	public static void main(String[] args) {
		System.out.println("지금부터 경주마 게임을 시작합니다...");
		System.out.println("경주마 준비");
		Horse horse1 = new Horse("재훈마");
		Horse horse2 = new Horse("대한마");
		Horse horse3 = new Horse("정석마");
		Horse horse4 = new Horse("찬울마");
		
		System.out.println("땅~~~~~~~~"); //보기에는 horse1이 먼저시작되고 먼저끝날거같지만 동시실행
		//(아무래도 첫번째가 cpu에 먼저 할당받을 확률 높긴함)
		horse1.start();
		horse2.start();
		horse3.start();
		horse4.start();
		
		//메인스레드는 다른 스레드가 종료될때까지 일시 정지
		try {
			horse1.join();
			horse2.join();
			horse3.join();
			horse4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("지금부터 경주마 게임을 종료합니다...");
	}

}
