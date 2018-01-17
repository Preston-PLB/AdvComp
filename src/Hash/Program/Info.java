package Hash.Program;

/**
 * Created by 131111 on 1/10/2018.
 */
public class Info {

    private String org, name;
    private boolean eligible;

    public Info(String org, String name){
        this.org = org;
        this.name = name;
        eligible = true;
    }

    boolean isEligible(){
        return eligible;
    }

    void unEleigible(){
        eligible = false;
    }

    String getOrg(){
        return org;
    }

    String getName(){
        return name;
    }

}
