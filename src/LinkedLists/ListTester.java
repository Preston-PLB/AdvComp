package LinkedLists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListTester {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList actorsList = new LinkedList();

        //PART 8
        LinkedList movies = new LinkedList();

        Scanner s = new Scanner(new File("movies.txt"));
        while (s.hasNextLine()) {
            String raw = s.nextLine();
            int date = Integer.parseInt(raw.substring(0, 4));
            String title = raw.substring(5, 37).trim();
            String[] actors = raw.substring(38, 39 + 45).trim().split(",");
            String[] directors = raw.substring(39 + 45 + 4).trim().split(",");

            LinkedList actorList = new LinkedList();
            LinkedList directorList = new LinkedList();

            for (String x : actors) {
                actorList.add(new Node(new Actor(x)));
            }

            for (String x : directors) {
                directorList.add(new Node(new Actor(x)));
            }

            movies.add(new Node(new Movie(date, title, actorList, directorList)));
        }

        s = new Scanner(new File("actors.txt"));
        while (s.hasNextLine()) {
            actorsList.add(new Node(new Actor(s.nextLine().trim())));
        }
        Node movieHead = movies.get(0);
        while(movieHead != null){
            Movie m = (Movie)movieHead.get();
            Node actorHead = actorsList.get(0);
            while(actorHead != null){
                Actor a = (Actor)actorHead.get();
                Node movieActorHead = m.getActors().get(0);
                while(movieActorHead != null){
                    Actor ma = (Actor)movieActorHead.get();
                    if(a.getName().trim().equals(ma.getName().trim())){
                        System.out.printf("%s staring %s in %d\n", m.getTitle(), a.getName(),  m.getDate());
                    }
                    movieActorHead = movieActorHead.getNext();
                }
                actorHead = actorHead.getNext();
            }
            movieHead = movieHead.getNext();
        }

        //PART 7
//        LinkedList movies = new LinkedList();
//
//        Scanner s = new Scanner(new File("C:\\Users\\131111\\Downloads\\movies.txt"));
//        while(s.hasNextLine()){
//            String raw = s.nextLine();
//            int date = Integer.parseInt(raw.substring(0,4));
//            String title = raw.substring(5,37).trim();
//            String[] actors = raw.substring(38  ,39+45).trim().split(",");
//            String[] directors = raw.substring(39+45+4).trim().split(",");
//
//            LinkedList actorList = new LinkedList();
//            LinkedList directorList = new LinkedList();
//
//            for(String x: actors){
//                actorList.add(new Node(new Actor(x)));
//            }
//
//            for(String x: directors){
//                directorList.add(new Node(new Actor(x)));
//            }
//
////            movies.add(new Node(new Movie(date, title, actorList, directorList)));
//    }
//
//        for(
//    int i = 0; i<movies.size();i++)
//
//    {
//        System.out.println(movies.get(i));
//    }
//
//    Movie first = (Movie) movies.get(0).get();
//
//        System.out.println(first);

    //PART 6

//        Movie m = new Movie(0xfe,"Your mom",new LinkedList(), new LinkedList());
//        Movie n = new Movie(0xfd,"Your dad",new LinkedList(), new LinkedList());
//        Movie b = new Movie(0xfc,"Your bro",new LinkedList(), new LinkedList());
//        Movie v = new Movie(0xfb,"Your sis",new LinkedList(), new LinkedList());
//        Movie c = new Movie(0xfa,"Your cus",new LinkedList(), new LinkedList());
//
//        LinkedList movies = new LinkedList();
//
//        movies.add(new Node(m));
//        movies.add(new Node(n));
//        movies.add(new Node(b));
//        movies.add(new Node(v));
//        movies.add(new Node(c));
//
//        for(int i =0; i<movies.size(); i++){
//            System.out.println(movies.get(i));
//        }
//
//        Movie first = (Movie)movies.get(0).get();
//
//        System.out.println(first);


    //PART 5

//        Scanner s = new Scanner(new File("C:\\Users\\131111\\Downloads\\actors.txt"));
//        while(s.hasNextLine()){
//            all.add(new Node(new Actor(s.nextLine())));
//        }
//        for(int i =0; i<all.size(); i++){
//            System.out.println(all.get(i));
//        }
//
//        Actor first = (Actor)all.get(0).get();
//
//        System.out.println(first.getName());

    //PART 4

//        all.add(new Node(new Actor("Preston")));
//        all.add(new Node(new Actor("Allison")));
//        all.add(new Node(new Actor("Alejas")));
//        all.add(new Node(new Actor("Theresa")));
//        all.add(new Node(new Actor("John")));
//
//        for(int i =0; i<all.size(); i++){
//            System.out.println(all.get(i));
//        }
//
//        Actor first = (Actor)all.get(0).get();
//
//        System.out.println(first.getName());

}

}
