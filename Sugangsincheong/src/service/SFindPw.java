package service;

import entity.EAccount;
import valueObject.VAccount;

public class SFindPw {
	private EAccount eAccount;

	public SFindPw() {
		this.eAccount = new EAccount();
	}

	public VAccount findPw(String id, String name, String birthFront, String birthBack, String mail) {
		VAccount vAccount = this.eAccount.getAccount(id, name, birthFront, birthBack, mail);
		return vAccount;
	}

}
