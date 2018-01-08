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
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, String> students = new HashMap<>();
        Scanner s = new Scanner(new File("open.dat"));

        String org = "";
        while(s.hasNextLine()){
            String temp = s.nextLine();
            if(temp.charAt(0) == '1'){
                Iterator it = map.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry pair = (Map.Entry)it.next();
                    HashSet temp_set = (HashSet) pair.getValue();
                    System.out.println(pair.getKey()+" "+temp_set.size());
                }
                map = new HashMap<>();
                students = new HashMap<>();
                System.out.println();
                continue;
            }
            if(temp.charAt(0) == '0'){
                break;
            }
            if(temp.charAt(0) >= 64 && temp.charAt(0) < 90){
                org = temp;
                map.put(org, new HashSet<>());
            }else {
                if (!students.containsKey(temp)) {
                    HashSet set = map.get(org);
                    set.add(temp);
                    map.put(org, set);
                    students.put(temp, org);
                }else{

                }
            }
        }
    }

}
