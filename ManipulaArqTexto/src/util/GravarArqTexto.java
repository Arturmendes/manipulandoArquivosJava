package util;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GravarArqTexto {

	public static void main(String[] args) {
		try {
			
			System.out.println("Abrindo teste.txt");
			
			FileReader fin = new FileReader("teste.txt");
			BufferedReader bin = new BufferedReader(fin);
			
			System.out.println("Lendo teste.txt");
			
			String linha = bin.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = bin.readLine();
			}
			
			
			
			System.out.println("Fechando teste.txt");
			
			bin.close();
			fin.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Erro: " + e1.getMessage());
			e1.printStackTrace();
		}
		
		
		
		
	}

}
