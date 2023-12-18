package com.zianyan.javafinalprojectchatweb.swing;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;


public class WebPageStarter extends JFrame {
	public WebPageStarter() {
		setSize(500, 300);
        setTitle("Web Page Starter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel welcomeLabel = new JLabel("Welcome To The Online Chat Room");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton button = new JButton("Start Chatroom Web");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("http://localhost:8080"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        JButton signupButton = new JButton("Signup Page");
        signupButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("http://localhost:8080/signup"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        JButton loginButton = new JButton("Login Page");
        loginButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("http://localhost:8080/login"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        JButton h2ConsoleButton = new JButton("H2 Database Console");
        h2ConsoleButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("http://localhost:8080/h2"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 2));
        buttonsPanel.add(new JPanel());
        buttonsPanel.add(button);
        buttonsPanel.add(new JPanel());
        buttonsPanel.add(signupButton);
        buttonsPanel.add(loginButton);
        buttonsPanel.add(h2ConsoleButton);
        

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(welcomeLabel, BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
    }
}
