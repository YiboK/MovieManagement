package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Group3InterFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Group3InterFrame frame = new Group3InterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Group3InterFrame() {
		getContentPane().setBackground(Color.BLACK);
		setIconifiable(true);
		setClosable(true);
		setTitle("About Group 3");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("CS564 Group 3");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setForeground(Color.GREEN);
		
		JLabel lblNewLabel_1 = new JLabel("Jianbang Sun");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.GREEN);
		
		JLabel lblNewLabel_2 = new JLabel("Yibo Kong");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.GREEN);
		
		JLabel lblNewLabel_3 = new JLabel("Yuhan Zhang");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.GREEN);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addGap(44)
					.addComponent(lblNewLabel_2)
					.addGap(42)
					.addComponent(lblNewLabel_3)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocation(550, 235);
	}
}
