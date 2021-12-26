import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.*;

public class ClientFrame extends JFrame{
	public ClientFrame(){
		setTitle("Echo Client");
		setSize(700, 500);
		
		textArea = new JTextArea(10, 8);
		scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
		
		downPanel = new JPanel();
		
		clientLogic = new ClientLogic();

		addButton(downPanel, "Connect", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				clientLogic.connect(textArea);
			}
		} );
		
		addButton(downPanel, "Disconnect", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				clientLogic.disconnect(textArea);
			}
		} );
		
		JTextField message = new JTextField("hello World", 20);
		downPanel.add(message);
		
		addButton(downPanel, "Send", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				clientLogic.send(textArea, message);
			}
		} );
		
		addButton(downPanel, "Clear", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textArea.setText("");
			}
		} );
		
		addButton(downPanel, "Quit", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		} );
		
		add(downPanel, BorderLayout.SOUTH);
		
	}
	
	public void addButton(Container container, String name, ActionListener listener) {
		JButton button = new JButton(name);
		button.addActionListener(listener);
		container.add(button);
	}
	
	
	private JTextArea textArea;
	private JPanel downPanel;
	private JPanel upperPanel;
	private JScrollPane scrollPane;
	private ClientLogic clientLogic;
}
