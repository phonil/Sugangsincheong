package viewSugangsincheong;

import java.util.Vector;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import service.SLecture;
import valueObject.VLecture;

public class PLectureTable extends JTable {

	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private ListSelectionModel listSelectionModel;

	private SLecture sLecture;
	private Vector<VLecture> vLectures;

	public PLectureTable() {
		Vector<String> header = new Vector<String>();
		String[] headArr = { "���¹�ȣ", "���¸�", "��米��", "����", "�ð�" };
		for (String s : headArr) {
			header.add(s);
		}

		this.tableModel = new DefaultTableModel(header, 0);
		this.listSelectionModel = new DefaultListSelectionModel();
		this.setModel(this.tableModel);

	}

	public Vector<VLecture> getVDirectories() {
		return this.vLectures;
	}

	public void setData(String fileName) {
		this.sLecture = new SLecture();
		this.vLectures = sLecture.getLectures(fileName); // n���� v���丮 �޾ƿ���.. / n���� ������ �����״� !

		for (VLecture vLecture : vLectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getId()); //// ��ܺο��� �������� ����� ���� ����
			row.add(vLecture.getName());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getCredit());
			row.add(vLecture.getTime());

			this.tableModel.addRow(row);
		}
		this.setRowSelectionInterval(0, 0);// �ʱ� ����
	}

}