import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
/**
 * Class handles external interaction with Spanish speaking user
 * Blog is passed as an instance variable and initialized in constructor
 *A user object is also created as it is indirectly part of the interface
 *Class is same as BlogInterface: except throughout (at times)
 *certain methods with different names are called - these methods
 *have the same functionality as in blog interface except they 
 *supply interaction in spanish.
 * @author adityanaganath
 *Thus, for comments, views comments in blog interface class.
 */
public class SpanishBlogInterface {

	private Blog b;
	
	public SpanishBlogInterface() {
		
		b = new Blog();

	}
	
	public void runSpanishInterface() throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		
		User you = new User();
		
		
		int choice;
		
		do {
			
			System.out.println ("\n" + "0:Lea el blog, 1:escriba su propia 2:carga de un blog existente o -1:de salida (0/1/2/-1)");
			
			choice = in.nextInt();
			
			in.nextLine();
			
			if (choice == 0) 
			{
				if (Blog.getNumberofEntries() == 0) {
					System.out.println("Actualmente no hay entradas. ÀPor quŽ no hacer uno?");
				}
				
				else {
				
				int decision;
				
				do{
				b.displaySpanishBlogEntries();
				
				decision = you.readSpanishBlog();
				
				} while (decision > Blog.getNumberofEntries());
				
				Blog.readBlogEntry(decision);
				
				Blog.viewComments(decision);
				
				System.out.println("\n" + "comentario (si/no)");
				
				String commentChoice = in.nextLine();
				if (commentChoice.equals("si")) {
				
					String text = you.spanishUserComment();
				
					if (text != null && !text.equals("")) {
				
					Blog.addComment(decision, text);
			}
		}
				else if (commentChoice.equals("no")) {
					
					System.out.println("ÀTe gustar’a modificar la entrada de blog o un comentario en particular? (b/c/no)");
					
					String modify = in.next(); 
						
					if (modify.equals("b")) {
						
						Blog.modifyBlog(decision);
					}
					
					else if (modify.equals("c")) {
						
						Blog.modifyComment(decision);
					}
					
					else if (modify.equals("no")) {
						continue;
					}
				}
					
			}
		}
			
			else if (choice == 1)
			{
				String title = you.getSpanishBlogTitle();
				String text = you.getSpanishBlogText();
				
				b.enterBlogEntry(title, text);
			}
			
			else if (choice == 2) {
				

				boolean validFile = false;
				
				do{
				
				try{
				System.out.println("Please enter the name of the file you would like to load");
				
				String loadName = in.nextLine();
				
				Blog.loadBlog(new File(loadName));
				validFile=true;
				
				} catch (Exception e){
					validFile=false;
				}
				} while (!validFile);
				
				continue;
			}
			
			
		} while (choice != -1); 
			
			System.out.println("ÀTe gustar’a guardar las entradas de blog existentes? (si/no)");
			
			String saveChoice = in.nextLine();
			
			if (saveChoice.equals("si")) {
				
				System.out.println("Por favor, introduzca el nombre del archivo que desea guardar el");
				
				String name = in.nextLine();
				
				Blog.saveBlog(name);
				
			}
			
			else if (saveChoice.equals("no")) {
				
				System.out.print("Gracias por visitar el blog!");
			}
			System.exit(0);

			
	}
}

