package com.melissadata.personatorworld.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.melissadata.personatorworld.model.PersonatorWorldTransaction;
import com.melissadata.personatorworld.model.PersonatorWorldOptions;
import com.melissadata.personatorworld.Main;

public class PersonatorWorldController {

    private Main main;
    private PersonatorWorldOptions option;

    private PersonatorWorldTransaction Transaction;

    @FXML
    private Button buttonSend;
    @FXML
    private Button buttonClear;
    @FXML
    private TabPane tabPane;
    private final int CONFIGURATION_TAB = 0;
    private final int RESPONSE_TAB = 1;

    @FXML
    private TextField inputLicenseKeyText;
    @FXML
    private TextField inputNationalIDText;
    @FXML
    private TextField inputFullNameText;
    @FXML
    private TextField inputCompanyText;
    @FXML
    private TextField inputDateOfBirthText;
    @FXML
    private TextField inputPhoneNumberText;
    @FXML
    private TextField inputEmailAddressText;
    @FXML
    private TextField inputAddressLine1Text;
    @FXML
    private TextField inputAddressLine2Text;
    @FXML
    private TextField inputAddressLine3Text;
    @FXML
    private TextField inputAddressLine4Text;

    @FXML
    private TextField inputLocalityText;
    @FXML
    private TextField inputAdministrativeAreaText;
    @FXML
    private TextField inputPostalCodeText;
    @FXML
    private TextField inputCountryText;

    @FXML
    private ComboBox<String> optionCorrectFirstNameBox;
    @FXML
    private ComboBox<String> optionNameHintBox;
    @FXML
    private ComboBox<String> optionGenderPopulationBox;
    @FXML
    private ComboBox<String> optionGenderAggressionBox;
    @FXML
    private ComboBox<String> optionMiddleNameLogicBox;

    @FXML
    private ComboBox<String> optionDeliveryLinesBox;
    @FXML
    private ComboBox<String> optionLineSeparatorBox;
    @FXML
    private ComboBox<String> optionOutputScriptBox;

    @FXML
    private ComboBox<String> optionPhoneVerifyBox;
    @FXML
    private ComboBox<String> optionCallerIDBox;
    @FXML
    private TextField optionDefaultCallingCodeBox;
    @FXML
    private TextField optionPhoneTimeToWaitBox;

    @FXML
    private ComboBox<String> optionVerifyMailboxBox;
    @FXML
    private ComboBox<String> optionDomainCorrectionBox;
    @FXML
    private TextField optionEmailTimeToWaitBox;

    @FXML
    private CheckBox actionVerifyCheckbox;
    @FXML
    private CheckBox actionScreenCheckbox;

    @FXML
    private TextArea RequestTextArea;
    @FXML
    private TextArea ResponseTextArea;

    @FXML
    private RadioButton jsonResponseFormatRadio;
    @FXML
    private RadioButton xmlResponseFormatRadio;
    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public PersonatorWorldController() {
        Transaction = new PersonatorWorldTransaction();
        option = new PersonatorWorldOptions();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        setActions();
        setupOptionSelections();
        initializeTextFields();
        sendButtonAction();
        clearButtonAction();
        updateRequestText();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * //@param mainApp
     */
    public void setMainApp(Main main) {
        this.main = main;
    }

    public void sendButtonAction() {
        buttonSend.setOnAction((event) -> {
            ResponseTextArea.setText(Transaction.processTransaction(RequestTextArea.getText()));
            tabPane.getSelectionModel().select(RESPONSE_TAB);
        });
    }

    public void clearButtonAction(){
        buttonClear.setOnAction((event) -> {
            inputNationalIDText.clear();
            inputFullNameText.clear();
            inputCompanyText.clear();
            inputDateOfBirthText.clear();
            inputPhoneNumberText.clear();
            inputEmailAddressText.clear();
            inputAddressLine1Text.clear();
            inputAddressLine2Text.clear();
            inputAddressLine3Text.clear();
            inputAddressLine4Text.clear();
            inputLocalityText.clear();
            inputAdministrativeAreaText.clear();
            inputPostalCodeText.clear();
            inputCountryText.clear();
            returnToConfiguration();
        });
    }

    public void initializeTextFields(){
        inputLicenseKeyText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setIdentNumber(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputNationalIDText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setNationalID(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputFullNameText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setFullName(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputCompanyText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setCompanyName(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputDateOfBirthText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setDateOfBirth(newvalue);
            updateRequestText();
            returnToConfiguration();
        });


        inputPhoneNumberText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setPhone(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputEmailAddressText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setEmail(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAddressLine1Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine1(newvalue);
            updateRequestText();
            returnToConfiguration();

        });

        inputAddressLine2Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine2(newvalue);
            updateRequestText();
            returnToConfiguration();

        });

        inputAddressLine3Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine3(newvalue);
            updateRequestText();
            returnToConfiguration();

        });

