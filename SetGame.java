import java.util.*;

public class SetGame extends App{
    Card[] userInput = new Card[3];
    Card[] allCards = new Card[81];
    Card[] grid = new Card[12];
    int allCardsCount = 0;
    
    int cardsClicked = 0;
    void setup() {
        int shape = 0; int fill = 0; int color = 0; int count = 0;
        for (int i = 0; i < allCards.length; i++) {
            allCards[i] = new Card (shape, fill, color, count);
            if (count != 2) {count += 1;}
            else if (count == 2 && color != 2) {count = 0; color +=1;}
            else if (count == 2 && color == 2 && fill != 2) {count = 0; color = 0; fill += 1;}
            else if (count == 2 && color == 2 && fill == 2 && shape != 2) {count = 0; color = 0; fill = 0; shape += 1;}
        }
        Random rand = new Random();
        
        for (int i = 0; i < allCards.length; i++) {
            int randomIndexToSwap = rand.nextInt(allCards.length);
            Card temp = allCards[randomIndexToSwap];
            allCards[randomIndexToSwap] = allCards[i];
            allCards[i] = temp;
        }
        for (int i = 0; i < grid.length; i++) {
            grid[i] = allCards[i];
            drawCenterRectangle(new Vector2(20.0,20.0),new Vector2(10.0,10.0),Vector3.red);
            allCardsCount += 1;
        }
        userInput[0] = null; userInput[1] = null; userInput[2] = null;
    }
    
    void checkUserInput() {
        if (userInput[0].checkSet(userInput[1],userInput[2])) {
            System.out.println("HEYTHERE");
            if(grid.length == 12) {
                for (int i = 0; i < grid.length; i++) {
                    if(!(grid[i] != userInput[0] && grid[i] != userInput[1] && grid[i] != userInput[2])) {
                        grid[i] = allCards[allCardsCount];
                        allCardsCount += 1;
                    }
                }
            }
            else {
                Card[] newGrid = new Card[12];
                for (int i = 0; i < grid.length; i++) {
                    if(grid[i] != userInput[0] && grid[i] != userInput[1] && grid[i] != userInput[2]) {
                        newGrid[i] = grid[i];
                    }
                }
                grid = newGrid;
            }        
        }
        userInput = new Card[3];
    }
    
    void draw(Card card, int i) {
        Vector3 color = Vector3.red;
        Vector3 fillType = Vector3.black;
        if (card.fill == Card.EMPTY) { fillType = Vector3.black; }
        else if (card.fill ==Card.LINED) { fillType = Vector3.gray; }
        else if (card.fill ==Card.FULL) { fillType = Vector3.white; }
        if (card.color == Card.RED) { color = Vector3.red; }
        else if (card.color == Card.BLUE) { color = Vector3.blue; }
        else if (card.color == Card.GREEN) { color = Vector3.green; }
        if (card.alive) {
            drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 46.0 + Double.valueOf(i/6) * -30.0),new Vector2(10.0,20.0),color);
        }
        if(card.shape == Card.OVAL) {
            double radius = 2.0;
            if (card.count == Card.COUNT1) { 
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 46.0 + Double.valueOf(i/6) * -30.0),radius,fillType);
            } else if (card.count == Card.COUNT2) {
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 42.0 + Double.valueOf(i/6) * -30.0),radius,fillType);
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 50.0 + Double.valueOf(i/6) * -30.0),radius,fillType); 
            } else if (card.count == Card.COUNT3) {
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 40.0 + Double.valueOf(i/6) * -30.0),radius,fillType);
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 46.0 + Double.valueOf(i/6) * -30.0),radius,fillType); 
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 52.0 + Double.valueOf(i/6) * -30.0),radius,fillType); 
            } 
        } else if(card.shape == Card.DIAMOND) {
            double radius = 2.0;
            Vector2 rectSize = new Vector2(5.0,2.0);
            if (card.count == Card.COUNT1) { 
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 46.0 + Double.valueOf(i/6) * -30.0),radius,fillType);
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 46.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);
            }  else if (card.count == Card.COUNT2) {
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 42.0 + Double.valueOf(i/6) * -30.0),radius,fillType);
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 42.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);            
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 50.0 + Double.valueOf(i/6) * -30.0),radius,fillType);            
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 50.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);
                
            } else if (card.count == Card.COUNT3) {
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 40.0 + Double.valueOf(i/6) * -30.0),radius,fillType);
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 40.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);                
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 46.0 + Double.valueOf(i/6) * -30.0),radius,fillType);                
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 46.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);
                drawCircle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 52.0 + Double.valueOf(i/6) * -30.0),radius,fillType);                
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 52.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);                
            }
        } else if(card.shape == Card.SQUIGGLE) {
             Vector2 rectSize = new Vector2(7.0,4.0);
            if (card.count == Card.COUNT1) { 
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 46.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);
            }  else if (card.count == Card.COUNT2) {
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 42.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);            
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 50.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);
                
            } else if (card.count == Card.COUNT3) {
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 40.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);                             
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 46.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);             
                drawCenterRectangle(new Vector2(-48.0 + Double.valueOf(i%6) * 20.0, 52.0 + Double.valueOf(i/6) * -30.0), rectSize,fillType);                
            }
        }
    }
    
    void addToGrid() {
        Card[] newGrid = new Card[grid.length + 3];
        for (int i=0; i < grid.length; i++) {
            newGrid[i] = grid[i];
        }
        newGrid[grid.length] = allCards[allCardsCount]; allCardsCount++;
        newGrid[grid.length + 1] = allCards[allCardsCount]; allCardsCount++;
        newGrid[grid.length + 2] = allCards[allCardsCount]; allCardsCount++;
        grid = newGrid;
        
        
    }
    
    void loop() {
        
        if(userInput[0] != null && userInput[1] != null && userInput[2] != null) {        
            checkUserInput();
        }
        if (keyPressed('A')) { 
            addToGrid();
        }
        if (keyPressed('C')) { userInput[0] = null; userInput[1] = null; userInput[2] = null;}
        for (int i = 0; i < grid.length; i++) {
            
            if(mousePressed) {
                
                if(mousePosition.x<-48.0 + Double.valueOf(i%6) * 20.0 + 5 && mousePosition.x>-48.0 + Double.valueOf(i%6) * 20.0 - 5) {
                    
                    if(mousePosition.y<16.0 + Double.valueOf(i/6) * 30.0 + 10 && mousePosition.y>16.0 + Double.valueOf(i/6) * 30.0 - 10) {
                        Card cardToAdd = grid[i];
                        userInput[cardsClicked++ % 3] = cardToAdd;
                        System.out.println(cardToAdd);
                    }
                }
            }
            draw(grid[i],i);
        }
    }
    
    public static void main(String[] arguments) {
        App app = new SetGame();
        app.setWindowBackgroundColor(0.0, 0.0, 0.0);
        app.setWindowSizeInWorldUnits(128.0, 128.0);
        app.setWindowCenterInWorldUnits(0.0, 0.0);
        app.setWindowHeightInPixels(512);
        app.setWindowTopLeftCornerInPixels(64, 64);
        app.run();
    }
}