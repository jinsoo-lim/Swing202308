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
    private List<String> data; 
    private JButton cancelbtn = new JButton("돌아가기");
    private JLabel idLavel = new JLabel("회원을 선택해주세요");
    
    public JinsooPractice_infoTap_ChatHGPT() {
        data = new ArrayList<>(); 

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\userinfo\\memberinfo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        comboBox = new JComboBox<>();
        for (String line : data) {
            String[] parts = line.split("\\|");
            if (parts.length > 0) {
                comboBox.addItem(parts[0]);
            }
        }

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) comboBox.getSelectedItem();
                
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
