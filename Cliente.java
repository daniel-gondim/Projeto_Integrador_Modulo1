import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {
		Scanner teclado = new Scanner(System.in);
		// Abrindo conex�o com o servidor no IP 127.0.0.1, porta: 7777
		Socket conexao = new Socket("127.0.0.1", 7777);
		// Criando os objetos de entrada e sa�da de dados
		InputStream entrada = conexao.getInputStream();
		OutputStream saida = conexao.getOutputStream();

		while (true) {
			System.out.print("CLIENTE >> ");
			String mensagemCliente = teclado.nextLine();
			// Cliente:
			// Enviar os bytes da string mensagem para o servidor
			// Transformar a String em um array de bytes
			byte[] dadosCliente = mensagemCliente.getBytes();
			// Enviar os bytes
			saida.write(dadosCliente);
			// For�ar o envio de poucos bytes
			saida.flush();

			// Criar um "espa�o" em bytes para armazenar os dados recebidos
			byte[] dadosServidor = new byte[100]; // Tamanho arbitr�rio suficiente
			// Ler os dados recebidos da entrada
			entrada.read(dadosServidor);
			// Converter os bytes recebidos para String
			String mensagemServidor = new String(dadosServidor);
			// Exibir a String recebida
			System.out.println("SERVIDOR >> " + mensagemServidor);

		}
	}

}