package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.SCheckId;
import valueObject.VAccount;

public class PSignUpDialog extends JDialog {

	private JTextField tfName;
	private JTextField tfId;
	private JTextField tfPassword;
	private JTextField tfBirthFront;
	private JTextField tfBirthBack;
	private JTextField tfEmail;

	private SCheckId sCheckId;

	private JButton btReturn;

	public PSignUpDialog(JDialog parentDialog, view.Main.ActionHandler actionHandler) {
		super(parentDialog, "Sign Up");

		ActionHandler actionHandler2 = new ActionHandler();

		this.setSize(440, 650);
		this.setModal(true); // ���

		this.setLayout(new BorderLayout());

		JPanel helloPanel = new JPanel();
		helloPanel.setBackground(Color.WHITE);
		this.add(helloPanel, BorderLayout.NORTH);

		JLabel lbHello = new JLabel("ȸ������ ȭ���Դϴ�.");
		helloPanel.add(lbHello);

		this.btReturn = new JButton("���ư���");
		helloPanel.add(btReturn);

		LayoutManager layoutManager = new GridBagLayout();
		GridBagConstraints gridBagConstraint = new GridBagConstraints();

		JPanel signUpPanel = new JPanel();
		this.add(signUpPanel, BorderLayout.CENTER);

		signUpPanel.setLayout(layoutManager);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 0;

		JLabel lbSignUp = new JLabel("ȸ������");
		signUpPanel.add(lbSignUp, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 1;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty1 = new JLabel(" ");
		signUpPanel.add(lbEmpty1, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 2;
		gridBagConstraint.gridwidth = 1;

		JLabel lbId = new JLabel("���̵�");
		signUpPanel.add(lbId, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 2;
		gridBagConstraint.gridwidth = 3;

		tfId = new JTextField();
		tfId.setColumns(15);
		signUpPanel.add(tfId, gridBagConstraint);

		gridBagConstraint.gridx = 4;
		gridBagConstraint.gridy = 2;
		gridBagConstraint.gridwidth = 1;

		JLabel lbEmpty7 = new JLabel(" ");
		signUpPanel.add(lbEmpty7, gridBagConstraint);

		gridBagConstraint.gridx = 5;
		gridBagConstraint.gridy = 2;
		gridBagConstraint.gridwidth = 1;

		JButton btCheckId = new JButton("�ߺ� Ȯ��");
		btCheckId.setBackground(Color.WHITE);
		signUpPanel.add(btCheckId, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 3;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty2 = new JLabel(" ");
		signUpPanel.add(lbEmpty2, gridBagConstraint);

		//

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 4;
		gridBagConstraint.gridwidth = 1;

		JLabel lbPw = new JLabel("��й�ȣ");
		signUpPanel.add(lbPw, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 4;
		gridBagConstraint.gridwidth = 3;

		tfPassword = new JPasswordField();
		tfPassword.setColumns(15);
		signUpPanel.add(tfPassword, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 5;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty3 = new JLabel(" ");
		signUpPanel.add(lbEmpty3, gridBagConstraint);

		//

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 6;
		gridBagConstraint.gridwidth = 1;

		JLabel lbName = new JLabel("�̸�");
		signUpPanel.add(lbName, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 6;
		gridBagConstraint.gridwidth = 3;

		tfName = new JTextField();
		tfName.setColumns(15);
		signUpPanel.add(tfName, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 7;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty4 = new JLabel(" ");
		signUpPanel.add(lbEmpty4, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 8;
		gridBagConstraint.gridwidth = 1;

		JLabel lbBirth = new JLabel("�ֹι�ȣ");
		signUpPanel.add(lbBirth, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 8;
		gridBagConstraint.gridwidth = 1;

		tfBirthFront = new JTextField();
		tfBirthFront.setColumns(6);
		signUpPanel.add(tfBirthFront, gridBagConstraint);

		gridBagConstraint.gridx = 2;
		gridBagConstraint.gridy = 8;
		gridBagConstraint.gridwidth = 1;

		JLabel lbBar = new JLabel("   -  ");
		signUpPanel.add(lbBar, gridBagConstraint);

		gridBagConstraint.gridx = 3;
		gridBagConstraint.gridy = 8;
		gridBagConstraint.gridwidth = 1;

		tfBirthBack = new JPasswordField();
		tfBirthBack.setColumns(6);
		signUpPanel.add(tfBirthBack, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 9;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty5 = new JLabel(" ");
		signUpPanel.add(lbEmpty5, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 10;
		gridBagConstraint.gridwidth = 1;

		JLabel lbEmail = new JLabel("�̸���");
		signUpPanel.add(lbEmail, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 10;
		gridBagConstraint.gridwidth = 3;

		tfEmail = new JTextField();
		tfEmail.setColumns(15);
		signUpPanel.add(tfEmail, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 11;
		gridBagConstraint.gridwidth = 5;

		JLabel lbEmpty6 = new JLabel(" ");
		signUpPanel.add(lbEmpty6, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 12;
		gridBagConstraint.gridwidth = 3;

		JButton btSignUp = new JButton("ȸ������");
		btSignUp.setBackground(Color.WHITE);
		signUpPanel.add(btSignUp, gridBagConstraint);

		btReturn.addActionListener(actionHandler);
		btCheckId.addActionListener(actionHandler2);
		btSignUp.addActionListener(actionHandler2);

		sCheckId = new SCheckId();
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			if (bt.getText().equals("�ߺ� Ȯ��")) { // id �ߺ� Ȯ��
				String id = tfId.getText();
				VAccount vAccount = sCheckId.checkId(id);
				if (vAccount == null) { // �ߺ�, id ��� �Ұ�
					JOptionPane.showMessageDialog(null, "���̵� �̹� �����մϴ�. \n�ٸ� ���̵� �Է��ϼ���.", "Message",
							JOptionPane.ERROR_MESSAGE);
				} else if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "����� ���̵� �Է��ϼ���.", "Message", JOptionPane.PLAIN_MESSAGE);
				} else { // �ߺ� x, id ��� ����
					JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�.", "Message", JOptionPane.PLAIN_MESSAGE);
				}
			} else if (bt.getText().equals("ȸ������")) {
				if (tfId.getText().equals("") || tfPassword.getText().equals("") || tfName.getText().equals("")
						|| tfBirthFront.getText().equals("") || tfBirthBack.getText().equals("")
						|| tfEmail.getText().equals("")) { // �Է����� ���� �κ� ������
					JOptionPane.showMessageDialog(null, "��� ���� �Է��ϼ���.", "Message", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						FileWriter fw = new FileWriter("account/id", true); // id ���Ͽ� id �Է�
						fw.write("\n" + tfId.getText());
						fw.close();

						fw = new FileWriter("account/account", true); // account ���Ͽ� ���� ���� ��� �Է�
						fw.write("\n" + tfId.getText() + " " + tfPassword.getText() + " " + tfName.getText() + " "
								+ tfBirthFront.getText() + " " + tfBirthBack.getText() + " " + tfEmail.getText());
						fw.close();

						File file = new File("account/" + tfId.getText() + "Miridamgi"); // ���̵� �̸���� ��� ����

						fw = new FileWriter(file, true);
						fw.write("");
						fw.close();

						//

						file = new File("account/" + tfId.getText() + "Sugangsincheong"); // ���̵� ������û ��� ����

						fw = new FileWriter(file, true);
						fw.write("");
						fw.close();

						JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�. \n�α��� ���ּ���.", "Message",
								JOptionPane.PLAIN_MESSAGE);
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

}