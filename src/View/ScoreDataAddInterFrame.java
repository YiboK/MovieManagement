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

import DataAccessObj.ScoreDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.ScoreData;

public class ScoreDataAddInterFrame extends JInternalFrame {

	private JTextField IMDBidTxt;
	private JTextField scoreTxt;
	private JTextArea votesTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private ScoreDataDAO scoreDataDao = new ScoreDataDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreDataAddInterFrame frame = new ScoreDataAddInterFrame();
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
	public ScoreDataAddInterFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add score Data ");
		setBounds(100, 100, 450, 272);
		
		JLabel lblNewLabel = new JLabel("Score ID: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Score: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("votes: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		IMDBidTxt = new JTextField();
		IMDBidTxt.setColumns(10);
		
		scoreTxt = new JTextField();
		scoreTxt.setColumns(10);
		
		votesTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDataAddActionPerformed(e);
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(votesTxt, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(IMDBidTxt)
											.addComponent(scoreTxt, 193, 193, Short.MAX_VALUE))))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(78)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(8)))
							.addGap(102))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(IMDBidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(scoreTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(votesTxt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocation(550, 235);
	}
	
	/**
	 * score Data Add event
	 * @param e
	 */
	private void ScoreDataAddActionPerformed(ActionEvent e) {
		
		String IMDBid = this.IMDBidTxt.getText();
		String scoreTemp = this.scoreTxt.getText();
		String votesTemp = this.votesTxt.getText();
		if (StringUtil.isEmpty(IMDBid)) {
			JOptionPane.showMessageDialog(null, "score ID Cannot Be Empty");
			return;
		}
		if (StringUtil.isEmpty(scoreTemp)) {
			JOptionPane.showMessageDialog(null, "score Cannot Be Empty");
			return;
		}
		if (StringUtil.isEmpty(votesTemp)) {
			JOptionPane.showMessageDialog(null, "votes Cannot Be Empty");
			return;
		}
		
		double score = Double.parseDouble(scoreTemp);
		int votes = Integer.parseInt(votesTemp);
		
		ScoreData scoreData = new ScoreData(IMDBid, score, votes);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = scoreDataDao.add(con, scoreData);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "score Data Successfully Add To Database!");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "score Data Addition Failed!");
			}
		} catch(Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "score Data Addition Failed!");
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
		this.IMDBidTxt.setText("");
		this.scoreTxt.setText("");
		this.votesTxt.setText("");
		
	}
}
