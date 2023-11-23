package com.wxy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.wxy.dao.ClassDao;
import com.wxy.dao.StudentDao;
import com.wxy.model.Student;
import com.wxy.model.StudentClass;
import com.wxy.model.UserType;
import com.wxy.utill.StringUtill;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ManageStudentFrm extends JFrame {
	private JTextField serachStudentNameTextField;
	private JTable studentListTable;
	private JTextField editStudentNameTextField;
	private JTextField editStudentPasswordField;
	private JComboBox searchStudentComboBox;  
	private List<StudentClass> studentClassList ;
	private JComboBox editStudentClassComboBox;
	private JComboBox editStudentClassComboBox_2;
	private ButtonGroup editSexButtonGroup;
	private JRadioButton editStudentSexManRadioButton;
	private JRadioButton editStudentSexFemalRadioButton;
	private JRadioButton editStudentSexUnkonwRadioButton;
	private JButton deleteStudentButton;
	private JPasswordField editStudentPasswordPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentFrm frame = new ManageStudentFrm();
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
	public ManageStudentFrm() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 803, 558);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/image/\u5B66\u751F.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		serachStudentNameTextField = new JTextField();
		serachStudentNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/image/\u5B66\u751F.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		searchStudentComboBox = new JComboBox();
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		searchButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/image/\u641C\u7D22.png")));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchStudent(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/image/\u5B66\u751F.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		editStudentClassComboBox = new JComboBox();
		
		editStudentNameTextField = new JTextField();
		editStudentNameTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_3.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/image/\u6240\u5C5E\u5355\u4F4D.png")));
		
		editStudentClassComboBox_2 = new JComboBox();
		
		JLabel editStudentSexManradioButton_1 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		editStudentSexManradioButton_1.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/image/\u6027\u522B.png")));
		editStudentSexManradioButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		editStudentSexManRadioButton = new JRadioButton("\u7537");
		editStudentSexManRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentSexFemalRadioButton.setSelected(false);
				editStudentSexManRadioButton.setSelected(true);
			}
		});
		editStudentSexManRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		editStudentSexFemalRadioButton = new JRadioButton("\u5973");
		editStudentSexFemalRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentSexFemalRadioButton.setSelected(true);
				editStudentSexManRadioButton.setSelected(false);
			}
		});
		editStudentSexFemalRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_5.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/image/\u5BC6\u7801.png")));
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		editStudentPasswordField = new JTextField();
		editStudentPasswordField.setColumns(10);
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		submitEditButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/image/\u786E\u8BA4 .png")));
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEditAct(e);
			}
		});
		
		deleteStudentButton = new JButton("\u5220\u9664\u5B66\u751F");
		deleteStudentButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/image/\u5220\u9664.png")));
		deleteStudentButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		deleteStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStudent(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(lblNewLabel)
							.addGap(4)
							.addComponent(serachStudentNameTextField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(lblNewLabel_1)
							.addGap(4)
							.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 683, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(editStudentClassComboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(editStudentNameTextField, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
									.addGap(42)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(editStudentSexManradioButton_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editStudentSexManRadioButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editStudentSexFemalRadioButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editStudentPasswordField, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(deleteStudentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(submitEditButton, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(serachStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editStudentSexManradioButton_1)
						.addComponent(editStudentSexManRadioButton)
						.addComponent(editStudentSexFemalRadioButton)
						.addComponent(submitEditButton))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(editStudentClassComboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(editStudentPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteStudentButton))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		studentListTable = new JTable();
		studentListTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u6240\u5C5E\u73ED\u7EA7", "\u5B66\u751F\u6027\u522B", "\u767B\u5F55\u5BC6\u7801"
			}
			/*{
				boolean[] columnEditables = new boolean[] {
						false, true, true, true, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}*/
	
		));
		// 表选中行监听事件
		studentListTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// 选择行号
				int rowNum = studentListTable.getSelectedRow();
				if (rowNum == -1) {
					return;
				}
				// 回填编辑学生名字框数据
				editStudentNameTextField.setText(studentListTable.getValueAt(rowNum, 1).toString());
				// 回填编辑学生班级框数据
				editStudentClassComboBox_2.setSelectedItem(studentListTable.getValueAt(rowNum, 2).toString());
				// 回填编辑学生性别数据
				if("女".equals(studentListTable.getValueAt(rowNum, 3).toString())) {
					editStudentSexFemalRadioButton.setSelected(true);
					editStudentSexManRadioButton.setSelected(false);
				} else {
					editStudentSexFemalRadioButton.setSelected(false);
					editStudentSexManRadioButton.setSelected(true);
				}
				// 回填编辑学生密码框数据
				editStudentPasswordField.setText(studentListTable.getValueAt(rowNum, 4).toString());
			}
		});
		scrollPane.setViewportView(studentListTable);
		getContentPane().setLayout(groupLayout);
		// 设置班级下拉框
		setStudentClassInfo();
		setTable(new Student());
		setAuthority();
	}
	
	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = studentListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String studentName = editStudentNameTextField.getText().toString();
		String studentPassword = editStudentPasswordField.getText().toString();
		if(StringUtill.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this, "请填写学生姓名！");
			return;
		}
		if(StringUtill.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(this, "请填写密码！");
			return;
		}
		
		Student student = new Student();
		student.setName(studentName);
		student.setPassword(studentPassword);
		String classInfo = editStudentClassComboBox_2.getSelectedItem().toString();
		student.setClassId(Integer.parseInt(classInfo.split("_")[0]));
		student.setId(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()));
		if(editStudentSexManRadioButton.isSelected()) {
			student.setSex(editStudentSexManRadioButton.getText().toString());
		}
		if(editStudentSexFemalRadioButton.isSelected()) {
			student.setSex(editStudentSexFemalRadioButton.getText().toString());
		}
		StudentDao studentDao = new StudentDao();
		if(studentDao.update(student)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		
		setTable(new Student());
	}

	protected void deleteStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		int row = studentListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		StudentDao studentDao = new StudentDao();
		
		if(studentDao.delete(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		setTable(new Student());
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		editStudentNameTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 1).toString());
		editStudentPasswordPasswordField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 4).toString());
		String className = dft.getValueAt(studentListTable.getSelectedRow(), 2).toString();
		for(int i=0;i<editStudentClassComboBox_2.getItemCount();i++){
			StudentClass sc = (StudentClass)editStudentClassComboBox_2.getItemAt(i);
			if(className.equals(sc.getName())){
				editStudentClassComboBox_2.setSelectedIndex(i);
			}
		}
		String sex = dft.getValueAt(studentListTable.getSelectedRow(), 3).toString();
		editSexButtonGroup.clearSelection();
		if(sex.equals(editStudentSexManRadioButton.getText()))editStudentSexManRadioButton.setSelected(true);
		if(sex.equals(editStudentSexFemalRadioButton.getText()))editStudentSexFemalRadioButton.setSelected(true);
		
	}
	protected void searchStudent(ActionEvent ae) {
		Student student = new Student();
		student.setName(serachStudentNameTextField.getText().toString());
		String classInfo = searchStudentComboBox.getSelectedItem().toString();
		student.setClassId(Integer.parseInt(classInfo.split("_")[0]));
		setTable(student);
	}
