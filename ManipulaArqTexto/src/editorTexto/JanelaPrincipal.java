package editorTexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import util.ManipulaArquivoTXT;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar barraMenu;

	private JMenu mArquivo;
	private JMenuItem miNovo;
	private JMenuItem miAbrir;
	private JMenuItem miSalvar;
	private JMenuItem miSair;

	private JTextArea taTexto;

	public JanelaPrincipal() {
		super("Editor de Texto Java...");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		barraMenu = new JMenuBar();

		mArquivo = new JMenu("Arquivo");
		miNovo = new JMenuItem("Novo");
		miAbrir = new JMenuItem("Abrir");
		miSalvar = new JMenuItem("Salvar");
		miSair = new JMenuItem("Sair");

		taTexto = new JTextArea();

		mArquivo.add(miNovo);
		mArquivo.add(miAbrir);
		mArquivo.add(miSalvar);
		mArquivo.addSeparator();
		mArquivo.add(miSair);

		barraMenu.add(mArquivo);

		this.setJMenuBar(barraMenu);

		this.getContentPane().add(taTexto);

		miNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miNovoOnClick();
			}
		});

		miAbrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miAbrirOnClick();
			}
		});

		miSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miSalvarOnClick();
			}
		});

		miSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miSairOnClick();
			}
		});

		this.setLocationRelativeTo(null);

		this.setSize(640, 480);
		this.setVisible(true);

	}

	private void miSairOnClick() {
		System.exit(0);
	}

	private void miSalvarOnClick() {
		
		JFileChooser arquivo = new JFileChooser();
		int retorno = arquivo.showSaveDialog(null);
		
		if(retorno == JFileChooser.APPROVE_OPTION) {
			String nomeArquivo = arquivo.getSelectedFile().getAbsolutePath();
			
			String conteudo = taTexto.getText();
			boolean retorno2 = ManipulaArquivoTXT.gravarArquivoTXT(nomeArquivo, conteudo, this);
			//boolean retorno2 = ManipulaArquivoTXT.gravarArquivoTXT(nomeArquivo, taTexto.getText(), this);

			if (retorno2) {
				JOptionPane.showMessageDialog(this, "Arquivo Salvo!!!");
			}
		}
		
		
		
	}

	private void miAbrirOnClick() {

		JFileChooser arquivo = new JFileChooser();
		int retorno = arquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			
			String nomeArquivo = arquivo.getSelectedFile().getAbsolutePath();
			String retorno2 = ManipulaArquivoTXT.lerArquivoTXT(nomeArquivo, this);
			taTexto.setText(retorno2);
		}

	}

	private void miNovoOnClick() {
		taTexto.setText("");
	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}

}
