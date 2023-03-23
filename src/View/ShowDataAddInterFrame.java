package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import DataAccessObj.ShowDataDAO;
import DataAccessObj.ShowDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.ShowData;
import model.ShowData;

public class ShowDataAddInterFrame extends JInternalFrame {

	private JTextField showIDTxt;
	private JTextField showTitleTxt;
	private JTextArea showDescTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private ShowDataDAO showDataDao = new ShowDataDAO();
	private JTextField popularityTxt;
	private JTextField runtimeTxt;
	private JTextField yearTxt;
	private JTextField IMDBidTxt;
	private JTextField seasonTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowDataAddInterFrame frame = new ShowDataAddInterFrame();
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
	public ShowDataAddInterFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Show Data ");
		setBounds(100, 100, 664, 309);
		
		JLabel lblNewLabel = new JLabel("Show ID: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Show Title: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Description: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		showIDTxt = new JTextField();
		showIDTxt.setColumns(10);
		
		showTitleTxt = new JTextField();
		showTitleTxt.setColumns(10);
		
		showDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDataAddActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}			
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Year: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Runtime: ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_5 = new JLabel("Popularity: ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		popularityTxt = new JTextField();
		popularityTxt.setColumns(10);
		
		runtimeTxt = new JTextField();
		runtimeTxt.setColumns(10);
		
		yearTxt = new JTextField();
		yearTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("IMDBid: ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		IMDBidTxt = new JTextField();
		IMDBidTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Season: ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		seasonTxt = new JTextField();
		seasonTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(showTitleTxt, Alignment.LEADING)
								.addComponent(showDescTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(showIDTxt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGap(30)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(yearTxt, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
									.addComponent(runtimeTxt)))
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addGap(34))
									.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(IMDBidTxt, 153, 153, Short.MAX_VALUE)
									.addComponent(seasonTxt))
								.addComponent(popularityTxt, 153, 153, Short.MAX_VALUE))))
					.addGap(67))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(showIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(yearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(showTitleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(runtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(showDescTxt, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(IMDBidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6)))
						.addComponent(lblNewLabel_7)
						.addComponent(seasonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(200, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(popularityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocation(550, 235);
	}
	
	/**
	 * Show Data Add event
	 * @param e
	 */
	private void showDataAddActionPerformed(ActionEvent e) {
		
		String showID = this.showIDTxt.getText();
		String showTitle = this.showTitleTxt.getText();
		String showDesc = this.showDescTxt.getText();
		int year = Integer.parseInt(this.yearTxt.getText());
		int runtime = Integer.parseInt(this.runtimeTxt.getText());
		int season = Integer.parseInt(this.seasonTxt.getText());
		String IMDBid = this.IMDBidTxt.getText();
		double popularity = Double.parseDouble(this.popularityTxt.getText());
		
		if (StringUtil.isEmpty(showID)) {
			JOptionPane.showMessageDialog(null, "Show ID Cannot Be Empty");
			return;
		}
		if (StringUtil.isEmpty(showTitle)) {
			JOptionPane.showMessageDialog(null, "Show Title Cannot Be Empty");
			return;
		}
		ShowData showData = new ShowData(showID, showTitle, showDesc, year, runtime, season, IMDBid, popularity);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = showDataDao.add(con, showData);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "Show Data Successfully Add To Database!");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "Show Data Addition Failed!");
			}
		} catch(Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Show Data Addition Failed!");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * reset event handle
	 * @param event
	 */
	private void resetValueActionPerformed(ActionEvent event) {
		this.resetValue();
		
	}

	/**
	 * reset menu
	 */
	private void resetValue() {
		this.showIDTxt.setText("");
		this.showTitleTxt.setText("");
		this.showDescTxt.setText("");
		this.yearTxt.setText("");
		this.runtimeTxt.setText("");
		this.seasonTxt.setText("");
		this.IMDBidTxt.setText("");
		this.popularityTxt.setText("");		
	}

}
