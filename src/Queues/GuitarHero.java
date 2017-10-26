package Queues;

import javafx.scene.input.KeyCode;

/**
 * Created by 131111 on 9/7/2017.
 */
public class GuitarHero {
    public static void main(String[] args){
        double CONCERT_A = 440.0;
        double CONCERT_C = CONCERT_A * Math.pow(2, 3/12.0);
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);
        boolean pressed = false;

        GuitarString[] gs = new GuitarString[37];

        double temp = 110.0;
        for(int i = 0; i<37; i++){
            System.out.println(temp * Math.pow(2, i / 12.0));
            gs[i] = new GuitarString(temp * Math.pow(2, i/12.0));
        }

        String keys = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        while(true){
            if(StdDraw.hasNextKeyTyped()){
                char key = StdDraw.nextKeyTyped();
                if(keys.indexOf(key) != -1){
                    gs[keys.indexOf(key)].pluck();
                }
            }
            double sample = 0;
            for(GuitarString g: gs){
                sample+=g.sample();
            }

            StdAudio.play(sample);

            for(GuitarString g: gs){
                g.tic();
            }
        }
    }


}
