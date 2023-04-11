package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import valueObject.VAccount;

public class Main {
	private PLoginDialog loginDialog;
	private PFindDialog findDialog;
	private PSignUpDialog pSignUpDialog;

	private int count;

	public Main() {

	}

	public void initialize() {
		ActionHandler actionHandler = new ActionHandler();

		loginDialog = new PLoginDialog(actionHandler);
		findDialog = new PFindDialog(loginDialog, actionHandler);
		pSignUpDialog = new PSignUpDialog(loginDialog, actionHandler);

		count = 0;

		loginDialog.setVisible(true);

	}

	public void run() {
		login();

	}

	public void finish() {

	}

	void login() {
		// �α���
		String id = this.loginDialog.getTfId().getText();
		String password = this.loginDialog.getTfPassword().getText();
		VAccount vAccount = this.loginDialog.getSLogin().login(id, password);
		try {
			PMainFrame mainFrame = new PMainFrame(vAccount);
			if (vAccount != null) {
				this.loginDialog.dispose();
				mainFrame.setVisible(true);
			}
		} catch (NullPointerException e) {
			count++;
			if (count == 5) {
				JOptionPane.showMessageDialog(this.loginDialog, "5ȸ Ʋ�Ƚ��ϴ�. ����˴ϴ�.", "Message",
						JOptionPane.ERROR_MESSAGE);
				this.loginDialog.dispose();
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(this.loginDialog, "���̵� Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�. \n" + (5 - count) + "ȸ ���ҽ��ϴ�.",
						"Message", JOptionPane.PLAIN_MESSAGE);
			}

		}
	}

	void findId() {
		// ���̵� ã��
		String name = this.findDialog.getTfName().getText();
		String birthFront = this.findDialog.getTfBirthFront().getText();
		String birthBack = this.findDialog.getTfBirthBack().getText();
		String mail = this.findDialog.getTfEmail().getText();
		VAccount vAccount = this.findDialog.getSFindId().findId(name, birthFront, birthBack, mail);

		try {
			JOptionPane.showMessageDialog(this.findDialog, name + "���� ���̵�� " + vAccount.getId() + "�Դϴ�.", "Message",
					JOptionPane.PLAIN_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this.findDialog, "�Էµ� ������ �߸��Ǿ����ϴ�.", "Message", JOptionPane.PLAIN_MESSAGE);
		}
	}

	void findPw() {
		// ��й�ȣ ã��
		String name = this.findDialog.getTfName2().getText();
		String birthFront = this.findDialog.getTfBirthFront2().getText();
		String birthBack = this.findDialog.getTfBirthBack2().getText();
		String mail = this.findDialog.getTfEmail2().getText();
		String id = this.findDialog.getTfId().getText();
		VAccount vAccount = this.findDialog.getSFindPw().findPw(id, name, birthFront, birthBack, mail);

		try {
			JOptionPane.showMessageDialog(this.findDialog, name + "���� ��й�ȣ�� " + vAccount.getPassword() + "�Դϴ�.",
					"Message", JOptionPane.PLAIN_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this.findDialog, "�Էµ� ������ �߸��Ǿ����ϴ�.", "Message", JOptionPane.PLAIN_MESSAGE);
		}
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			if (bt.getText().equals("�α���")) { // �α��� ��ư �̺�Ʈ
				run();

			} else if (bt.getText().equals("��й�ȣ ã��")) { // ��й�ȣ ã�� ��ư �̺�Ʈ
				findDialog.setVisible(true);

			} else if (bt.getText().equals("ȸ������")) {
				pSignUpDialog.setVisible(true);

			} else if (bt.getText().equals("����")) { // ���� ��ư �̺�Ʈ
				System.exit(0);

			} else if (bt.getText().equals("���ư���")) {
				pSignUpDialog.dispose();
				findDialog.dispose();

			} else if (bt.getText().equals("���̵� ��ȸ")) {
				findId();

			} else if (bt.getText().equals("��й�ȣ ��ȸ")) {
				findPw();

			}

		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();

	}
}