# ToDo-Helper

Elaine Zhang, Ruoxi Li  
April 26, 2021  
CSC 212: Programming with Data Structures Spring 2021 Smith College

Files/Software: Program is coded in Java and run on MacOS and Windows.

Our program helps to keep track of todo lists. The user will be able to create their own categories as new lists and add or delete elements from the lists. They will be able to choose different viewing options, such as viewing a select few of lists of their choice, viewing all the lists, and viewing items due on a specified date. There is also the option to write all the lists into a file, so the user can print it out on paper. 

We will use two Hashmaps to 1) store the todo lists and 2) store the items' corresponding due dates. The key in the Hashmaps are category names (Strings) and the values will be ArrayLists of Strings to store the list of items in the todo list. We will display the menu below for the user to navigate the program: 

Menu.
1. Create a new list/category
    - Enter a title for the new list. The program will give an error if the title already exists and will ask you to enter another title.
2. Delete a list
    - A menu of all the list titles will be displayed. Enter the menu number for the list you want to delete. The program will give an error if the number does not exist.
3. Add item to existing list
    - A menu of all the list titles will be displayed. Enter the menu number for the list you want to add items to. Enter the name of the item and the due date in the form "MM/DD". If no due date, enter "00/00". Be cautious of repeats in the same list.
4. Delete item from existing list
    - A menu of all the list titles will be displayed. Enter the menu number for the list you want to delete items from. Next, enter the corresponding number of the item displayed. The program will give an error if the number is out of bounds.
5. Write into file  
    - A file called "todoHelper.txt" will be written with all the lists and items stored in the program. Find this file in your local system.
6. View all lists and items
    - All the list titles and the items and due dates in the list will be displayed.
7. Choose list(s) to view
    - Enter the menu number from the lists displayed. The specified lists with all its items and due dates will be displayed.
8. Find all items due on a date
    - Enter the date in the form "MM/DD". Items with the corresponding date will be displayed. The program will given an error if the form is written incorrectly.
0. exit
