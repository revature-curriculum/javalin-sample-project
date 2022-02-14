package objects;

public class Item {

    String task;
    boolean complete;

    public Item(String task){
        this.task = task;
        complete = false;
    }

    public String getTask(){
        return task;
    }

    public boolean getStatus(){
        return complete;
    }

    public void finish(){
        complete = true;
    }

    public void unfinish(){
        complete = false;
    }
    
}
