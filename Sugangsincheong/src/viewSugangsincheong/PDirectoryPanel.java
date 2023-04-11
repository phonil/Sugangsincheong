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

public class PDirectoryPanel extends JPanel { // ���� ���� �κ� �г�. ķ�۽�, �ܰ���, �а�, ���� ��� �κ�

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

		// Directory ��ܺ� - selectPanel

		JPanel selectPanel = new JPanel();
		layoutManager = new BoxLayout(selectPanel, BoxLayout.X_AXIS);
		selectPanel.setLayout(layoutManager);

		JScrollPane scrollPane = new JScrollPane();
		this.campusTable = new PDirectory("ķ�۽�");
		this.campusTable.getSelectionModel().addListSelectionListener(this.listSelectionListener);
		scrollPane.setViewportView(this.campusTable);
		selectPanel.add(scrollPane);

		scrollPane = new JScrollPane();
		this.collegeTable = new PDirectory("����");
		this.collegeTable.getSelectionModel().addListSelectionListener(this.listSelectionListener);
		scrollPane.setViewportView(this.collegeTable);
		selectPanel.add(scrollPane);

		scrollPane = new JScrollPane();
		this.departmentTable = new PDirectory("�а�");
		this.departmentTable.getSelectionModel().addListSelectionListener(this.listSelectionListener);
		scrollPane.setViewportView(this.departmentTable);
		selectPanel.add(scrollPane);

		// Directroy �ϴܺ� - lecturePanel

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

	// selectPanel ���̺� ����

	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;
		private ListSelectionModel listSelectionModel;

		private SDirectory sDirectory;
		private Vector<VDirectory> vDirectories;

		public PDirectory(String head) {
			Vector<String> header = new Vector<String>();
			header.add(head);
			this.tableModel = new DefaultTableModel(header, 0); // �ڿ��� �ο� / �ο�� �ڵ����� ���� / 0���� �����ص� ��
			this.listSelectionModel = new DefaultListSelectionModel();
			this.setModel(this.tableModel);
		}

		public Vector<VDirectory> getVDirectories() {
			return this.vDirectories;
		}

		public String setData(String fileName) {
			this.sDirectory = new SDirectory();
			this.vDirectories = sDirectory.getDirectories(fileName); // n���� v���丮 �޾ƿ���.. / n���� ������ �����״� //

			for (VDirectory vDirectory : vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName()); // �ϴܺο��� ������
				this.tableModel.addRow(row);
			}
			this.setRowSelectionInterval(0, 0);// �ʱ� ����
			return vDirectories.get(0).getFileName(); // �� ���ð��� ����Ű�� ���ϳ��� ������ �����ϴ� ��
		}

	}

	public PLectureTable getLectureTable() {
		return this.lectureTable;
	}

	class ListSelectionHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) { // ���⼭ setData�� �ϴ°� ����.
			ListSelectionModel lsm = (ListSelectionModel) e.getSource();
			int rowIdx = lsm.getMinSelectionIndex(); // ������ �κ� �ε��� ��ȯ / �ʱ�� 0
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
