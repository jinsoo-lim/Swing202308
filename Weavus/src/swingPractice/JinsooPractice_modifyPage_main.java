package swingPractice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JinsooPractice_modifyPage_main extends JFrame {
	
	
	private JPanel signUpPanel = new JPanel(new GridLayout(8,2));
	 private JLabel idText = new JLabel(JinsooPractice_LoginIn.login_id);
	 private JLabel pwText = new JLabel(JinsooPractice_LoginIn.login_pw);
	 private JLabel nameText = new JLabel(JinsooPractice_LoginIn.login_name);
	 private JLabel birthYearText = new JLabel(JinsooPractice_LoginIn.login_birthYear);
	 private JLabel birthMonthContent = new JLabel(JinsooPractice_LoginIn.login_birthMonth);	 
	 private JLabel birthDayText = new JLabel(JinsooPractice_LoginIn.login_birthDay);
	 private JLabel phoneNumberText = new JLabel(JinsooPractice_LoginIn.login_phoneNumber);
	 private JButton signUpbtn = new JButton("수정");
	 private JButton cancelbtn = new JButton("돌아가기");
	
	 private JLabel idLavel = new JLabel("아이디");
	 private JLabel pwLavel = new JLabel("비밀번호");
	 private JLabel nameLavel = new JLabel("이름");
	 private JLabel birthYearLavel = new JLabel("생일 년도");
	 private JLabel birthMonthLavel = new JLabel("생일 월자");
	 private JLabel birthDayLavel = new JLabel("생일 일자");
	 private JLabel phoneNumberLavel = new JLabel("휴대폰 번호");
	 

		
	 JinsooPractice_modifyPage_main(){

		 this.setTitle("내 정보 메인화면");
			
		 	this.signUpPanel.add(idLavel);
			this.signUpPanel.add(idText);	
			this.signUpPanel.add(pwLavel);
			this.signUpPanel.add(pwText);
			this.signUpPanel.add(nameLavel);
			this.signUpPanel.add(nameText);
			this.signUpPanel.add(birthYearLavel);
			this.signUpPanel.add(birthYearText);
			this.signUpPanel.add(birthMonthLavel);
			this.signUpPanel.add(birthMonthContent);
			this.signUpPanel.add(birthDayLavel);
			this.signUpPanel.add(birthDayText);
			this.signUpPanel.add(phoneNumberLavel);
			this.signUpPanel.add(phoneNumberText);
			this.signUpPanel.add(signUpbtn);
			this.signUpPanel.add(cancelbtn);
			
			this.setContentPane(signUpPanel);
//			this.setSize(300,500);	
			pack();
			this.setLocationRelativeTo(null);
			
			//돌아가기 버튼 누르면,
			cancelbtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					JinsooPractice_MainFrame goingSignIn = new JinsooPractice_MainFrame();
					goingSignIn.setVisible(true);				
					}
			});
			
			signUpbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					JinsooPractice_modifyPage_modify goingSignIn = new JinsooPractice_modifyPage_modify();
					goingSignIn.setVisible(true);
				}
			});
	 }
}
