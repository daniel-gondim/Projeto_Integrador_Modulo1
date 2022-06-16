import java.net.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Cliente {
	public static void main(String[] args) throws Exception {
		// Cria array de bytes que será enviado para o servidor
		char[] letras;

		// Cria uma conexao com o servidor no IP 127.0.0.1, porta: 7777
		Socket conexao = new Socket("127.0.0.1", 7777);
		System.out.println("O cliente acaba de se conectar ao servidor!");

		// Cria os objetos de entrada e saida de dados
		Scanner teclado = new Scanner(System.in);
		InputStream entrada = conexao.getInputStream();
		OutputStream saida = conexao.getOutputStream();

		// while com true para iniciar um loop infinito
		while (true) {

			// Digita a mensagem a ser enviada
			String mensagemCliente = JOptionPane.showInputDialog("Cliente >> ");
			//System.out.print("CLIENTE >> ");
			//String mensagemCliente = teclado.nextLine();

			// Converte a string fornecida em uma cadeia de caracteres
			letras = mensagemCliente.toCharArray();

			// Envia os bytes criptografados para o servidor utilizando o método cripto da classe Criptografia
			saida.write(Criptografia.cripto(letras));

			// System.out.println("Mensagem enviada criptografada!");

			// Força o envio de poucos bytes
			saida.flush();

			// Cria um "espaço" em bytes para armazenar os dados recebidos do servidor
			byte[] dadosServidor = new byte[100]; // Tamanho arbitr rio suficiente

			// Recebe os dados do servidor com uma variável inteiro para determinar o tamanho máximo do array de byte
			int max = entrada.read(dadosServidor);

			// Converte os bytes recebidos do servidor para String
			String mensagemServidor = new String(Criptografia.descripto(dadosServidor, max));

			// Exibe a mensagem enviada pelo servidor
			// System.out.println("SERVIDOR >> " + mensagemServidor);
			JOptionPane.showMessageDialog(null, "SERVIDOR >> " + mensagemServidor);
		}
	}
}
