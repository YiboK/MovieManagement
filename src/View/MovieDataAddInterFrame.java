package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import DataAccessObj.MovieDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.MovieData;

public class MovieDataAddInterFrame extends JInternalFrame {
	private JTextField movieIDTxt;
	private JTextField movieTitleTxt;
	private JTextArea movieDescTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private MovieDataDAO movieDataDao = new MovieDataDAO();
	private JTextField popularityTxt;
	private JTextField runtimeTxt;
	private JTextField yearTxt;
	private JTextField IMDBidTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieDataAddInterFrame frame = new MovieDataAddInterFrame();
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
	public MovieDataAddInterFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Movie Data ");
		setBounds(100, 100, 664, 309);
		
		JLabel lblNewLabel = new JLabel("Movie ID: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Movie Title: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Description: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		movieIDTxt = new JTextField();
		movieIDTxt.setColumns(10);
		
		movieTitleTxt = new JTextField();
		movieTitleTxt.setColumns(10);
		
		movieDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movieDataAddActionPerformed(e);
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
								.addComponent(movieTitleTxt, Alignment.LEADING)
								.addComponent(movieDescTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(movieIDTxt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
											.addGap(30))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(yearTxt, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
											.addComponent(runtimeTxt))
										.addComponent(IMDBidTxt)))
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGap(159))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(18)
							.addComponent(popularityTxt, 153, 153, 153)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(movieIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(yearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(movieTitleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(runtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(movieDescTxt, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(IMDBidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(popularityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocation(550, 235);
	}
	
	/**
	 * Movie Data Add event
	 * @param e
	 */
	private void movieDataAddActionPerformed(ActionEvent e) {
		
		String movieID = this.movieIDTxt.getText();
		String movieTitle = this.movieTitleTxt.getText();
		String movieDesc = this.movieDescTxt.getText();
		int year = Integer.parseInt(this.yearTxt.getText());
		int runtime = Integer.parseInt(this.runtimeTxt.getText());
		String IMDBid = this.IMDBidTxt.getText();
		double popularity = Double.parseDouble(this.popularityTxt.getText());
		
		if (StringUtil.isEmpty(movieID)) {
			JOptionPane.showMessageDialog(null, "Movie ID Cannot Be Empty");
			return;
		}
		if (StringUtil.isEmpty(movieTitle)) {
			JOptionPane.showMessageDialog(null, "Movie Title Cannot Be Empty");
			return;
		}
		MovieData movieData = new MovieData(movieID, movieTitle, movieDesc, year, runtime, IMDBid, popularity);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = movieDataDao.add(con, movieData);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "Movie Data Successfully Add To Database!");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "Movie Data Addition Failed!");
			}
		} catch(Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Movie Data Addition Failed!");
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
		this.movieIDTxt.setText("");
		this.movieTitleTxt.setText("");
		this.movieDescTxt.setText("");
		this.yearTxt.setText("");
		this.runtimeTxt.setText("");
		this.IMDBidTxt.setText("");
		this.popularityTxt.setText("");		
	}
}
