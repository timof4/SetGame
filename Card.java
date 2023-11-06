public class Card {
    static int SQUIGGLE = 0;
    static int DIAMOND = 1;
    static int OVAL = 2;
    
    static int EMPTY = 0;
    static int LINED = 1;
    static int FULL = 2;
    
    static int GREEN = 0;
    static int RED = 1;
    static int BLUE = 2;
    
    static int COUNT1 = 0;
    static int COUNT2 = 1;
    static int COUNT3 = 2;
    
    int shape;
    int fill;
    int color;
    int count;
    boolean alive = true;
    
    Card (int shape, int fill, int color, int count) {
        this.shape = shape;
        this.fill = fill;
        this.color = color;
        this.count = count;
    }
    void printCard() {
        if (shape == SQUIGGLE) {System.out.print("Squiggle, ");}
        else if (shape == DIAMOND) {System.out.print("Diamond, ");}
        else if (shape == OVAL) {System.out.print("Oval, ");}
        if (fill == EMPTY) {System.out.print("Empty, ");}
        else if (fill == LINED) {System.out.print("Lined, ");}
        else if (fill == FULL) {System.out.print("Full, ");}
        if (color == GREEN) {System.out.print("Green, ");}
        else if (color == RED) {System.out.print("Red, ");}
        else if (color == BLUE) {System.out.print("Blue, ");}
        if (count == COUNT1) {System.out.print("Squiggle, ");}
        else if (shape == DIAMOND) {System.out.print("Diamond, ");}
        else if (shape == OVAL) {System.out.print("Oval, ");}
    }
    boolean checkSet(Card card2, Card card3) {
        if (card2 == card3 || this == card2 || this == card3) {return false;}
        if (!((shape == card2.shape && shape == card3.shape)  || (shape + card2.shape + card3.shape == 3))) {return false;}
        if (!((fill == card2.fill && fill == card3.fill)  || (fill + card2.fill + card3.fill == 3))) {return false;}
        if (!((color == card2.color && color == card3.color)  || (color + card2.color + card3.color == 3))) {return false;}
        if (!((color == card2.count && count == card3.count)  || (count + card2.count + card3.count == 3))) {return false;}
        System.out.println("YAYAYAYAYA");
        return true;
    }

}