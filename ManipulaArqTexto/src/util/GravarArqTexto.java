package util;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GravarArqTexto {

	public static void main(String[] args) {
		try {
			
			System.out.println("Abrindo para gravação teste.txt");
			
			FileWriter fout = new FileWriter("teste.txt");
			PrintWriter pout = new PrintWriter(fout);
			
			System.out.println("Gravando teste.txt");
			pout.println("Linha 01");
			pout.println("Linha 02");
			pout.println("Linha 03");
			pout.println("Linha 04");
			
			
			System.out.println("Fechando teste.txt");
			pout.close();
			fout.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Erro: " + e1.getMessage());
			e1.printStackTrace();
		}
		
		
		
		
	}

}
