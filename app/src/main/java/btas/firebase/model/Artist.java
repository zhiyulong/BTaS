package btas.firebase.model;

import java.util.List;
import java.util.Map;

import com.google.cloud.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Artist implements BtasModel {
    private String id;
    private String artistName;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth; // YYYY-MM-DD
    private Map<String, String> socialMediaAccounts;
    private List<String> marketingPreferences;
    private List<String> musicPreferences;
    
    // private List<String> userGeneratedContent;
    // private List<String> fanClubMembership;
    // private List<String> purchaseHistory;
}
