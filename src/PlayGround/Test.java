package PlayGround;

import LinkedLists.LinkedListStack;

public class Test {

    public static void main(String[] args){
        LinkedListStack test = new LinkedListStack();
        test.push("Your mom");
        System.out.println(test.peek().equals("Your mom"));

    }

}
