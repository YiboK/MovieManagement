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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DataAccessObj.MovieDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.MovieData;

public class MovieDataManageInterFrame extends JInternalFrame {
	private JTable movieDataTable;
	
	private DbUtil dbUtil = new DbUtil();
	private MovieDataDAO movieDataDao = new MovieDataDAO();
	private JTextField s_movieTitleTxt;
	private JTextField idTxt;
	private JTextField movieTitleTxt;
	private JTextField movieDescTxt;
	private JTextField yearTxt;
	private JTextField IMDBidTxt;
	private JTextField popularityTxt;
	private JTextField runtimeTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieDataManageInterFrame frame = new MovieDataManageInterFrame();
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
	public MovieDataManageInterFrame() {
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Movie Data Management");
		setBounds(100, 100, 782, 531);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Movie Title: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		s_movieTitleTxt = new JTextField();
		s_movieTitleTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movieDataSearchActionPerformed(e);
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
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 626, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_movieTitleTxt, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
					.addGap(70))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_movieTitleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("ID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Title: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		movieTitleTxt = new JTextField();
		movieTitleTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Description: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		movieDescTxt = new JTextField();
		movieDescTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movieDataUpdateActionEvent(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movieDataDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Year: ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel lblNewLabel_5 = new JLabel("IMDBid: ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		yearTxt = new JTextField();
		yearTxt.setColumns(10);
		
		IMDBidTxt = new JTextField();
		IMDBidTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Runtime: ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel lblNewLabel_7 = new JLabel("Popularity: ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		popularityTxt = new JTextField();
		popularityTxt.setColumns(10);
		
		runtimeTxt = new JTextField();
		runtimeTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(yearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(runtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(IMDBidTxt)
									.addComponent(movieTitleTxt, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
								.addComponent(popularityTxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addComponent(movieDescTxt, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
							.addGap(51))
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
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(IMDBidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(yearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(popularityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6)
								.addComponent(runtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(movieDescTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)))
		);
		panel.setLayout(gl_panel);
		
		movieDataTable = new JTable();
		movieDataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				movieDataTableMousePressed(e);
			}
		});
		movieDataTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		movieDataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MovieID", "Movie Tilte", "Description", "Year", "Runtime", "IMDBid", "Popularity"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		movieDataTable.getColumnModel().getColumn(0).setPreferredWidth(61);
		movieDataTable.getColumnModel().getColumn(1).setPreferredWidth(96);
		movieDataTable.getColumnModel().getColumn(2).setPreferredWidth(157);
		movieDataTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		movieDataTable.getColumnModel().getColumn(4).setPreferredWidth(59);
		movieDataTable.getColumnModel().getColumn(5).setPreferredWidth(64);
		movieDataTable.getColumnModel().getColumn(6).setPreferredWidth(74);
		scrollPane.setViewportView(movieDataTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new MovieData());
		this.setLocation(500, 235);
	}
	
	/**
	 * movie data delete event handle
	 * @param e
	 */
	private void movieDataDeleteActionEvent(ActionEvent e) {
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
				int deleteNum = movieDataDao.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "Deletion Successed");
					this.resetValue();
					this.fillTable(new MovieData());
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

	private void movieDataUpdateActionEvent(ActionEvent e) {
		String id = idTxt.getText();
		String movieTitle = movieTitleTxt.getText();
		String movieDesc = movieDescTxt.getText();
		int year = Integer.parseInt(yearTxt.getText());
		int runtime = Integer.parseInt(runtimeTxt.getText());
		String IMDBid = IMDBidTxt.getText();
		Double popularity = Double.parseDouble(popularityTxt.getText());

		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select data need to be modified!");
			return;
		}
		
		if (StringUtil.isEmpty(movieTitle)) {
			JOptionPane.showMessageDialog(null, "Movie Title Cannot be Empty!");
			return;
		}
		
		MovieData movieData = new MovieData(id, movieTitle, movieDesc, year, runtime, IMDBid, popularity);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = movieDataDao.updata(con, movieData);
			if(modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "Modification Successed!");
				this.resetValue();
				this.fillTable(new MovieData());
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
	private void movieDataTableMousePressed(MouseEvent event) {
		int row = movieDataTable.getSelectedRow();
		idTxt.setText((String)movieDataTable.getValueAt(row, 0));
		movieTitleTxt.setText((String)movieDataTable.getValueAt(row, 1));
		movieDescTxt.setText((String)movieDataTable.getValueAt(row, 2));
		yearTxt.setText(String.valueOf(movieDataTable.getValueAt(row, 3)));
		runtimeTxt.setText(String.valueOf(movieDataTable.getValueAt(row, 4)));
		IMDBidTxt.setText((String)movieDataTable.getValueAt(row, 5));
		popularityTxt.setText(String.valueOf(movieDataTable.getValueAt(row, 6)));

	}

	/**
	 * Movie Title Search Event Handle
	 * @param event
	 */
	private void movieDataSearchActionPerformed(ActionEvent event) {

		String s_movieTitle = this.s_movieTitleTxt.getText();
		MovieData movieData = new MovieData();
		movieData.setMovieTitle(s_movieTitle);
		this.fillTable(movieData);
	}

	/**
	 * initialize Movie Table
	 * @param movieData
	 */
	private void fillTable(MovieData movieData) {
		DefaultTableModel dtm = (DefaultTableModel) movieDataTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = movieDataDao.list(con, movieData);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("MovieID"));
				v.add(rs.getString("title"));
				v.add(rs.getString("Description"));
				v.add(rs.getInt("year"));
				v.add(rs.getInt("runtime"));
				v.add(rs.getString("IMDBid"));
				v.add(rs.getDouble("popularity"));

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
		this.movieDescTxt.setText("");
		this.yearTxt.setText("");
		this.runtimeTxt.setText("");
		this.IMDBidTxt.setText("");
		this.popularityTxt.setText("");

	}
}
