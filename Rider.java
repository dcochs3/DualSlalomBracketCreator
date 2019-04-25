import java.lang.Integer;

public class Rider implements Comparable<Rider> {
    private String name;
    private String number;
    private String qualifyingTime;


    public Rider(String name, String number, String qualifyingTime) {
        this.name = name;
        this.number = number;
        this.qualifyingTime = qualifyingTime;
    }

    public String getRiderName() {
        return name;
    }

    public String getRiderNumber() {
        return number;
    }

    public String getQualifyingTime() {
        return qualifyingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            //self check
            return true;
        }
        if (o == null) {
            //null check
            return false;
        }
        if (!(o instanceof Rider)) {
            //type check
            return false;
        }
        Rider rider = (Rider) o;
        //now compare their fields
        return (this.name.equals(rider.getRiderName())
            && this.number.equals(rider.getRiderNumber())
            && this.qualifyingTime.equals(rider.getQualifyingTime()));
    }

    @Override
    public int compareTo(Rider rider) {
        //if this < rider  : return -1
        //if this == rider : return 0
        //if this > rider  : return 1

        return this.convertQTToMS() - rider.convertQTToMS();
    }

    private int convertQTToMS() {
        //convert the qualifying time string to milliseconds
        String[] qualifyingTimeSplit = qualifyingTime.split(":");
        //example
        //0:23:540
        int minutes = Integer.parseInt(qualifyingTimeSplit[0]);
        int seconds = Integer.parseInt(qualifyingTimeSplit[1]);
        int milliseconds = Integer.parseInt(qualifyingTimeSplit[2]);

        int totalMilliseconds = (minutes * 60000) + (seconds * 1000)
                                + milliseconds;

        return totalMilliseconds;
    }
}