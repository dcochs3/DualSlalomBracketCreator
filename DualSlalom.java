import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DualSlalom {
    private static ArrayList<Rider> riderList = new ArrayList<Rider>();

    public static void main(String[] args) {
        if (args.length == 0) {
            //the user did not enter a filename
            System.out.println("\nError! You must enter a csv file.");
            System.out.println("Example:");
            System.out.println("java DualSlalom qualifyingtimes.csv");
            return;
        }

        //otherwise, parse the file
        String csvFile = args[0];
        BufferedReader br = null;
        FileWriter fw = null;
        String line = "";
        String cvsSplitBy = ",";
        int skip = 0;
        String category = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] lineContents = line.split(cvsSplitBy);

                if (lineContents.length == 1) {
                    //this line contains the category name
                    //create a file with that name

                    //if riderList has stuff in it,
                    //write to the file we created last time
                    if ((riderList.size() > 0) && (fw != null)) {
                        
                        Collections.sort(riderList);

                        Scanner scan = new Scanner(System.in);

                        System.out.println("There are " + riderList.size()
                            + " riders for the " + category + " category.");
                        System.out.println("Please select how many riders"
                            + " you would like to qualify.");

                        if (riderList.size() >= 2) {
                            //2-3 : show up to 2
                            System.out.println("2");
                        }
                        if (riderList.size() >= 4) {
                            //4-7 : show up to 4
                            System.out.println("4");
                        }
                        if (riderList.size() >= 8) {
                            //8-15 : show up to 8
                            System.out.println("8");
                        }
                        if (riderList.size() >= 16) {
                            //16-31 : show up to 16
                            System.out.println("16");
                        }
                        if (riderList.size() >= 32) {
                            //32-63 : show up to 32
                            System.out.println("32");
                        }
                        if (riderList.size() >= 64) {
                            //64+ : show up to 64
                            System.out.println("64");
                        }

                        String action = scan.nextLine();

                        try {
                            Integer.parseInt(action);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input.");
                            return;
                        }

                        int numRiders = Integer.parseInt(action);

                        if ((numRiders != 2) && (numRiders != 4) && 
                            (numRiders != 8) && (numRiders != 16) &&
                            (numRiders != 32) && (numRiders != 64)) {
                            //invalid input
                            System.out.println("Invalid input.");
                            return;
                        }

                        int numToRemove = riderList.size() - numRiders;

                        if (numToRemove < 0) {
                            //invalid input
                            System.out.println("Invalid input.");
                            return;
                        }

                        for (int i = 0; i < numToRemove; i++) {
                            riderList.remove(riderList.size() - 1);
                        }

                        //write to the file
                        fw.append(category);
                        fw.append("\n");

                        fw.append("Seed");
                        fw.append(",");
                        fw.append("Name");
                        fw.append(",");
                        fw.append("Number");
                        fw.append(",");
                        fw.append("Qualifying Time");
                        fw.append("\n");

                        for (int i = 0; i < riderList.size() / 2; i++) {
                            //Rider 1
                            //seed
                            fw.append(Integer.toString(i + 1));
                            fw.append(",");
                            //name
                            fw.append(riderList.get(i).getRiderName());
                            fw.append(",");
                            //number
                            fw.append(riderList.get(i).getRiderNumber());
                            fw.append(",");
                            //time
                            fw.append(riderList.get(i).getQualifyingTime());
                            fw.append("\n");

                            //Rider 2
                            //seed
                            fw.append(Integer.toString(riderList.size() - i));
                            fw.append(",");
                            //name
                            fw.append(riderList.get(riderList.size() - i - 1).getRiderName());
                            fw.append(",");
                            //number
                            fw.append(riderList.get(riderList.size() - i - 1).getRiderNumber());
                            fw.append(",");
                            //time
                            fw.append(riderList.get(riderList.size() - i - 1).getQualifyingTime());
                            fw.append("\n");
                            fw.append("\n");
                        }
                        
                        //then close the file
                        fw.flush();
                        fw.close();
                        fw = null;
                        riderList.clear();
                    }

                    category = lineContents[0];
                    fw = new FileWriter(category + ".csv");
                    skip = 1; //set this so we skip parsing the next line
                } else if (lineContents.length == 0) {
                    //do nothing
                } else {
                    if (skip == 0) {
                        //add riders to our riderList
                        String name = lineContents[0];
                        String number = lineContents[1];
                        String qualifyingtime = lineContents[2];
                        Rider r = new Rider(name, number, qualifyingtime);
                        riderList.add(r);
                    } else {
                        //skip == 1
                        //skip parsing this line
                        skip = 0;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                //we need to close the buffered reader
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}