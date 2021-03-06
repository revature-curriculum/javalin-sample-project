import io.javalin.Javalin;
import java.util.*;
import io.javalin.http.Handler;
import objects.Item;


public class Main {

  static ArrayList<Item> todoList;

    public static void main(String[] args) {

      todoList = new ArrayList<>();

      Javalin app = Javalin.create().start(4100);
        
      app.get("/", todoListHandler);

      app.get("/addTask", ctx -> ctx.render("addTask.jte"));

      app.post("/postTask", addTaskHandler);

      app.post("/complete", completeTaskHandler);

      app.get("/completedList", ctx -> ctx.render("completed.jte", Collections.singletonMap("todoList", todoList)));

      app.post ("/incomplete", incompleteTaskHandler);

    }

    static Handler todoListHandler = ctx -> {
      ctx.render("index.jte", Collections.singletonMap("todoList", todoList));
    };

    static Handler addTaskHandler = ctx -> {
      String task = ctx.formParam("task");
      todoList.add(new Item(task));
      ctx.render("index.jte", Collections.singletonMap("todoList", todoList));
    };

    static Handler completeTaskHandler = ctx -> {
      String task = ctx.formParam("task");

      for (Item item : todoList){
        if (item.getTask().equals(task) && item.getStatus() == false){
          item.finish();
          break;
        }
      }
      ctx.render("index.jte", Collections.singletonMap("todoList", todoList));
    };

    static Handler incompleteTaskHandler = ctx -> {
      String task = ctx.formParam("task");

      for (Item item : todoList){
        if (item.getTask().equals(task) && item.getStatus() == true){
          item.unfinish();
          break;
        }
      }
      ctx.render("completed.jte", Collections.singletonMap("todoList", todoList));
    };
  
}
