import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class Helper {
    public double log2(double input) {
        double result = (Math.log(input) / Math.log(2));
        return result;
    }

    public double roundTwoDecimalPlaces(double input) {
        return Math.round(input * 100) / 100.00;
    }

    public String getBinaryCode(String input) {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < input.length(); i++) {
            output.append(
                    String.format("%8s", Integer.toBinaryString(input.charAt(i))).replaceAll(" ", "0")
            );
        }
        return output.toString();
    }

    public void onlyPlusDigitsInTextField(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() { //Method let user write only numbers or .
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[0-9]*\\.?[0-9]*")) {
                    textField.setText(oldValue);
                }
            }
        });
    }


}
