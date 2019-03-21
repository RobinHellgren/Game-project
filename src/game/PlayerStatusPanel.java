package game;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;

public class PlayerStatusPanel extends JPanel {
	private JTextField nameTextField;
	private JTextField classTextField;
	private JTextField healthTextField;
	private JTextField strTextField;
	private JTextField agiTextField;
	private JTextField smrTextField;
	/**
	 * Create the panel, created with window builder.
	 */
	public PlayerStatusPanel() {
		setPreferredSize(new Dimension(180, 400));
		setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(0, 29, 56, 16);
		add(lblName);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setBounds(0, 58, 56, 16);
		add(lblClass);
		
		JLabel lblNewLabel = new JLabel("Health");
		lblNewLabel.setBounds(0, 87, 56, 16);
		add(lblNewLabel);
		
		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setBounds(0, 116, 56, 16);
		add(lblStrength);
		
		JLabel lblAgility = new JLabel("Agility");
		lblAgility.setBounds(0, 145, 56, 16);
		add(lblAgility);
		
		JLabel lblSmarts = new JLabel("Smarts");
		lblSmarts.setBounds(0, 174, 56, 16);
		add(lblSmarts);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setBounds(63, 26, 116, 22);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		classTextField = new JTextField();
		classTextField.setEditable(false);
		classTextField.setBounds(63, 55, 116, 22);
		add(classTextField);
		classTextField.setColumns(10);
		
		healthTextField = new JTextField();
		healthTextField.setEditable(false);
		healthTextField.setBounds(63, 84, 116, 22);
		add(healthTextField);
		healthTextField.setColumns(10);
		
		strTextField = new JTextField();
		strTextField.setEditable(false);
		strTextField.setBounds(63, 113, 116, 22);
		add(strTextField);
		strTextField.setColumns(10);
		
		agiTextField = new JTextField();
		agiTextField.setEditable(false);
		agiTextField.setBounds(63, 142, 116, 22);
		add(agiTextField);
		agiTextField.setColumns(10);
		
		smrTextField = new JTextField();
		smrTextField.setEditable(false);
		smrTextField.setBounds(63, 171, 116, 22);
		add(smrTextField);
		smrTextField.setColumns(10);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(52, 0, 56, 16);
		add(lblPlayer);

	}
	//function that updates the fields.
	public void updateField(Player player) {
		nameTextField.setText(player.getName());
		classTextField.setText(player.getPlayerClass());
		healthTextField.setText(player.getHealth().toString());
		strTextField.setText(player.getStrength().toString());
		agiTextField.setText(player.getAgility().toString());
		smrTextField.setText(player.getSmarts().toString());
	}



}
