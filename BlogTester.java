import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BlogTester {

	/** Class runs either of the two interfaces
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) {

		String language;
		BlogInterface i = new BlogInterface();
		SpanishBlogInterface s = new SpanishBlogInterface();
		/**
		 * do-while handles problem of malicious input
		 */
		do {
		System.out.println("Welcome to the Blog! Select language: English or Spanish? (english/espanol)");
		
		Scanner choice = new Scanner(System.in);
		
		language = choice.nextLine();
		
		 } while(!(language.equals("english") || language.equals("espanol")));
		
		while (true){
			/**
			 * try-catch is crucial for handling exceptions
			 *FileNotFound and InputMismatch are two common exceptions here
			 */
		try {
			
			
			if (language.equals("english")) {
				i.runInterface();
			}
			
			else if (language.equals("espanol")) {
				
				s.runSpanishInterface();
			}
		}
		/**
		 * Exceptions handled here (thrown from other classes)
		 */
		catch (FileNotFoundException e) {
		
			System.out.println("You entered an invalid file name");
			System.out.println("\n" + "Ha introducido un nombre de archivo no v‡lido");
			
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Please format your input correctly");
			System.out.println("\n" + "Por favor, formatear la entrada correctamente");
		}
		
		catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Please reformat your input");
			System.out.println("\n" + "Por favor, reformatear su aportaci—n");
		}
		}
	}
	
	
			
			
			
	

}
