package ezen.thread;

class SomeThread extends Thread {
	private boolean running;
	
	public SomeThread() {
		this(true);
	}
	
	public SomeThread(boolean running) {
		this.running = running;
	}

	public boolean isRunning() { // boolean 타입은 get아니라 is임
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		while (running) {
			System.out.println("음악재생");
		}
		if(!running)
		System.out.println("스레드에서 사용중이던 리소스 해제");
		
	}

}

public class ThreadStopExample {

	public static void main(String[] args) {
		System.out.println("메인스레드 실행");
		SomeThread thread = new SomeThread();
		thread.start();

		// 스레드 종료
//		thread.stop(); //강제종료라서 악영향..안씀, 강제종료시키는 메소드 없다고생각하기

		thread.setRunning(false);

		System.out.println("메인스레드 종료");
	}

}
