/*
 * Created by JFormDesigner on Wed Apr 24 14:25:24 CST 2019
 */

package com.jczx.view;

import com.jczx.mappers52.UhMapper;
import com.jczx.model52.Uh;
import com.jczx.service.LoginService;
import com.jczx.service.impl.LoginServiceImpl;
import com.jczx.util.BeanFactory;
import com.jczx.util.StringTools;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 * @author qianyc
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
    }

    private void button_resetActionPerformed(ActionEvent e) {
        textField_username.setText("");
        passwordField_password.setText("");
    }

    private void button_loginActionPerformed(ActionEvent e) {
        String username = textField_username.getText();
        String password = passwordField_password.getText();

        Map m = new HashMap();
        m.put("username",username);
        m.put("password",StringTools.MD5(password));
        LoginService ls = (LoginService)BeanFactory.getBean("loginService");
        Uh uh = ls.getUhByNameAndPassword(m);
        if(uh == null){
            System.out.println("登录失败");
        }else{
            System.out.println("登录成功"+uh);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        label1 = new JLabel();
        textField_username = new JTextField();
        label2 = new JLabel();
        passwordField_password = new JPasswordField();
        button_login = new JButton();
        button_reset = new JButton();

        //======== this ========
        setTitle("\u5de5\u5177");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u6587\u4ef6");
                menu1.setEnabled(false);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(95, 40), label1.getPreferredSize()));
        contentPane.add(textField_username);
        textField_username.setBounds(155, 35, 115, textField_username.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6  \u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(95, 75, 48, 17);
        contentPane.add(passwordField_password);
        passwordField_password.setBounds(155, 70, 115, passwordField_password.getPreferredSize().height);

        //---- button_login ----
        button_login.setText("\u767b\u5f55");
        button_login.setIcon(new ImageIcon(getClass().getResource("/icon/\u786e\u5b9a.png")));
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_loginActionPerformed(e);
            }
        });
        contentPane.add(button_login);
        button_login.setBounds(95, 115, 80, button_login.getPreferredSize().height);

        //---- button_reset ----
        button_reset.setText("\u91cd\u7f6e");
        button_reset.setIcon(new ImageIcon(getClass().getResource("/icon/\u53d6\u6d88.png")));
        button_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_resetActionPerformed(e);
            }
        });
        contentPane.add(button_reset);
        button_reset.setBounds(190, 115, 80, button_reset.getPreferredSize().height);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JLabel label1;
    private JTextField textField_username;
    private JLabel label2;
    private JPasswordField passwordField_password;
    private JButton button_login;
    private JButton button_reset;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setSize(380,250);
                    mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
