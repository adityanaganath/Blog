import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 * Blog class characterizes a blog object
 * @author adityanaganath
 *It is fed blog entries (IV)
 *IV is static as it is shared amongst all instances of the class
 *Methods are predominantly static as they either operate solely on parameters passed
 *or because the "Entries" IV is static itself
 *Important: Some output is in both spanish and english: this is an effort to 
 *elegantly accommodate a second interface with a different language
 */ 
public class Blog {
 
	private static ArrayList<BlogEntry> Entries;

	/** 
	 * Blog constructor initializes "Entries" Array list
	 */
	public Blog() {
		
		Entries = new ArrayList<BlogEntry>();
	}
	/**
	 * Used specified content and title used to create Blog Entry
	 * Consequently, method for creating a new entry
	 * @param blogTitle
	 * @param blogText
	 */
	public void enterBlogEntry(String blogTitle, String blogText) {
		
		String t = blogTitle;
		String c = blogText;
		
		BlogEntry b = new BlogEntry(t,c);
		
		Entries.add(b);
		
		System.out.println("\n Your entry has been successfully added!/ Su entrada ha sido agregado con Žxito!");
		
		
	}
	
	
	public void displayBlogEntries() {
		
		for (BlogEntry b: Entries) {
			
			System.out.print("\n");
			System.out.println(b.getTitle());
			
		}
	}
	
	public void displaySpanishBlogEntries() {
		
		for (BlogEntry b: Entries) {
			
			System.out.print("\n");
			
			System.out.print(b.getSpanishTitle());
			
		}
	}		
	
	public static void readBlogEntry(int chosenBlog)  {
		
			BlogEntry b = Entries.get(chosenBlog -1);
		
			System.out.print(b.getContent());
			
	}
		
	public static int getNumberofEntries() {
		
		return Entries.size();
		
	}
		
	public static void viewComments(int chosenBlog) {
		
		
		BlogEntry b = Entries.get(chosenBlog-1);
		
		for (String comment: b.getComments())
		{
			System.out.println("\n\n"+ "Comment:");
			System.out.println("\n" + comment);
		}
	}
	
	public static void addComment(int chosenBlog, String c) {
		
			BlogEntry b = Entries.get(chosenBlog-1);
			b.addComment(c);
			
		}
	/** 
	 * Methods for blog modification. 
	 * Two options provided to user: delete and edit
	 * @param chosenBlog
	 */
	public static void modifyBlog(int chosenBlog) {
		
		System.out.println("Would you like to delete a entry or edit it?/ ÀQuieres deletar una entrada o editarlo? (d/e)");
		
		Scanner choice = new Scanner(System.in);
		
		String modifyChoice = choice.nextLine();
		
		if (modifyChoice.equals("d")) {
			
			Entries.remove(chosenBlog-1);
			
			System.out.print("The blog entry has been successfully removed!/ La entrada del blog ha eliminado con Žxito!");
			
		}
		
		else if (modifyChoice.equals("e")) {
			
			System.out.println("Enter your new text here/Introduzca el texto de nuevo aqu’");
			
			String edit = choice.nextLine();
			
			Entries.get(chosenBlog-1).setContent(edit);
			
			System.out.println("You have successfully edited the entry!/Ha editado la entrada!");
		}
	}
	
	public static void modifyComment(int chosenBlog) {
		
		Scanner editComment = new Scanner(System.in);
		/**
		 * If no comments exist, then user cannot modify anything
		 */
		if (Entries.get(chosenBlog-1).getNumberOfComments() == 0) {
			System.out.println("There are currently no comments to modify");

		}
		
		else {
		
		System.out.println("Would you like to delete a comment or edit it?/ÀTe gustar’a deletar un comentario o editarlo (d/e)");
		
		String modifyCommentChoice = editComment.nextLine();
		
		if (modifyCommentChoice.equals("d")) {
			
			int deleteComment;
			/**
			 * do-while loops for input that is incorrect or malicious
			 * eg: user enters wrong index of comment or negative (or 0) integer.
			 */
			do {
			System.out.println("Enter the number corresponding to the index of the comment");
			System.out.println("you would like to delete");
			
			System.out.println("\n" + "Introduce el nœmero correspondiente al ’ndice de los comentarios");
			System.out.println("Enter the number corresponding to the index of the comment");
			
			deleteComment = editComment.nextInt();
			
			} while(deleteComment > Entries.get(chosenBlog-1).getNumberOfComments() || deleteComment <= 0);
		
			Entries.get(chosenBlog-1).removeComment(deleteComment-1);
			
			System.out.println("The comment has been successfully deleted!/ El comentario ha sido eliminado!");
		}
		
		else if (modifyCommentChoice.equals("e")) {
			
			int modifiedComment;
		
			do{
			
			System.out.println("Enter the number corresponding to the index of the comment");
			System.out.println("you would like to edit");
			
			System.out.println("\n" + "Introduce el nœmero correspondiente al ’ndice de los comentarios");
			System.out.println("que desea editar");
			
			
			modifiedComment = editComment.nextInt();
			
			
			} while(modifiedComment > Entries.get(chosenBlog-1).getNumberOfComments() || modifiedComment <= 0);
			/**
			 * temp handles the issue of passing a blank line as input for an comment edit
			 */
			String temp = editComment.nextLine();
			
			System.out.println("Please enter your new comment/Por favor, ingrese su comentario nuevo");
			
			String newComment = editComment.nextLine();
			
			Entries.get(chosenBlog-1).removeComment(modifiedComment-1);
			Entries.get(chosenBlog-1).addComment(newComment);
			
			System.out.println("\n" + "Your comment has been successfully edited/ Tu comentario ha sido editado");
		}}
	}
	
	
	/**
	 * User specifies name of file
	 * Class PrintWriter writes blog data onto this file
	 * @param f
	 * @throws FileNotFoundException
	 */
	public static void saveBlog(String f) throws FileNotFoundException {
		
		
		PrintWriter Blog = new PrintWriter(new File(f));
		
		for (BlogEntry b : Entries) {
			Blog.print(b.toString() + "\n");
		}
		
		System.out.println("\n" + "Please check your local folder for the saved entries /");
		System.out.println("Por favor revise su carpeta local para las entradas guardadas");
		
		System.out.println("\n" + "Thank you for visiting the blog/ Gracias por visitar el blog");
		/**
		 * closing printwriter as pointer is at end
		 */
		Blog.close();
		
	}
	
	/**
	 * User inputs file. It must exists(previously saved) or an exception is thrown
	 * information is consequently easy to access as the format is essentially programmer defined.
	 * @param savedBlogs
	 * @throws FileNotFoundException
	 */
	public static void loadBlog(File savedBlogs) throws FileNotFoundException {
		
		Scanner readSource = new Scanner(savedBlogs);
		
		while (readSource.hasNextLine()) {
			
			String entryTitle = readSource.nextLine();
			
			if (!entryTitle.isEmpty()){
				
				String entryContent = readSource.nextLine();
			
				BlogEntry b = new BlogEntry(entryTitle,entryContent);
			
			
			while (readSource.hasNextLine()) {
				
				String comment=readSource.nextLine();
				
				if (comment.isEmpty()) {
					break;
				}
				else {
					b.addComment(comment);
					
				}
			}
			
			Entries.add(b);
			}
			
		}
	}
	

	
	
	
}
