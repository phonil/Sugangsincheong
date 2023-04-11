package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import global.Constants;
import global.Locale;
import service.SLogin;

public class PLoginDialog extends JDialog { // 로그인 다이얼로그
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private JTextField tfId;
	private SLogin sLogin;

	private JPasswordField tfPassword;

	private WindowHandler windowHandler;

	public JTextField getTfId() {
		return this.tfId;
	}

	public JPasswordField getTfPassword() {
		return this.tfPassword;
	}

	public SLogin getSLogin() {
		return this.sLogin;
	}

	public PLoginDialog(view.Main.ActionHandler actionHandler) {
		this.windowHandler = new WindowHandler();
		this.addWindowListener(this.windowHandler);

		this.setSize(Locale.LLoginPanel.X, Locale.LLoginPanel.Y);
		this.setModal(true); // 모달
		this.setLocationRelativeTo(null); // 중앙배치

		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);

		this.setTitle(Locale.LLoginPanel.LOGIN_LABEL);

		JLabel nLabel = new JLabel(Locale.LLoginPanel.TITLE_LABEL);
		this.add(nLabel, BorderLayout.NORTH);
		nLabel.setHorizontalAlignment(nLabel.CENTER);

		JPanel sPanel = new JPanel();
		sPanel.setLayout(new BorderLayout());
		this.add(sPanel, BorderLayout.SOUTH);

		JLabel emLa = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		sPanel.add(Box.createHorizontalStrut(5), BorderLayout.WEST);
		sPanel.add(Box.createHorizontalStrut(5), BorderLayout.EAST);
		sPanel.add(emLa, BorderLayout.SOUTH);

		JLabel wLabel = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		this.add(wLabel, BorderLayout.WEST);

		JLabel eLabel = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		this.add(eLabel, BorderLayout.EAST);

		LayoutManager layoutManager2 = new GridBagLayout();
		GridBagConstraints gridBagConstraint = new GridBagConstraints();

		JPanel panel1 = new JPanel();
		panel1.setLayout(layoutManager2);
		this.add(panel1, BorderLayout.CENTER);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 0;

		JLabel lbId = new JLabel(Locale.LLoginPanel.ID_LABEL);
		panel1.add(lbId, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 0;

		JLabel emLabel5 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel5, gridBagConstraint);

		gridBagConstraint.gridx = 2;
		gridBagConstraint.gridy = 0;

		this.tfId = new JTextField();
		this.tfId.setColumns(10);
		panel1.add(tfId, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 1;

		JLabel emLabel8 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel8, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 2;

		JLabel emLabel9 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel9, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 3;

		JLabel emLabel10 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel10, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 2;

		JLabel lbPassword = new JLabel(Locale.LLoginPanel.PASSWORD_LABEL);
		panel1.add(lbPassword, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 2;

		JLabel emLabel6 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel6, gridBagConstraint);

		gridBagConstraint.gridx = 2;
		gridBagConstraint.gridy = 2;

		this.tfPassword = new JPasswordField();
		this.tfPassword.setColumns(10);
		panel1.add(tfPassword, gridBagConstraint);

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 3;

		JLabel emLabel = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 3;

		JLabel emLabel2 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel2, gridBagConstraint);

		// 회원가입 버튼

		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 4;

		JButton btRe = new JButton(Locale.LLoginPanel.SIGNUP_LABEL);
		btRe.setBackground(Color.WHITE);
		panel1.add(btRe, gridBagConstraint);

		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 4;

		JLabel emLabel7 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel7, gridBagConstraint);

		// 찾기 버튼

		gridBagConstraint.gridx = 2;
		gridBagConstraint.gridy = 4;

		JButton btFind = new JButton(Locale.LLoginPanel.FIND_PASSWORD_LABEL);
		btFind.setBackground(Color.WHITE);
		panel1.add(btFind, gridBagConstraint);

		gridBagConstraint.gridx = 3;
		gridBagConstraint.gridy = 0;

		JLabel emLabel11 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel11, gridBagConstraint);

		gridBagConstraint.gridx = 3;
		gridBagConstraint.gridy = 1;

		JLabel emLabel12 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel12, gridBagConstraint);

		gridBagConstraint.gridx = 4;
		gridBagConstraint.gridy = 1;

		JLabel emLabel13 = new JLabel(Locale.LLoginPanel.EMPTY_LABEL);
		panel1.add(emLabel13, gridBagConstraint);

		// 로그인 버튼

		gridBagConstraint.gridx = 4;
		gridBagConstraint.gridy = 0;
		gridBagConstraint.ipady = 35;
		gridBagConstraint.gridheight = 3;

		JButton btLogin = new JButton(Locale.LLoginPanel.LOGIN_LABEL);
		this.getRootPane().setDefaultButton(btLogin); //
		btLogin.setBackground(Color.WHITE);
		panel1.add(btLogin, gridBagConstraint);

		gridBagConstraint.gridx = 4;
		gridBagConstraint.gridy = 4;
		gridBagConstraint.ipadx = 10;
		gridBagConstraint.ipady = 0;

		JButton btCancel = new JButton(Locale.LLoginPanel.Cancel_LABEL);
		btCancel.setBackground(Color.WHITE);
		panel1.add(btCancel, gridBagConstraint);

		btLogin.addActionListener(actionHandler);
		btFind.addActionListener(actionHandler);
		btRe.addActionListener(actionHandler);
		btCancel.addActionListener(actionHandler);

		this.sLogin = new SLogin();
	}

	class WindowHandler implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(EXIT_ON_CLOSE);
		}

		@Override
		public void windowClosed(WindowEvent e) {
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}
	}

}
