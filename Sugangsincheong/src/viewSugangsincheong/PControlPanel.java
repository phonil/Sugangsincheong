package viewSugangsincheong;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import viewSugangsincheong.PSugangsincheongPanel.ActionHandler;

public class PControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton buttonRight;
	private JButton buttonLeft;

	public JButton getButtonRight() {
		return buttonRight;
	}

	public JButton getButtonLeft() {
		return buttonLeft;
	}

	public PControlPanel(ActionHandler actionHandler) {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);

		this.buttonRight = new JButton(">>");
		this.buttonRight.addActionListener(actionHandler);
		this.buttonRight.setActionCommand(this.buttonRight.getText());
		this.add(this.buttonRight);

		this.buttonLeft = new JButton("<<");
		this.buttonLeft.addActionListener(actionHandler);
		this.buttonLeft.setActionCommand(this.buttonLeft.getText());
		this.add(this.buttonLeft);

	}

}