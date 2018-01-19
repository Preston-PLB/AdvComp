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
        HashMap<String, HashSet<String>> students = new HashMap<>();
        Scanner s = new Scanner(new File("open.dat"));

        String org = "";
        while(s.hasNextLine()){
            String str = s.nextLine().trim();
            if(str.charAt(0) >= 65 && str.charAt(0) <= 96){
                org = str;
                students.put(org, new HashSet<>());
            }else if(str.charAt(0) == '1'){
                for(Map.Entry set: students.entrySet()){
                    HashSet<String> temp = (HashSet<String>) set.getValue();
                    System.out.print(set.getKey()+" "+temp.size());
                    System.out.print("\n");
                }
                System.out.print("\n\n");
            }else if(str.charAt(0) == '0'){
                break;
            }else{
                    students.get(org).add(str);
            }
        }



    }

}
