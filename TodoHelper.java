/** File: Final project/TodoHelper.java  ZhangE (Elaine) and LiR(Ruoxi)
 * keep tack of todo lists
*/

import java.util.*; // scanner, hashmap, arraylist
import java.io.*; // read file

class TodoHelper{

    static Scanner cin = new Scanner(System.in);
    static ArrayList<TodoList> todoLists = new ArrayList<>(); // store all todo lists created
    
    public static void main(String[] args) {
        char op; // user option
        do{
            // menu
            System.out.print("\nMenu.\n1.Create new list\n2.Delete list\n3.Add item to existing list\n4.Delete item from existing list\n5.View all lists and items\n6.Choose list to view\n7.Find all items due on a date\n0.Exit\nOption? "); 
            op = cin.next().charAt(0); 
            switch(op){
                case '1': newList(); break;
                case '2': delList(); break;
                //case '3':
                //case '4':
                //case '5':
                case '6': chooseLists(); break;
                case '7': findDueDates(); break;
                case '0': System.out.println("Goodbye."); break; // exit
                default: System.out.println("Error. Enter a number in menu.");
            }
        } while(op != '0');
    }

    static void newList(){ // CASE 1: create new list by asking for a new list name and adding to todoLists
        HashMap<String, String> items = new HashMap<>(); // store key=items and value=due dates
        TodoList t; 
        String newLst; // new list name
        cin.useDelimiter(System.lineSeparator()); // use next() instead of nextLine()
        do{ // keep asking if name already exists
            System.out.print("Enter name of new list: ");
            newLst = cin.next(); // new list name
            t = new TodoList(newLst, items); // create new todolist 
            if(arrcontains(t)){
                System.out.println("Error. Name already exists, enter a different name.");
            }
        } while(arrcontains(t)); 

        char addItem; 
        do{ // keep asking if user wants to enter items
            System.out.print("Enter item (y/n)? ");
            addItem = cin.next().charAt(0);
            if(addItem == 'y'){
                System.out.print("Enter item: "); // ask for item name
                String itemName = cin.next();
                System.out.print("Enter due date (y/n)? "); // ask for due dates
                char addDate = cin.next().charAt(0);
                String date;
                if(addDate == 'y'){
                    do{ // keep asking for date if wrong format
                        System.out.print("Enter due date (MM/DD/YYYY): ");
                        date = cin.next();
                        if(!checkDate(date)){  // if wrong format
                            System.out.println("Error. Check format of date.");
                        }
                    } while(!checkDate(date));
                    
                }
                else{
                    date = "NA";
                }
                items.put(itemName, date); 
            }
        } while(addItem == 'y');
        t = new TodoList(newLst, items); // create new list 
        todoLists.add(t);
        System.out.println("Created new list " + newLst + ": ");
        printTodos();
    }

    static void delList(){ // CASE 2: delete list chosen by user
        if(todoLists.isEmpty()){ // check for empty todoLists 
            System.out.println("No lists entered. Cannot delete a list.");
            return;
        }
        int index = userMenuChoice(); // get user num input 
        System.out.println("Deleted list " + todoLists.get(index).getName() + ": ");
        todoLists.remove(index); // delete list
        printTodos();
    }

    static void chooseLists(){ // CASE 6: choose lists to view
        if(todoLists.isEmpty()){ // check for empty todoLists 
            System.out.println("No lists entered. No list to view.");
            return;
        }
        int index = userMenuChoice(); // get user num input
        System.out.println(todoLists.get(index)); // print list chosen
    }

    static void findDueDates(){ // CASE 7: print all items due on a date
        String d;
        cin.useDelimiter(System.lineSeparator()); // use next() instead of nextLine();
        do{ // keep asking for date if wrong format
            System.out.print("Enter date (MM/DD/YYYY): ");
            d = cin.next(); // get user date
            if(!checkDate(d)){
                System.out.println("Error. Check format of date.");
            }
        } while(!checkDate(d));
        
        // search for items with date in todolists
        ArrayList<String> matches = new ArrayList<>(); // store items-listname with due date
        for(TodoList t : todoLists){
            HashMap<String, String> listItems = t.getItems(); 
            ArrayList<String> vals = new ArrayList<>(listItems.values());
            ArrayList<String> ks = new ArrayList<>(listItems.keySet());
            for(int i = 0; i < vals.size(); i++){
                if(vals.get(i).equals(d)){
                    matches.add(ks.get(i)+ " - from list " + t.getName()); 
                }
            }
        }
        if(matches.isEmpty()){
            System.out.println("No items with this due date.");
        }
        else{
            for(String s : matches){
                System.out.println(s);
            }
        }
    }

    static boolean arrcontains(TodoList tlst){ // check if tlst name in arraylist
        for(TodoList t : todoLists){
            if(t.equals(tlst)){
                return true;
            }
        }
        return false;
    }

    static boolean checkMenuNum(char userNum, int menuSize){ //check userNum is a number between 1 and menuSize, return true if good
        if(!(userNum >= '0' && userNum <= '9')){ // check if char is a number
            return false;
        }
        int n = Integer.parseInt(String.valueOf(userNum));
        if(1 <= n && n <= menuSize){
            return true;
        }
        return false;
    }

    static int userMenuChoice(){ // display a menu and have user choose a list num
        for(int i = 0; i < todoLists.size(); i++){ 
            System.out.println(i+1 + ". " + todoLists.get(i).getName());
        }
        char num;
        boolean goodInput;
        do{ // keep asking for num if not a number in menu
            System.out.print("Enter num of list: ");
            num = cin.next().charAt(0);
            goodInput = checkMenuNum(num, todoLists.size()); // check if num is in range
            if(!goodInput){
                System.out.println("Error. Make sure you enter a number in the menu.");
            }
        } while(!goodInput);
        return Integer.parseInt(String.valueOf(num))-1; // convert char num to int and get index
    }

    static boolean checkDate(String d){ // check input of date, make sure in format "MM/DD/YYYY", return true if good
        if(d.length() != 10){
            return false;
        }
        String[] arrD = d.split("/"); // [MM, DD, YYYY]
        if(arrD[0].length() != 2 || arrD[1].length() != 2 || arrD[2].length() != 4){
            return false;
        }
        return true;
    }
 
    static void printTodos(){ // print todoLists
        if(todoLists.isEmpty()){
            System.out.println("No lists stored.");
            return;
        }
        for(TodoList t : todoLists){
            System.out.println(t);
        }
    }
}

class TodoList{
    private String name; // name of list
    private HashMap <String, String> items; // key = item, value = due date

    public TodoList(String name, HashMap <String, String> items){
        this.name = name;
        this.items = items;
    }

    public String getName(){
        return name;
    }

    public HashMap <String, String> getItems(){ 
        return items;
    }

    public void addItem(String item, String date){ // add item 
        items.put(item, date);
    }

    public void delItem(String item){ // delete item 
        items.remove(item);
    }

    public boolean equals(TodoList tlst){ // check if 2 TodoLists equal
        return name.equalsIgnoreCase(tlst.name);
    }

    public String toString(){
        return name + ": " + items;
    }
}