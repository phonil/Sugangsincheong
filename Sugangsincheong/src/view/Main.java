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
		// 로그인
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
				JOptionPane.showMessageDialog(this.loginDialog, "5회 틀렸습니다. 종료됩니다.", "Message",
						JOptionPane.ERROR_MESSAGE);
				this.loginDialog.dispose();
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(this.loginDialog, "아이디 혹은 비밀번호가 틀렸습니다. \n" + (5 - count) + "회 남았습니다.",
						"Message", JOptionPane.PLAIN_MESSAGE);
			}

		}
	}

	void findId() {
		// 아이디 찾기
		String name = this.findDialog.getTfName().getText();
		String birthFront = this.findDialog.getTfBirthFront().getText();
		String birthBack = this.findDialog.getTfBirthBack().getText();
		String mail = this.findDialog.getTfEmail().getText();
		VAccount vAccount = this.findDialog.getSFindId().findId(name, birthFront, birthBack, mail);

		try {
			JOptionPane.showMessageDialog(this.findDialog, name + "님의 아이디는 " + vAccount.getId() + "입니다.", "Message",
					JOptionPane.PLAIN_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this.findDialog, "입력된 정보가 잘못되었습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
		}
	}

	void findPw() {
		// 비밀번호 찾기
		String name = this.findDialog.getTfName2().getText();
		String birthFront = this.findDialog.getTfBirthFront2().getText();
		String birthBack = this.findDialog.getTfBirthBack2().getText();
		String mail = this.findDialog.getTfEmail2().getText();
		String id = this.findDialog.getTfId().getText();
		VAccount vAccount = this.findDialog.getSFindPw().findPw(id, name, birthFront, birthBack, mail);

		try {
			JOptionPane.showMessageDialog(this.findDialog, name + "님의 비밀번호는 " + vAccount.getPassword() + "입니다.",
					"Message", JOptionPane.PLAIN_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this.findDialog, "입력된 정보가 잘못되었습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
		}
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			if (bt.getText().equals("로그인")) { // 로그인 버튼 이벤트
				run();

			} else if (bt.getText().equals("비밀번호 찾기")) { // 비밀번호 찾기 버튼 이벤트
				findDialog.setVisible(true);

			} else if (bt.getText().equals("회원가입")) {
				pSignUpDialog.setVisible(true);

			} else if (bt.getText().equals("종료")) { // 종료 버튼 이벤트
				System.exit(0);

			} else if (bt.getText().equals("돌아가기")) {
				pSignUpDialog.dispose();
				findDialog.dispose();

			} else if (bt.getText().equals("아이디 조회")) {
				findId();

			} else if (bt.getText().equals("비밀번호 조회")) {
				findPw();

			}

		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();

	}
}