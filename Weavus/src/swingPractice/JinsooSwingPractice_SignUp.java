package swingPractice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JinsooSwingPractice_SignUp extends JDialog {
	 private JPanel signUpPanel = new JPanel(new GridLayout(11, 0));
	 private JTextField idText = new JTextField("아이디");
	 private JPasswordField pwText = new JPasswordField("");
	 private JPasswordField pwCheckText = new JPasswordField("");
	 private JTextField nameText = new JTextField("이름");
	 private JTextField birthYearText = new JTextField("생일 년도 예)1993");
	 private JTextField birthMonthContent = new JTextField("생일 월자 예)03");	 
	 private JTextField birthDayText = new JTextField("생일 일자 예)18");
	 private JTextField phoneNumberText = new JTextField("핸드폰 번호 예)010-1111-2222");
	 private JButton signUpbtn = new JButton("회원가입");
	 private JButton cancelbtn = new JButton("돌아가기");
	 
	 private boolean membershipProgress = false;
	 
	 
	 
	 public JinsooSwingPractice_SignUp() {
			
			this.setTitle("회원가입");
			
			this.signUpPanel.add(idText);
			this.signUpPanel.add(pwText);
			this.signUpPanel.add(pwCheckText);
			this.signUpPanel.add(nameText);
			this.signUpPanel.add(birthYearText);
			this.signUpPanel.add(birthMonthContent);
			this.signUpPanel.add(birthDayText);
			this.signUpPanel.add(phoneNumberText);
			this.signUpPanel.add(signUpbtn);
			this.signUpPanel.add(cancelbtn);
			
			this.setContentPane(signUpPanel);
//			this.setSize(300,500);	
			pack();
			this.setLocationRelativeTo(null);

			FocusEvent();
			checkValue();
			cancelbtn();
		}
	 
		 
	private void cancelbtn() {
		cancelbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}


	private void checkValue() {
		 //회원 가입할때 모든 값이 입력되었는지 체크하기 위한 메소드
		signUpbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idText.getText().trim().length()==0 || idText.getText().trim().equals("아이디")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
					idText.grabFocus(); // 해당 텍스트 필드에 포커스 설정
					return;  //즉시, 코드를 중지시킨다. //가독성 위함
				}
				if(pwText.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.", "비밀번호 입력", JOptionPane.WARNING_MESSAGE);
					pwText.grabFocus();
					return;
				}
				
				if(pwCheckText.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력해 주세요.", "비밀번호 확인 입력", JOptionPane.WARNING_MESSAGE);
					pwCheckText.grabFocus();
					return;
				}
				// 패스워드와 패드워드 확인 란이 ! equls (같지 않다면) 재밌네.
				if(!(pwText.getText().trim().equals(pwCheckText.getText().trim()))) {
					JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다.!!", "비밀번호 확인", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(nameText.getText().trim().length()==0 || nameText.getText().trim().equals("이름")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
					nameText.grabFocus();
					return;
				}
				if(birthYearText.getText().trim().length()==0 || birthYearText.getText().trim().equals("생일 년도 예)1993")) {
					JOptionPane.showMessageDialog(null, "생년월일의 생일 년도를 입력해 주세요.", "생일 년도 입력", JOptionPane.WARNING_MESSAGE);
					birthYearText.grabFocus();
					return;
				}
				if(birthMonthContent.getText().trim().length()==0 || birthMonthContent.getText().trim().equals("생일 월자 예)03")) {
					JOptionPane.showMessageDialog(null, "생년월일의 월을 선택해 주세요.", "월 입력", JOptionPane.WARNING_MESSAGE);
					birthMonthContent.grabFocus();
					return;
				}
				if(birthDayText.getText().trim().length()==0 || birthDayText.getText().trim().equals("생일 일자 예)18")) {
					JOptionPane.showMessageDialog(null, "생일 일자를 입력해 주세요.", "생일 일자 입력", JOptionPane.WARNING_MESSAGE);
					birthDayText.grabFocus();
					return;
				}
				if(phoneNumberText.getText().trim().length()==0 || phoneNumberText.getText().trim().equals("핸드폰 번호 예)010-1111-2222")) {
					JOptionPane.showMessageDialog(null, "핸드폰 번호를 입력해 주세요.", "핸드폰 번호 입력", JOptionPane.WARNING_MESSAGE);
					phoneNumberText.grabFocus();
					return;
				}
				
				
				
				
				//회원가입시 텍스트 파일을 하나 만들어서 아이디와 비번을 저장 하자. 
				//한줄 뛰고 아이디|비밀번호 텍스트 파일에 차곡 차곡 저장하기 "|" 는 
				//아이디랑 패스워드 구분하기 위해 사용
				String txt = idText.getText()+"|"+pwText.getText()+"|"+pwText.getText()+"|"+nameText.getText()+"|"+birthYearText.getText()
				+"|"+birthMonthContent.getText()+"|"+birthDayText.getText()+"|"+phoneNumberText.getText();
				txt = txt + "\n";
				String fileName = "C:\\userinfo\\memberinfo.txt" ;
				
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();
				String name = nameText.getText().trim();
				String birthYear = birthYearText.getText().trim();
				String birthMonth = birthMonthContent.getText().trim();
				String birthDay = birthDayText.getText().trim();
				String phoneNumber = phoneNumberText.getText().trim();
				
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true));
					// 파일안에 문자열 쓰기
					bufferedWriter.write(txt);
					bufferedWriter.flush();
					
					bufferedWriter.close();		
					
				} catch(Exception errmsg){
					errmsg.printStackTrace();
				}
				//여기까지 왔다면 모든 값을 입력하고 선택하는 것이 완료되었으니 회원가입 과정이 완료.	
				membershipProgress = true;	//멤버 쪽에, 초기화 불린
				
				JOptionPane.showMessageDialog(null, "회원 가입이 완료 되었습니다.","회원 가입 완료.", JOptionPane.WARNING_MESSAGE);
				
				setVisible(false);
				new JinsooPractice_modifyPage_main();
			}
		});
		
	}


	//텍스트 필드에 있는 값을 체크하고 지우기 위한 메소드
	 private void FocusEvent() {
			idText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {		
					if(idText.getText().trim().length()==0) {
						idText.setText("아이디");
					}
					//focuslost 포커스를 잃는 경우
				}
				public void focusGained(FocusEvent e) {				
					if(idText.getText().trim().equals("아이디")) {
						idText.setText("");
					}				
				}
			});      //focusgained  포커스를 얻은 경우		
			
			nameText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(nameText.getText().trim().length()==0) {
						nameText.setText("이름");
					}
				}
				
				public void focusGained(FocusEvent e) {			
					if(nameText.getText().trim().equals("이름")) {
						nameText.setText("");
					}
				}
			});
			
			
			birthYearText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(birthYearText.getText().trim().length()==0) {
						birthYearText.setText("생일 년도 예)1993");
					}
				}

				public void focusGained(FocusEvent e) {
					if(birthYearText.getText().trim().equals("생일 년도 예)1993")) {
						birthYearText.setText("");
					}
				}
			});
			
			birthMonthContent.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(birthMonthContent.getText().trim().length()==0) {
						birthMonthContent.setText("생일 월자 예)03");
					}
				}

				public void focusGained(FocusEvent e) {
					if(birthMonthContent.getText().trim().equals("생일 월자 예)03")) {
						birthMonthContent.setText("");
					}
				}
			});
			
			birthDayText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(birthDayText.getText().trim().length()==0) {
						birthDayText.setText("생일 일자 예)18");
					}
				}

				public void focusGained(FocusEvent e) {
					if(birthDayText.getText().trim().equals("생일 일자 예)18")) {
						birthDayText.setText("");
					}
				}
			});
			
			phoneNumberText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(phoneNumberText.getText().trim().length()==0) {
						phoneNumberText.setText("핸드폰 번호 예)010-1111-2222");
					}
				}

				public void focusGained(FocusEvent e) {
					if(phoneNumberText.getText().trim().equals("핸드폰 번호 예)010-1111-2222")) {
						phoneNumberText.setText("");
					}
				}
			});	
	 }
	 
}

