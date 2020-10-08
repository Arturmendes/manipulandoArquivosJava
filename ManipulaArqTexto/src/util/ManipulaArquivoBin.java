package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ManipulaArquivoBin {

	private String nomeArquivo;

	public ManipulaArquivoBin() {

	}

	public ManipulaArquivoBin(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public boolean gravaArquivoBin(int qtdAcesso) throws IOException {

		FileOutputStream fout = new FileOutputStream(this.nomeArquivo);
		DataOutputStream dout = new DataOutputStream(fout);

		dout.writeInt(qtdAcesso);

		dout.close();
		fout.close();

		return true;
	}

	public int leArquivoBin() throws IOException {
		
		FileInputStream fin = new FileInputStream(this.nomeArquivo);
		DataInputStream din = new DataInputStream(fin);	
		
		int qtdAcesso = din.readInt();
		
		din.close();
		fin.close();
		
		return qtdAcesso;
	}

}
