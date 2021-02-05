import java.util.Scanner;

public class FileHandlingMain {
	public static void main(String args[]) {
		FileHandle fileHandle = new FileHandle();
		Scanner fileNameScanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter file name");
			fileHandle.createFile(fileNameScanner.nextLine());
			int input = 0;
			while(input!=4) {
				System.out.println("Select options \n 1.Write \n 2.Append \n 3.Read \n 4.Exit");
				input = sc.nextInt();
				if(input==1) {
					System.out.println("Enter text to Write into file");
					String inputText = fileNameScanner.nextLine();
					fileHandle.WriteFile(inputText, false);
				}
				else if(input==2) {
					System.out.println("Enter text to Append into file");
					fileHandle.WriteFile(fileNameScanner.nextLine(), true);
				}
				else if(input==3) {
					fileHandle.ReadFile();
				}
				else if(input==4) {
					System.out.println("Thankyou for using FileHandler!");
				}
			}
		}catch(Exception ex) {
           System.err.println("An exception has occurred: "+ex.getMessage());
		}
		finally {
			fileNameScanner.close();
			sc.close();
		}
	}


}

