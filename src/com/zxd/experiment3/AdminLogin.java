package com.zxd.experiment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author scarborough
 * @creat 2023/5/29 - 10:42
 */
public class AdminLogin extends JFrame implements ActionListener {
    /**
     * ��¼���û�
     */
    public AdminAccount currentAccount;
    /**
     * ������壬����
     */
    private JPanel p0, p1, p2, p3;
    /**
     * �˺�
     */
    private JTextField userName;
    /**
     * ����
     */
    private JPasswordField passWord;
    /**
     * ��¼���˳���ť
     */
    private JButton login, exit;
    private JLabel jl1, jl2, jl3;
    Map<String, AdminAccount> resultMap = new HashMap<>();

    public AdminLogin(){
        // �������
        super("����Ա��¼ATM");

        // ������UI
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        MySqlConnection mySqlConnection = new MySqlConnection();
        Connection connection = mySqlConnection.getConnection();

        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM admin_info";
            ResultSet resultSet = statement.executeQuery(sql);
            Map<String, Object> map = new HashMap<>();
            while(resultSet.next()){
                AdminAccount adminAccount = new AdminAccount(
                        resultSet.getString("admin_id"),
                        resultSet.getString("password"));
                resultMap.put(resultSet.getString("admin_id"), adminAccount);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        // ���ô��ڵĵ�����Ͻǵ�x�Ĵ�����ʽ���������õ����˳�����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ���ô��岼��Ϊ4*1�����񲼾�
        setLayout(new GridLayout(4, 1));

        p0 = new JPanel();
        // ���ñ�ǩ���ݣ���ͬ��
        jl1 = new JLabel("��ӭʹ��ATM��Ա��ϵͳ��");
        // ���ñ�ǩ���壬�Ӵ֣���С����ͬ��
        jl1.setFont(new Font("����", Font.BOLD, 40));
        // �������������ǩ���ӵ���壨��ͬ��
        p0.add(jl1);

        p1 = new JPanel();
        jl2 = new JLabel("�˺ţ�");
        jl2.setFont(new Font("����", Font.BOLD, 25));
        p1.add(jl2);
        // �����ı��򳤶�Ϊ20
        userName = new JTextField(20);
        userName.setFont(new Font("����", Font.PLAIN, 25));
        p1.add(userName);

        p2 = new JPanel();
        jl3 = new JLabel("���룺");
        jl3.setFont(new Font("����", Font.BOLD, 25));
        p2.add(jl3);
        passWord = new JPasswordField(20);
        passWord.setFont(new Font("����", Font.PLAIN, 25));
        // �����������������ʱ��ʾΪ*
        passWord.setEchoChar('*');
        p2.add(passWord);

        p3 = new JPanel();
        // ����������Ϊ���Բ��֣����λ�������С���Զ���
        p3.setLayout(null);
        login = new JButton("��¼");
        // ���尴ť�����С
        login.setBounds(350, 50, 60, 40);
        exit = new JButton("�˳�");
        exit.setBounds(500, 50, 60, 40);
        p3.add(login);
        p3.add(exit);

        // ��������ӵ�����
        add(p0);
        add(p1);
        add(p2);
        add(p3);

        // ���ô���ɼ�
        setVisible(true);
        // ���ô����С
        setSize(900, 700);
        // ����
        setLocationRelativeTo(null);
        // ���ô����С�̶�
        setResizable(false);

        // ��ť���Ӽ���
        login.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == login){
            if(resultMap.containsKey(userName.getText())){
                AdminAccount adminAccount = resultMap.get(userName.getText());
                if(new String(passWord.getPassword()).equals(adminAccount.password)){
                    JOptionPane.showMessageDialog(this, "��¼�ɹ�");
                    // ʵ�������������洰��
                    new AdminMenu(adminAccount);
                    // �ͷŵ�¼����
                    dispose();
                }
            }
        }
    }
}