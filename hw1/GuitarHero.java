import edu.princeton.cs.algs4.StdAudio;
import synthesizer.GuitarString;

public class GuitarHero {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final double CONCERT_A = 440.0;
    private static GuitarString[] strings;

    private static GuitarString[] initStrings() {
        int l = keyboard.length();
        GuitarString[] strings = new GuitarString[l];
        for (int i = 0; i < l; i++) {
            double f = CONCERT_A * Math.pow(2, (i - 24) / 12);
            System.out.println(keyboard.charAt(i));
            System.out.println(f);
            strings[i] = new GuitarString(f);
        }
        return strings;
    }

    private static double computeSample() {
        double sample = 0.0;
        for (GuitarString g: strings) {
            sample += g.sample();
        }
        return sample;
    }

    private static void updateStrings() {
        for (GuitarString g: strings) {
            g.tic();
        }
    }

    public static void main(String[] args) {
        /* create guitar strings */
        strings = initStrings();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    strings[index].pluck();
                }
            }

            double sample = computeSample();

            StdAudio.play(sample);

            updateStrings();
        }
    }
}
