package com.wxy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar;
import com.wxy.dao.ClassDao;
import com.wxy.model.StudentClass;
import com.wxy.utill.StringUtill;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageClassFrm extends JFrame {
	private JTextField searchClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextArea editClassInfoTextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageClassFrm frame = new ManageClassFrm();
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
	public ManageClassFrm() {
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		setSize(800, 750);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/image/\u540D\u79F0.png")));
		
		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentClass sc = new StudentClass();
				sc.setName(searchClassNameTextField.getText());
				setTable(sc);
				
				
			}
		});
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		searchButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/image/\u641C\u7D22.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/image/\u540D\u79F0.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_1.setToolTipText("");
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/image/\u73ED\u7EA7\u4FE1\u606F.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setColumns(10);
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/image/\u786E\u8BA4 .png")));
		
		JButton submitDeleteButton = new JButton("\u5220\u9664");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteClassAct(ae);
			}
		});
		submitDeleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		submitDeleteButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/image/\u5220\u9664.png")));
		
		editClassInfoTextArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(122)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(submitEditButton)
								.addComponent(submitDeleteButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitDeleteButton))
					.addGap(78))
		);
		
		classListTable = new JTable();
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4FE1\u606F\u4ECB\u7ECD"
			}
		));
		
		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		StudentClass studentClass = new StudentClass();
		studentClass.setName(searchClassNameTextField.getText());
		setTable(studentClass);
		setVisible( true );
	}
	protected void deleteClassAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION) {
			return;
		}
		int index = classListTable.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据！");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(),0).toString());
				ClassDao classDao = new ClassDao();
		if(classDao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		setTable(new StudentClass());
	}

	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		ClassDao classDao =new ClassDao();
		int index = classListTable.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
	}
		DefaultTableModel dft = (DefaultTableModel)classListTable.getModel();
		String className = dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
		String classInfo = dft.getValueAt(classListTable.getSelectedRow(), 2).toString();
		String editClassName = editClassNameTextField.getText();
		String editClassInfo = editClassInfoTextArea.getText();
		if(StringUtill.isEmpty(editClassInfo)) {
			JOptionPane.showMessageDialog(this, "请选择修改的数据！");
			return;
		}
		
		if(className.equals(editClassName) && classInfo.equals(editClassInfo)){
			JOptionPane.showMessageDialog(this, "你还没有做任何修改！");
			return;
		}
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(),0).toString());
		StudentClass sc = new StudentClass();
		sc.setId(id);
		sc.setName(editClassName);
		sc.setInfo(editClassInfo);
		if(classDao.update(sc)) {
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else {
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		//班级信息管理
		setTable(new StudentClass());
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel)classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString());
		editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(), 2).toString());
	}

	private void setTable(StudentClass student){
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
        dft.setRowCount(0);
        ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(student);
		for(StudentClass sc : classList) {
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			dft.addRow(v);
		}
		
	}
}
