package tools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
//class that returns a string from a file
public class TextFileReader {
	private static TextFileReader instance;
	private String textFileMapPath;
	private TextFileReader() {
		//set the path to the map containing the text files
		textFileMapPath = System.getProperty("user.dir") + "/textFiles/";
	}
	public String readFile(String path) throws IOException {
		//read file as byte code and store them in an array
		byte[] encoded = Files.readAllBytes(Paths.get(textFileMapPath + path));
		//return the decoded byte array as an string, decode using the enviroments default charset
		return new String(encoded, Charset.defaultCharset());
	}
	//single ton functions to create an instance if there isn't one already and then return the instance of this class
	public static TextFileReader getInstance() {
		if(instance == null) {
			instance = new TextFileReader();
		}
		return instance;
	}
}
