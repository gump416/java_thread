package ezen.thread;

import ezen.ams.Account; //패키지가 달라서 빌드패스로 경로잡아줌
import ezen.ams.NotSufficientBalanceException;

public class ATM {
	/** 테스트를 위한 공유 계좌 */
	Account account = new Account("1111-2222", "방그리가족통장", 1111, 100000);

	/** 입금 */
	public void depositMoney(String accountNum, int passwd, long money, String user) throws RuntimeException {
		System.out.println("***** " + user + " 입금 시작 *****");
// 본점 서버와의 통신에 약간의 시간이 소요된다 가정..
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.deposit(money);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(user + " 입금 후 잔액 : " + account.getRestMoney());
		System.out.println("***** " + user + " 입금 완료 *****");
	}

	/** 출금 */
	public /*synchronized*/ void withdrawMoney(String accountNum, int passwd, long money, String user)
			throws RuntimeException {
		System.out.println("***** " + user + " 출금 시작 *****");
		if (money > account.getRestMoney()) {
			throw new RuntimeException("-> 잔액이 부족합니다.");
		}
// 본점 서버와의 통신에 약간의 시간이 소요된다 가정..
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {

			// 실행 대기 상태에 있는 다른 쓰레드가 WithdrawMoney()를 사용할 수 있도록 notify() 메소드 호출
//			this.notify();	//스레드의 메소드가 아닌 (Object)화장실에 메소드 쓰는것(복습하면서다시이해)
//			notify(); //notifyAll()은 여러쓰레드들 모두 대기중에 올림, this 써도 그만 안써도 그만
			account.withdraw(money);
			// 1000원 씩 공평하게 출금할 수 있도록 현재 스레드 일시정지
//			this.wait();
//			wait();
		} catch (NotSufficientBalanceException e) { //withdraw 예외처리
			e.printStackTrace();
		} //catch (InterruptedException e) { //wait 예외처리
//			e.printStackTrace();
//		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("->" + user + " 출금 후 잔액 : " + account.getRestMoney());
		System.out.println("***** " + user + " 출금 완료 *****");
	}
}