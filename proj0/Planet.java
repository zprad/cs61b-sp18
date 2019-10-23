/** Class that describe a planet.
 *  @author prad
 */
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double NewtonConstant = 6.67e-11;

    public Planet(double xP, double yP, double xV,double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        double squareOfDistance = dx * dx + dy * dy;
        return Math.sqrt(squareOfDistance);
    }

    public double calcForceExertedBy(Planet p) {
        double d = calcDistance(p);
        double force = NewtonConstant * mass * p.mass / (d * d);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double f = calcForceExertedBy(p);
        double d = calcDistance(p);
        double dx = p.xxPos - xxPos;
        double fx = f * dx / d;
        return fx;
    }

    public double calcForceExertedByY(Planet p) {
        double f = calcForceExertedBy(p);
        double d = calcDistance(p);
        double dy = p.yyPos - yyPos;
        double fy = f * dy / d;
        return fy;
    }

    public double calcNetForceExertedByX(Planet[] lisPlanets) {
        double netFx = 0;
        for (Planet planet : lisPlanets) {
            if (planet.equals(this)) {
                continue;
            }
            netFx += calcForceExertedByX(planet);
        }
        return netFx;
    }

    public double calcNetForceExertedByY(Planet[] lisPlanets) {
        double netFy = 0;
        for (Planet planet : lisPlanets) {
            if (planet.equals(this)) {
                continue;
            }
            netFy += calcForceExertedByY(planet);
        }
        return netFy;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel += ax * dt;
        yyVel += ay * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        String filePath = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, filePath);
		StdDraw.show();
    }
}