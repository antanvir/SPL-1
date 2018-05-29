package forspl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

public class ShowVariable {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowVariable window = new ShowVariable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShowVariable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 530, 350);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 482, 274);
		frame.getContentPane().add(tabbedPane);
	
//===>
		JPanel panel = new JPanel();
		tabbedPane.addTab("Integer", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblVariableNames = new JLabel("Variable Names");
		lblVariableNames.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVariableNames.setHorizontalAlignment(SwingConstants.CENTER);
		lblVariableNames.setBounds(21, 11, 137, 27);
		panel.add(lblVariableNames);
		
		JLabel lblNewLabel = new JLabel(" Total Bytes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(294, 11, 116, 27);
		panel.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 38, 233, 197);
		panel.add(textPane);
		
		
		String str = VarNameCollector.GetAllVariables(0);
		int value = VarNameCollector.count;
		String Bstr = "Each int variable takes 4 Bytes\n\n";
		Bstr = Bstr + value+"x"+"4 Bytes = "+value*4 +" Bytes\n";
		str= str+"-------------------------\nTotal "+ value+" variables found\n";
		
		textPane.setText(str);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(267, 38, 186, 147);
		panel.add(textPane_1);
		
		textPane_1.setText(Bstr);
	
//===>
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Double", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Variable Names");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(22, 11, 149, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total Bytes");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(268, 11, 149, 30);
		panel_1.add(lblNewLabel_2);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(10, 41, 222, 194);
		panel_1.add(textPane_2);
		
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(262, 41, 193, 134);
		panel_1.add(textPane_3);
		
		String str1 = VarNameCollector.GetAllVariables(1);
		int value1 = VarNameCollector.count;
		String Bstr1 = "Each double variable takes 8 Bytes\n\n";
		Bstr1 = Bstr1 + value1+"x"+"8 Bytes = "+value1*8 +" Bytes\n";
		str1= str1+"-------------------------\nTotal "+ value1+" variables found\n";
		textPane_2.setText(str1);
		textPane_3.setText(Bstr1);
			
//===>		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Float", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Variable Names");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(35, 11, 143, 30);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total Bytes");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(280, 11, 143, 30);
		panel_2.add(lblNewLabel_4);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(10, 41, 237, 194);
		panel_2.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(280, 52, 187, 124);
		panel_2.add(textPane_5);
		
		String str2 = VarNameCollector.GetAllVariables(2);
		int value2 = VarNameCollector.count;
		String Bstr2 = "Each float variable takes 4 Bytes\n\n";
		Bstr2 = Bstr2 + value2+"x"+"4 Bytes = "+value2*4 +" Bytes\n";
		str2= str2+"-------------------------\nTotal "+ value2+" variables found\n";
		textPane_4.setText(str2);
		textPane_5.setText(Bstr2);
			
//===>
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Char", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Variable Names");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(22, 11, 168, 34);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Total Bytes");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(277, 11, 159, 34);
		panel_3.add(lblNewLabel_6);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(10, 47, 243, 188);
		panel_3.add(textPane_6);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(287, 47, 180, 133);
		panel_3.add(textPane_7);
		
		String str3 = VarNameCollector.GetAllVariables(3);
		int value3 = VarNameCollector.count;
		String Bstr3 = "Each char variable takes 1 Bytes\n\n";
		Bstr3 = Bstr3 + value3+"x"+"1 Bytes = "+value3*1 +" Bytes\n";
		str3= str3+"-------------------------\nTotal "+ value3+" variables found\n";
		textPane_6.setText(str3);
		textPane_7.setText(Bstr3);
		
//===>		
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Boolean", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Variable Names");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(32, 11, 179, 34);
		panel_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Total Bytes");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(243, 11, 192, 34);
		panel_4.add(lblNewLabel_8);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setBounds(10, 49, 231, 186);
		panel_4.add(textPane_8);
		
		JTextPane textPane_9 = new JTextPane();
		textPane_9.setBounds(277, 49, 190, 139);
		panel_4.add(textPane_9);
		
		String str4 = VarNameCollector.GetAllVariables(4);
		int value4 = VarNameCollector.count;
		String Bstr4 = "Each boolean variable takes 8 Bytes\n\n";
		Bstr4 = Bstr4 + value4+"x"+"1 Bytes = "+value4*1 +" Bytes\n";
		str4= str4+"-------------------------\nTotal "+ value4+" variables found\n";
		textPane_8.setText(str4);
		textPane_9.setText(Bstr4);
		
//===>	
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("String", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Variable Names");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(20, 11, 154, 36);
		panel_5.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Total Bytes");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(244, 11, 184, 36);
		panel_5.add(lblNewLabel_10);
		
		JTextPane textPane_10 = new JTextPane();
		textPane_10.setBounds(10, 46, 236, 189);
		panel_5.add(textPane_10);
		
		JTextPane textPane_11 = new JTextPane();
		textPane_11.setBounds(275, 46, 192, 138);
		panel_5.add(textPane_11);
		
		String str5 = VarNameCollector.GetAllVariables(5);
		int value5 = VarNameCollector.count;
		int value6 = VarNameCollector.count1;
		String Bstr5 = "Each String variable takes Bytes according to its length\n\n";
		Bstr5 = Bstr5 + value6+" Strings x (length of each String) = "+value5*1 +" Bytes\n";
		str5= str5+"-------------------------\nTotal "+ value6+" variables found\n";
		textPane_10.setText(str5);
		textPane_11.setText(Bstr5);
	}
}
