package swingPractice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JinsooPractice_infoTap_ChatHGPT extends JFrame {
    private JComboBox<String> comboBox;
    private List<String> data; // BufferedReader에서 읽어온 데이터를 저장할 리스트
    private JButton cancelbtn = new JButton("돌아가기");
    private JLabel idLavel = new JLabel("회원을 선택해주세요");
    
    public JinsooPractice_infoTap_ChatHGPT() {
        data = new ArrayList<>(); // 데이터를 저장할 리스트 초기화

        // 파일에서 데이터를 읽어와서 data 리스트에 저장
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\userinfo\\memberinfo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JComboBox 생성 및 데이터 설정
        comboBox = new JComboBox<>();
        for (String line : data) {
            // 각 줄에서 파싱하여 첫 번째 값을 추가
            String[] parts = line.split("\\|");
            if (parts.length > 0) {
                comboBox.addItem(parts[0]);
            }
        }

        // JComboBox 이벤트 처리
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) comboBox.getSelectedItem();
                // 선택된 항목을 처리하는 코드 작성
                
                JOptionPane.showMessageDialog(null, "선택된 회원: " + selectedValue);
                setVisible(false);
                new JinsooPractice_infoTap_Tap();
						
            }
        });
        
        cancelbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JinsooPractice_MainFrame goingSignIn = new JinsooPractice_MainFrame();
				goingSignIn.setVisible(true);				
				}
		});

        // JFrame 설정
        setTitle("회원 일람");
        setLayout(new FlowLayout());
        add(idLavel);
        add(comboBox);
        add(cancelbtn);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JinsooPractice_infoTap_ChatHGPT();
    }
}
