package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DataAccessObj.ActorDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.ActorData;
import model.ScoreData;
import model.ShowData;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ActorDataManageInterFrame extends JInternalFrame {
	private JTextField s_actorNameTxt;
	private JTable ActorDataTable;
	private JTextField idTxt;
	private JTextField nameTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private ActorDataDAO actorDataDao = new ActorDataDAO();

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
	public ActorDataManageInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Actor Data Manage");
		setBounds(100, 100, 564, 452);
		
		JLabel lblNewLabel = new JLabel("Actor Name: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		s_actorNameTxt = new JTextField();
		s_actorNameTxt.setColumns(10);
		
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
							.addComponent(s_actorNameTxt, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
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
						.addComponent(s_actorNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("Actor ID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Name: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorDataUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
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
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(nameTxt)
						.addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		ActorDataTable = new JTable();
		ActorDataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ActorDataTableMousePressed(e);
			}
		});
		ActorDataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ActorID", "Actor Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ActorDataTable.getColumnModel().getColumn(0).setPreferredWidth(57);
		ActorDataTable.getColumnModel().getColumn(1).setPreferredWidth(265);
		scrollPane.setViewportView(ActorDataTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new ActorData());
		this.setLocation(550, 235);
	}
	
	private void ActorDataDeleteActionEvent(ActionEvent e) {
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
				int deleteNum = actorDataDao.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "Deletion Successed");
					this.resetValue();
					this.fillTable(new ActorData());
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

	private void ActorDataUpdateActionEvent(ActionEvent e) {
		String id = idTxt.getText();
		String actorName = nameTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select data need to be modified!");
			return;
		}
		
		if (StringUtil.isEmpty(actorName)) {
			JOptionPane.showMessageDialog(null, "Name Cannot be Empty!");
			return;
		}
		
		ActorData actorData = new ActorData(id, actorName);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = actorDataDao.updata(con, actorData);
			if(modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "Modification Successed!");
				this.resetValue();
				this.fillTable(new ActorData());
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
	private void ActorDataTableMousePressed(MouseEvent event) {
		int row = ActorDataTable.getSelectedRow();
		idTxt.setText((String)ActorDataTable.getValueAt(row, 0));
		nameTxt.setText((String)ActorDataTable.getValueAt(row, 1));
	}

	/**
	 * Show Title Search Event Handle
	 * @param event
	 */
	private void ActorDataSearchActionPerformed(ActionEvent event) {

		String s_actorName = this.s_actorNameTxt.getText();
		ActorData actorData = new ActorData();
		actorData.setActorID(s_actorName);
		this.fillTable(actorData);
	}

	/**
	 * initialize Show Table
	 * @param ShowData
	 */
	private void fillTable(ActorData actorData) {
		DefaultTableModel dtm = (DefaultTableModel) ActorDataTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = actorDataDao.list(con, actorData);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("personid"));
				v.add(rs.getString("name"));
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
		this.nameTxt.setText("");
	}
}
