package view;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import global.Constants;
import valueObject.VAccount;

public class PStatusPanel extends JPanel {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private JFrame parent;

	private JLabel lbMiridamgiCredit;
	private JLabel lbSincheongCredit;

	public void setMiridamgiCredit(int credit) {
		this.lbMiridamgiCredit.setText("�̸� ��� ���� : " + credit);
	}

	public void setSincheongCredit(int credit) {
		this.lbSincheongCredit.setText("  ���� ��û ���� : " + credit);
	}

	public PStatusPanel(VAccount vAccount, JFrame frame, view.PMainFrame.ActionHandler actionHandler) {
		this.parent = frame;
		this.setBackground(Color.lightGray);

		// �̸���� ����
		File file = new File("account/" + vAccount.getId() + "Miridamgi");

		int miridamgiCredit = getCredit(file);

		this.lbMiridamgiCredit = new JLabel("�̸� ��� ���� : " + miridamgiCredit);
		this.add(lbMiridamgiCredit);

		// ������û ����
		file = new File("account/" + vAccount.getId() + "Sugangsincheong");

		int sugangsincheongCredit = getCredit(file);

		this.lbSincheongCredit = new JLabel("  ���� ��û ���� : " + sugangsincheongCredit);
		this.add(lbSincheongCredit);

	}

	public int getCredit(File file) {
		Scanner sc;
		int credit = 0;
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				for (int i = 0; i < 3; i++) {
					sc.next();
				}
				credit += Integer.parseInt(sc.next());
				sc.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return credit;
	}

}
