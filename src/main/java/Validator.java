import java.util.List;

public class Validator implements ExpressionValidator{

    private static final String SUBTRACT = Operator.SUBTRACT.getToken();
    private static final String OPENING_BRACKET = Bracket.OPENING_BRACKET.getToken();
    private static final String CLOSING_BRACKET = Bracket.CLOSING_BRACKET.getToken();

    @Override
    public boolean isValidate(List<String> expression) {
        String leftOfToken = null;
        String rightOfToken = null;
        Integer openingBracketPosition = null;
        for (int i = 0; i < expression.size(); i++) {
            String token = expression.get(i);

            if (i != 0) {
                leftOfToken = expression.get(i - 1);
            }

            if (i < expression.size()-1){
                rightOfToken = expression.get(i + 1);
            }

            if (Operator.isOperator(token)){
                if (Operator.isOperator(leftOfToken) || Operator.isOperator(rightOfToken))
                    return false;
            } else if (OPENING_BRACKET.equals(token)){
                openingBracketPosition = i;
                if (isOperand(leftOfToken) || !SUBTRACT.equals(rightOfToken) && Operator.isOperator(rightOfToken)){
                    return false;
                } else if (leftOfToken != null && leftOfToken.equals(CLOSING_BRACKET)){
                    return false;
                }
            } else if (CLOSING_BRACKET.equals(token)){
                if (openingBracketPosition == null || openingBracketPosition > i){
                    return false;
                } else if (Operator.isOperator(leftOfToken) || isOperand(rightOfToken)){
                    return false;
                } else if (leftOfToken != null && leftOfToken.equals(OPENING_BRACKET)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isOperand(String token) {
        if (token == null){
            return false;
        }
        return !Operator.isOperator(token) && !Bracket.isBracket(token);
    }

}
