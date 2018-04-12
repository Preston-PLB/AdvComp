package Shapes;

public class Main {

    public static void main(String[] args){
        int[] x = {0,500,1000};
        int[] y = {1000,0,1000};

        serpin(x,y,8
        );
    }

    public static void serpin(int[] x, int[] y, int depth){
        Triangle t = new Triangle();
        t.draw(x,y,0);
        loop(1,x,y,depth);
    }

    private static void loop(int index,int[] x, int[] y, int depth) {
        if(depth != index){

            int[] x1 = new int[3];
            int[] y1 = new int[3];

            for(int i = 0; i<3; i++){
                x1[i] = (int)(.5 * x[(i+1)%3] + (1-.5) * x[i]);
                y1[i] = (int)(.5 * y[(i+1)%3] + (1-.5) * y[i]);
            }

            Triangle t = new Triangle();
            t.draw(x1, y1, 1);

            int[] x2 = {x[0], x1[0], x1[2]};
            int[] y2 = {y[0], y1[0], y1[2]};

            int[] x3 = {x1[0], x[1], x1[1]};
            int[] y3 = {y1[0], y[1], y1[1]};

            int[] x4 = {x1[2], x1[1], x[2]};
            int[] y4 = {y1[2], y1[1], y[2]};

            loop(index+1,x2,y2,depth);
            loop(index+1,x3,y3,depth);
            loop(index+1,x4,y4,depth);

        }
    }

}
