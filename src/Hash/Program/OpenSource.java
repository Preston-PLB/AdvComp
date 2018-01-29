package Hash.Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
                ArrayList<Organization> orgs = new ArrayList<>();
                HashMap<String, Boolean> eli = new HashMap<>();
                for(Map.Entry set: students.entrySet()){
                    HashSet<String> temp = (HashSet<String>) set.getValue();
                    for(String string: temp){
                        if(eli.containsKey(string)){
                            eli.put(string, true);
                        }else{
                            eli.put(string, false);
                        }
                    }
                }
                for(Map.Entry set: students.entrySet()){
                    HashSet<String> temp = (HashSet<String>) set.getValue();
                    int i = 0;
                    for(String string: temp){
                        if(!eli.get(string)){
                            i++;
                        }
                    }
                    orgs.add(new Organization((String)set.getKey(), i));
                }
                Collections.sort(orgs);
                for(Organization o: orgs){
                    System.out.println(o);
                }

                System.out.print("\n");
                students = new HashMap<>();
            }else if(str.charAt(0) == '0'){
                break;
            }else{
                students.get(org).add(str);
            }
        }
    }
}
