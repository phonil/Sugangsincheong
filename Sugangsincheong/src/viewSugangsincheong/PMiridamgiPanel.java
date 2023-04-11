package viewSugangsincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import service.SLecture;
import valueObject.VLecture;

public class PMiridamgiPanel extends JTable {

	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private ListSelectionModel listSelectionModel;

	private SLecture sLecture;
	private Vector<VLecture> vLectures;

	private boolean existId;

	public PMiridamgiPanel() {
		Vector<String> header = new Vector<String>();
		String[] headArr = { "강좌번호", "강좌명", "담당교수", "학점", "시간" };
		for (String s : headArr) {
			header.add(s);
		}
		vLectures = new Vector<VLecture>();

		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
	}

	public Vector<VLecture> getVLectures() {
		return vLectures;
	}

	public void setData(VLecture lecture) {
		Vector<String> row = new Vector<String>();
		row.add(lecture.getId());
		row.add(lecture.getName());
		row.add(lecture.getProfessor());
		row.add(lecture.getCredit());
		row.add(lecture.getTime());

		existId = true;

		for (int i = 0; i < this.tableModel.getRowCount(); i++) {
			if (this.tableModel.getDataVector().elementAt(i).equals(row)) {
				existId = false;
			}
		}

		if (existId) {
			vLectures.add(lecture);
			this.tableModel.addRow(row);
		}

		this.setRowSelectionInterval(0, 0);// 초기 세팅

	}

}