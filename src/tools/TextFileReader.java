package tools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileReader {
	private static TextFileReader instance;
	private String textFileMapPath;
	private TextFileReader() {
		textFileMapPath = System.getProperty("user.dir") + "/textFiles/";
	}
	public String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(textFileMapPath + path));
		return new String(encoded, Charset.defaultCharset());
	}
	public static TextFileReader getInstance() {
		if(instance == null) {
			instance = new TextFileReader();
		}
		return instance;
	}
}
