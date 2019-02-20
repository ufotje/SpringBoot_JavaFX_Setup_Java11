package app.utility.validation;

import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Demesmaecker Daniel on 26/10/2017.
 * utilityClass with ValidationMethods
 */
public class Validation {

    /**
     * Checks if the input follows a specified pattern
     * @param field String
     * @param value String
     * @param pattern String
     * @return boolean
     */
    public static boolean validate(String field, String value, String pattern){
        if(!value.isEmpty()){
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(value);
            if(m.find() && m.group().equals(value)){
                return true;
            }else{
                validationAlert(field, false);
                return false;
            }
        }else{
            validationAlert(field, true);
            return false;
        }
    }

    /**
     * Checks if a field is empty
     * @param field String
     * @param empty String
     * @return boolean
     */
    public static boolean emptyValidation(String field, boolean empty){
        if(!empty){
            return true;
        }else{
            validationAlert(field, true);
            return false;
        }
    }

    /**
     * Prompts the user with a warning when validation fails
     * @param field String
     * @param empty boolean
     */
    private static void validationAlert(String field, boolean empty){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
            if(empty) alert.setContentText("Please Enter "+ field);
            else alert.setContentText("Please Enter Valid "+ field);
        alert.showAndWait();
    }
}
