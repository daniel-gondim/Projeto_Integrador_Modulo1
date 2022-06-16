public class Criptografia {

	public static byte[] cripto(char[] letras) {

		// Cria um laço de repetição que recebe um array de caracteres como argumento
		for (int i = 0; i < letras.length; i++) {
			// Criptografa cada caractere do array de bytes com a Cifra de César
			letras[i] = (char) (letras[i] + 3);
		}
		// Cria uma string do array de caracteres com a mensagem cifrada
		String textocifrado = new String(letras);

		// Transforma a mensagem crifrada em um array de bytes para enviá-la para o destino
		byte[] dadosCliente = textocifrado.getBytes();
		
		// Devolve a mensagem criptografada
		return dadosCliente;
	}
		// Cria o método descriptografar que recebe como argumento um array de bytes e tamanho máximo desse array
		public static byte[] descripto(byte[] letras, int max) {

			// Cria uma string do array de byte
			String aux = new String(letras);
			
			// Transforma a String em uma cadeia de caracteres
			char[] auxiliar = aux.toCharArray();

			// Cria um laço para descriptografar a mensagem
			for (int i = 0; i < max; i++) {
				// System.out.println(x[i])
				auxiliar[i] = (char) (auxiliar[i] - 3);
			}

			// Transforma o array de caracteres em uma string
			String textocifrado = new String(auxiliar);

			// Transforma a string em um array de bytes que será enviado para o destino
			byte[] dadosCliente = textocifrado.getBytes();
			
			// // Devolve a mensagem descriptografada
			return dadosCliente;
		}
}
