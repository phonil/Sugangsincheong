package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.SFindId;
import service.SFindPw;

public class PFindDialog extends JDialog {

	private SFindId sFindId;
	private SFindPw sFindPw;

	private JPanel findFirstPanel;
	private FindSecondPanel findSecondPanel;
	private FindSecondPanel findThirdPanel;

	private JTextField tfName;
	private JTextField tfName2;

	private JTextField tfBirthFront;
	private JTextField tfBirthFront2;

	private JTextField tfBirthBack;
	private JTextField tfBirthBack2;

	private JTextField tfEmail;
	private JTextField tfEmail2;

	private JTextField tfId;

	public JTextField getTfName() {
		return this.tfName;
	}

	public JTextField getTfName2() {
		return this.tfName2;
	}

	public JTextField getTfBirthFront() {
		return this.tfBirthFront;
	}

	public JTextField getTfBirthFront2() {
		return this.tfBirthFront2;
	}

	public JTextField getTfBirthBack() {
		return this.tfBirthBack;
	}

	public JTextField getTfBirthBack2() {
		return this.tfBirthBack2;
	}

	public JTextField getTfEmail() {
		return this.tfEmail;
	}

	public JTextField getTfEmail2() {
		return this.tfEmail2;
	}

	public JTextField getTfId() {
		return this.tfId;
	}

	public SFindId getSFindId() {
		return this.sFindId;
	}

	public SFindPw getSFindPw() {
		return this.sFindPw;
	}

	//

