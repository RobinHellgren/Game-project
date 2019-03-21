package game;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;

public class EnemyStatusPanel extends JPanel {
	private JTextField nameTextField;
	private JTextField healthNameField;

	/**
	 * Create the panel.
	 */
	public EnemyStatusPanel() {
		setPreferredSize(new Dimension(150, 400));
		setMinimumSize(new Dimension(150, 400));
		setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(0, 22, 56, 16);
		add(lblName);
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setBounds(0, 51, 56, 16);
		add(lblHealth);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setBounds(42, 19, 116, 22);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		healthNameField = new JTextField();
		healthNameField.setEditable(false);
		healthNameField.setBounds(42, 48, 116, 22);
		add(healthNameField);
		healthNameField.setColumns(10);
		
		JLabel lblEnemy = new JLabel("Enemy");
		lblEnemy.setBounds(42, 0, 56, 16);
		add(lblEnemy);

	}
	public void updateField(Actor enemy) {
		nameTextField.setText(enemy.getName());
		healthNameField.setText(enemy.getHealth().toString());
	}
}
