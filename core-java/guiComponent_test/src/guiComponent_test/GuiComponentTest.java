package guiComponent_test;

import javax.swing.*;

public class GuiComponentTest {

	public static void main(String[] args) {
		// TODO Gui Component test Sequence
		
		//Components
		JButton button_1 = new JButton("OK");
		JButton button_2 = new JButton("CANCEL");
		JLabel label_1 = new JLabel("Enter Your Name: ");
		JTextField textfield_1 = new JTextField("Type Name Here");
		JCheckBox checkbox_1 = new JCheckBox("Bold");
		JCheckBox checkbox_2 = new JCheckBox("Italic");
		JRadioButton radiobutton_1 = new JRadioButton("Male");
		JRadioButton radiobutton_2 = new JRadioButton("Female");
		
		JComboBox combobox_1 = new JComboBox(new String[]{"Freshman", "Sophomore", "Junior", "Senior"});
		
		//Create a Panel to group components
		JPanel panel = new JPanel();
		panel.add(button_1);
		panel.add(button_2);
		panel.add(label_1);
		panel.add(textfield_1);
		panel.add(checkbox_1);
		panel.add(checkbox_2);
		panel.add(radiobutton_1);
		panel.add(radiobutton_2);
		panel.add(combobox_1);
		
		//Create a Frame
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setTitle("Gui Component Test");
		frame.setSize(800, 75);
		frame.setLocation(680,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Show the GUI
		frame.setVisible(true);
		
	}

}
