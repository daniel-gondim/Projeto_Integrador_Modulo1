import java.net.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;

public class Servidor {
	public static void main(String[] args) throws Exception {
		
		// Cria um Socket para "escutar" (listen) a porta 7777
		ServerSocket servidor = new ServerSocket(7777);
		System.out.println("Aguardando conex�o do cliente na porta 7777...");
		//JOptionPane.showMessageDialog(null, "Aguardando conex�o do cliente na porta 7777...");
		
		// Aceita a conex�o do cliente quando ela chegar
		Socket conexao = servidor.accept();
		System.out.println("Conex�o com o cliente " + conexao.getInetAddress().getHostAddress() + " estabelecida com sucesso!");
		
		// Cria os objetos de entrada e sa�da de dados
		Scanner teclado = new Scanner(System.in);
		InputStream entrada = conexao.getInputStream();
		OutputStream saida = conexao.getOutputStream();
		
		// Cria fora do loop uma cadeia de caracteres que ser� usada para transformar a mensagem do servidor em um array de caracteres 		
		char [] auxiliar; 
		
		while (true) {
			// Cria um "espa�o" em bytes para armazenar os dados recebidos
			byte[] dadosCliente = new byte[100]; // Tamanho arbitr rio suficiente
			
			// L� os dados recebidos do cliente
			int max = entrada.read(dadosCliente);
			
			// Converte os bytes recebidos do cliente para string e aplicar o m�todo descripto para descriptografar a mensagem
			String mensagemCliente = new String(Criptografia.descripto(dadosCliente, max));
			
			// Imprime a mensagem enviada pelo cliente
			JOptionPane.showMessageDialog(null, "Cliente >> " + mensagemCliente);
			
			// Envia resposta para o cliente:
			String mensagemServidor = JOptionPane.showInputDialog("Servidor >> ");
			// System.out.print("SERVIDOR >> ");
			// JOptionPane.showMessageDialog(null, "Servidor >> ");
			// String mensagemServidor = teclado.nextLine();
			
			// Transforma a mensagem do servidor em um array de caracteres 	
			auxiliar = mensagemServidor.toCharArray();
			
			// Escreve a mensagem em forma de bytes para o cliente utilizando, para isso, o m�todo cripto
			saida.write(Criptografia.cripto(auxiliar));
			
			// For�a o envio de poucos bytes
			saida.flush();		
			
		}
	}

}