        inputAddressLine4Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine4(newvalue);
            updateRequestText();
            returnToConfiguration();

        });

        inputLocalityText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setLocality(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAdministrativeAreaText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAdministrativeArea(newvalue);
            updateRequestText();
            returnToConfiguration();
        });


        inputPostalCodeText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setPostalCode(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputCountryText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setCountry(newvalue);
            updateRequestText();
            returnToConfiguration();

        });

        optionDefaultCallingCodeBox.textProperty().addListener((observable, oldvalue, newvalue) -> {
           option.setOptionDefaultCallingCode(newvalue);
           Transaction.setOptions(option);
           updateRequestText();
           returnToConfiguration();
        });

        optionPhoneTimeToWaitBox.textProperty().addListener((observable, oldvalue, newvalue) -> {
            option.setOptionTimeToWaitPhone(newvalue);
            Transaction.setOptions(option);
            updateRequestText();
            returnToConfiguration();
        });

        optionEmailTimeToWaitBox.textProperty().addListener((observable, oldvalue, newvalue) -> {
            option.setOptionTimeToWaitEmail(newvalue);
            Transaction.setOptions(option);
            updateRequestText();
            returnToConfiguration();
        });
    }

    public void setActions() {

        actionVerifyCheckbox.setOnAction((event) -> {
            Transaction.setActionVerify(actionVerifyCheckbox.isSelected());
            updateRequestText();
            returnToConfiguration();
        });

        actionScreenCheckbox.setOnAction((event) -> {
            Transaction.setActionScreen(actionScreenCheckbox.isSelected());
            updateRequestText();
            returnToConfiguration();
        });
    }

    // Define what values each combo box can hold
    private void setupOptionSelections() {
        optionCorrectFirstNameBox.setItems(FXCollections.observableArrayList("", "Off", "On"));
        optionNameHintBox.setItems(FXCollections.observableArrayList("", "DefinitelyFull", "VeryLikelyFull", "ProbablyFull", "Varying", "ProbablyInverse",
                                                                    "VeryLikelyInverse", "DefinitelyInverse", "MixedFirstName", "MixedLastName"));
        optionGenderPopulationBox.setItems(FXCollections.observableArrayList("", "Mixed", "Male", "Female"));
        optionGenderAggressionBox.setItems(FXCollections.observableArrayList("", "Aggressive", "Neutral", "Conservative"));
        optionMiddleNameLogicBox.setItems(FXCollections.observableArrayList("", "ParseLogic", "HyphenatedLast", "MiddleName"));

        optionDeliveryLinesBox.setItems(FXCollections.observableArrayList("", "Off", "On"));
        optionLineSeparatorBox.setItems(FXCollections.observableArrayList("", "Semicolon", "Pipe", "CR", "LF", "CRLF", "Tab", "BR"));
        optionOutputScriptBox.setItems(FXCollections.observableArrayList("", "NoChange", "Latin", "Native"));

        optionPhoneVerifyBox.setItems(FXCollections.observableArrayList("", "Express", "Premium"));
        optionCallerIDBox.setItems(FXCollections.observableArrayList("", "Off", "On"));

        optionVerifyMailboxBox.setItems(FXCollections.observableArrayList("", "Express", "Premium"));
        optionDomainCorrectionBox.setItems(FXCollections.observableArrayList("", "On", "Off"));
    }

    public void optionCorrectFirstName() {
        option.setOptionCorrectFirstName(optionCorrectFirstNameBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }
    public void optionNameHint() {
        option.setOptionNameHint(optionNameHintBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void optionGenderPopulation() {
        option.setOptionGenderPopulation(optionGenderPopulationBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void optionGenderAggression() {
        option.setOptionGenderAggression(optionGenderAggressionBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void optionMiddleNameLogic() {
        option.setOptionMiddleNameLogic(optionMiddleNameLogicBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void optionDeliveryLines() {
        option.setOptionDeliveryLines(optionDeliveryLinesBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void optionLineSeparator() {
        option.setOptionLineSeparator(optionLineSeparatorBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void optionOutputScript() {
        option.setOptionOutputScript(optionOutputScriptBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void optionPhoneVerify() {
        option.setOptionPhoneVerifyLevel(optionPhoneVerifyBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void optionCallerID() {
        option.setOptionCallerID(optionCallerIDBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void optionVerifyMailbox() {
        option.setOptionEmailVerifyMailboxLevel(optionVerifyMailboxBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void setOptionDomainCorrection() {
        option.setOptionDomainCorrection(optionDomainCorrectionBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    private void returnToConfiguration(){
        if(tabPane.getSelectionModel().getSelectedIndex() != 0)	tabPane.getSelectionModel().select(CONFIGURATION_TAB);

    }

    private void updateRequestText(){
        RequestTextArea.setText(Transaction.generateRequestString(option));
    }
}
