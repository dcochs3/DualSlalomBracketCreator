import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    private static ArrayList<Rider> riderList = new ArrayList<Rider>();

    public static void main(String[] args) {
        Rider r1 = new Rider("Jeff", "2", "0:33:622"); //2
        Rider r2 = new Rider("Leslie", "3", "0:30:622"); //1
        Rider r3 = new Rider("Ryan", "4", "0:43:622"); //4
        Rider r4 = new Rider("Jacob", "6", "0:36:622"); //3
        Rider r5 = new Rider("Josh", "7", "0:33:622"); //

        riderList.add(r1);
        riderList.add(r2);
        riderList.add(r3);
        riderList.add(r4);
        riderList.add(r5);

        for (Rider r : riderList) {
            System.out.println(r.getRiderName());
        }

        Collections.sort(riderList);

        for (Rider r : riderList) {
            System.out.println(r.getRiderName());
        }
    }
}