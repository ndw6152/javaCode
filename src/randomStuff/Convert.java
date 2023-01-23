package randomStuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

/**
 * Created by ndw6152 on 7/30/2018.
 */
class Pair {
    public String input;
    public String output;
    public double conversion;

    public Pair(String input, double inputVal, String output, double outputVal) {
        this.input = input;
        this.output = output;
        this.conversion = outputVal/inputVal;
    }
}

public class Convert {


    public Hashtable<String, Hashtable<String, Double>> createConversionTable(ArrayList<Pair> arr) {
        Hashtable<String, Hashtable<String, Double>> result = new Hashtable<>();

        for(Pair p : arr) {
            Hashtable<String, Double> content;
            if(!result.containsKey(p.input)) {
                content = new Hashtable<>();
            }
            else {
                content = result.get(p.input);
            }
            content.put(p.output, p.conversion);
            result.put(p.input, content);
        }
        return result;
    }

    public double convert(String input, String output, double val, Hashtable<String, Hashtable<String, Double>> table) {
        if(!table.containsKey(input)) {
            return -1;
        }
        else if(!table.get(input).containsKey(output)) {
            return -1;
        }
        double conversion = table.get(input).get(output);


        return val * conversion;
    }


    public static void main(String[] args) {
        Convert sol = new Convert();

        Pair euroToUsd = new Pair("euro", 0.85, "usd", 1);
        Pair usdToYen = new Pair("usd", 1, "yen", 111.29);
        Pair euroToYen = new Pair("euro", 1, "yen", 130.38);
        ArrayList<Pair> arr = new ArrayList<>();
        arr.add(euroToUsd); arr.add(usdToYen); arr.add(euroToYen);

        Hashtable<String, Hashtable<String, Double>> conversionTable = sol.createConversionTable(arr);

        System.out.println(sol.convert("euro", "yen", 3, conversionTable));


        ArrayList<Integer> arr2 = new ArrayList<>();
        //arr2.add(20);arr2.add(10);arr2.add(40);arr2.add(48);arr2.add(44);arr2.add(34);
        arr2.add(20);arr2.add(40);
        //Collections.sort(arr2.subList(0, 2));
        System.out.println(arr2);

    }
}