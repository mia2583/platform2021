import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientLogic {
	public void connect(JTextArea textArea) {
		if(s == null || s.isClosed()) {

		try {
			
			//textArea.append("Try to connect " + s.getLocalAddress().getHostAddress());
			s = new Socket("localhost", 1234);
			
			inStream = s.getInputStream();
			outStream = s.getOutputStream();
			textArea.append("Try to connect " + s.getInetAddress() + "\n");
			in = new Scanner(inStream);
			
			out = new PrintWriter(outStream, true);
			String line = in.nextLine();
			textArea.append(line);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	public void disconnect(JTextArea textArea) {
		if(!s.isClosed()) {
		try {
			
			//textArea.append("Try to connect " + s.getLocalAddress().getHostAddress());
			s.close();
			textArea.append("disconnected");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public void send(JTextArea textArea, JTextField message) {
		if(s != null || !s.isClosed()) {
		
		String msg = message.getText();
		textArea.append("Send: " + msg);
		out.println(msg);
		String line = in.nextLine();
		textArea.append("Receive: " + line);
		message.setText("");
		}
	}
	
	private Scanner in;
	private Socket s;
	private InputStream inStream;
	private PrintWriter out;
	private OutputStream outStream;
}
