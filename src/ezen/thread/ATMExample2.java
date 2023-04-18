package ezen.thread;

public class ATMExample2 {

	public static void main(String[] args) {
		ATM atm = new ATM(); // notify는 Atm(Object)이가지고 있다. 락을쥐고있음..

		Thread thread1 = new Thread("아빠(스레드)") {
			@Override
			public void run() {
				synchronized (atm) {
					atm.notify();
					while (true) { // 이해를돕기위해 while문씀,동기화의 단점,아들은 돈 못 뽑음
						atm.withdrawMoney("1111-2222", 1111, 10000, "아빠(사용자)");
						try {
							atm.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};

		Thread thread2 = new Thread("아들(스레드)") {
			@Override
			public void run() {
				synchronized (atm) {
					atm.notify();
					while (true) { //쓰레기코드..이해를돕기위해 씀
						atm.withdrawMoney("1111-2222", 1111, 10000, "아들(사용자)");
						try {
							atm.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		thread1.start();
		thread2.start();

	}

}
