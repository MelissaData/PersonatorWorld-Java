package com.melissadata.personatorworld.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

public class PersonatorWorldTransaction {

    private final String endpoint;

    private PersonatorWorldOptions options;

    private String identNumber;
    private String nationalID, fullName, companyName, dateOfBirth, phone, email;
    private String addressLine1, addressLine2, addressLine3, addressLine4,
                   locality, administrativeArea, postalCode, country;

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
        try {
            URL url = new URL(request);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String responseBody = in.lines().collect(Collectors.joining());
            response = getPrettyJSON(responseBody);

        } catch (Exception e){
            System.out.println("Error sending request: \n" + e);
        }
        return response;
    }

    private String getPrettyJSON(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject responseObject = gson.fromJson(json, JsonObject.class);
        return gson.toJson(responseObject);
    }

    public String generateRequestString(PersonatorWorldOptions option) {
        StringBuilder sb = new StringBuilder();

        sb.append(endpoint)
            .append("&id=" + getIdentNumber())
            .append(option.generateOptionString())

            .append(generateRequestParam("act", getActions()))
            .append(generateRequestParam("nat", getNationalID()))
            .append(generateRequestParam("full", getFullName()))
            .append(generateRequestParam("comp", getCompanyName()))
            .append(generateRequestParam("phone", getPhone()))
            .append(generateRequestParam("email", getEmail()))
            .append(generateRequestParam("dob", getDateOfBirth()))
            .append(generateRequestParam("a1", getAddressLine1()))
            .append(generateRequestParam("a2", getAddressLine2()))
            .append(generateRequestParam("a3", getAddressLine3()))
            .append(generateRequestParam("a4", getAddressLine4()))
            .append(generateRequestParam("loc", getLocality()))
            .append(generateRequestParam("admarea", getAdministrativeArea()))
            .append(generateRequestParam("postal", getPostalCode()))
            .append(generateRequestParam("ctry", getCountry()));

        return sb.toString();
    }

    private String generateRequestParam(String arg, String value) {
        String encodedValue = "";
        try {
            encodedValue = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding Exception: " + e);
        }

        if(!encodedValue.equals("")) {
            return "&" + arg + "=" + encodedValue;
        }

        return "";
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
