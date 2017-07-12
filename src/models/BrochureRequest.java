package models;

/**
 * Created by Sem on 09-Jul-17.
 */
public class BrochureRequest {
    int id;
    String type;
    String destination;
    String contactName;
    String contactAdress;
    String contactPostalCode;
    String contactPlaceofResidence;
    String contactPhone;
    String contactMobilePhone;
    String email;
    String remarks;
    boolean contactCanCallback;

    public BrochureRequest(int id, String type, String destination, String contactName,
                           String contactAdress, String contactPostalCode, String contactPlaceofResidence,
                           String contactPhone, String contactMobilePhone, String email, String remarks,
                           boolean contactCanCallback) {
        this.id = id;
        this.type = type;
        this.destination = destination;
        this.contactName = contactName;
        this.contactAdress = contactAdress;
        this.contactPostalCode = contactPostalCode;
        this.contactPlaceofResidence = contactPlaceofResidence;
        this.contactPhone = contactPhone;
        this.contactMobilePhone = contactMobilePhone;
        this.email = email;
        this.remarks = remarks;
        this.contactCanCallback = contactCanCallback;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDestination() {
        return destination;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactAdress() {
        return contactAdress;
    }

    public String getContactPostalCode() {
        return contactPostalCode;
    }

    public String getContactPlaceofResidence() {
        return contactPlaceofResidence;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactMobilePhone() {
        return contactMobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getRemarks() {
        return remarks;
    }

    public boolean isContactCanCallback() {
        return contactCanCallback;
    }

}
