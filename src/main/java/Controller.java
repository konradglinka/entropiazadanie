import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    ChoiceBox<String> alphabetChoiceBox;
    @FXML
    TextField howManyInformationsInBinaryMessage;
    @FXML
    TextField efectiveEntropy;
    @FXML
    TextField conditionalEntropy;
    @FXML
    TextField binaryAlphabetEntropy;
    @FXML
    TextField howManyCharsInBinnaryMessage;
    @FXML
    TextField entropyOfAlfabet;
    @FXML
    TextArea binnaryMessage;
    @FXML
    TextField probabilityOfError;
    @FXML
    TextField message;
    @FXML
    VBox firstBox;
    @FXML
    VBox secoundBox;



    double entropyOfAlfabetResult;
    double probabilityOfErrorResult;
    double pomValue;
    Helper helper=new Helper();
    @FXML
    void initialize()  {
    alphabetChoiceBox.getItems().add("POLSKI - 32 ZNAKI");
    alphabetChoiceBox.getItems().add("ANGIELSKI - 26 ZNAKÓW");
    alphabetChoiceBox.getItems().add("NIEMIECKI - 30 ZNAKÓW");
    alphabetChoiceBox.getSelectionModel().select(0);
    helper.onlyPlusDigitsInTextField(probabilityOfError);


    }

    @FXML
    void onClickNextButton()  {
        if(message.getText().length()<=0||probabilityOfError.getText().length()<=0||Double.parseDouble(probabilityOfError.getText())>1.0||Double.parseDouble(probabilityOfError.getText())<0.0){
             Alert warningAlert = new Alert(Alert.AlertType.WARNING);
          warningAlert.setTitle("Nieprawidłowe dane wejściowe");
            warningAlert.getDialogPane().setStyle("-fx-font-size: 16px;");
            warningAlert.setHeaderText(null);
            warningAlert.setContentText("Wprowadzono nieprawidłowe dane wejściowe.\n" +
                    "Prawdopobieństwo błedu musi być między 0-1, a wiadomość nie może być pusta.");
            warningAlert.showAndWait();
        }
        else {
            firstBox.setVisible(false);
            secoundBox.setVisible(true);
            if (alphabetChoiceBox.getSelectionModel().getSelectedItem().equals("POLSKI - 32 ZNAKI")) {
                entropyOfAlfabetResult = helper.roundTwoDecimalPlaces(helper.log2(32.0));
            } else if (alphabetChoiceBox.getSelectionModel().getSelectedItem().equals("ANGIELSKI - 26 ZNAKÓW")) {
                entropyOfAlfabetResult = helper.roundTwoDecimalPlaces(helper.log2(26.0));
            } else {
                entropyOfAlfabetResult = helper.roundTwoDecimalPlaces(helper.log2(30.0));
            }
            probabilityOfErrorResult = Double.parseDouble(probabilityOfError.getText());
            entropyOfAlfabet.setText(String.valueOf(entropyOfAlfabetResult));
            binnaryMessage.setText(helper.getBinaryCode(message.getText()));
            howManyCharsInBinnaryMessage.setText(String.valueOf(binnaryMessage.getText().length()));
            binaryAlphabetEntropy.setText(String.valueOf(helper.log2(2.0)));
            pomValue = 1 - probabilityOfErrorResult;
            conditionalEntropy.setText(String.valueOf(-probabilityOfErrorResult * helper.log2(probabilityOfErrorResult) - pomValue * helper.log2(pomValue)));
            efectiveEntropy.setText(String.valueOf(Double.parseDouble(binaryAlphabetEntropy.getText()) - Double.parseDouble(conditionalEntropy.getText())));
            howManyInformationsInBinaryMessage.setText(String.valueOf(
                    Double.parseDouble(efectiveEntropy.getText()) * Double.parseDouble(howManyCharsInBinnaryMessage.getText())));
        }
    }

    @FXML
    void onExit(){
        System.exit(0);
    }
}