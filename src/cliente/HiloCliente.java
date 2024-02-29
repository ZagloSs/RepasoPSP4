package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import cadenaLarga.Cadena;

public class HiloCliente extends Thread{

	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	private Cadena cadena;
	
	
	public HiloCliente(Socket socket, Cadena cadena) {
		super();
		this.socket = socket;
		this.cadena = cadena;
	}

	public void run() {
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			String msg = "";
			while(!msg.toUpperCase().equals("FIN")){
				msg = dis.readUTF();
				if (msg.length() > cadena.getCadena().length()) {
					cadena.setCadena(msg);
					cadena.setQuien(socket.getInetAddress().toString());
				}
				dos.writeUTF("La cadena mas larga es del usuario: " + cadena.getQuien() + "\nCadena: " + cadena.getCadena());
				
			}
			
			dis.close();
			dos.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
