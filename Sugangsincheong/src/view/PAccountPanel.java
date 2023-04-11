package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import global.Constants;
import global.Locale;
import valueObject.VAccount;

public class PAccountPanel extends JPanel {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private JFrame parent;
	private PUserInfoDialog userInfoDialog;

	public PAccountPanel(VAccount vAccount, JFrame frame, view.PMainFrame.ActionHandler actionHandler) {
		this.parent = frame;
		this.setBackground(Color.lightGray);

		this.userInfoDialog = new PUserInfoDialog(frame, vAccount);

		JLabel lName = new JLabel(vAccount.getName());
		this.add(lName);

		JLabel lGreeting = new JLabel(Locale.INSA_POSTFIX);
		this.add(lGreeting);

		JLabel lLogin = new JLabel(Locale.LOGIN_TIME_PREFIX);
		this.add(lLogin);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Locale.TIME_FORMAT); // 현재 시간

		JLabel lTime = new JLabel(simpleDateFormat.format(new Date()));
		this.add(lTime);

		JLabel lDescription = new JLabel(Locale.IPNIDA);
		this.add(lDescription);

		ActionHandler actionHandler2 = new ActionHandler();

		//
		JButton btInfo = new JButton("내 정보");
		btInfo.addActionListener(actionHandler2);
		this.add(btInfo);
		//

		JButton btLogout = new JButton(Locale.LOGOUT_LABEL);
		btLogout.addActionListener(actionHandler2);
		this.add(btLogout);

		JButton btSave = new JButton("저장");
		btSave.addActionListener(actionHandler);
		this.add(btSave);

	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			if (bt.getText().equals(Locale.LOGOUT_LABEL)) {
				parent.dispose();
				Main main = new Main();
				main.initialize(); // count 초기화도 됨
			} else if (bt.getText().equals("내 정보")) {
				// 내 정보 다이얼로그 띄우기
				userInfoDialog.setVisible(true);
			}
		}
	}

}
