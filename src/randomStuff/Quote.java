package randomStuff;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Hashtable;

public class Quote {
    @SerializedName("comments")
    private String comments;

    @SerializedName("labor_cost")
    private Hashtable<String, Double> laborCostMap;

    @SerializedName("parts_cost")
    private Hashtable<String, Double> partsCostMap;

    @SerializedName("onsite_service_charges")
    int onSiteServiceCharge;


    @SerializedName("labor_cost2")
    private ArrayList<ItemCost> arr;

    public Quote() {
        laborCostMap = new Hashtable<>();
        partsCostMap = new Hashtable<>();
        arr = new ArrayList<>();
    }


    public class ItemCost {
        private String itemName;
        private double itemCost;

        public ItemCost(String name, double cost) {
            itemName = name;
            itemCost = cost;
        }
    }


    private void init() {
        laborCostMap.put("oil change", 10.0);
        laborCostMap.put("Door repair", 250.0);

        partsCostMap.put("4 tires", 330.0);
        partsCostMap.put("exhaust", 250.0);

        comments = "Hello world";

        onSiteServiceCharge = 5;

        arr.add(new ItemCost("change filter", 55.0));
        arr.add(new ItemCost("change window", 75.0));
    }

    public static String toJson(Object object) {
        Gson gson = new Gson();
        String str = gson.toJson(object);
        return str;
    }

    public static void main(String[] args) {
        Quote q = new Quote();
        q.init();

        toJson(q);

    }
}
