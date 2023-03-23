package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DataAccessObj.ScoreDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.ScoreData;

public class ScoreDataMovieManageInterFrame extends JInternalFrame {

	private JTable scoreDataTable;
	
	private DbUtil dbUtil = new DbUtil();
	private ScoreDataDAO scoreDataDao = new ScoreDataDAO();
	private JTextField s_movieTitleTxt;
	private JTextField idTxt;
	private JTextField movieTitleTxt;
	private JTextField scoreTxt;
	private JTextField votesTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreDataMovieManageInterFrame frame = new ScoreDataMovieManageInterFrame();
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
	public ScoreDataMovieManageInterFrame() {
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Score Data Management");
		setBounds(100, 100, 609, 502);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Title: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		s_movieTitleTxt = new JTextField();
		s_movieTitleTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Search Movie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDataSearchActionPerformed(e);
			}
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Management Menu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_movieTitleTxt, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
					.addGap(62))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_movieTitleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("ID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Title: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		movieTitleTxt = new JTextField();
		movieTitleTxt.setEditable(false);
		movieTitleTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Score: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		scoreTxt = new JTextField();
		scoreTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDataUpdateActionEvent(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDataDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JLabel lblNewLabel_4 = new JLabel("votes: ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		votesTxt = new JTextField();
		votesTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scoreTxt)
								.addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(votesTxt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addComponent(movieTitleTxt, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(movieTitleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(scoreTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(votesTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		scoreDataTable = new JTable();
		scoreDataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ScoreDataTableMousePressed(e);
			}
		});
		scoreDataTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scoreDataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IMDBid", "Title", "Score", "votes"
			}
		));
		scoreDataTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		scrollPane.setViewportView(scoreDataTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new ScoreData(), "");
		this.setLocation(550, 235);
	}
	
	/**
	 * score data delete event handle
	 * @param e
	 */
	private void ScoreDataDeleteActionEvent(ActionEvent e) {
		String id = idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select data need to be modified!");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "Confirm Deletion?");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = scoreDataDao.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "Deletion Successed");
					this.resetValue();
					this.fillTable(new ScoreData(), "");
				} else {
					JOptionPane.showMessageDialog(null, "Deletion Failed");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Deletion Failed");
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void ScoreDataUpdateActionEvent(ActionEvent e) {
		String id = idTxt.getText();
		String score = scoreTxt.getText();
		String votes = votesTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select data need to be modified!");
			return;
		}
	
		if (StringUtil.isEmpty(score)) {
			JOptionPane.showMessageDialog(null, "Score Cannot be Empty!");
			return;
		}
		if (StringUtil.isEmpty(votes)) {
			JOptionPane.showMessageDialog(null, "votes Cannot be Empty!");
			return;
		}
		
		ScoreData scoreData = new ScoreData(id, Double.parseDouble(score), Integer.parseInt(votes));
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = scoreDataDao.updata(con, scoreData);
			if(modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "Modification Successed!");
				this.resetValue();
				this.fillTable(new ScoreData(), "");
			} else {
				JOptionPane.showMessageDialog(null, "Modification Failed!");
			}
		} catch (Exception e1){
			e1.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	/**
	 * mouse pressed event handle
	 * @param event
	 */
	private void ScoreDataTableMousePressed(MouseEvent event) {
		int row = scoreDataTable.getSelectedRow();
		idTxt.setText((String)scoreDataTable.getValueAt(row, 0));
		movieTitleTxt.setText((String)scoreDataTable.getValueAt(row, 1));
		scoreTxt.setText((String)scoreDataTable.getValueAt(row, 2));
		votesTxt.setText((String)scoreDataTable.getValueAt(row, 3));
	}

	/**
	 * score Title Search Event Handle
	 * @param event
	 */
	private void ScoreDataSearchActionPerformed(ActionEvent event) {

		String movieTitle = this.s_movieTitleTxt.getText();
		ScoreData scoreData = new ScoreData();
		this.fillTable(scoreData, movieTitle);
		
	}

	/**
	 * initialize score Table
	 * @param scoreData
	 */
	private void fillTable(ScoreData scoreData, String movieTitle) {
		DefaultTableModel dtm = (DefaultTableModel) scoreDataTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = scoreDataDao.list(con, scoreData, movieTitle);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("IMDBid"));
				v.add(rs.getString("Title"));
				v.add(rs.getString("Score"));
				v.add(rs.getString("votes"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void resetValue() {
		this.idTxt.setText("");
		this.movieTitleTxt.setText("");
		this.scoreTxt.setText("");
		this.votesTxt.setText("");
	}
}
