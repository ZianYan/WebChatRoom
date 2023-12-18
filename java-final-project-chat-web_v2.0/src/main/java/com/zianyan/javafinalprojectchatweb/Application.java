package com.zianyan.javafinalprojectchatweb;

import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zianyan.javafinalprojectchatweb.swing.WebPageStarter;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		System.setProperty("java.awt.headless", "false");
		SwingUtilities.invokeLater(() -> {
		    WebPageStarter starter = new WebPageStarter();
		    starter.setVisible(true);
		});
	}

}
