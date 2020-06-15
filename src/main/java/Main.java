import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        Converter converter = new Converter();
        Validator validator = new Validator();
        Calculator calculator = new Calculator(validator, converter);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = reader.readLine()) != null) {


            System.out.println(calculator.calculate(line));
        }

    }
}
