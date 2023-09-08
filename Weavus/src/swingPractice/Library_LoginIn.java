package swingPractice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

	public class Library_LoginIn  extends JFrame{
		private JPanel loginPanel = new JPanel(new GridLayout(3,2));
		private JLabel idLabel = new JLabel("아이디 "); 
		private JLabel pwLabel = new JLabel("비밀번호 ");
		private JTextField idText = new JTextField();
		private JPasswordField pwText = new JPasswordField();
		private JButton loginBtn = new JButton("로그인");
		private JButton memberbtn = new JButton("관리자 등록");
		
		 	public static String login_id;
			public static String login_pw;
			public static String login_pwCheck;
			public static String login_name;
			public static String login_birthYear;
			public static String login_birthMonth;
			public static String login_birthDay;
			public static String login_phoneNumber;
		
		

		public Library_LoginIn() {
			setTitle("로그인 창");
			
			this.setContentPane(loginPanel);
			loginPanel.add(idLabel);
			loginPanel.add(pwLabel);
			loginPanel.add(idText);
			loginPanel.add(pwText);
			loginPanel.add(loginBtn);
			loginPanel.add(memberbtn);
		
			pack();
			this.setLocationRelativeTo(null);
			
			this.setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			loginBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String id = idText.getText().trim();
					String pw = pwText.getText().trim();
					

					String login = "";
					
					if(id.length()==0 || pw.length()==0) {
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!", JOptionPane.DEFAULT_OPTION);
						return;
					}
					
					try {
						BufferedReader bufferdreader = new BufferedReader(new FileReader("C:\\userinfo\\memberinfo.txt"));
						  
						String str;
						List<String> infoList = new ArrayList<String>(); 
						while((str = bufferdreader.readLine()) != null) {  
							infoList.add(str);
						}
					        
						bufferdreader.close();
					        
						boolean loginOk = false;
						
						for(String info : infoList) {
							String [] splitText = info.split("\\|");
							String infold = splitText[0];
							String infoPw = splitText[1];
							String infoName = splitText[3];
							String infobirthYear = splitText[4];
							String infobirthMonth = splitText[5];
							String infobirthDay = splitText[6];
							String infphoneNumber = splitText[7];
							
							if (id.equals(infold) && pw.equals(infoPw)) {
								loginOk = true; 
								login_id = infold;
								login_pw = infoPw;
								login_name = infoName;
								login_birthYear = infobirthYear;
								login_birthMonth = infobirthMonth;
								login_birthDay = infobirthDay;
								login_phoneNumber = infphoneNumber;
								
							}

						}

						
						JOptionPane jo = new JOptionPane();
						if(loginOk) {
							jo.showMessageDialog(null, id + "님 환영합니다");
							setVisible(false);
							
							Library_mainpage goingSignIn = new Library_mainpage();
							goingSignIn.setVisible(true);
							
							
							
						}else {
							jo.showMessageDialog(null, "계정 정보를 확인해 주세요.");
						}
						
						
					} catch(Exception e1){
						e1.printStackTrace();
					}
					
				
					
				}
			});
					memberbtn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JinsooSwingPractice_SignUp signup = new JinsooSwingPractice_SignUp();
							signup.setVisible(true);
						}
					});
					
					
		}
		
		
				
			
		public static void main(String[] args) {
			new Library_LoginIn();
		}
		
		

}
