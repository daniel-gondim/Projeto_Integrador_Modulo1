import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Servidor {
	public static void main(String[] args) throws Exception {
		Scanner teclado = new Scanner(System.in);
		// Criar um Socket para "escutar" (listen) a porta 7777
		ServerSocket servidor = new ServerSocket(7777);
		System.out.println("Aguardando conexão do cliente...");
		// Servidor deve aceitar a conex�o do cliente quando ela chegar
		Socket conexao = servidor.accept();
		System.out.println("Conex�o estabelecida!");
		// Criando os objetos de entrada e sa�da de dados
		InputStream entrada = conexao.getInputStream();
		OutputStream saida = conexao.getOutputStream();
		while (true) {
			// Servidor:
			// Criar um "espa�o" em bytes para armazenar os dados recebidos
			byte[] dadosCliente = new byte[100]; // Tamanho arbitr�rio suficiente
			// Ler os dados recebidos da entrada
			entrada.read(dadosCliente);
			// Converter os bytes recebidos para String
			String mensagemCliente = new String(dadosCliente);
			// Exibir a String recebida
			System.out.println("CLIENTE >> " + mensagemCliente);
			//Enviar resposta para o cliente:
			System.out.print("SERVIDOR >> ");
			String mensagemServidor = teclado.nextLine();
			// Enviar os bytes da string mensagem para o servidor
			// Transformar a String em um array de bytes
			byte[] dadosServidor = mensagemServidor.getBytes();
			// Enviar os bytes
			saida.write(dadosServidor);
			// For�ar o envio de poucos bytes
			saida.flush();
			
		}
	}

}