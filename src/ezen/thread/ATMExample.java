package ezen.thread;

public class ATMExample {

	public static void main(String[] args) {
		ATM atm = new ATM();
		
		Thread thread1 = new Thread("아빠(스레드)") {
			@Override
			public void run() {
				while(true) { //이해를돕기위해 while문씀,동기화의 단점,아들은 돈 못 뽑음
					atm.withdrawMoney("1111-2222",  1111, 10000, "아빠(사용자)");
				}
			}
		};
		
		Thread thread2 = new Thread("아들(스레드)") {
			@Override
			public void run() {
				while(true) {
					atm.withdrawMoney("1111-2222",  1111, 10000, "아들(사용자)");
				}
			}
		};
		thread1.start();
		thread2.start();
		
		}
		
	}


