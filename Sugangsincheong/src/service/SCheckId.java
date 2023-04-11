package service;

import entity.EAccount;
import valueObject.VAccount;

public class SCheckId {
	private EAccount eAccount;

	public SCheckId() {
		this.eAccount = new EAccount();
	}

	public VAccount checkId(String id) {
		VAccount vAccount = this.eAccount.getAccount(id);
		return vAccount;
	}

}
