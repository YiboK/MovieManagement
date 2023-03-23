package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Util.DbUtil;
import Util.StringUtil;

public class MainLeftFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane = null;
	private JTable roleMovieTable;
	private JTextField topMovieTxt;
	private DbUtil dbUtil = new DbUtil();
	private JTable roleShowTable;
	private JTextField topShowTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainLeftFrame() {
		setAutoRequestFocus(false);
		setTitle("IMDB Manage Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1550, 850);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Basic Data Manage");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("IMDB Movie Data Manage");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Movie Data");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieDataAddInterFrame movieDataAddInterFrame = new MovieDataAddInterFrame();
				movieDataAddInterFrame.setVisible(true);
				desktopPane.add(movieDataAddInterFrame);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Manage Movie Data ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieDataManageInterFrame movieDataManageInterFrame = new MovieDataManageInterFrame();
				movieDataManageInterFrame.setVisible(true);
				desktopPane.add(movieDataManageInterFrame);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("IMDB TV Show Data Manage");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add TV Show Data");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowDataAddInterFrame showDataAddInterFrame = new ShowDataAddInterFrame();
				showDataAddInterFrame.setVisible(true);
				desktopPane.add(showDataAddInterFrame);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Manage TV Show Data ");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowDataManageInterFrame showDataManageInterFrame = new ShowDataManageInterFrame();
				showDataManageInterFrame.setVisible(true);
				desktopPane.add(showDataManageInterFrame);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Exit");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Exit Manager System?");
				if (result == 0) {
					dispose();
				}
			}
		});
		
		JMenu mnNewMenu_4 = new JMenu("IMDB Actor Data Manage");
		mnNewMenu.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Add Actor Data");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorDataAddInterFrame actorDataAddInterFrame = new ActorDataAddInterFrame();
				actorDataAddInterFrame.setVisible(true);
				desktopPane.add(actorDataAddInterFrame);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Manage Actor Data");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorDataManageInterFrame actorDataManageInterFrame = new ActorDataManageInterFrame();
				actorDataManageInterFrame.setVisible(true);
				desktopPane.add(actorDataManageInterFrame);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_5 = new JMenu("IMDB Score Manage");
		mnNewMenu.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Add Score");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDataAddInterFrame scoreDataAddInterFrame = new ScoreDataAddInterFrame();
				scoreDataAddInterFrame.setVisible(true);
				desktopPane.add(scoreDataAddInterFrame);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Manage Movie Score");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDataMovieManageInterFrame scoreDataMovieManageInterFrame = new ScoreDataMovieManageInterFrame();
				scoreDataMovieManageInterFrame.setVisible(true);
				desktopPane.add(scoreDataMovieManageInterFrame);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Manage Show Score");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDataShowManageInterFrame scoreDataShowManageInterFrame = new ScoreDataShowManageInterFrame();
				scoreDataShowManageInterFrame.setVisible(true);
				desktopPane.add(scoreDataShowManageInterFrame);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_6 = new JMenu("IMDB Relation Manage");
		mnNewMenu.add(mnNewMenu_6);
		
		JMenu mnNewMenu_7 = new JMenu("Manage Movie-Score");
		mnNewMenu_6.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Add Movie-Score Relation");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HasMDataAddInterFrame hasMDataAddInterFrame = new HasMDataAddInterFrame();
				hasMDataAddInterFrame.setVisible(true);
				desktopPane.add(hasMDataAddInterFrame);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Delete Movie-Score Relation");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HasMDataManageInterFrame hasMDataManageInterFrame = new HasMDataManageInterFrame();
				hasMDataManageInterFrame.setVisible(true);
				desktopPane.add(hasMDataManageInterFrame);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_8 = new JMenu("Manage Show-Score");
		mnNewMenu_6.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Add Show-Score Relation");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HasTDataAddInterFrame hasTDataAddInterFrame = new HasTDataAddInterFrame();
				hasTDataAddInterFrame.setVisible(true);
				desktopPane.add(hasTDataAddInterFrame);
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Delete Show-Score Relation");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HasTDataManageInterFrame hasTDataManageInterFrame = new HasTDataManageInterFrame();
				hasTDataManageInterFrame.setVisible(true);
				desktopPane.add(hasTDataManageInterFrame);
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_14);
		
		JMenu mnNewMenu_9 = new JMenu("Manage Actor-Movie");
		mnNewMenu_6.add(mnNewMenu_9);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Add Actor-Movie Relation");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActMDataAddInterFrame actMDataAddInterFrame = new ActMDataAddInterFrame();
				actMDataAddInterFrame.setVisible(true);
				desktopPane.add(actMDataAddInterFrame);
			}
		});
		mnNewMenu_9.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Delete Actor-Movie Relation");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActMDataManageInterFrame actMDataManageInterFrame = new ActMDataManageInterFrame();
				actMDataManageInterFrame.setVisible(true);
				desktopPane.add(actMDataManageInterFrame);
			}
		});
		mnNewMenu_9.add(mntmNewMenuItem_16);
		
		JMenu mnNewMenu_10 = new JMenu("Manage Actor-Show");
		mnNewMenu_6.add(mnNewMenu_10);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Add Actor-Show Relation");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActTDataAddInterFrame actTDataAddInterFrame = new ActTDataAddInterFrame();
				actTDataAddInterFrame.setVisible(true);
				desktopPane.add(actTDataAddInterFrame);
			}
		});
		mnNewMenu_10.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Delete Actor-Show Relation");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActTDataManageInterFrame actTDataManageInterFrame = new ActTDataManageInterFrame();
				actTDataManageInterFrame.setVisible(true);
				desktopPane.add(actTDataManageInterFrame);
			}
		});
		mnNewMenu_10.add(mntmNewMenuItem_18);
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("About us");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About Group 3");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Group3InterFrame group3InterFrame = new Group3InterFrame();
				group3InterFrame.setVisible(true);
				desktopPane.add(group3InterFrame);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 230, 428, 462);
		desktopPane.add(scrollPane);
		
		roleMovieTable = new JTable();
		roleMovieTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Title", "Character Name"
			}
		));
		roleMovieTable.getColumnModel().getColumn(0).setPreferredWidth(146);
		roleMovieTable.getColumnModel().getColumn(1).setPreferredWidth(147);
		roleMovieTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(roleMovieTable);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO IMDB MANAGEMENT SYSTEM!");
		lblNewLabel.setFont(new Font("Bodoni MT Condensed", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(500, 64, 540, 56);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Look Up Roles ");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblNewLabel_1.setBounds(68, 185, 124, 20);
		desktopPane.add(lblNewLabel_1);
		
		topMovieTxt = new JTextField();
		topMovieTxt.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		topMovieTxt.setBounds(190, 185, 80, 20);
		desktopPane.add(topMovieTxt);
		topMovieTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Played in Movie!");
		lblNewLabel_2.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblNewLabel_2.setBounds(280, 185, 140, 20);
		desktopPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Search!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoleMovieUpdateActionEvent(e);
			}
		});
		btnNewButton.setFont(new Font("Baskerville Old Face", Font.ITALIC, 16));
		btnNewButton.setBounds(416, 185, 80, 23);
		desktopPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1026, 230, 428, 462);
		desktopPane.add(scrollPane_1);
		
		roleShowTable = new JTable();
		roleShowTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Title", "Character Name"
			}
		));
		roleShowTable.getColumnModel().getColumn(0).setPreferredWidth(160);
		roleShowTable.getColumnModel().getColumn(1).setPreferredWidth(152);
		roleShowTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane_1.setViewportView(roleShowTable);
		
		JLabel lblNewLabel_1_1 = new JLabel("Look Up Roles ");
		lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(1026, 189, 140, 20);
		desktopPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Played in Show!");
		lblNewLabel_2_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(1229, 185, 135, 20);
		desktopPane.add(lblNewLabel_2_1);
		
		topShowTxt = new JTextField();
		topShowTxt.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		topShowTxt.setBounds(1153, 186, 66, 21);
		desktopPane.add(topShowTxt);
		topShowTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoleShowUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setFont(new Font("Baskerville Old Face", Font.ITALIC, 16));
		btnNewButton_1.setBounds(1374, 185, 80, 23);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Find Top Movie/Show");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainFrame().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Arial Black", Font.ITALIC, 18));
		btnNewButton_2.setBounds(1192, 722, 262, 23);
		desktopPane.add(btnNewButton_2);
		
		this.setLocationRelativeTo(null);
		

	}

	private void RoleShowUpdateActionEvent(ActionEvent e) {
		String roleShow = topShowTxt.getText();
		if (StringUtil.isEmpty(roleShow)) {
			JOptionPane.showMessageDialog(null, "Please Enter The PersonID of Any Actor!");
			return;
		} else {
			fillTableShow(roleShow);
		}
		
	}

	private void RoleMovieUpdateActionEvent(ActionEvent e) {
		String roleMovie = topMovieTxt.getText();
		if (StringUtil.isEmpty(roleMovie)) {
			JOptionPane.showMessageDialog(null, "Please Enter The PersonID of Any Actor!");
			return;
		} else {
			fillTableMovie(roleMovie);
		}
		
	}
	
	private void fillTableMovie(String PersonID) {
		DefaultTableModel dtm = (DefaultTableModel) roleMovieTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			StringBuffer sb = new StringBuffer("call newimdb.getActorCharacterM(" + PersonID + ")");
			PreparedStatement pstat = con.prepareStatement(sb.toString());
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("title"));
				v.add(rs.getString("cnameM"));
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
	
	private void fillTableShow(String PersonID) {
		DefaultTableModel dtm = (DefaultTableModel) roleShowTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			StringBuffer sb = new StringBuffer("call newimdb.getActorCharacterT(" + PersonID + ")");
			PreparedStatement pstat = con.prepareStatement(sb.toString());
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("title"));
				v.add(rs.getString("cnameT"));
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
}
