package com.wxy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.wxy.dao.TeacherDao;
import com.wxy.model.Teacher;
import com.wxy.utill.StringUtill;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;

public class ManageTeacherFrm extends JFrame {
	private JTextField searchTeacherNameTextField;
	private JTable teacherListTable;
	private JTextField editTeacherNameTextField;
	private JTextField editTeacherTitleTextField;
	private JTextField editTeacherPasswordTextField;
	private JTextField editTeacherAgeTextField;
	private JRadioButton editTeacherSexManJRadioButton;
	private JRadioButton editTeacherSexManJRadioButton_1;
	private JRadioButton editTeacherSexFemalJRadioButton;
	private JRadioButton editTeacherSexFemalJRadioButton_1;
	private JButton deleteTeacherButton;
	private JButton searchTeacherButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTeacherFrm frame = new ManageTeacherFrm();
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
	public ManageTeacherFrm() {
		
		setTitle("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 853, 591);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/image/\u8001\u5E08.png")));
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		searchTeacherNameTextField = new JTextField();
		searchTeacherNameTextField.setColumns(10);
		
		searchTeacherButton = new JButton("\u67E5\u8BE2");
		searchTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchTeacher(e);
			}
		});
		searchTeacherButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/image/\u641C\u7D22.png")));
		searchTeacherButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		teacherListTable = new JTable();
		teacherListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6559\u5E08ID", "\u6559\u5E08\u59D3\u540D", "\u6559\u5E08\u6027\u522B", "\u6559\u5E08\u804C\u79F0", "\u6559\u5E08\u5E74\u9F84", "\u767B\u5F55\u5BC6\u7801"
			}
		));
		teacherListTable.getColumnModel().getColumn(3).setResizable(false);
		teacherListTable.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(teacherListTable);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u6559\u5E08\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(223)
							.addComponent(lblNewLabel)
							.addGap(10)
							.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(searchTeacherButton))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))))
					.addGap(35))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(searchTeacherButton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/image/\u8001\u5E08.png")));
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		editTeacherNameTextField = new JTextField();
		editTeacherNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lblNewLabel_2.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/image/\u804C\u79F0.png")));
		
		ButtonGroup buttonGroup = new ButtonGroup(); 
		editTeacherSexManJRadioButton = new JRadioButton("\u7537");
		editTeacherSexManJRadioButton.setSelected(true);
		
		editTeacherSexFemalJRadioButton = new JRadioButton("\u5973");
		buttonGroup.add(editTeacherSexManJRadioButton);
		buttonGroup.add(editTeacherSexFemalJRadioButton);
		
		editTeacherTitleTextField = new JTextField();
		editTeacherTitleTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/image/\u5BC6\u7801.png")));
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		editTeacherPasswordTextField = new JTextField();
		editTeacherPasswordTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lblNewLabel_4.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/image/\u6027\u522B.png")));
		
		editTeacherSexManJRadioButton_1 = new JRadioButton("\u7537");
		editTeacherSexManJRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editTeacherSexManJRadioButton_1.setSelected(true);
				editTeacherSexFemalJRadioButton.setSelected(false);
			}
		});
	
		editTeacherSexManJRadioButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		editTeacherSexFemalJRadioButton_1 = new JRadioButton("\u5973");
		editTeacherSexFemalJRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editTeacherSexManJRadioButton_1.setSelected(false);
				editTeacherSexFemalJRadioButton.setSelected(true);
			}
		});
		editTeacherSexFemalJRadioButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		lblNewLabel_5.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/image/\u5E74\u9F84.png")));
		lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		editTeacherAgeTextField = new JTextField();
		editTeacherAgeTextField.setColumns(10);
		
		JButton editTeacheSubmitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		editTeacheSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editTeacherAct(e);
			}
		});
		editTeacheSubmitButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/image/\u786E\u8BA4 .png")));
		editTeacheSubmitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		deleteTeacherButton = new JButton("\u5220\u9664\u4FE1\u606F");
		deleteTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTeacher(e);
			}
		});
		deleteTeacherButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		deleteTeacherButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/image/\u5220\u9664.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(editTeacherPasswordTextField)
						.addComponent(editTeacherTitleTextField)
						.addComponent(editTeacherNameTextField, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
					.addGap(146)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherSexManJRadioButton_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(editTeacherSexFemalJRadioButton_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(editTeacheSubmitButton)
							.addGap(18)
							.addComponent(deleteTeacherButton)
							.addGap(43)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(editTeacherSexManJRadioButton_1)
						.addComponent(editTeacherSexFemalJRadioButton_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(editTeacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(editTeacherPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(editTeacheSubmitButton)
								.addComponent(deleteTeacherButton))))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		teacherListTable = new JTable();
		teacherListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		teacherListTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u6559\u5E08ID", "\u6559\u5E08\u59D3\u540D", "\u6559\u5E08\u6027\u522B", "\u6559\u5E08\u804C\u79F0", "\u6559\u5E08\u5E74\u9F84", "\u767B\u5F55\u5BC6\u7801"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(teacherListTable);
			getContentPane().setLayout(groupLayout);
			setTable(new Teacher());
			setAuthority();
		}
		protected void editTeacherAct(ActionEvent ae) {
			// TODO Auto-generated method stub
			int row = teacherListTable.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(this, "ÇëÑ¡ÔñÒªÐÞ¸ÄµÄÊý¾Ý£¡");
				return;
			}
			String teacherName = editTeacherNameTextField.getText();
			String teacherSex = editTeacherSexManJRadioButton_1.isSelected() ? editTeacherSexManJRadioButton_1.getText() : editTeacherSexFemalJRadioButton_1.getText();
			String teacherTitle = editTeacherTitleTextField.getText().toString();
			int teacherAge = 0;
			try {
				teacherAge = Integer.parseInt(editTeacherAgeTextField.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "½ÌÊ¦ÄêÁä±ØÐëÊý×Ö£¡");
			}
			String teacherPassword = editTeacherPasswordTextField.getText();
			if(StringUtill.isEmpty(teacherName)){
				JOptionPane.showMessageDialog(this, "½ÌÊ¦ÐÕÃû±ØÐëÌîÐ´£¡");
				return;
			}
			if(StringUtill.isEmpty(teacherTitle)){
				JOptionPane.showMessageDialog(this, "½ÌÊ¦Ö°³Æ±ØÐëÌîÐ´£¡");
				return;
			}
			if(teacherAge == 0 || teacherAge < 0){
				JOptionPane.showMessageDialog(this, "½ÌÊ¦ÄêÁä±ØÐë´óÓÚ0£¡");
				return;
			}
			if(StringUtill.isEmpty(teacherPassword)){
				JOptionPane.showMessageDialog(this, "½ÌÊ¦µÇÂ¼ÃÜÂë±ØÐëÌîÐ´£¡");
				return;
			}
			Teacher teacher = new Teacher();
			teacher.setId(Integer.parseInt(teacherListTable.getValueAt(row, 0).toString()));
			teacher.setName(teacherName);
			teacher.setSex(teacherSex);
			teacher.setTitle(teacherTitle);
			teacher.setAge(teacherAge);
			teacher.setPassword(teacherPassword);
			TeacherDao teacherDao = new TeacherDao();
			if(teacherDao.update(teacher)){
				JOptionPane.showMessageDialog(this, "ÐÞ¸Ä³É¹¦£¡");
			}else{
				JOptionPane.showMessageDialog(this, "ÐÞ¸ÄÊ§°Ü£¡");
			}
			setTable(new Teacher());
		}

		protected void searchTeacher(ActionEvent e) {
			// TODO Auto-generated method stub
			String teacherNameString = searchTeacherNameTextField.getText().toString();
			Teacher teacher = new Teacher();
			teacher.setName(teacherNameString);
			setTable(teacher);
		}

		protected void deleteTeacher(ActionEvent ae) {
			// TODO Auto-generated method stub
			int row = teacherListTable.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(this, "ÇëÑ¡ÔñÒªÉ¾³ýµÄÊý¾Ý£¡");
				return;
			}
			if(JOptionPane.showConfirmDialog(this, "È·¶¨ÒªÉ¾³ýÃ´£¿") != JOptionPane.OK_OPTION)return;
			int id = Integer.parseInt(teacherListTable.getValueAt(row, 0).toString());
			TeacherDao teacherDao = new TeacherDao();
			if(teacherDao.delete(id)){
				JOptionPane.showMessageDialog(this, "É¾³ý³É¹¦£¡");
			}else{
				JOptionPane.showMessageDialog(this, "É¾³ýÊ§°Ü£¡");
			}
			setTable(new Teacher());
		}

		private void setTable(Teacher teacher){
			if("½ÌÊ¦".equals(MainFrm.userType.getName())){
				Teacher tLogined = (Teacher) MainFrm.userObject;
				teacher.setName(tLogined.getName());
				searchTeacherNameTextField.setText(teacher.getName());
			}
			DefaultTableModel dft = (DefaultTableModel) teacherListTable.getModel();
			dft.setRowCount(0);
			TeacherDao teacherDao = new TeacherDao();
			List<Teacher> teacherList = teacherDao.getTeacherList(teacher);
			for (Teacher t : teacherList) {
				Vector v = new Vector();
				v.add(t.getId());
				v.add(t.getName());
				v.add(t.getSex());
				v.add(t.getTitle());
				v.add(t.getAge());
				v.add(t.getPassword());
				dft.addRow(v);
			}
		}
		protected void selectedTableRow(MouseEvent me) {
			// TODO Auto-generated method stub
			DefaultTableModel dft = (DefaultTableModel) teacherListTable.getModel();
			editTeacherNameTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 1).toString());
			editTeacherTitleTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 3).toString());
			editTeacherAgeTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 4).toString());
			editTeacherPasswordTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 5).toString());
			String sex = dft.getValueAt(teacherListTable.getSelectedRow(), 2).toString();
			if(sex.equals(editTeacherSexManJRadioButton_1.getText())) {
				editTeacherSexManJRadioButton_1.setSelected(true);
				editTeacherSexFemalJRadioButton_1.setSelected(false);
			} else {
				editTeacherSexFemalJRadioButton_1.setSelected(true);
				editTeacherSexManJRadioButton_1.setSelected(false);
			}
		}
		private void setAuthority(){
			if("½ÌÊ¦".equals(MainFrm.userType.getName())){
				deleteTeacherButton.setEnabled(false);
				searchTeacherNameTextField.setEditable(false);
			}
		}
	}


