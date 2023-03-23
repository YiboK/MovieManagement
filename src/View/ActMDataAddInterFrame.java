package View;

import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import DataAccessObj.ActMDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.ActMData;

public class ActMDataAddInterFrame extends JInternalFrame {

	private JTextField actorIDTxt;
	private JTextField movieIDTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private ActMDataDAO actMDataDao = new ActMDataDAO();
	private JTextField cnameMTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActMDataAddInterFrame frame = new ActMDataAddInterFrame();
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
	public ActMDataAddInterFrame() {
		setRootPaneCheckingEnabled(false);
		setTitle("Add Actor-Movie Relation");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 414, 300);
		
		JLabel lblNewLabel = new JLabel("Actor ID: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Movie ID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		actorIDTxt = new JTextField();
		actorIDTxt.setColumns(10);
		
		movieIDTxt = new JTextField();
		movieIDTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actMDataAddActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Character: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		cnameMTxt = new JTextField();
		cnameMTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(movieIDTxt)
										.addComponent(cnameMTxt, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
										.addComponent(actorIDTxt, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addContainerGap(105, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(actorIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(movieIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(cnameMTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(45))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocation(550, 235);
	}
	
	/**
	 * actor Data Add event
	 * @param e
	 */
	private void actMDataAddActionPerformed(ActionEvent e) {
		
		String actorID = this.actorIDTxt.getText();
		String movieID = this.movieIDTxt.getText();
		String cnameM = this.cnameMTxt.getText();
		if (StringUtil.isEmpty(actorID)) {
			JOptionPane.showMessageDialog(null, "ActorID Cannot Be Empty");
			return;
		}
		if (StringUtil.isEmpty(movieID)) {
			JOptionPane.showMessageDialog(null, "MovieID Cannot Be Empty");
			return;
		}
		if (StringUtil.isEmpty(cnameM)) {
			JOptionPane.showMessageDialog(null, "Character Cannot Be Empty");
			return;
		}
		
		ActMData actMData = new ActMData(actorID, movieID, cnameM);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = actMDataDao.add(con, actMData);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "Actor-Movie Relation Successfully Add To Database!");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "Actor-Movie Relation Addition Failed!");
			}
		} catch(Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Actor-Movie Relation Addition Failed!");
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
		this.actorIDTxt.setText("");
		this.movieIDTxt.setText("");
		this.cnameMTxt.setText("");
		
	}

}
