import java.util.Scanner;

/**
 * This class contains a map and its play method to manage game generally and 
 * get input and connect with map class to do different actions of game
 * @author Mohammad Hassannejadi
 * @version 1.0 
 */

public class Game {

    Map map;
    
    /**
     * constructor of game to create an instance of map
     */
    public Game(){
        map = new Map();
    }

    /**
     * play method is manage inputs and pass them to map and manage game generally 
     */
    public void play(){
        while(true){
            map.removeOpportunities();
            map.findOpportiunities();
            if(map.checkPass()){
                map.findOpportiunities();
                if(map.checkPass()){
                    map.addElements();
                    System.out.println("Black: "+map.blackScore()+" White: "+map.whiteScore());
                    System.out.println();
                    map.show();
                    break;
                }
                System.out.println("PASS");
                map.findOpportiunities();
                continue;
            }
            System.out.println("Black: "+map.blackScore()+" White: "+map.whiteScore());
            System.out.println();
            map.addElements();
            map.show();
            System.out.println("Turn: "+map.getTurn());
            Scanner obj = new Scanner(System.in);
            while(true){
                String input = obj.next();
                int numY = Integer.parseInt(""+input.charAt(0));
                char word = input.charAt(1);
                int numX = 0;
                if((numY>0 && numY<9)&&(word == 'A' || word == 'B' || word == 'C' || word == 'D' || word == 'E' || word == 'F' || word == 'G' || word == 'H')){
                    if(word=='A'){
                        numX = 1;
                    }
                    if(word=='B'){
                        numX = 2;
                    }
                    if(word=='C'){
                        numX = 3;
                    }
                    if(word=='D'){
                        numX = 4;
                    }
                    if(word=='E'){
                        numX = 5;
                    }
                    if(word=='F'){
                        numX = 6;
                    }
                    if(word=='G'){
                        numX = 7;
                    }
                    if(word=='H'){
                        numX = 8;
                    }
                    if(map.getMap(numX-1, numY-1)!=3){
                        System.out.println("Wrong coordiante");
                    }
                    else{
                        map.move(numX-1,numY-1);
                        break;
                    }

                }
                else{
                    System.out.println("Wrong input !!!");
                } 
            }    
        }
        
        if(map.whiteScore()>map.blackScore()){
            System.out.println("White wins :)");
        }
        else if(map.whiteScore()<map.blackScore()){
            System.out.println("Black wins :)");
        }
        else{
            System.out.println("Draw :|");
        }
        
    }
    
}