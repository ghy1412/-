package com.bit.client.service;

import com.bit.client.dao.AccountDao;
import com.bit.client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class UserLogin {
    private JPanel RegPanel;
    private JPanel userNamePanel;
    private JTextField usernameText;
    private JLabel userName;
    private JPanel passwordPanel;
    private JLabel password;
    private JButton regBtn;
    private JButton loginBtn;
    private JPasswordField passwordText;

    private AccountDao accountDao = new AccountDao();

    public UserLogin() {
        //这是点击注册
        regBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserReg();
            }
        });
        //这是点击登录
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName  = usernameText.getText();
                String password = String.valueOf(passwordText.getPassword());

                User user = accountDao.userLogin(userName, password);

                if (user != null){
                    JOptionPane.showMessageDialog(null,"登录成功",
                            "提示信息",JOptionPane.INFORMATION_MESSAGE);

                    //调到用户列表页面
                    
                } else {
                    JOptionPane.showMessageDialog(null,"登录失败",
                            "提示信息",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("登录页面");
        frame.setContentPane(new UserLogin().RegPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

}
