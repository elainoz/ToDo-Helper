/** File: Final project/TodoHelper.java  ZhangE (Elaine) and LiR(Ruoxi)
 * keep tack of todo lists
*/

import java.util.*; // scanner, hashmap, arraylist
import java.io.*; // read file

class TodoHelper{

    static Scanner cin = new Scanner(System.in);
    static HashMap<String, ArrayList<String>> todoLists = new HashMap<>(); // value: todo lists // key: list title 
    static HashMap<String, ArrayList<String>> dates = new HashMap<>(); // value: "MM/DD/YYYY" if no date, "00/00/0000" // key: same list titles

    public static void main(String[] args) {
        char op; // user option
        do{
            // menu
            System.out.print("\nMenu.\n1.Create new list\n2.Delete list\n3.Add item to existing list\n4.Delete item from existing list\n5.Write into file\n6.View all lists and items\n7.Choose list(s) to view\n8.Find all items due on a date\n0.Exit\nOption? "); 
            op = cin.next().charAt(0); 
            switch(op){
                case '1': newList(); break;
                //case '2': delList();
                //case '3':
                //case '4':
                //case '5':
                //case '6':
                //case '7': 
                //case '8':
                case '0': System.out.println("Goodbye."); break; // exit
                default: System.out.println("Error. Enter a number in menu.");
            }
        } while(op != '0');
    }

    static void newList(){ // CASE 1: create new list by asking for a new list title and adding to todoLists
        String newLst; // ask for title of list
        do{ // keep asking if title already exists
            System.out.print("Enter title of new list: ");
            cin.nextLine();
            newLst = cin.nextLine(); // new list title
            if(todoLists.keySet().contains(newLst)){
                System.out.println("Error. Title already exists, enter a different title.");
            }
        } while(todoLists.keySet().contains(newLst)); 
        
        ArrayList<String> items = new ArrayList<>(); // ask for items list
        ArrayList<String> dueDates = new ArrayList<>(); //ask for due dates of items
        char addItem; 
        do{ // keep asking if user wants to enter items
            System.out.print("Enter item (y/n)? ");
            addItem = cin.next().charAt(0);
            if(addItem == 'y'){
                System.out.print("Enter item: "); // ask for item name
                cin.nextLine();
                String itemName = cin.nextLine();
                items.add(itemName); // add user item to arraylist
                System.out.print("Enter due date (y/n)? "); // ask for due dates
                char addDate = cin.next().charAt(0);
                String date;
                if(addDate == 'y'){
                    System.out.print("Enter due date (MM/DD/YYYY): ");
                    date = cin.next();
                }
                else{
                    date = "00/00/0000";
                }
                dueDates.add(date);
            }
        } while(addItem == 'y');

    }

    static void delList(){ // CASE 2: delete list chosen by user
        // display menu of existing lists
        // check for empty todoLists and out of bounds

    }
}