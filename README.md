# ToDo-Helper

Elaine Zhang, Ruoxi Li  
May 1, 2021  
CSC 212: Programming with Data Structures Spring 2021 Smith College

Files/Software: Program is coded in Java and run on MacOS and Windows.

Our program helps to keep track of todo lists. The user will be able to create their own categories as new lists and add or delete elements from the lists. They will be able to choose different viewing options, such as viewing a select few of lists of their choice, viewing all the lists, and viewing items due on a specified date. There is also the option to write all the lists into a file, so the user can print it out on paper. 

We will use an ArrayList of TodoList objects to store the todo lists. A TodoList objects has the following attributes:  
- **name**, which is stored as a String object. This attribute keeps track of the name of the list.  
- **items**, which is stored as a HashMap\<String, String\>. The key is the name of the item and the value is the due date of the item. The due date is stored in the format "MM/DD/YYYY" and if there is no due date, "NA".  

We will display the menu below for the user to navigate the program: 

Menu.
1. Create a new list
    - Enter a name for the new list. The program will give an error if the name already exists and will ask you to enter another name. You will also have the option to enter items into the new list.
2. Delete a list
    - A menu of all the list names will be displayed. Enter the menu number for the list you want to delete. The program will give an error if the number does not exist.
3. Add item to existing list
    - A menu of all the list titles will be displayed. Enter the menu number for the list you want to add items to. Enter the name of the item and the due date in the form "MM/DD/YYYY", if applicable. Be cautious of repeats of the same item name in the same list.
4. Delete item from existing list
    - A menu of all the list titles will be displayed. Enter the menu number for the list you want to delete items from. Next, enter the corresponding number of the items displayed. The program will give an error if the number is out of bounds.
5. View all lists and items
    - All the list names and the items and due dates in the list will be displayed.
6. Choose list(s) to view
    - Enter the menu number from the lists displayed. The specified list with all its items and due dates will be displayed.
7. Find all items due on a date
    - Enter the date in the form "MM/DD/YYYY". Items with the corresponding date will be displayed. The program will given an error if the form is written incorrectly.
0. Exit

When the user exits the program, they will have the option to save their changes in a file called "todoList.txt". An example of the file format is shown below:  
The general form is: ListName,Item1,Date1,Item2,Date2  
  
Work,submit application,02/17/22,take role,NA,attend meeting,05/23/21  
English Homework,finish essay,05/21/21,read book,05/10/21  
Chores,wash dishes,NA,clean room,04/14/21  
Volunteering,visit animal shelter,04/22/22,watch kids,12/12/21  
Extracurriculars,attend dance class,NA