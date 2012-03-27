import java.util.ArrayList;
/**
 * Class is responsible for characterizing the blog entry object
 * @author adityanaganath
 * Declaring Instance Variables
 */
public class BlogEntry {

	
	private String content;
	private ArrayList<String> comments;
	private String title;
	
	/**
	 * Constructor initializes some IVs
	 * @param t = used to initialize title IV
	 * @param c = used to initialize content IV
	 */
	public BlogEntry(String t, String c) {
		
		title = t;
		content = c;
		comments = new ArrayList<String>();
		
	}
	/**
	 * 
	 * @return Getter methods & Setter methods
	 */
	public String getTitle() {
		
		return "Title: "+title;
	}
	
	public String getSpanishTitle() {
		
		return "Titulo: " + title;
	}
	
	public String getContent(){
		
		return content;
	}
	
	public ArrayList<String> getComments() {
		return comments;
	}
	
	public void addComment(String c) {
		
		comments.add(c);
	}
	/**
	 * Method is useful for handling errors
	 * @return
	 */
	public int getNumberOfComments() {
		return comments.size();
	}
	
	public void removeComment(int remove) {
		
		comments.remove(remove);
	}
	
	public void setContent(String newContent){
		content = newContent;
	}
	private String individualComments() {

		String str = new String();
		
		for (int i = 0; i<comments.size(); i++) {
			str = str.concat(comments.get(i) + "\n");
		}
		return str;
	}
	
	/**
	 * toString() characterizes an individual blog entry
	 */
	public String toString() {
		
		String info = title + "\n" + content  + "\n"+  individualComments() + "\n";
		return info;
	}
}
