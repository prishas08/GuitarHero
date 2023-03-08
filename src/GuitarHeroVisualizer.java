/*****************************************************************************
 *  Compilation:  javac GuitarHeroLite.java
 *  Execution:    java  GuitarHeroLite
 *  Dependencies: StdAudio.java StdDraw.java GuitarString.java
 *
 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ****************************************************************************/

public class GuitarHeroVisualizer { 

    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C
    	String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        
        GuitarString noteArray[] = new GuitarString [37];
        for(int i = 0; i < noteArray.length; i++)
        {
        	double frequency = i - 24;
        	frequency = Math.pow(1.05956,frequency);
        	frequency = frequency * 440;
        	noteArray[i] = new GuitarString(frequency);
        }

        // the main input loop
        while (true) {


            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                
                int x =  keyboard.indexOf(key);
                if(x!=-1)
                {
                    noteArray[x].pluck();
                }

            }

            // compute the superposition of the samples
            double sample = 0.0;
            for(int i = 0; i < noteArray.length; i++)
            {
            	sample+= noteArray[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(int i = 0; i < noteArray.length; i++)
            {
            	noteArray[i].tic();
            }
        }
    }
    

}