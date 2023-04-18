package ezen.thread;

/** 스레드 테스트를 위한 애플리케이션 클래스 */
public class ReserveExample {
	public static void main(String[] args) {
		
// 스레드에 의해 공유되는 객체 생성
		MovieReserveSystem reserveSystem = new MovieReserveSystem();
		
// 테스트를 위한 회원 스레드 생성 및 실행
		Member m1 = new Member("찬호", reserveSystem);
		Member m2 = new Member("지성", reserveSystem);
		Member m3 = new Member("승엽", reserveSystem);
		Member m4 = new Member("a", reserveSystem);
		Member m5 = new Member("b", reserveSystem);
		Member m6 = new Member("c", reserveSystem);
		Member m7 = new Member("d", reserveSystem);
		Member m8 = new Member("e", reserveSystem);
		Member m9 = new Member("f", reserveSystem);
		Member m10 = new Member("g", reserveSystem);
		Member m11 = new Member("h", reserveSystem);
		m1.start();
		m2.start();
		m3.start();
		m4.start();
		m5.start();
		m6.start();
		m7.start();
		m8.start();
		m9.start();
		m10.start();
		m11.start();
	}
}