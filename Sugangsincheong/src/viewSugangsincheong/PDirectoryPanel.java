package viewSugangsincheong;

import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import service.SDirectory;
import valueObject.VDirectory;

public class PDirectoryPanel extends JPanel { // 가장 왼쪽 부분 패널. 캠퍼스, 단과대, 학과, 강의 담는 부분

	private static final long serialVersionUID = 1L;

	private ListSelectionHandler listSelectionListener;

	private PDirectory campusTable;
	private PDirectory collegeTable;
	private PDirectory departmentTable;

	private PLectureTable lectureTable;

	public PDirectoryPanel() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);

		this.listSelectionListener = new ListSelectionHandler();

		// Directory 상단부 - selectPanel

		JPanel selectPanel = new JPanel();
		layoutManager = new BoxLayout(selectPanel, BoxLayout.X_AXIS);
		selectPanel.setLayout(layoutManager);

		JScrollPane scrollPane = new JScrollPane();
		this.campusTable = new PDirectory("캠퍼스");
		this.campusTable.getSelectionModel().addListSelectionListener(this.listSelectionListener);
		scrollPane.setViewportView(this.campusTable);
		selectPanel.add(scrollPane);

		scrollPane = new JScrollPane();
		this.collegeTable = new PDirectory("대학");
		this.collegeTable.getSelectionModel().addListSelectionListener(this.listSelectionListener);
		scrollPane.setViewportView(this.collegeTable);
		selectPanel.add(scrollPane);

		scrollPane = new JScrollPane();
		this.departmentTable = new PDirectory("학과");
		this.departmentTable.getSelectionModel().addListSelectionListener(this.listSelectionListener);
		scrollPane.setViewportView(this.departmentTable);
		selectPanel.add(scrollPane);

		// Directroy 하단부 - lecturePanel

		JPanel lecturePanel = new JPanel();
		layoutManager = new BoxLayout(lecturePanel, BoxLayout.X_AXIS);
		lecturePanel.setLayout(layoutManager);

		scrollPane = new JScrollPane();
		this.lectureTable = new PLectureTable();
		this.lectureTable.getSelectionModel().addListSelectionListener(this.listSelectionListener);
		scrollPane.setViewportView(this.lectureTable);
		lecturePanel.add(scrollPane);

		this.add(selectPanel);
		this.add(lecturePanel);

		String fileName = "root";
		fileName = this.campusTable.setData(fileName);
		fileName = this.collegeTable.setData(fileName);
		fileName = this.departmentTable.setData(fileName);
		this.lectureTable.setData(fileName);

	}

	// selectPanel 테이블 위함

	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;
		private ListSelectionModel listSelectionModel;

		private SDirectory sDirectory;
		private Vector<VDirectory> vDirectories;

		public PDirectory(String head) {
			Vector<String> header = new Vector<String>();
			header.add(head);
			this.tableModel = new DefaultTableModel(header, 0); // 뒤에는 로우 / 로우는 자동으로 변함 / 0으로 시작해도 됨
			this.listSelectionModel = new DefaultListSelectionModel();
			this.setModel(this.tableModel);
		}

		public Vector<VDirectory> getVDirectories() {
			return this.vDirectories;
		}

		public String setData(String fileName) {
			this.sDirectory = new SDirectory();
			this.vDirectories = sDirectory.getDirectories(fileName); // n개의 v디렉토리 받아오는.. / n개의 파일이 있을테니 //

			for (VDirectory vDirectory : vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName()); // 하단부와의 차이점
				this.tableModel.addRow(row);
			}
			this.setRowSelectionInterval(0, 0);// 초기 세팅
			return vDirectories.get(0).getFileName(); // 그 세팅값이 가리키는 파일네임 가져와 리턴하는 것
		}

	}

	public PLectureTable getLectureTable() {
		return this.lectureTable;
	}

	class ListSelectionHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) { // 여기서 setData를 하는게 목적.
			ListSelectionModel lsm = (ListSelectionModel) e.getSource();
			int rowIdx = lsm.getMinSelectionIndex(); // 선택한 부분 인덱스 반환 / 초기는 0
			String fileName;
			DefaultTableModel dm;
			if (e.getValueIsAdjusting()) {
				if (lsm.equals(campusTable.getSelectionModel())) {
					fileName = campusTable.vDirectories.get(rowIdx).getFileName();
					dm = (DefaultTableModel) collegeTable.getModel();
					dm.getDataVector().removeAllElements();

					fileName = collegeTable.setData(fileName);
					dm = (DefaultTableModel) departmentTable.getModel();
					dm.getDataVector().removeAllElements();

					fileName = departmentTable.setData(fileName);
					dm = (DefaultTableModel) lectureTable.getModel();
					dm.getDataVector().removeAllElements();
					lectureTable.setData(fileName);

				} else if (lsm.equals(collegeTable.getSelectionModel())) {
					fileName = collegeTable.vDirectories.get(rowIdx).getFileName();
					dm = (DefaultTableModel) departmentTable.getModel();
					dm.getDataVector().removeAllElements();

					fileName = departmentTable.setData(fileName);
					dm = (DefaultTableModel) lectureTable.getModel();
					dm.getDataVector().removeAllElements();
					lectureTable.setData(fileName);

				} else if (lsm.equals(departmentTable.getSelectionModel())) {
					fileName = departmentTable.vDirectories.get(rowIdx).getFileName();
					dm = (DefaultTableModel) lectureTable.getModel();
					dm.getDataVector().removeAllElements();
					lectureTable.setData(fileName);

				}

			}

		}

	}

}
