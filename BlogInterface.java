import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
/**
 * Class handles the external interaction with English speaking user
 * @author adityanaganath
 *Blog is passed as an instance variable and initialized in constructor
 *A user object is also created as it is indirectly part of the interface
 */
public class BlogInterface {
	
	private Blog b;
		
	public BlogInterface() {
			
			b = new Blog();
			
			}
		/**
		 * Essentially calling methods written in the blog class
		 * @throws FileNotFoundException
		 */
		public void runInterface() throws FileNotFoundException { 
			
			Scanner in = new Scanner(System.in);
			
			User you = new User();
			
			int choice;
			
			do {
				 /**
				  * Command line prompts to the user
				  */
				System.out.println ("\n" + "0:Read blog, 1:Enter your own, 2:Load an existing blog or -1:Exit (0/1/2/-1)");
				
				choice = in.nextInt();
				
				in.nextLine();
				
				if (choice == 0) 
				{
					if (Blog.getNumberofEntries() == 0) {
						System.out.println("There are currently no entries. Why don't you make one?");
					}
					
					else {
						
					int decision;
					do {
					b.displayBlogEntries();
					
					decision = you.readBlog();
					/**
					 * loops if user supplied int does not map to a blog entry
					 */
					} while (decision > Blog.getNumberofEntries());
					
					Blog.readBlogEntry(decision);
					
					Blog.viewComments(decision);
					
					System.out.println("\n" + "Comment (y/n)");
					
					String commentChoice = in.nextLine();
					if (commentChoice.equals("y")) {
					
						String text = you.userComment();
						/**
						 * condition for not adding an invalid comment
						 */
						if (text != null && !text.equals("")) {
					
						Blog.addComment(decision, text);
				}
			}
					else if (commentChoice.equals("n")) {
						
						System.out.println("Would you like to modify the blog entry or a particular comment? (b/c/no)");
						
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
					String title = you.getBlogTitle();
					String text = you.getBlogText();
					
					b.enterBlogEntry(title, text);
				}
				
				else if (choice == 2) {
					/**
					 * Use a boolean to keep track of a valid file
					 */
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
				
				System.out.println("Would you like to save the existing blog entries? (y/n)");
				
				String saveChoice = in.nextLine();
				
				if (saveChoice.equals("y")) {
					/**
					 * Saving a file with user specified name
					 */
					System.out.println("Please enter the name of the file you would like to save on");
					
					String name = in.nextLine();
					
					Blog.saveBlog(name);
					
				}
				
				else if (saveChoice.equals("n")) {
					
					System.out.print("Thank you for visiting the blog!");
				}
				System.exit(0);
				
		}
	}

