import java.util.Scanner;
/**
 * Class is responsible for handling important user interaction
 * @author adityanaganath
 *Declaring Instance Variables
 */
public class User {
	
	private String blogTitle;
	private String text;
	
	/**
	 * User constructor is not passed an parameters/does not initialize IVs
	 */
	public User() {
		
	}
	
	Scanner input = new Scanner(System.in);
	/**
	 * Separate getters for English/Spanish interfaces
	 * @return
	 */
	public String getBlogTitle() {
		
		do {
		System.out.println("Please enter a title for your blog entry");
		
		
		blogTitle = input.nextLine();
		
		} while(blogTitle == null || blogTitle.equals(""));
		
		return blogTitle;
	}
	
	public String getSpanishBlogTitle () {
		
		String spanishBlogTitle;
		do {
		System.out.println("Por favor, introduzca un t’tulo para la entrada de blog");
		
		spanishBlogTitle = input.nextLine();
		
		} while (spanishBlogTitle == null || spanishBlogTitle.equals(""));
		
		return spanishBlogTitle;
	}
	
	public String getBlogText() {
		
		do {
		System.out.println("Please enter the content of your blog entry");
		
		text = input.nextLine();
		
		} while (text == null || text.equals(""));
		
		return text;
		
	}
	
	public String getSpanishBlogText() {
		
		String spanishText;
		
		do {
		System.out.println("Por favor, introduzca el contenido de su entrada en el blog");
		
		spanishText = input.nextLine();
		
		} while (spanishText == null || spanishText.equals(""));
		
		return spanishText;
	}
	/**
	 * handles user reading blog
	 * @return
	 */
	public int readBlog() {
		
		System.out.println("\n" +"Enter the number corresponding to the index of the blog entry");
		System.out.println("To read a blog");
		
		Scanner number = new Scanner(System.in);
		
		int choice = number.nextInt();
		
		return choice;
		
		
	}
	
	public int readSpanishBlog() {
		
		System.out.println("\n" + "Introduce el nœmero correspondiente al ’ndice de la entrada de blog");
		System.out.println("Para leer un blog");
		
		Scanner number = new Scanner(System.in);
		
		int choice = number.nextInt();
		
		return choice;
	}
	/** 
	 * allows user to comment on a blog entry
	 * @return
	 */
	public String userComment() {
		
		System.out.println("Please enter your comment here");
		
		String comment = input.nextLine();
		return comment;
	
		}
	
	public String spanishUserComment() {
		
		System.out.println("Por favor, ingrese su comentario aqu’");
		
		String comment = input.nextLine();
		return comment;
	}
	
	
}
