import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandle {
	File myFile;
	
	//Method to create file.
	public void createFile(String fileName){
		 myFile = new File(fileName);
		try {
			if(!myFile.exists()) {
				myFile.createNewFile();
				System.out.println("File Created at : "+myFile.getAbsolutePath());
			}
			else {
				System.out.println("File already exists  at : "+myFile.getAbsolutePath());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
	//Method to Write/Append into a file.
	public void WriteFile(String textToWrite, Boolean shouldAppend) {
		try {
			FileWriter fileWriter = new FileWriter(myFile, shouldAppend);
			fileWriter.append(textToWrite+"\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
	//Method to read from the file
	public void ReadFile() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(myFile));
			String str;
			if(myFile.length()>0) {
			while((str = bf.readLine()) != null) {
				System.out.println(str);
			}
			bf.close();
			}
			else {
				System.out.println("File is empty!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
}
