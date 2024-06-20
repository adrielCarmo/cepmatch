package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaCEP {
    public boolean isValid(String cep) {
        boolean result;
        if (cep == null || cep.isEmpty()) {
            result = true;
        } else {
            Pattern pattern = Pattern.compile("^(([0-9]{2}\\.[0-9]{3}-[0-9]{3})|([0-9]{2}[0-9]{3}-[0-9]{3})|([0-9]{8}))$");
            Matcher matcher = pattern.matcher(cep);
            result = matcher.find();
        }
        return result;
    }
}
