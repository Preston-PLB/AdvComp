package Hash.Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by 131111 on 1/4/2018.
 */
public class OpenSource {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Info> students = new HashMap<>();
        Scanner s = new Scanner(new File("open.dat"));

        String org = "";
        while(s.hasNextLine()){
            String str = s.nextLine().trim();
            if(str.charAt(0) >= 65 && str.charAt(0) <= 97){
                org = str;
            }else{
                if(students.containsKey(str)){
                    students.get(str).unEleigible();
                }else{
                    students.put(str, new Info(org));
                }
            }
        }



    }

}
