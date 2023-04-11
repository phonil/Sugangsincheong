package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

import global.Constants;
import service.SLecture;
import valueObject.VAccount;
import valueObject.VLecture;
import viewSugangsincheong.PSugangsincheongPanel;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private PSugangsincheongPanel sugangsincheongPanel;
	private PAccountPanel accountPanel;
	private PStatusPanel statusPanel;

	private VAccount vAccount;

	private Vector<VLecture> vecSugangsincheong; // ������û ���� ���� ����
	private Vector<VLecture> vecMiridamgi; // �̸���� ���� ���� ����

	private SLecture sLecture;

	public void setVAccount(VAccount vAccount) {
		this.vAccount = vAccount;
	}

	public PMainFrame(VAccount vAccount) {
		// attribute
		ActionHandler actionHandler = new ActionHandler();
		this.setSize(Constants.CMainFrame.WIDTH, Constants.CMainFrame.HEIGHT);

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// component
		this.sLecture = new SLecture();

		this.vAccount = vAccount;
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);

		// �̸���� ���� �б� - �ҷ����� ����
		this.vecMiridamgi = sLecture.getLectures("account/" + this.vAccount.getId() + "Miridamgi", 1);
		// ������û ���� �б� - �ҷ����� ����
		this.vecSugangsincheong = sLecture.getLectures("account/" + this.vAccount.getId() + "Sugangsincheong", 1);

		// ��ܿ� �̸� ���� ����
		this.accountPanel = new PAccountPanel(this.vAccount, this, actionHandler);
		this.add(this.accountPanel, BorderLayout.NORTH);

		// �ϴ� ���� ����
		this.statusPanel = new PStatusPanel(this.vAccount, this, actionHandler);
		this.add(this.statusPanel, BorderLayout.SOUTH);

		// ������ ��� ���� / ��� �г��� ���� ��� �� ���� ū �г�
		this.sugangsincheongPanel = new PSugangsincheongPanel();
		this.add(this.sugangsincheongPanel, BorderLayout.CENTER);

		// �̸���� ����� ���� ���̺� �ֱ�
		for (int i = 0; i < vecMiridamgi.size(); i++) {
			sugangsincheongPanel.getMiridamgiPanel().setData(vecMiridamgi.get(i)); // �̸���� ���� �Ϸ�...
		}
		// ������û ����� ���� ���̺� �ֱ�
		for (int i = 0; i < vecSugangsincheong.size(); i++) {
			sugangsincheongPanel.getSincheongPanel().setData(vecSugangsincheong.get(i)); // �̸���� ����Ϸ�...
		}

	}

	public void initialize() {
		this.setVisible(true);

	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			if (bt.getText().equals("����")) { // ���Ͽ� ���� ����

				vecMiridamgi = sugangsincheongPanel.getMiridamgiPanel().getVLectures();
				vecSugangsincheong = sugangsincheongPanel.getSincheongPanel().getVLectures();

				try {
					// �̸����
					FileWriter fw = new FileWriter("account/" + vAccount.getId() + "Miridamgi", false); // �� ������ ��� �����״�
																										// �����

					// �̸���� ��� ä���ֱ�
					for (int i = 0; i < vecMiridamgi.size(); i++) {
						fw.write(vecMiridamgi.get(i).getId() + " " + vecMiridamgi.get(i).getName() + " "
								+ vecMiridamgi.get(i).getProfessor() + " " + vecMiridamgi.get(i).getCredit() + " "
								+ vecMiridamgi.get(i).getTime());
						fw.write("\n");
					}
					fw.close(); // �� �ݾ���� ��

					// ������û
					fw = new FileWriter("account/" + vAccount.getId() + "Sugangsincheong", false);

					for (int j = 0; j < vecSugangsincheong.size(); j++) {
						fw.write(vecSugangsincheong.get(j).getId() + " " + vecSugangsincheong.get(j).getName() + " "
								+ vecSugangsincheong.get(j).getProfessor() + " " + vecSugangsincheong.get(j).getCredit()
								+ " " + vecSugangsincheong.get(j).getTime());
						fw.write("\n");
					}
					fw.close();

					// ���� �� �ٷ� status ���� ����

					// �̸���� ����
					File file = new File("account/" + vAccount.getId() + "Miridamgi");
					int miridamgiCredit = statusPanel.getCredit(file);
					statusPanel.setMiridamgiCredit(miridamgiCredit);

					// ������û ����
					file = new File("account/" + vAccount.getId() + "Sugangsincheong");
					int sugangsincheongCredit = statusPanel.getCredit(file);
					statusPanel.setSincheongCredit(sugangsincheongCredit);

				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}
	}

}
