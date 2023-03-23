package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import DataAccessObj.ActorDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.ActorData;
import java.awt.event.ActionListener;

public class ActorDataAddInterFrame extends JInternalFrame {
	private JTextField ActorIDTxt;
	private JTextField ActorNameTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private ActorDataDAO actorDataDao = new ActorDataDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActorDataAddInterFrame frame = new ActorDataAddInterFrame();
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
	public ActorDataAddInterFrame() {
		setTitle("Add Actor Data");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("Actor ID: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Actor Name: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		ActorIDTxt = new JTextField();
		ActorIDTxt.setColumns(10);
		
		ActorNameTxt = new JTextField();
		ActorNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorDataAddActionPerformed(e);
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
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(ActorIDTxt, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addComponent(ActorNameTxt))))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ActorIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(ActorNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
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
	private void ActorDataAddActionPerformed(ActionEvent e) {
		
		String actorID = this.ActorIDTxt.getText();
		String actorTitle = this.ActorNameTxt.getText();
		if (StringUtil.isEmpty(actorID)) {
			JOptionPane.showMessageDialog(null, "actor ID Cannot Be Empty");
			return;
		}
		if (StringUtil.isEmpty(actorTitle)) {
			JOptionPane.showMessageDialog(null, "actor Title Cannot Be Empty");
			return;
		}
		ActorData actorData = new ActorData(actorID, actorTitle);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = actorDataDao.add(con, actorData);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "actor Data Successfully Add To Database!");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "actor Data Addition Failed!");
			}
		} catch(Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "actor Data Addition Failed!");
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
		this.ActorIDTxt.setText("");
		this.ActorNameTxt.setText("");
		
	}

}
