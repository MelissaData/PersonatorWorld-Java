package com.melissadata.personatorworld.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonatorWorldOptions {
    private final StringProperty optionCorrectFirstName;
    private final StringProperty optionNameHint;
    private final StringProperty optionGenderPopulation;
    private final StringProperty optionGenderAggression;
    private final StringProperty optionMiddleNameLogic;

    private final StringProperty optionDeliveryLines;
    private final StringProperty optionLineSeparator;
    private final StringProperty optionOutputScript;

    private final StringProperty optionPhoneVerifyLevel;
    private final StringProperty optionCallerID;
    private final StringProperty optionDefaultCallingCode;
    private final StringProperty optionTimeToWaitPhone;

    private final StringProperty optionEmailVerifyMailboxLevel;
    private final StringProperty optionDomainCorrection;
    private final StringProperty optionTimeToWaitEmail;

    public PersonatorWorldOptions() {
        optionCorrectFirstName        = new SimpleStringProperty("");
        optionNameHint                = new SimpleStringProperty("");
        optionGenderPopulation        = new SimpleStringProperty("");
        optionGenderAggression        = new SimpleStringProperty("");
        optionMiddleNameLogic         = new SimpleStringProperty("");

        optionDeliveryLines           = new SimpleStringProperty("");
        optionLineSeparator           = new SimpleStringProperty("");
        optionOutputScript            = new SimpleStringProperty("");

        optionPhoneVerifyLevel        = new SimpleStringProperty("");
        optionCallerID                = new SimpleStringProperty("");
        optionDefaultCallingCode      = new SimpleStringProperty("");
        optionTimeToWaitPhone         = new SimpleStringProperty("");

        optionEmailVerifyMailboxLevel = new SimpleStringProperty("");
        optionDomainCorrection        = new SimpleStringProperty("");
        optionTimeToWaitEmail         = new SimpleStringProperty("");
    }

    public String generateOptionString() {
        String optionString = "";

        String nameOptions = generateNameOptionString();
        String addressOptions = generateAddressOptionString();
        String phoneOptions = generatePhoneOptionString();
        String emailOptions = generateEmailOptionString();

        if(!nameOptions.equals(""))
            optionString += "&nameOpt=" + nameOptions;

        if(!addressOptions.equals(""))
            optionString += "&AddrOpt=" + addressOptions;

        if(!phoneOptions.equals(""))
            optionString += "&PhoneOpt=" + phoneOptions;

        if(!emailOptions.equals(""))
            optionString += "&EmailOpt=" + emailOptions;
        return optionString;
    }

    // Generate Name Options Portion of String
    public String generateNameOptionString(){
        String[] options = {
            generateOptionParam("CorrectFirstName", getOptionCorrectFirstName()),
            generateOptionParam("NameHint", getOptionNameHint()),
            generateOptionParam("GenderPopulation", getOptionGenderPopulation()),
            generateOptionParam("GenderAggression", getOptionGenderAggression()),
            generateOptionParam("MiddleNameLogic", getOptionMiddleNameLogic()),
        };

        return joinOptionParams(options);
    }

    // Generate Address Option Portion of String
    public String generateAddressOptionString(){
        String[] options = {
            generateOptionParam("DeliveryLines", getOptionDeliveryLines()),
            generateOptionParam("LineSeparator", getOptionLineSeparator()),
            generateOptionParam("OutputScript", getOptionOutputScript()),
        };
        return joinOptionParams(options);
    }

    // Generate Phone Option Portion of String
    public String generatePhoneOptionString(){
        String[] options = {
            generateOptionParam("VerifyPhone", getOptionPhoneVerifyLevel()),
            generateOptionParam("CallerID", getOptionCallerID()),
            generateOptionParam("DefaultCallingCode", getOptionDefaultCallingCode()),
            generateOptionParam("TimeToWait", getOptionTimeToWaitPhone()),
        };
        return joinOptionParams(options);
    }

    // Generate Email Option Portion of String
    public String generateEmailOptionString() {
        String[] options = {
            generateOptionParam("VerifyMailbox", getOptionEmailVerifyMailboxLevel()),
            generateOptionParam("DomainCorrection", getOptionDomainCorrection()),
            generateOptionParam("TimeToWait", getOptionTimeToWaitEmail()),
        };
        return joinOptionParams(options);
    }

    private String generateOptionParam(String name, String value) {
        return value.equals("") ? "" : name + ":" + value;
    }

    private String joinOptionParams(String[] options) {
        List<String> optionList = new ArrayList<>();
        for (String option : options) {
            if(!option.equals("")) optionList.add(option);
        }
        return String.join(",", optionList);
    }

    public String getOptionCorrectFirstName() {
        return optionCorrectFirstName.get();
    }

    public StringProperty optionCorrectFirstNameProperty() {
        return optionCorrectFirstName;
    }

    public void setOptionCorrectFirstName(String optionCorrectFirstName) {
        this.optionCorrectFirstName.set(optionCorrectFirstName);
    }

    public String getOptionNameHint() {
        return optionNameHint.get();
    }

    public StringProperty optionNameHintProperty() {
        return optionNameHint;
    }

    public void setOptionNameHint(String optionNameHint) {
        this.optionNameHint.set(optionNameHint);
    }

    public String getOptionGenderPopulation() {
        return optionGenderPopulation.get();
    }

    public StringProperty optionGenderPopulationProperty() {
        return optionGenderPopulation;
    }

    public void setOptionGenderPopulation(String optionGenderPopulation) {
        this.optionGenderPopulation.set(optionGenderPopulation);
    }

    public String getOptionGenderAggression() {
        return optionGenderAggression.get();
    }

    public StringProperty optionGenderAggressionProperty() {
        return optionGenderAggression;
    }

    public void setOptionGenderAggression(String optionGenderAggression) {
        this.optionGenderAggression.set(optionGenderAggression);
    }

    public String getOptionMiddleNameLogic() {
        return optionMiddleNameLogic.get();
    }

    public StringProperty optionMiddleNameLogicProperty() {
        return optionMiddleNameLogic;
    }

    public void setOptionMiddleNameLogic(String optionMiddleNameLogic) {
        this.optionMiddleNameLogic.set(optionMiddleNameLogic);
    }

    public String getOptionDeliveryLines() {
        return optionDeliveryLines.get();
    }

    public StringProperty optionDeliveryLinesProperty() {
        return optionDeliveryLines;
    }

    public void setOptionDeliveryLines(String optionDeliveryLines) {
        this.optionDeliveryLines.set(optionDeliveryLines);
    }

    public String getOptionLineSeparator() {
        return optionLineSeparator.get();
    }

    public StringProperty optionLineSeparatorProperty() {
        return optionLineSeparator;
    }

    public void setOptionLineSeparator(String optionLineSeparator) {
        this.optionLineSeparator.set(optionLineSeparator);
    }

    public String getOptionOutputScript() {
        return optionOutputScript.get();
    }

    public StringProperty optionOutputScriptProperty() {
        return optionOutputScript;
    }

    public void setOptionOutputScript(String optionOutputScript) {
        this.optionOutputScript.set(optionOutputScript);
    }

    public String getOptionPhoneVerifyLevel() {
        return optionPhoneVerifyLevel.get();
    }

    public StringProperty optionPhoneVerifyLevelProperty() {
        return optionPhoneVerifyLevel;
    }

    public void setOptionPhoneVerifyLevel(String optionPhoneVerifyLevel) {
        this.optionPhoneVerifyLevel.set(optionPhoneVerifyLevel);
    }

    public String getOptionCallerID() {
        return optionCallerID.get();
    }

    public StringProperty optionCallerIDProperty() {
        return optionCallerID;
    }

    public void setOptionCallerID(String optionCallerID) {
        this.optionCallerID.set(optionCallerID);
    }

    public String getOptionDefaultCallingCode() {
        return optionDefaultCallingCode.get();
    }

    public StringProperty optionDefaultCallingCodeProperty() {
        return optionDefaultCallingCode;
    }

    public void setOptionDefaultCallingCode(String optionDefaultCallingCode) {
        this.optionDefaultCallingCode.set(optionDefaultCallingCode);
    }

    public String getOptionTimeToWaitPhone() {
        return optionTimeToWaitPhone.get();
    }

    public StringProperty optionTimeToWaitPhoneProperty() {
        return optionTimeToWaitPhone;
    }

    public void setOptionTimeToWaitPhone(String optionTimeToWaitPhone) {
        this.optionTimeToWaitPhone.set(optionTimeToWaitPhone);
    }

    public String getOptionEmailVerifyMailboxLevel() {
        return optionEmailVerifyMailboxLevel.get();
    }

    public StringProperty optionEmailVerifyMailboxLevelProperty() {
        return optionEmailVerifyMailboxLevel;
    }

    public void setOptionEmailVerifyMailboxLevel(String optionEmailVerifyMailboxLevel) {
        this.optionEmailVerifyMailboxLevel.set(optionEmailVerifyMailboxLevel);
    }

    public String getOptionDomainCorrection() {
        return optionDomainCorrection.get();
    }

    public StringProperty optionDomainCorrectionProperty() {
        return optionDomainCorrection;
    }

    public void setOptionDomainCorrection(String optionDomainCorrection) {
        this.optionDomainCorrection.set(optionDomainCorrection);
    }

    public String getOptionTimeToWaitEmail() {
        return optionTimeToWaitEmail.get();
    }

    public StringProperty optionTimeToWaitEmailProperty() {
        return optionTimeToWaitEmail;
    }

    public void setOptionTimeToWaitEmail(String optionTimeToWaitEmail) {
        this.optionTimeToWaitEmail.set(optionTimeToWaitEmail);
    }

}
