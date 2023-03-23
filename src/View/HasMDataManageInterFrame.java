package View;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DataAccessObj.HasMDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.HasMData;

public class HasMDataManageInterFrame extends JInternalFrame {

	private JTextField s_MovieIDTxt;
	private JTable HasMDataTable;
	private JTextField MovieIDTxt;
	private JTextField ScoreIDTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private HasMDataDAO hasMDataDAO = new HasMDataDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActorDataManageInterFrame frame = new ActorDataManageInterFrame();
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
	public HasMDataManageInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Actor Data Manage");
		setBounds(100, 100, 564, 452);
		
		JLabel lblNewLabel = new JLabel("MovieID: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		s_MovieIDTxt = new JTextField();
		s_MovieIDTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorDataSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Management Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_MovieIDTxt, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addGap(59))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_MovieIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("MovieID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("ScoreID:  ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		MovieIDTxt = new JTextField();
		MovieIDTxt.setEditable(false);
		MovieIDTxt.setColumns(10);
		
		ScoreIDTxt = new JTextField();
		ScoreIDTxt.setEditable(false);
		ScoreIDTxt.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorDataDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ScoreIDTxt)
						.addComponent(MovieIDTxt, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(MovieIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(ScoreIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		HasMDataTable = new JTable();
		HasMDataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ActorDataTableMousePressed(e);
			}
		});
		HasMDataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MovieID", "ScoreID"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		HasMDataTable.getColumnModel().getColumn(0).setPreferredWidth(186);
		HasMDataTable.getColumnModel().getColumn(1).setPreferredWidth(221);
		scrollPane.setViewportView(HasMDataTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new HasMData());
		this.setLocation(550, 235);
	}
	
	private void ActorDataDeleteActionEvent(ActionEvent e) {
		String id = MovieIDTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select data need to be modified!");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "Confirm Deletion?");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = hasMDataDAO.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "Deletion Successed");
					this.resetValue();
					this.fillTable(new HasMData());
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

	/**
	 * mouse pressed event handle
	 * @param event
	 */
	private void ActorDataTableMousePressed(MouseEvent event) {
		int row = HasMDataTable.getSelectedRow();
		MovieIDTxt.setText((String)HasMDataTable.getValueAt(row, 0));
		ScoreIDTxt.setText((String)HasMDataTable.getValueAt(row, 1));
	}

	/**
	 * Show Title Search Event Handle
	 * @param event
	 */
	private void ActorDataSearchActionPerformed(ActionEvent event) {

		String s_MovieID = this.s_MovieIDTxt.getText();
		HasMData hasMData = new HasMData();
		hasMData.setMovieID(s_MovieID);
		this.fillTable(hasMData);
	}

	/**
	 * initialize Show Table
	 * @param ShowData
	 */
	private void fillTable(HasMData actorData) {
		DefaultTableModel dtm = (DefaultTableModel) HasMDataTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = hasMDataDAO.list(con, actorData);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("MovieID"));
				v.add(rs.getString("IMDBid"));
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
		this.MovieIDTxt.setText("");
		this.ScoreIDTxt.setText("");
	}
}
