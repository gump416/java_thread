package ezen.thread;

public class AutoSaveExample {

	public static void main(String[] args) {
		System.out.println("아래한글 시작됨..");
		Thread autoSaver = new Thread(new AutoSaveThread());
		//데몬스레드로 설정, 데몬설정주석하면 무한로프 도는것을 확인할수있음
		autoSaver.setDaemon(true);
		autoSaver.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("아래한글 종료됨..");
	}

}
