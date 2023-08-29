
package cinema;

import java.io.Serializable;

public class Time implements Serializable {

    private int hours, minutes, seconds;

    Time(){

    }

    Time(int h, int m, int s){
        hours = checkHours(h);
        minutes = checkMinutes(m);
        seconds = checkSeconds(s);
    }

    Time(Time t){
        this.hours = t.hours;
        this.minutes = t.minutes;
        this.seconds = t.seconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = checkHours(hours);
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = checkMinutes(minutes);
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = checkSeconds(seconds);
    }

    public int checkHours(int h) {
        if (h >= 0 && h < 24) {
            return h;
        } else {
            return -1;
        }
    }

    public int checkMinutes(int m) {
        if (m >= 0 && m < 60) {
            return m;
        } else {
            return -1;
        }
    }

    public int checkSeconds(int s) {
        if (s >= 0 && s < 60) {
            return s;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Time{" + "hours=" + hours + ", minutes=" + minutes + ", seconds=" + seconds + '}';
    }
}