package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import cadenaLarga.Cadena;
import cliente.HiloCliente;

public class MainServidor {
	public static ArrayList<HiloCliente> hilosClientes = new ArrayList<HiloCliente>();
	public static void main(String[] args) {
		
		Cadena cadena = new Cadena("", "");
		
		try(ServerSocket serverSocket = new ServerSocket(6566)){
			while(true) {
				Socket socketClient = serverSocket.accept();
				HiloCliente hiloCliente = new HiloCliente(socketClient, cadena);
				hilosClientes.add(hiloCliente);
				hilosClientes.get(hilosClientes.size()-1).start();
			}

		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
