package service;

import entity.EAccount;
import valueObject.VAccount;

public class SFindId {
	private EAccount eAccount;

	public SFindId() {
		this.eAccount = new EAccount();
	}

	public VAccount findId(String name, String birthFront, String birthBack, String mail) {
		VAccount vAccount = this.eAccount.getAccount(name, birthFront, birthBack, mail);
		return vAccount;
	}

}
