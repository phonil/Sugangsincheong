package viewSugangsincheong;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import valueObject.VLecture;

public class PSugangsincheongPanel extends JPanel { // MainFrame의 Center
	private static final long serialVersionUID = 1L;

	private PDirectoryPanel directoryPanel;
	private PControlPanel controlPanel1;
	private PMiridamgiPanel miridamgiPanel;
	private PControlPanel controlPanel2;
	private PSincheongPanel sincheongPanel;

	public PMiridamgiPanel getMiridamgiPanel() {
		return this.miridamgiPanel;
	}

	public PSincheongPanel getSincheongPanel() {
		return this.sincheongPanel;
	}

	public PSugangsincheongPanel() {
		ActionHandler actionHandler = new ActionHandler();

		// attributes
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);

		// component

		// 왼쪽 Directory 담당 패널
		this.directoryPanel = new PDirectoryPanel();
		this.add(directoryPanel);

		this.controlPanel1 = new PControlPanel(actionHandler);
		this.add(controlPanel1);

		JScrollPane scrollPane = new JScrollPane();
		this.miridamgiPanel = new PMiridamgiPanel();
		scrollPane.setViewportView(this.miridamgiPanel);
		this.add(scrollPane);

		this.controlPanel2 = new PControlPanel(actionHandler);
		this.add(controlPanel2);

		scrollPane = new JScrollPane();
		this.sincheongPanel = new PSincheongPanel();
		scrollPane.setViewportView(this.sincheongPanel);
		this.add(scrollPane);

	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			DefaultTableModel dm;
			int selectedRow;
			VLecture lecture;
			int count;
			if (bt.equals(controlPanel1.getButtonRight())) {
				selectedRow = directoryPanel.getLectureTable().getSelectedRow(); // 어떤 수업 선택됐는지 (몇 번째 줄인지)
				lecture = directoryPanel.getLectureTable().getVDirectories().get(selectedRow); // 해당 강의

				miridamgiPanel.setData(lecture);

			} else if (bt.equals(controlPanel1.getButtonLeft())) {
				selectedRow = miridamgiPanel.getSelectedRow();

				if (selectedRow == -1) { // 비어있을 때 버튼 누르면..
					return;
				}

				lecture = miridamgiPanel.getVLectures().get(selectedRow);
				dm = (DefaultTableModel) miridamgiPanel.getModel();

				dm.removeRow(selectedRow);
				miridamgiPanel.getVLectures().remove(selectedRow);

				count = miridamgiPanel.getRowCount();
				if (count > 0) {
					miridamgiPanel.setRowSelectionInterval(0, 0);
				}

			} else if (bt.equals(controlPanel2.getButtonRight())) {
				selectedRow = miridamgiPanel.getSelectedRow();

				if (selectedRow == -1) {
					return;
				}

				lecture = miridamgiPanel.getVLectures().get(selectedRow);

				sincheongPanel.setData(lecture);

				dm = (DefaultTableModel) miridamgiPanel.getModel();
				dm.removeRow(selectedRow);
				miridamgiPanel.getVLectures().remove(selectedRow);

				count = miridamgiPanel.getRowCount();

				if (count > 0) {
					miridamgiPanel.setRowSelectionInterval(0, 0);
				}

			} else if (bt.equals(controlPanel2.getButtonLeft())) {
				selectedRow = sincheongPanel.getSelectedRow();

				if (selectedRow == -1) {
					return;
				}

				lecture = sincheongPanel.getVLectures().get(selectedRow);

				miridamgiPanel.setData(lecture);

				dm = (DefaultTableModel) sincheongPanel.getModel();
				dm.removeRow(selectedRow);
				sincheongPanel.getVLectures().remove(selectedRow);

				count = sincheongPanel.getRowCount();

				if (count > 0) {
					sincheongPanel.setRowSelectionInterval(0, 0);
				}

			}

		}

	}
}
