This program is a command line blog. On running the program, the user will be prompted to either read an entry, enter 
an entry, load a previously saved entry or exit the blog. The user should enter the number corresponding to the particular command.
The user should keep in mind that when he first runs the program there will be no entries (the program will tell him this if he tries to read an entry when there are no entries), 
and thus he should first enter an entry himself, or load an entry he previously saved on the blog. Once he has done so, he is free to read an entry.
He can do this by pressing 0 and then the index number of the entry. Thus, if there are three entries, he would have to enter 2 to read the second entry.
If the user enters a letter/string instead of a number, the program will inform him of an error and take him back to the main menu.
When reading an entry, the user has the option to comment or not. If he pressed y, he is allowed to comment. If he pressed n, the program will ask him
if he wants to modify a blog entry, comment or return to the main menu. If he chooses to modify a blog entry or comment, the program will ask him if he 
want to delete it or edit the content. He can choose deleting by pressing d and editing by pressing e. For comments, he must also select the index of the 
comment in the same way he selected the index of the blog entry he wanted to read (by entering the corresponding number).
To save a blog with all its entries and comments, the user must first exit the blog. This is done by pressing -1 in the main menu.
The program will prompt him for the name of the file he would like to save it on. He should enter a name and the blog will be saved there.
When he runs the program again, he can load the blog he saved (or any other blogs he previously saved) by pressing 2. The program will prompt
him for the file name. The user must enter a valid file name i.e. the file name of a blog previously saved. If he doesn't, the program will report 
an error and take him back to the main screen.

Design: I initially had 5 classes - A user class, blog class, blog entry class, blog interface class and tester class.
I felt dividing tasks into these classes was logical. The user class would manage user interaction with the blog,
the blog entry class would provide the blue print for a blog entry, the blog class would contain all the blog entries
and methods for the interface that would allow the user to interact with the blog such as reading an entry or writing an entry.
The interface class would call the blog class to form the bridge between the user and the blog. The tester class would run the program
and handle exceptions in a try-catch.

For the added functionality of saving and loading, I did not see the need to create an entirely new class (example, FileReader) as I was 
not implementing serializable. I was adding two simple methods instead. Thus, due to the triviality of the methods and the fact that
the blog class was managing two responsibilites (seen in the CRCs), I decided to add the functionality to the blog class (and thus, a third
responsibility to the blog class).

For extra credit, I felt that the most elegant way to implement multi-lingual capabilities was to create another interface in the other 
language and make sure that all the output was in that language. Some methods were also added in the user class (example: getSpanishTitle())
to be called in the different interface. In cases where it would be extremely tedious to create another methods with the same features 
but output in a different language, I decided to print output in both english and the other language. I saw this fit as I see the purpose
of the multi-lingual feature as a tool for allowing non-english speakers to interact with the blog. The program serves that purpose as
a spanish speaker would be able to find his/her way around the blog. Under the circumstances,I felt this was the most elegant approach.

Note: All methods with the word spanish in them was implemented after the initial program was running and the output in two languages was
added later as well. This was post the initial design.