//拿到当前登陆学生信息，确定是不是学生登陆（强转学生对象）
	private void setTable(Student student){
//		MainFrm.userType.getName().equals(UserType.STUDENT.getName())【错误】代码规范必须是字符串常量.equals(变量)
		if(UserType.STUDENT.getName().equals(MainFrm.userType.getName())){
			
			Student s = (Student)MainFrm.userObject;
			student.setName(s.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		dft.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		List<Student> studentList = studentDao.getStudentList(student);
		for (Student s : studentList) {
			Vector v = new Vector();
			v.add(s.getId());
			v.add(s.getName());
			v.add(s.getClassId()+ "_" + getClassNameById(s.getClassId()));
			v.add(s.getSex());
			v.add(s.getPassword());
			dft.addRow(v);
		}
	}
	private void setStudentClassInfo(){
		ClassDao classDao = new ClassDao();
		studentClassList = classDao.getClassList(new StudentClass());
		for (StudentClass sc : studentClassList) {
			String itemName = sc.getId() + "_" + sc.getName();
			searchStudentComboBox.addItem(itemName);
			editStudentClassComboBox_2.addItem(itemName);
		}
	}
	private String getClassNameById(int id){
		for (StudentClass sc : studentClassList) {
			if(sc.getId() == id)return sc.getName();
		}
		return "";
	}
	private void setAuthority(){
		if("学生".equals(MainFrm.userType.getName())){
			Student s = (Student)MainFrm.userObject;
			serachStudentNameTextField.setText(s.getName());
			serachStudentNameTextField.setEnabled(false);
			deleteStudentButton.setEnabled(false);
			int classId = s.getClassId();
			ClassDao classDao = new ClassDao();
			StudentClass studentClassQuery = new StudentClass();
			studentClassQuery.setId(classId);
			List<StudentClass> classList = classDao.getClassList(studentClassQuery);
			if (classList.size() > 0) {
				String className = classList.get(0).getName();
				searchStudentComboBox.setSelectedItem(classId + "_" + className);
				editStudentClassComboBox_2.setSelectedItem(classId + "_" + className);
			}
			searchStudentComboBox.setEnabled(false);
			editStudentClassComboBox_2.setEnabled(false);
		}
	}
}
