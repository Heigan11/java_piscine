package enaums;

public enum Button {
    LEFT('a'),
    UP('w'),
    RIGHT('d'),
    DOWN('s'),
    CONFIRM('8'),
    GIVE_UP('9'),
    UNKNOWN('0');

    private char symbol;

    Button(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Button getButtonBySymbol(char symbol){
        for (Button button : values()){
            if (button.symbol == symbol){
                return button;
            }
        }
        return UNKNOWN;
    }
}
