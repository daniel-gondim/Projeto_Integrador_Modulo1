
public class Criptografia {
	
	public static void main(String[] args) {
	String palavra = "Senac";

	char [] letras = palavra.toCharArray();
	//String [] x = new String [5]; 
	
	for (int i = 0; i < letras.length; i++) {
		//System.out.println(x[i])
		letras[i] = (char)(letras[i] + 3);
	}
	
	String textocifrado = new String (letras);
	System.out.println("Texto cifrado: " + TextoCifrado);

	}
}