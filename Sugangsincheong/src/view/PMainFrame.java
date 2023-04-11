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

	private Vector<VLecture> vecSugangsincheong; // 수강신청 내역 저장 벡터
	private Vector<VLecture> vecMiridamgi; // 미리담기 내역 저장 벡터

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

		// 미리담기 파일 읽기 - 불러오기 위함
		this.vecMiridamgi = sLecture.getLectures("account/" + this.vAccount.getId() + "Miridamgi", 1);
		// 수강신청 파일 읽기 - 불러오기 위함
		this.vecSugangsincheong = sLecture.getLectures("account/" + this.vAccount.getId() + "Sugangsincheong", 1);

		// 상단에 이름 등의 정보
		this.accountPanel = new PAccountPanel(this.vAccount, this, actionHandler);
		this.add(this.accountPanel, BorderLayout.NORTH);

		// 하단 학점 정보
		this.statusPanel = new PStatusPanel(this.vAccount, this, actionHandler);
		this.add(this.statusPanel, BorderLayout.SOUTH);

		// 실질적 사용 공간 / 사용 패널을 위한 놈들 중 가장 큰 패널
		this.sugangsincheongPanel = new PSugangsincheongPanel();
		this.add(this.sugangsincheongPanel, BorderLayout.CENTER);

		// 미리담기 저장된 파일 테이블에 넣기
		for (int i = 0; i < vecMiridamgi.size(); i++) {
			sugangsincheongPanel.getMiridamgiPanel().setData(vecMiridamgi.get(i)); // 미리담기 저장 완료...
		}
		// 수강신청 저장된 파일 테이블에 넣기
		for (int i = 0; i < vecSugangsincheong.size(); i++) {
			sugangsincheongPanel.getSincheongPanel().setData(vecSugangsincheong.get(i)); // 미리담기 저장완료...
		}

	}

	public void initialize() {
		this.setVisible(true);

	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			if (bt.getText().equals("저장")) { // 파일에 내용 저장

				vecMiridamgi = sugangsincheongPanel.getMiridamgiPanel().getVLectures();
				vecSugangsincheong = sugangsincheongPanel.getSincheongPanel().getVLectures();

				try {
					// 미리담기
					FileWriter fw = new FileWriter("account/" + vAccount.getId() + "Miridamgi", false); // 이 내역은 계속 변할테니
																										// 덮어쓰기

					// 미리담기 목록 채워넣기
					for (int i = 0; i < vecMiridamgi.size(); i++) {
						fw.write(vecMiridamgi.get(i).getId() + " " + vecMiridamgi.get(i).getName() + " "
								+ vecMiridamgi.get(i).getProfessor() + " " + vecMiridamgi.get(i).getCredit() + " "
								+ vecMiridamgi.get(i).getTime());
						fw.write("\n");
					}
					fw.close(); // 꼭 닫아줘야 함

					// 수강신청
					fw = new FileWriter("account/" + vAccount.getId() + "Sugangsincheong", false);

					for (int j = 0; j < vecSugangsincheong.size(); j++) {
						fw.write(vecSugangsincheong.get(j).getId() + " " + vecSugangsincheong.get(j).getName() + " "
								+ vecSugangsincheong.get(j).getProfessor() + " " + vecSugangsincheong.get(j).getCredit()
								+ " " + vecSugangsincheong.get(j).getTime());
						fw.write("\n");
					}
					fw.close();

					// 저장 시 바로 status 문구 변경

					// 미리담기 학점
					File file = new File("account/" + vAccount.getId() + "Miridamgi");
					int miridamgiCredit = statusPanel.getCredit(file);
					statusPanel.setMiridamgiCredit(miridamgiCredit);

					// 수강신청 학점
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
