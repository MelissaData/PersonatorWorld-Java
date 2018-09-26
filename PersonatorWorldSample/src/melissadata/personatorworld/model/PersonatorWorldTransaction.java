package melissadata.personatorworld.model;

import org.apache.sling.commons.json.JSONObject;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

public class PersonatorWorldTransaction {

    private final String endpoint;

    private PersonatorWorldOptions options;

    private String identNumber;
    private String nationalID, fullName, companyName, dateOfBirth, phone, email;
    private String addressLine1, addressLine2, addressLine3, addressLine4, locality, administrativeArea, postalCode, country;

    private boolean actionVerify;
    private boolean actionScreen;
    public PersonatorWorldTransaction() {
        endpoint            = "https://globalpersonator.melissadata.net/v1/doContactVerify?";
        identNumber         = "";
        nationalID          = "";
        fullName            = "";
        companyName         = "";
        dateOfBirth         = "";
        phone               = "";
        email               = "";
        addressLine1        = "";
        addressLine2        = "";
        addressLine3        = "";
        addressLine4        = "";
        locality            = "";
        administrativeArea  = "";
        postalCode          = "";
        country             = "";
        actionVerify        = false;
        actionScreen        = false;
    }

    public String processTransaction(String request) {
        String response = "";
        URI uri;
        URL url;
        try {
            uri = new URI(request);
            url = new URL(uri.toURL().toString());

            HttpURLConnection urlConn = (HttpURLConnection)(url.openConnection());

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringReader reader;
            StringWriter writer = new StringWriter();
            StringBuilder jsonResponse = new StringBuilder();
            String inputLine = "";

            while ((inputLine = in.readLine()) != null) {
                jsonResponse.append(inputLine);
            }
            @SuppressWarnings("deprecation")
            JSONObject test = new JSONObject(jsonResponse.toString());
            response = test.toString(10);


        } catch (Exception e){
            System.out.println("Error sending request: \n" + e);
        }
        return response;
    }

    public String generateRequestString(PersonatorWorldOptions option) {
        String request = "";
        request = endpoint;
        request += "&id=" + getIdentNumber();
        request += option.generateOptionString();
        try {
            request += "&act=" + getActions();
            if(!getNationalID().equals(""))
                request += "&nat=" + URLEncoder.encode(getNationalID(), "UTF-8");

            if(!getFullName().equals(""))
                request += "&full=" + URLEncoder.encode(getFullName(), "UTF-8");

            if(!getCompanyName().equals(""))
                request += "&comp=" + URLEncoder.encode(getCompanyName(), "UTF-8");

            if(!getPhone().equals(""))
                request += "&phone=" + URLEncoder.encode(getPhone(), "UTF-8");

            if(!getEmail().equals(""))
                request += "&email=" + URLEncoder.encode(getEmail(), "UTF-8");

            if(!getDateOfBirth().equals(""))
                request += "&dob=" + URLEncoder.encode(getDateOfBirth(), "UTF-8");

            if(!getAddressLine1().equals(""))
                request += "&a1=" + URLEncoder.encode(getAddressLine1(), "UTF-8");

            if(!getAddressLine2().equals(""))
                request += "&a2=" + URLEncoder.encode(getAddressLine2(), "UTF-8");

            if(!getAddressLine3().equals(""))
                request += "&a3=" + URLEncoder.encode(getAddressLine3(), "UTF-8");

            if(!getAddressLine4().equals(""))
                request += "&a4=" + URLEncoder.encode(getAddressLine4(), "UTF-8");

            if(!getLocality().equals(""))
                request += "&loc=" + URLEncoder.encode(getLocality(), "UTF-8");

            if(!getAdministrativeArea().equals(""))
                request += "&admarea=" + URLEncoder.encode(getAdministrativeArea(), "UTF-8");

            if(!getPostalCode().equals(""))
                request += "&postal=" + URLEncoder.encode(getPostalCode(), "UTF-8");

            if(!getCountry().equals(""))
                request += "&ctry=" + URLEncoder.encode(getCountry(), "UTF-8");

        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding Exception: " +e);
        }



        return request;
    }

    public PersonatorWorldOptions getOptions() {
        return options;
    }

    public void setOptions(PersonatorWorldOptions options) {
        this.options = options;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isActionVerify() {
        return actionVerify;
    }

    public void setActionVerify(boolean actionVerify) {
        this.actionVerify = actionVerify;
    }


    public boolean isActionScreen() {
        return actionScreen;
    }

    public void setActionScreen(boolean actionScreen) {
        this.actionScreen = actionScreen;
    }

    public String getActions() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Check");
        if(isActionVerify())
            tmp.append(",verify");
        if(isActionScreen())
            tmp.append(",screen");
        return tmp.toString();
    }
}
