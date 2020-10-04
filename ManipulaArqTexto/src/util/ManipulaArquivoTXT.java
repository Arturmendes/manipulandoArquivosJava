package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import editorTexto.JanelaPrincipal;

public class ManipulaArquivoTXT {

	public static boolean gravarArquivoTXT(String nomeArquivo, String conteudo, JanelaPrincipal janelaPrincipal) {
		try {

			System.out.println("Abrindo para gravação " + nomeArquivo);

			FileWriter fout = new FileWriter(nomeArquivo);
			PrintWriter pout = new PrintWriter(fout);

			System.out.println("Gravando " + nomeArquivo);
			pout.println(conteudo);

			System.out.println("Fechando " + nomeArquivo);
			pout.close();
			fout.close();

			return true;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Erro: " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	public static String lerArquivoTXT(String nomeArquivo, JanelaPrincipal janelaPrincipal) {
		try {

			FileReader fin = new FileReader(nomeArquivo);
			BufferedReader bin = new BufferedReader(fin);

			String linha = bin.readLine();
			String retorno = "";
			while (linha != null) {
				
				retorno += linha + "\n";
				
				linha = bin.readLine();
			}

			bin.close();
			fin.close();

			JOptionPane.showMessageDialog(janelaPrincipal, "Arquivo Aberto!!!");
			
			return retorno;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Erro: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
