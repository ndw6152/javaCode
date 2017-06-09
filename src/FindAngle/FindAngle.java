package FindAngle;

import static java.lang.Math.abs;

/**
 *
 * Created by Anonealio on 6/8/2017.
 */
public class FindAngle {

    public FindAngle() {

    }

    public double getMinutesAngle(int minutes) {
        double val = (360/60) * minutes;
        System.out.println("minutes : " + val);
        return val;

    }

    public double getHourAngle(int hour, int minutes) {
        double val = (360/12)*hour + (360/12)*(minutes/60.0);
        System.out.println("hour : " + val);
        return val;
    }

    public double getTotalAngle(int hour, int minutes) {
        if(hour< 1 || hour > 12) {
            return -1;
        }
        if(minutes< 0 || minutes > 61) {
            return -1;
        }
        return abs(getHourAngle(hour, minutes) - getMinutesAngle(minutes))%180;
    }

    public static void main(String[] args) {
        FindAngle a1 = new FindAngle();

        System.out.println("Angle: " + a1.getTotalAngle(12, 0));
    }
}
