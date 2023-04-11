package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VAccount;

public class EAccount {
	private String Id;
	private String password;
	private String name;
	private String birthFront;
	private String birthBack;
	private String mail;

	public EAccount() {
	}

	private boolean read(String id, String password) { // 로그인 사용
		boolean found = false;
		try {
			File file = new File("account/account");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext() && !found) {
				this.Id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();
				this.birthFront = scanner.next();
				this.birthBack = scanner.next();
				this.mail = scanner.next();

				if (this.Id.compareTo(id) == 0 && this.password.compareTo(password) == 0) {
					found = true;
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	private boolean read(String name, String birthFront, String birthBack, String mail) {
		boolean found = false;
		try {
			File file = new File("account/account");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext() && !found) {
				this.Id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();
				this.birthFront = scanner.next();
				this.birthBack = scanner.next();
				this.mail = scanner.next();

				if (this.name.compareTo(name) == 0 && this.birthFront.compareTo(birthFront) == 0
						&& this.birthBack.compareTo(birthBack) == 0 && this.mail.compareTo(mail) == 0) {
					found = true;
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	private boolean read(String id, String name, String birthFront, String birthBack, String mail) {
		boolean found = false;
		try {
			File file = new File("account/account");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext() && !found) {
				this.Id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();
				this.birthFront = scanner.next();
				this.birthBack = scanner.next();
				this.mail = scanner.next();

				if (this.Id.compareTo(id) == 0 && this.name.compareTo(name) == 0
						&& this.birthFront.compareTo(birthFront) == 0 && this.birthBack.compareTo(birthBack) == 0
						&& this.mail.compareTo(mail) == 0) {
					found = true;
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	private boolean read(String id) { // 아이디 중복 확인
		boolean found = true;
		try {
			File file = new File("account/id");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext() && found) {
				this.Id = scanner.next();
				if (this.Id.compareTo(id) == 0) {
					found = false; // 중복이면 false 반환
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return found;

	}

	public VAccount getAccount(String id, String password) { // 로그인 사용
		VAccount vAccount = null;
		// file read
		boolean found = this.read(id, password);
		if (found) {
			vAccount = new VAccount();
			vAccount.setId(this.Id);
			vAccount.setPassword(this.password);
			vAccount.setName(this.name);
			vAccount.setBirthFront(this.birthFront);
			vAccount.setBirthBack(this.birthBack);
			vAccount.setMail(this.mail);
		}

		return vAccount;
	}

	public VAccount getAccount(String name, String birthFront, String birthBack, String mail) {
		VAccount vAccount = null;
		// file read
		boolean found = this.read(name, birthFront, birthBack, mail);
		if (found) {
			vAccount = new VAccount();
			vAccount.setId(this.Id);
			vAccount.setPassword(this.password);
			vAccount.setName(this.name);
			vAccount.setBirthFront(this.birthFront);
			vAccount.setBirthBack(this.birthBack);
			vAccount.setMail(this.mail);
		}

		return vAccount;
	}

	public VAccount getAccount(String id, String name, String birthFront, String birthBack, String mail) {
		VAccount vAccount = null;
		// file read
		boolean found = this.read(id, name, birthFront, birthBack, mail);
		if (found) {
			vAccount = new VAccount();
			vAccount.setId(this.Id);
			vAccount.setPassword(this.password);
			vAccount.setName(this.name);
			vAccount.setBirthFront(this.birthFront);
			vAccount.setBirthBack(this.birthBack);
			vAccount.setMail(this.mail);
		}

		return vAccount;
	}

	public VAccount getAccount(String id) { // 아이디 중복 확인
		VAccount vAccount = null;
		// file read
		boolean found = this.read(id);
		if (found) { // 중복이면 false / null
			vAccount = new VAccount();
			vAccount.setId(this.Id);
		}
		return vAccount;
	}

}