	public PFindDialog(JDialog parentDialog, view.Main.ActionHandler actionHandler) {
		super(parentDialog, "find_ID/PW");

		this.setSize(440, 650);
		this.setModal(true); // ���

		LayoutManager layoutManager = new GridBagLayout();
		GridBagConstraints gridBagConstraint = new GridBagConstraints();

		ActionHandler actionHandler2 = new ActionHandler();

		// ���̾ƿ� ���� �г�
		JPanel basePanel = new JPanel();
		basePanel.setLayout(new BorderLayout());
		this.add(basePanel);

		// ù ��° �г�
		this.findFirstPanel = new JPanel();
		this.findFirstPanel.setBackground(Color.WHITE);
		basePanel.add(findFirstPanel, BorderLayout.NORTH);

		JLabel findLabel = new JLabel("���̵� / ��й�ȣ ã��");
		findLabel.setHorizontalAlignment(JLabel.LEFT);
		this.findFirstPanel.add(findLabel);

		JButton btBack = new JButton("���ư���");
		this.findFirstPanel.add(btBack);

		JButton btReset = new JButton("��� �����");
		this.findFirstPanel.add(btReset);

		// ��ü borderLayout, centerPanel�� Center, �� �ȿ� �г� ���η� �� ��(�ڽ�) �� �� �г��� ���̵� / �н�����

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		basePanel.add(centerPanel, BorderLayout.CENTER);

		// �� ��° �г� ( ���̵� ��ȸ )

		this.findSecondPanel = new FindSecondPanel();
		centerPanel.add(findSecondPanel);
		this.findSecondPanel.setLayout(layoutManager);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 0;

		JLabel lbFindId = new JLabel("���̵� ã��");
		this.findSecondPanel.add(lbFindId, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 1;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty1 = new JLabel(" ");
		this.findSecondPanel.add(lbEmpty1, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 2;
		gridBagConstraint.gridwidth = 1;

		JLabel lbName = new JLabel("�̸�");
		this.findSecondPanel.add(lbName, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 2;
		gridBagConstraint.gridwidth = 3;

		tfName = new JTextField();
		tfName.setColumns(15);
		this.findSecondPanel.add(tfName, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 3;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty2 = new JLabel(" ");
		this.findSecondPanel.add(lbEmpty2, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 4;
		gridBagConstraint.gridwidth = 1;

		JLabel lbBirth = new JLabel("�ֹι�ȣ");
		this.findSecondPanel.add(lbBirth, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 4;
		gridBagConstraint.gridwidth = 1;

		tfBirthFront = new JTextField();
		tfBirthFront.setColumns(6);
		this.findSecondPanel.add(tfBirthFront, gridBagConstraint);

		gridBagConstraint.gridx = 2;
		gridBagConstraint.gridy = 4;
		gridBagConstraint.gridwidth = 1;

		JLabel lbBar = new JLabel("   -  ");
		this.findSecondPanel.add(lbBar, gridBagConstraint);

		gridBagConstraint.gridx = 3;
		gridBagConstraint.gridy = 4;
		gridBagConstraint.gridwidth = 1;

		tfBirthBack = new JPasswordField();
		tfBirthBack.setColumns(6);
		this.findSecondPanel.add(tfBirthBack, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 5;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty3 = new JLabel(" ");
		this.findSecondPanel.add(lbEmpty3, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 6;
		gridBagConstraint.gridwidth = 1;

		JLabel lbEmail = new JLabel("�̸���");
		this.findSecondPanel.add(lbEmail, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 6;
		gridBagConstraint.gridwidth = 3;

		tfEmail = new JTextField();
		tfEmail.setColumns(15);
		this.findSecondPanel.add(tfEmail, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 7;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty4 = new JLabel(" ");
		this.findSecondPanel.add(lbEmpty4, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 8;
		gridBagConstraint.gridwidth = 3;

		JButton btCallId = new JButton("���̵� ��ȸ");
		btCallId.setBackground(Color.WHITE);
		this.findSecondPanel.add(btCallId, gridBagConstraint);

		// �� ��° �г� ( ��й�ȣ �缳�� )

		this.findThirdPanel = new FindSecondPanel();
		centerPanel.add(findThirdPanel);
		this.findThirdPanel.setLayout(layoutManager);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 0;

		JLabel lbFindPw = new JLabel("��й�ȣ ã��");
		this.findThirdPanel.add(lbFindPw, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 1;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty5 = new JLabel(" ");
		this.findThirdPanel.add(lbEmpty5, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 2;
		gridBagConstraint.gridwidth = 1;

		JLabel lbName2 = new JLabel("�̸�");
		this.findThirdPanel.add(lbName2, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 2;
		gridBagConstraint.gridwidth = 3;

		tfName2 = new JTextField();
		tfName2.setColumns(15);
		this.findThirdPanel.add(tfName2, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 3;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty6 = new JLabel(" ");
		this.findThirdPanel.add(lbEmpty6, gridBagConstraint);

		//

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 4;
		gridBagConstraint.gridwidth = 1;

		JLabel lbId = new JLabel("���̵�");
		this.findThirdPanel.add(lbId, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 4;
		gridBagConstraint.gridwidth = 3;

		tfId = new JTextField();
		tfId.setColumns(15);
		this.findThirdPanel.add(tfId, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 5;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty9 = new JLabel(" ");
		this.findThirdPanel.add(lbEmpty9, gridBagConstraint);

		//

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 6;
		gridBagConstraint.gridwidth = 1;

		JLabel lbBirth2 = new JLabel("�ֹι�ȣ");
		this.findThirdPanel.add(lbBirth2, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 6;
		gridBagConstraint.gridwidth = 1;

		tfBirthFront2 = new JTextField();
		tfBirthFront2.setColumns(6);
		this.findThirdPanel.add(tfBirthFront2, gridBagConstraint);

		gridBagConstraint.gridx = 2;
		gridBagConstraint.gridy = 6;
		gridBagConstraint.gridwidth = 1;

		JLabel lbBar2 = new JLabel("   -  ");
		this.findThirdPanel.add(lbBar2, gridBagConstraint);

		gridBagConstraint.gridx = 3;
		gridBagConstraint.gridy = 6;
		gridBagConstraint.gridwidth = 1;

		tfBirthBack2 = new JPasswordField();
		tfBirthBack2.setColumns(6);
		this.findThirdPanel.add(tfBirthBack2, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 7;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty7 = new JLabel(" ");
		this.findThirdPanel.add(lbEmpty7, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 8;
		gridBagConstraint.gridwidth = 1;

		JLabel lbEmail2 = new JLabel("�̸���");
		this.findThirdPanel.add(lbEmail2, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 8;
		gridBagConstraint.gridwidth = 3;

		tfEmail2 = new JTextField();
		tfEmail2.setColumns(15);
		this.findThirdPanel.add(tfEmail2, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 9;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty8 = new JLabel(" ");
		this.findThirdPanel.add(lbEmpty8, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 10;
		gridBagConstraint.gridwidth = 3;

		JButton btCallPw = new JButton("��й�ȣ ��ȸ");
		btCallPw.setBackground(Color.WHITE);
		this.findThirdPanel.add(btCallPw, gridBagConstraint);

		// �׼��ڵ鷯

		btBack.addActionListener(actionHandler);
		btReset.addActionListener(actionHandler2);

		btCallId.addActionListener(actionHandler);
		btCallPw.addActionListener(actionHandler);

		this.sFindId = new SFindId();
		this.sFindPw = new SFindPw();
	}

	class FindSecondPanel extends JPanel {

		public FindSecondPanel() {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		}
	}

	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			if (bt.getText().equals("��� �����")) {
				tfName.setText("");
				tfBirthFront.setText("");
				tfBirthBack.setText("");
				tfEmail.setText("");
				tfName2.setText("");
				tfBirthFront2.setText("");
				tfBirthBack2.setText("");
				tfEmail2.setText("");
				tfId.setText("");
			}
		}
	}

}
