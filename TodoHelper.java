/** File: Final project/TodoHelper.java  ZhangE (Elaine) and LiR(Ruoxi)
 * keep tack of todo lists
*/

import java.util.*; // scanner, hashmap, arraylist
import java.io.*; // read file

class TodoHelper{

    static Scanner cin = new Scanner(System.in);
    static HashMap<String, ArrayList<String>> todoLists = new HashMap<>(); // value: todo lists // key: list title 
    static HashMap<String, String> dates = new HashMap<>(); // value: "MM/DD/YYYY" if no date, "00/00/0000" // key: same list titles

    public static void main(String[] args) {
        char op; // user option
        do{
            // menu
            System.out.print("Menu.\n1.Create new list\n2.Delete list\n3.Add item to existing list\n4.Delete item from existing list\n5.Write into file\n6.View all lists and items\n7.Choose list(s) to view\n8.Find all items due on a date\n0.Exit\nOption? "); 
            op = cin.next().charAt(0); 
        } while(op != '0');

        switch(op){
            //case '1': 
            //case '2': 
            //case '3':
            //case '4':
            //case '5':
            //case '6':
            //case '7': 
            //case '8':
            case '0': System.out.println("Goodbye."); break; // exit
            default: System.out.println("Error. Enter a number in menu.");
        }
        
    }

    static void newList(){ // CASE 1: create new list by asking for a new list title and adding to todoLists
        // double check for repeated titles
        
    }

    static void delList(){ // CASE 2: delete list chosen by user
        // display menu of existing lists
        // check for empty todoLists and out of bounds

    }
}