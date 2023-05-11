package btas.firebase.model;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Merch implements BtasModel {

    private String id;
    private String merchName;
    private String merchType;
    private String designer;
    private String manufacture;
    private double cost;
    private double price;
    private int totalAmount;
    private double salesAmount;
    private List<String> marketingPreferences;
    private Map<String, Double> offlineDistributors;  // name:commision
    private Map<String, Double> onlineDistributors;
    // private double discountedPrice;
    // private List<String> userPreferences;

}
