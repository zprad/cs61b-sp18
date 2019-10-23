public class NBody {

    public static double readRadius(String filename) {
        In in = new In(filename);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[n];
        int i = 0;
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            double xv = in.readDouble();
            double yv = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet p = new Planet(x, y, xv, yv, m, img);
            planets[i] = p;
            i += 1;
            if (i == n) {
                break;
            }
        }
        return planets;
    }

    public static void main(String[] args) {
        // Todo: limit args length to 3

        // Collecting All Needed Input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        
        drawBackground(r);

        for (Planet planet : planets) {
            planet.draw();
        }

        StdDraw.show();

        StdDraw.enableDoubleBuffering();


        double time = 0;
        int l = planets.length;
        while (time < T) {

            double[] xForces = new double[l];
            double[] yForces = new double[l];
            // update planets position
            for (int i = 0; i < l; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            drawBackground(r);

            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

            time += dt;

        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }

    public static void drawBackground(double radius) {
        double r = radius;
        String backgroundImg = "images/starfield.jpg"; 
        StdDraw.setScale(-r, r);
        StdDraw.clear();
        StdDraw.picture(0, 0, backgroundImg);
    }
}