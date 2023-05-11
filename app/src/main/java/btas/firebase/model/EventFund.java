package btas.firebase.model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventFund implements BtasModel {
    private String eventId;
    private String funder;
    private String fundingMethod;
    private Map<String, Float> budgetList;
    private float totalCost;
    private float totalIncome;

    public String getId() {
        return eventId;
    }

    public void setId(String id) {
        eventId = id;
    }
}
