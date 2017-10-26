package LinkedLists;

public class Actor {

    private String name;

    public Actor(){
        name = null;
    }

    public Actor(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
