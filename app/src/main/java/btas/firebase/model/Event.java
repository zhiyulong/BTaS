package btas.firebase.model;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Event implements BtasModel {
    private String id;
    private String eventName;
    private String time;
    private List<String> locations;
    private List<String> artistIds;
    private List<String> salesMerchIds;
    private List<String> marketingPreferences;
    private List<String> reflectiveDocuments;
    private List<String> relativeDocuments;
    private Map<String, Double> venueFlow;
    private Map<String, Double> platformFlow;
    private Map<String, String> memberJobSegment;

    // private String eventDetails;  
    // private String image;
    // private String movingImage;
    // private String audio;
    // private String sound;
    // private String perspection;
}
