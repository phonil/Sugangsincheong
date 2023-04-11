package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import global.Constants;
import valueObject.VAccount;

public class PUserInfoDialog extends JDialog {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private JFrame parent;
	private ImagePanel imagePanel;

	private PInfoMiddlePanel infoMiddlePanel;

	public PUserInfoDialog(JFrame frame, VAccount vAccount) {
		this.parent = frame;

		this.setSize(450, 450);
		this.setModal(true); // 모달

		this.setLayout(new BorderLayout());

		//
		infoMiddlePanel = new PInfoMiddlePanel(vAccount);
		infoMiddlePanel.setBackground(Color.WHITE);
		this.add(infoMiddlePanel, BorderLayout.CENTER);

		//
		imagePanel = new ImagePanel(new ImageIcon("./image/logo1.jpg").getImage());
		this.add(imagePanel, BorderLayout.SOUTH);

	}

	class PInfoMiddlePanel extends JPanel {
		public PInfoMiddlePanel(VAccount vAccount) {
			LayoutManager layoutManager = new GridBagLayout();
			GridBagConstraints gridBagConstraint = new GridBagConstraints();

			JPanel wrapPanel = new JPanel();
			wrapPanel.setLayout(layoutManager);
			wrapPanel.setBackground(Color.white);
			this.add(wrapPanel);

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 0;

			JLabel lbTitle = new JLabel("내 계정 정보 ");
			wrapPanel.add(lbTitle, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 1;
			gridBagConstraint.weightx = 2;

			JLabel lbEmpty1 = new JLabel(" ");
			wrapPanel.add(lbEmpty1, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 2;
			gridBagConstraint.gridwidth = 1;

			JLabel lbId = new JLabel("아이디 ");
			wrapPanel.add(lbId, gridBagConstraint);

			gridBagConstraint.gridx = 1;
			gridBagConstraint.gridy = 2;
			gridBagConstraint.gridwidth = 3;

			JLabel lbId2 = new JLabel(vAccount.getId());
			wrapPanel.add(lbId2, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 3;
			gridBagConstraint.weightx = 2;
			gridBagConstraint.gridwidth = 2;

			JLabel lbEmpty = new JLabel(" ");
			wrapPanel.add(lbEmpty, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 4;
			gridBagConstraint.gridwidth = 1;

			JLabel lbPw = new JLabel("비밀번호 ");
			wrapPanel.add(lbPw, gridBagConstraint);

			gridBagConstraint.gridx = 1;
			gridBagConstraint.gridy = 4;
			gridBagConstraint.gridwidth = 3;

			JLabel lbPw2 = new JLabel(vAccount.getPassword());
			wrapPanel.add(lbPw2, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 5;
			gridBagConstraint.weightx = 2;
			gridBagConstraint.gridwidth = 2;

			JLabel lbEmpty2 = new JLabel(" ");
			wrapPanel.add(lbEmpty2, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 6;
			gridBagConstraint.gridwidth = 1;

			JLabel lbName = new JLabel("이름 ");
			wrapPanel.add(lbName, gridBagConstraint);

			gridBagConstraint.gridx = 1;
			gridBagConstraint.gridy = 6;
			gridBagConstraint.gridwidth = 3;

			JLabel lbName2 = new JLabel(vAccount.getName());
			wrapPanel.add(lbName2, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 7;
			gridBagConstraint.weightx = 2;
			gridBagConstraint.gridwidth = 2;

			JLabel lbEmpty3 = new JLabel(" ");
			wrapPanel.add(lbEmpty3, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 8;
			gridBagConstraint.gridwidth = 1;

			JLabel lbBirth = new JLabel("주민번호 ");
			wrapPanel.add(lbBirth, gridBagConstraint);

			gridBagConstraint.gridx = 1;
			gridBagConstraint.gridy = 8;
			gridBagConstraint.gridwidth = 1;

			JLabel lbBirthFront = new JLabel(vAccount.getBirthFront());
			wrapPanel.add(lbBirthFront, gridBagConstraint);

			gridBagConstraint.gridx = 2;
			gridBagConstraint.gridy = 8;
			gridBagConstraint.gridwidth = 1;

			JLabel lbBar = new JLabel("  -  ");
			wrapPanel.add(lbBar, gridBagConstraint);

			gridBagConstraint.gridx = 3;
			gridBagConstraint.gridy = 8;
			gridBagConstraint.gridwidth = 1;

			JLabel lbBirthBack = new JLabel(vAccount.getBirthBack());
			wrapPanel.add(lbBirthBack, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 9;
			gridBagConstraint.weightx = 2;
			gridBagConstraint.gridwidth = 2;

			JLabel lbEmpty4 = new JLabel(" ");
			wrapPanel.add(lbEmpty4, gridBagConstraint);

			//

			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 10;
			gridBagConstraint.gridwidth = 1;

			JLabel lbMail = new JLabel("이메일 ");
			wrapPanel.add(lbMail, gridBagConstraint);

			gridBagConstraint.gridx = 1;
			gridBagConstraint.gridy = 10;
			gridBagConstraint.gridwidth = 3;

			JLabel lbMail2 = new JLabel(vAccount.getMail());
			wrapPanel.add(lbMail2, gridBagConstraint);

		}
	}

	class ImagePanel extends JPanel { // 이미지 삽입 위함 (명지대학교 로고)
		private Image img;

		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(new BorderLayout());

		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}

	}

}
