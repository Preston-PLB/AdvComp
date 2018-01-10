package Hash.Program;

/**
 * Created by 131111 on 1/10/2018.
 */
public class Info {

    private String org;
    private boolean eligible;

    public Info(String org){
        this.org = org;
        eligible = true;
    }

    boolean isEligible(){
        return eligible;
    }

    void unEleigible(){
        eligible = false;
    }

}
