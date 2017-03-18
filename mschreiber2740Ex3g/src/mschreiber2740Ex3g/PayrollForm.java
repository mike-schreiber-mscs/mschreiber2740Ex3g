package mschreiber2740Ex3g;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class PayrollForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblTotalHours;
	private JLabel lblGrossPay;
	private JList payrollList;
	private DefaultListModel payrollListModel;
	private JTextComponent hoursTextfield;
	private JTextField hoursTextField;
	private JTextField empIdTextField;
	private JTextField empNameTextField;
	private JTextField payRateTextField;
	private JButton btnUpdate;
	private JButton btnAdd;
	private JButton btnClear;
	private PayrollObjMapper payrollObjMapper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollForm frame = new PayrollForm();
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
	public PayrollForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				do_this_windowClosing(arg0);
			}
		});
		setTitle("COMC2740 MSchreiber Ex2e");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 314, 87);
		contentPane.add(scrollPane);
		
		
		
//		payrollListModel = new DefaultListModel();
//		payrollListModel.addElement(new Payroll (101, "Mark Swanson", 10.0));
//		payrollListModel.addElement(new Payroll (102, "Patti Weigand", 20.0));
//		payrollListModel.addElement(new Payroll (103, "Lyle Stelter", 30.0));
//		payrollListModel.addElement(new Payroll (104, "Neva Burdick", 40.0));
//		payrollListModel.addElement(new Payroll (105, "Lisa Laing", 50.0));
		payrollObjMapper = new PayrollObjMapper("exercise3g.txt");
		payrollListModel = payrollObjMapper.getAllPayroll();
		
		payrollList = new JList(payrollListModel);
		payrollList.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent arg0) {
				do_payrollList_mouseClicked(arg0);
			}
		});
		payrollList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		payrollList.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(payrollList);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeId.setBounds(10, 109, 114, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeName.setBounds(10, 138, 114, 14);
		contentPane.add(lblEmployeeName);
		
		JLabel lbl2 = new JLabel("Pay rate (7.25 - 100):");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl2.setBounds(10, 163, 142, 14);
		contentPane.add(lbl2);
		
		JLabel lblEnterHours = new JLabel("Enter hours (0.1 - 20.0):");
		lblEnterHours.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterHours.setBounds(10, 188, 154, 14);
		contentPane.add(lblEnterHours);
		
		JLabel lbl3 = new JLabel("Total hours:");
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl3.setBounds(10, 213, 114, 14);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("Gross pay:");
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl4.setBounds(10, 237, 114, 14);
		contentPane.add(lbl4);
		
		hoursTextField = new JTextField();
		hoursTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				do_hoursTextField_focusGained(e);
			}
					});
		hoursTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		hoursTextField.setText("0.00");
		hoursTextField.setBounds(197, 185, 70, 20);
		contentPane.add(hoursTextField);
		hoursTextField.setColumns(10);
		
		lblTotalHours = new JLabel("0.00");
		lblTotalHours.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalHours.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalHours.setBounds(182, 213, 85, 14);
		contentPane.add(lblTotalHours);
		
		lblGrossPay = new JLabel("$0.00");
		lblGrossPay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrossPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrossPay.setBounds(197, 237, 70, 14);
		contentPane.add(lblGrossPay);
		
		btnAdd = new JButton("+");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnAdd_actionPerformed(arg0);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(278, 184, 46, 23);
		contentPane.add(btnAdd);
		
		btnClear = new JButton("Clear");
		btnClear.setEnabled(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClear_actionPerformed(e);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setBounds(134, 262, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnClearForm = new JButton("Clear Form");
		btnClearForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClearForm_actionPerformed(e);
			}
		});
		btnClearForm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClearForm.setBounds(10, 262, 114, 23);
		contentPane.add(btnClearForm);
		
		empIdTextField = new JTextField();
		empIdTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		empIdTextField.setText("000");
		empIdTextField.setBounds(183, 106, 86, 20);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		empNameTextField = new JTextField();
		empNameTextField.setBounds(183, 135, 86, 20);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		payRateTextField = new JTextField();
		payRateTextField.setBounds(183, 160, 86, 20);
		contentPane.add(payRateTextField);
		payRateTextField.setColumns(10);
		
		
		
		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerformed(e);
			
			}
		});
		
		
		
		
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(233, 262, 89, 23);
		contentPane.add(btnUpdate);
		}
		
		
	
		protected void do_payrollList_mouseClicked(MouseEvent arg0) {
		
		Payroll item = (Payroll) payrollList.getSelectedValue();
		empIdTextField.setText(Integer.toString(item.getIdNumber())); 
		empNameTextField.setText(item.getName());
		DecimalFormat dollarFmt = new DecimalFormat("###0.00");
		payRateTextField.setText(dollarFmt.format(item.getHourlyPay()));
		lblTotalHours.setText(Double.toString(item.gethours()));
		DecimalFormat dollarFmt2 = new DecimalFormat("$#,###0.00");
		lblGrossPay.setText(dollarFmt2.format(item.calcGrossPay()));
		this.hoursTextField.requestFocus();
	    this.hoursTextField.selectAll();
	    this.btnAdd.setEnabled(true);
		this.btnClear.setEnabled(true);
		this.btnUpdate.setEnabled(true);
	}
	
	
		
		protected void do_btnAdd_actionPerformed(ActionEvent arg0) {
			
		Payroll payroll = (Payroll) payrollList.getSelectedValue();
		double hours = Double.parseDouble(this.hoursTextField.getText());
			
			if (payroll.addHours(hours)){
				  
				this.lblTotalHours.setText(Double.toString(payroll.gethours()));
				DecimalFormat payFmt = new DecimalFormat("$#,###.00");
				this.lblGrossPay.setText(payFmt.format(payroll.calcGrossPay()));   
				this.hoursTextField.setText("0");
				this.hoursTextField.requestFocus();
				this.hoursTextField.selectAll();
			}
			
			else 			{
				JOptionPane.showMessageDialog(null, "Invalid hours. \nMust be between .1 and 20.");
			}	
		
			this.hoursTextField.requestFocus();
	}
	
	protected void do_btnClear_actionPerformed(ActionEvent e) {
		
		Payroll item3 = (Payroll) payrollList.getSelectedValue();
		item3.sethours(0);
		lblTotalHours.setText("0");
		lblGrossPay.setText("$0.00");
		hoursTextField.setText("0");
		this.hoursTextField.requestFocus();
		this.hoursTextField.selectAll();
	}
	
	protected void do_btnClearForm_actionPerformed(ActionEvent e) {
		
		empIdTextField.setText("0");
		empNameTextField.setText("");
		payRateTextField.setText("$0.00");
		hoursTextField.setText("0");
		lblTotalHours.setText("0");
		lblGrossPay.setText("$0.00");
		this.payrollList.clearSelection();
		this.btnAdd.setEnabled(false);
		this.btnClear.setEnabled(false);
		this.btnUpdate.setEnabled(false);
		
		
	}
		
	
	protected void do_hoursTextField_focusGained(FocusEvent e) {
		hoursTextField.selectAll();
	}

	
	
	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		
		int id = Integer.parseInt(empIdTextField.getText());
		double rate = Double.parseDouble(payRateTextField.getText());
		String name = (empNameTextField.getText());
		Payroll payroll = (Payroll) payrollList.getSelectedValue();
		
			if (!payroll.setIdNumber(id)){			
				JOptionPane.showMessageDialog(null, "Invalid Employee Id. \nMust be > 100.");
				empIdTextField.setText("101");
				empIdTextField.requestFocus();
				empIdTextField.selectAll();
			}
		
			
			else if (!payroll.setHourlyPay(rate)){				
					JOptionPane.showMessageDialog(null, "Invalid Pay Rate. \nMust be >= 7.25 or <= 100.");
					payRateTextField.setText("7.25");
					payRateTextField.requestFocus();
					payRateTextField.selectAll();
			}
			
		
		
			else if (!payroll.setName(name)){
						JOptionPane.showMessageDialog(null, "Name is empty or Invalid.");
						empNameTextField.setText("Mark Swanson");
						empNameTextField.requestFocus();
						empNameTextField.selectAll();
		}
			else {
				payroll.setHourlyPay(rate);
				payroll.setIdNumber(id);
				payroll.setName(name);
				
			}
		 
		 payrollList.repaint();	 
	}
	
	
	
	protected void do_this_windowClosing(WindowEvent arg0) {
		if(payrollObjMapper != null) {
			payrollObjMapper.writeAllPayroll(payrollListModel);		
			}
	}
}
	