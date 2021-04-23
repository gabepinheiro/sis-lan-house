package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFiles {
	private static final String path = "/home/gabriel/Documentos/config.txt";
	public static void writefile(String ip, String porta) throws IOException {
		File file = new File(path);
		long begin = System.currentTimeMillis();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(ip);
		writer.newLine();
		writer.write(porta);
		
		//Criando o conteúdo do arquivo
		writer.flush();
		//Fechando conexão e escrita do arquivo.
		writer.close();
		
		System.out.println("Arquivo gravado em: " + path);
	}
}