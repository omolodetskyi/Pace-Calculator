package pacecalc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUI extends JFrame {

	JButton btnCalc;
	JButton btnExit;
	JPanel panelMain;
	JTextField txtTime;
	JTextField txtDistance;
	JTextField txtPace;
	ButtonGroup bgSelect;
	JRadioButton rbPace;
	JRadioButton rbTime;
	JRadioButton rbDistance;
	JLabel lblTime;
	JLabel lblPace;
	JLabel lblDistance;
	JOptionPane exitMessage;
	JOptionPane errorMessage;

	public GUI() {
		this.setSize(580, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelMain = new JPanel();

		panelMain.setLayout(new GridBagLayout());

		btnCalc = new JButton("Calculate");

		btnExit = new JButton("Exit");

		lblPace = new JLabel("Enter pace in format mm:ss");
		lblTime = new JLabel("Enter time in format hh:mm:ss");
		lblDistance = new JLabel("Enter distance in meters(integer value)");

		txtTime = new JTextField(20);
		txtPace = new JTextField(20);
		txtDistance = new JTextField(20);
		txtPace.setEnabled(false);

		rbPace = new JRadioButton("Calculate pace based on time and distance");
		rbPace.setActionCommand("pace");

		rbTime = new JRadioButton("Calculate time based on pace and distance");
		rbTime.setActionCommand("time");

		rbDistance = new JRadioButton("Calculate distance based on pace and time");
		rbDistance.setActionCommand("distance");

		ListenerForRadioButton lForRadioButton = new ListenerForRadioButton();

		rbPace.addActionListener(lForRadioButton);
		rbTime.addActionListener(lForRadioButton);
		rbDistance.addActionListener(lForRadioButton);

		bgSelect = new ButtonGroup();
		bgSelect.add(rbPace);
		bgSelect.add(rbTime);
		bgSelect.add(rbDistance);
		rbPace.setSelected(true);

		Box enterBox = Box.createVerticalBox();
		enterBox.add(lblTime);
		enterBox.add(txtTime);
		enterBox.add(lblDistance);
		enterBox.add(txtDistance);
		enterBox.add(lblPace);
		enterBox.add(txtPace);
		Box choiceBox = Box.createVerticalBox();
		choiceBox.add(rbPace);
		choiceBox.add(rbTime);
		choiceBox.add(rbDistance);
		choiceBox.setBorder(BorderFactory.createEtchedBorder());
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(Box.createHorizontalGlue());
		buttonBox.add(btnCalc);
		buttonBox.add(btnExit);
		componentAdd(panelMain, enterBox, 0, 0, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL);
		componentAdd(panelMain, choiceBox, 1, 0, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL);
		componentAdd(panelMain, buttonBox, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL);

		this.add(panelMain);
		this.pack();
		this.setTitle("Pace Calculator");
		this.setVisible(true);

	}

	void addCalcListener(ActionListener lForButton) {
		btnCalc.addActionListener(lForButton);

	}

	void addExitListener(ActionListener ExitButton) {
		btnExit.addActionListener(ExitButton);
	}

	int showExitMessage() {
		Object[] options = { "Yes", "No" };
		int userChoice = JOptionPane.showOptionDialog(this, "Are you sure you would like to exit PaceCalculator?",
				"Confirm please", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		return userChoice;
	}

	void showErrorMessage() {
		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(this, "Your input was wrong, please enter correct values in correct format",
				"Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
	}

	String getTime() {
		return txtTime.getText();
	}

	String getPace() {

		return txtPace.getText();
	}

	String getDistance() {
		return txtDistance.getText();
	}

	void setTime(String time) {
		txtTime.setText(time);
	}

	void setDistance(String distance) {
		txtDistance.setText(distance);
	}

	void setPace(String pace) {
		txtPace.setText(pace);
	}

	int getCalcSelection() {
		int userCalcSelecton = 1;
		if (rbPace.isSelected()) {
			userCalcSelecton = 1;
		} else if (rbTime.isSelected()) {
			userCalcSelecton = 2;
		} else if (rbDistance.isSelected()) {
			userCalcSelecton = 3;
		}
		return userCalcSelecton;
	}

	class ListenerForRadioButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == rbPace) {
				txtPace.setEnabled(false);
				txtTime.setEnabled(true);
				txtDistance.setEnabled(true);
			} else if (e.getSource() == rbTime) {
				txtPace.setEnabled(true);
				txtTime.setEnabled(false);
				txtDistance.setEnabled(true);
			} else if (e.getSource() == rbDistance) {
				txtPace.setEnabled(true);
				txtTime.setEnabled(true);
				txtDistance.setEnabled(false);
			}
		}

	}

	private void componentAdd(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight,
			int place, int stretch) {
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = xPos;

		gridConstraints.gridy = yPos;

		gridConstraints.ipadx = 5;
		gridConstraints.ipady = 5;

		gridConstraints.gridwidth = compWidth;

		gridConstraints.gridheight = compHeight;

		gridConstraints.weightx = 100;

		gridConstraints.weighty = 100;

		gridConstraints.insets = new Insets(5, 5, 5, 5);

		gridConstraints.anchor = place;

		gridConstraints.fill = stretch;

		thePanel.add(comp, gridConstraints);

	}

}
