package swingPractice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JinsooPractice_modifyPage_modify extends JFrame {
	
	
	private JPanel signUpPanel = new JPanel(new GridLayout(9, 2));
	 private JLabel idText = new JLabel(JinsooPractice_LoginIn.login_id);
	 private JLabel pwText = new JLabel(JinsooPractice_LoginIn.login_pw);
	 private JLabel pwCheckText = new JLabel(JinsooPractice_LoginIn.login_pw);
	 private JLabel nameText = new JLabel(JinsooPractice_LoginIn.login_name);
	 private JLabel birthYearText = new JLabel(JinsooPractice_LoginIn.login_birthYear);
	 private JLabel birthMonthContent = new JLabel(JinsooPractice_LoginIn.login_birthMonth);	 
	 private JLabel birthDayText = new JLabel(JinsooPractice_LoginIn.login_birthDay);
	 private JLabel phoneNumberText = new JLabel(JinsooPractice_LoginIn.login_phoneNumber);
	 private JButton modifybtn = new JButton("수정 완료");
	 private JButton cancelbtn = new JButton("돌아가기");
	
	 private JLabel idLavel = new JLabel("아이디");
	 private JLabel pwLavel = new JLabel("비밀번호");
	 private JLabel pwCheckLavel = new JLabel("비밀번호 체크");
	 private JLabel nameLavel = new JLabel("이름");
	 private JLabel birthYearLavel = new JLabel("생일 년도");
	 private JLabel birthMonthLavel = new JLabel("생일 월자");
	 private JLabel birthDayLavel = new JLabel("생일 일자");
	 private JLabel phoneNumberLavel = new JLabel("휴대폰 번호");
	 
	 private JTextField pwField = new JTextField();
	 private JTextField pwCheckField = new JTextField();
	 private JTextField nameField = new JTextField();
	 private JTextField birthYearField = new JTextField();
	 private JTextField birthMonthField = new JTextField();
	 private JTextField birthDayField = new JTextField();
	 private JTextField phoneNumberField = new JTextField();
	 
	 	public static String login_id;
		public static String login_pw;
		public static String login_pwCheck;
		public static String login_name;
		public static String login_birthYear;
		public static String login_birthMonth;
		public static String login_birthDay;
		public static String login_phoneNumber;

		
	 JinsooPractice_modifyPage_modify(){

		 this.setTitle("");
			
		 	this.signUpPanel.add(idLavel);
			this.signUpPanel.add(idText);
			this.signUpPanel.add(pwLavel);
			this.signUpPanel.add(pwField);
			this.signUpPanel.add(pwCheckLavel);
			this.signUpPanel.add(pwCheckField);
			this.signUpPanel.add(nameLavel);
			this.signUpPanel.add(nameField);
			this.signUpPanel.add(birthYearLavel);
			this.signUpPanel.add(birthYearField);
			this.signUpPanel.add(birthMonthLavel);
			this.signUpPanel.add(birthMonthField);
			this.signUpPanel.add(birthDayLavel);
			this.signUpPanel.add(birthDayField);
			this.signUpPanel.add(phoneNumberLavel);
			this.signUpPanel.add(phoneNumberField);
			this.signUpPanel.add(modifybtn);
			this.signUpPanel.add(cancelbtn);
			
			this.setContentPane(signUpPanel);
			pack();
			this.setLocationRelativeTo(null);
			
			cancelbtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					JinsooPractice_MainFrame goingSignIn = new JinsooPractice_MainFrame();
					goingSignIn.setVisible(true);				
					}
			});
			checkValue();
			
	 }
	private void checkValue() {
		
		modifybtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pwField.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.", "비밀번호 입력", JOptionPane.WARNING_MESSAGE);
					pwText.grabFocus();
					return;
				}
				
				if(pwCheckField.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력해 주세요.", "비밀번호 확인 입력", JOptionPane.WARNING_MESSAGE);
					pwCheckText.grabFocus();
					return;
				}
				if(!(pwField.getText().trim().equals(pwCheckField.getText().trim()))) {
					JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다.!!", "비밀번호 확인", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(nameField.getText().trim().length()==0 || nameField.getText().trim().equals("이름")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
					nameField.grabFocus();
					return;
				}
				if(birthYearField.getText().trim().length()==0 || birthYearField.getText().trim().equals("생일 년도 예)1993")) {
					JOptionPane.showMessageDialog(null, "생일 년도를 입력해 주세요.", "생일 년도 입력", JOptionPane.WARNING_MESSAGE);
					birthYearField.grabFocus();
					return;
				}
				if(birthMonthField.getText().trim().length()==0 || birthMonthField.getText().trim().equals("생일 월자 예)03")) {
					JOptionPane.showMessageDialog(null, "생년월자을 입력해 주세요.", "월 입력", JOptionPane.WARNING_MESSAGE);
					birthMonthField.grabFocus();
					return;
				}
				if(birthDayField.getText().trim().length()==0 || birthDayField.getText().trim().equals("생일 일자 예)18")) {
					JOptionPane.showMessageDialog(null, "생일 일자를 입력해 주세요.", "생일 일자 입력", JOptionPane.WARNING_MESSAGE);
					birthDayField.grabFocus();
					return;
				}
				if(phoneNumberField.getText().trim().length()==0 || phoneNumberField.getText().trim().equals("핸드폰 번호 예)010-1111-2222")) {
					JOptionPane.showMessageDialog(null, "핸드폰 번호를 입력해 주세요.", "핸드폰 번호 입력", JOptionPane.WARNING_MESSAGE);
					phoneNumberField.grabFocus();
					return;
				}
				try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\userinfo\\memberinfo.txt"));
				String str;
				String dummyInfo = "";
					while((str = bufferedReader.readLine()) != null) {
						String[] splitText = str.split("\\|");
						
						String infoId = splitText[0];
						if(infoId.equals(JinsooPractice_LoginIn.login_id)) {
							dummyInfo += idText.getText() + "|" + pwField.getText() + "|" + pwCheckField.getText() 
							+ "|" + nameField.getText() + "|" + birthYearField.getText() + "|" +birthMonthField.getText() 
							+ "|" +birthDayField.getText() + "|" +phoneNumberField.getText() + "\n";
						}else {
							dummyInfo += str + "\n";
						}
					}
					bufferedReader.close();
					
					String fileName = "C:\\userinfo\\memberinfo.txt";
					
					BufferedWriter bufferwriter = new BufferedWriter(new FileWriter(fileName,false));
					bufferwriter.write(dummyInfo);
					bufferwriter.flush();
					bufferwriter.close();
					
					JinsooPractice_LoginIn.login_pw = pwField.getText();
					JinsooPractice_LoginIn.login_pwCheck = pwCheckField.getText();
					JinsooPractice_LoginIn.login_name = nameField.getText();
					JinsooPractice_LoginIn.login_birthYear = birthYearField.getText();
					JinsooPractice_LoginIn.login_birthMonth = birthMonthField.getText();
					JinsooPractice_LoginIn.login_birthDay = birthDayField.getText();
					JinsooPractice_LoginIn.login_phoneNumber = phoneNumberField.getText();
					
					
					JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
					setVisible(false);
					JinsooPractice_modifyPage_main jinsooPractice_modifyPage_main = new JinsooPractice_modifyPage_main();
					jinsooPractice_modifyPage_main.setVisible(true);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
