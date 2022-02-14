## Javalin Sample Project
---
### Description
A Todo web application using Javalin, JTE and Java.

---
### Process
After hearing the initial idea the first step is to build a map of all the different parts needed and how they interact with each other. In this case the different parts were:

* Todo Class (This will be a class representing a todo task)
    - Task (this will be a string holding whatever task the user puts in)
    - Status (this will represent if the task is marked complete or not)
* Todo List (This will be an arraylist to hold all of the todo items)
* Page for showing pending tasks
* Page for showing complete tasks
* Some form for adding new tasks
* Some way to mark tasks complete
* Some way to mark complete tasks as incomplete

I made separated the parts into two sections. One section will be in Java and the other will be html/jte.
The Java section and html/JTE sections interact with routes and handlers. I decided how many routes and handlers I needed for this project:
* Home page (index) route. This page can be the initial landing page and also show a list of pending tasks. I decided to add the form for adding new tasks to this page as well.
    - This would require another route for receiving a post request from the form as well as a handler for adding new tasks to the arraylist.
* Side page to see completed tasks.
* In both of these pages there will be a table that shows the tasks. I want there to be a button users can click to change the status of the tasks. On the home page table the button will make the tasks complete and the completed tasks table button will change the tasks to incomplete.
    - I can use similar code for both of these cases but will need two separate routes and handlers for them.
    - One route and handler that marks the task complete.
    - The other will mark tasks incomplete.

  
I decided on a workflow:
* Finish creating the basic and central parts first
    - The most basic part and sort of central is the todo class
    - Some parts of the main class like creating the arraylist, creating the javalin app and making the first route.
    - Creating a jte page to see the list
* Then move outwards and add less central aspects one by one.
    - Creating the form for adding new tasks.
    - Creating the route and handler for it.
    - Creating the button form
    - Creating the route and handler for it.
    - Copying the code to a new jte page for completed tasks.
    - Removing the parts not needed and modifying the code for the new purpose.
    - Testing and fixing errors.

---

### Steps

1. Creating the Todo Class
    - The two fields (String task, boolean complete)
    - Constructor that takes in the task. I set the boolean to false on initialization because all the tasks will be incomplete at first.
    - Getters to get the todo task and boolean.
    - Method to set complete to true.
    - Method to set complete to false.
2. Setting up Main.java
    - Creating the javalin app object.
    - Importing all the required packages (java.util.* for arraylist and the Todo Class)
    - Creating an arraylist of todo's.
    - Setting up the initial route ("/" and rendering index.jte).
    - Sending the arraylist of todo's in this route to index.jte
3. Creating index.jte
    - Import the required packages.
    - Add an intro heading.
    - Add a table.
    - Add a for loop in the table (looping over the arraylist).
    - Add an if statement checking if the item is not completed.
    - Adding a table row, then table data cell and finally printing out the item task.
    - Adding another table data cell for the future button.
4. Creating the form for adding todo tasks
    - Created a post route in Main.java.
    - Created an associated handler that takes in a task string from formParam, creates a new task with the data and adds it to the arraylist.
    - Created a form in index.html below the table.
    - Only one field (task description).
    - Set the form action to the right place.
    - Create the submit button.
5. Test if it works.
6. Create a form for marking todo items as complete.
    - This form has a hidden field that sends the item task as a form parameter. To the user the form will look like a simple button that marks the todo task as complete.
    - Create a post route that receives the data.
    - Create an associated handler. This handler takes in the form param, looks through the arraylist till it finds a match, then sets the todo item to complete (uses the todo item complete method).
7. Create another version of index.html for seeing completed tasks already.
   - Set up the required routes and handlers.
   - No need for an add item form here so remove it
   - Change the button to say mark as incomplete or something similar.
   - Update the form action method.
   - Create a new route and handler for it.
   - This handler will now use the mark as incomplete method to mark complete as false.
8. Test
9. Show off your new todo web application! 

---
