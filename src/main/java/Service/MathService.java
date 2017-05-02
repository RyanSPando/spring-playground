package Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathService {
    private static final Map<String, String> operatorMap = createOperatorMap();

    public static String calculate(String operation, String x, String y) {
        BigDecimal total;
        String operator = "+";

        if (operation != null)
            operator = operatorMap.get(operation);

        switch (operator) {
            case "+":
                total = new BigDecimal(x).add(new BigDecimal(y));
                break;
            case "*":
                total = new BigDecimal(x).multiply(new BigDecimal(y));
                break;
            case "-":
                total = new BigDecimal(x).subtract(new BigDecimal(y));
                break;
            case "/":
                total = new BigDecimal(x).divide(new BigDecimal(y));
                break;
            default:
                total = new BigDecimal(x).add(new BigDecimal(y));
                break;
        }

        return String.format("%s %s %s = %s", x, operator, y,
                new DecimalFormat("0.##").format(total));
    }

    private static Map<String,String> createOperatorMap() {
        Map<String, String> operatorMap = new HashMap<>();
        operatorMap.put("add", "+");
        operatorMap.put("subtract", "-");
        operatorMap.put("multiply", "*");
        operatorMap.put("divide", "/");

        return operatorMap;
    }

    public static String sum(List<String> params) {
        String message = params.stream().reduce((x,y) -> x + " + " + y).get();
        BigDecimal total = params.stream().map(BigDecimal::new).reduce(BigDecimal::add).get();

        return message + " = " + new DecimalFormat("0.##").format(total);
    }
}
