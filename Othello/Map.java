
/**
 * This class is manage positions and board of game and find possible loclations to move and change color of beads
 * and check pass of game
 * @author Mohammad Hassannejadi 
 * @version 1.0
 */

public class Map{

    private int[][] map = new int[8][8]; // empty are 0 ,  black are 1 , white are 2 , opportunity are 3
    private char[][] visualMap = new char[60][30];
    private int turn;
    /**
     * constructor of map to assign first time 4 block of board 
     */
    public Map(){
        
        turn = 0;
        
        map[3][4] = 1; //black
        map[4][3] = 1; //black
        map[3][3] = 2; //white
        map[4][4] = 2; //white
        
    }

    /**
     * getting type of a block of map
     * @param x x coordinate
     * @param y y coordinate
     * @return type of block : empty are 0 ,  black are 1 , white are 2 , opportunity are 3
     */
    public int getMap(int x , int y){
        return map[x][y];
    }

    /**
     * check possiblity to move of player
     * @return true if impossible to move
     */
    public boolean checkPass(){
        for(int i=0; i<8 ; i++){
            for(int j=0; j<8 ;j++){
                if(map[i][j]==3){  //opportuinity block
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * convert blocks of map are 3(oppotiunity) to 1(empty)
     */
    public void removeOpportunities(){
        for(int i=0; i<8 ; i++){
            for(int j=0; j<8 ;j++){
                if(map[i][j]==3){
                    map[i][j] = 0;
                }
            }
        }
    }
    /**
     * find opportiunity blocks to move and set their type to 3
     */
    public void findOpportiunities(){

        if(turn%2==0){ //black turn
            for(int i=0; i<8 ; i++){
                for(int j=0; j<8 ;j++){
                    if(map[i][j]==1){ //1 means black
                        
                        if(i>1 && map[i-1][j]==2){  //1
                            int x = i;
                            int y = j;
                            x--;
                            while(x>0 && map[x][y]==2){
                                x--;
                            }
                            if(x>=0 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(j>1 && map[i][j-1]==2){  //2
                            int x = i;
                            int y = j;
                            y--;
                            while(y>0 && map[x][y]==2){
                                y--;
                            }
                            if(y>=0 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i<6 && map[i+1][j]==2){  //3
                            int x = i;
                            int y = j;
                            x++;
                            while(x<7 && map[x][y]==2){
                                x++;
                            }
                            if(x<=7 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(j<6 && map[i][j+1]==2){ //4
                            int x = i;
                            int y = j;
                            y++;
                            while(y<7 && map[x][y]==2){
                                y++;
                            }
                            if(y<=7 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i>1 && j>1 && map[i-1][j-1]==2){ //5
                            int x = i;
                            int y = j;
                            x--;
                            y--;
                            while(x>0 && y>0 && map[x][y]==2){
                                x--;
                                y--;
                            }
                            if(x>=0 && y>=0 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i>1 && j<6 && map[i-1][j+1]==2){ //6
                            int x = i;
                            int y = j;
                            x--;
                            y++;
                            while(x>0 && y<7 && map[x][y]==2){
                                x--;
                                y++;
                            }
                            if(x>=0 && y<=7 && map[x][y]==0){ 
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i<6 && j>1 && map[i+1][j-1]==2){ //7
                            int x = i;
                            int y = j;
                            x++;
                            y--;
                            while(x<7 && y>0 && map[x][y]==2){
                                x++;
                                y--;
                            }
                            if(x<=7 && y>=0 && map[x][y]==0){ 
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i<6 && j<6 && map[i+1][j+1]==2){ //8
                            int x = i;
                            int y = j;
                            x++;
                            y++;
                            while(x<7 && y<7 && map[x][y]==2){
                                x++;
                                y++;
                            }
                            if(x<=7 && y<=7 && map[x][y]==0){ 
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                    }
                }
            }
        }
        else{ //white turn 
            for(int i=0; i<8 ; i++){
                for(int j=0; j<8 ;j++){
                    if(map[i][j]==2){ //2 means white
                        
                        if(i>1 && map[i-1][j]==1){  //1
                            int x = i;
                            int y = j;
                            x--;
                            while(x>0 && map[x][y]==1){
                                x--;
                            }
                            if(x>=0 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(j>1 && map[i][j-1]==1){  //2
                            int x = i;
                            int y = j;
                            y--;
                            while(y>0 && map[x][y]==1){
                                y--;
                            }
                            if(y>=0 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i<6 && map[i+1][j]==1){  //3
                            int x = i;
                            int y = j;
                            x++;
                            while(x<7 && map[x][y]==1){
                                x++;
                            }
                            if(x<=7 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(j<6 && map[i][j+1]==1){ //4
                            int x = i;
                            int y = j;
                            y++;
                            while(y<7 && map[x][y]==1){
                                y++;
                            }
                            if(y<=7 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i>1 && j>1 && map[i-1][j-1]==1){ //5
                            int x = i;
                            int y = j;
                            x--;
                            y--;
                            while(x>0 && y>0 && map[x][y]==1){
                                x--;
                                y--;
                            }
                            if(x>=0 && y>=0 && map[x][y]==0){
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i>1 && j<6 && map[i-1][j+1]==1){ //6
                            int x = i;
                            int y = j;
                            x--;
                            y++;
                            while(x>0 && y<7 && map[x][y]==1){
                                x--;
                                y++;
                            }
                            if(x>=0 && y<=7 && map[x][y]==0){ 
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i<6 && j>1 && map[i+1][j-1]==1){ //7
                            int x = i;
                            int y = j;
                            x++;
                            y--;
                            while(x<7 && y>0 && map[x][y]==1){
                                x++;
                                y--;
                            }
                            if(x<=7 && y>=0 && map[x][y]==0){ 
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                        if(i<6 && j<6 && map[i+1][j+1]==1){ //8
                            int x = i;
                            int y = j;
                            x++;
                            y++;
                            while(x<7 && y<7 && map[x][y]==1){
                                x++;
                                y++;
                            }
                            if(x<=7 && y<=7 && map[x][y]==0){ 
                                map[x][y] = 3; //opportiunity for move
                            }
                        }
                    }
                }
            }
        }
        turn++;
    }
    /**
     * get turn of game
     * @return player that is his turn
     */
    public String getTurn(){
        if(turn%2==1){
            return "Black";
        }
        else{
            return "White";
        }
    }
    /**
     * adding elements of  characters to map array 
     */
    public void addElements(){
        for(int i=0; i<3*8+2; i++)
        {
            for(int j=0; j<6*8+3; j++)
            {
                if((i%3==1)&&((j%6)!=2)&&(j>1))
                {
                    visualMap[j][i]='_';

                }

                else if((i>1)&&(j%6==2))
                {
                    visualMap[j][i]='|';

                }
                else
                {
                    visualMap[j][i]=' ';

                }

            }
        }
        visualMap[5][0] = 'A';
        visualMap[11][0] = 'B';
        visualMap[17][0] = 'C';
        visualMap[23][0] = 'D';
        visualMap[29][0] = 'E';
        visualMap[35][0] = 'F';
        visualMap[41][0] = 'G';
        visualMap[47][0] = 'H';
        visualMap[0][3] = '1';
        visualMap[0][6] = '2';
        visualMap[0][9] = '3';
        visualMap[0][12] = '4';
        visualMap[0][15] = '5';
        visualMap[0][18] = '6';
        visualMap[0][21] = '7';
        visualMap[0][24] = '8';

        for(int i=0 ; i<8 ; i++){
            for(int j=0 ; j<8 ; j++){
                if(map[i][j]==1){
                    visualMap[6*i+5][3*j+3]='B'; //black
                    //visualMap[6*i+5][3*j+3]='☆';
                }
                else if(map[i][j]==2){
                    visualMap[6*i+5][3*j+3]='W'; //white
                   // visualMap[6*i+5][3*j+3]='★';
                }
                else if(map[i][j]==3){
                    visualMap[6*i+5][3*j+3]='*'; //opportiunity
                    //visualMap[6*i+5][3*j+3]='✺';
                }
            }
        }
    }
    /**
     * show the map and players
     */
    public void show(){
        
        for(int i=0 ; i<3*8+2 ; i++){
            for(int j=0 ; j<7*8+2 ; j++){
                System.out.print(visualMap[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * put a bead in a opportiunity block that user choose
     * @param x x coordinate of user select
     * @param y y coordinate of user select
     */
    public void move(int x , int y){
        turn++;
        if(turn%2==0){ //black turn
            int i = x;
            int j = y;    
            if(i>1 && map[i-1][j]==2){  //1
                x--;
                while(x>0 && map[x][y]==2){
                    x--;
                }
                if(x>=0 && map[x][y]==1){
                    for(int ii = x+1 ; ii <= i ; ii++){
                        map[ii][j] = 1;
                        
                    }
                }
            }
            if(j>1 && map[i][j-1]==2){  //2
                x = i;
                y = j;
                y--;
                while(y>0 && map[x][y]==2){
                    y--;
                }
                if(y>=0 && map[x][y]==1){
                    for(int jj = y+1 ; jj <= j ; jj++){
                        map[i][jj] = 1;
                        
                    }
                }
            }
            if(i<6 && map[i+1][j]==2){  //3
                x = i;
                y = j;
                x++;
                while(x<7 && map[x][y]==2){
                    x++;
                }
                if(x<=7 && map[x][y]==1){
                    for(int ii = i ; ii < x ; ii++){
                        map[ii][j] = 1;
                        
                    }
                }
            }
            if(j<6 && map[i][j+1]==2){ //4
                x = i;
                y = j;
                y++;
                while(y<7 && map[x][y]==2){
                    y++;
                }
                if(y<=7 && map[x][y]==1){
                    for(int jj = j ; jj < y ; jj++){
                        map[i][jj] = 1;
                        
                    }
                }
            }
            if(i>1 && j>1 && map[i-1][j-1]==2){ //5
                x = i;
                y = j;
                x--;
                y--;
                while(x>0 && y>0 && map[x][y]==2){
                    x--;
                    y--;
                }
                if(x>=0 && y>=0 && map[x][y]==1){
                    int jj = y+1 , ii = x+1;
                    while( ii <= i && jj <= j ){
                        map[ii][jj] = 1; 
                        jj++;
                        ii++;
                    }
                }
            }
            if(i>1 && j<6 && map[i-1][j+1]==2){ //6
                x = i;
                y = j;
                x--;
                y++;
                while(x>0 && y<7 && map[x][y]==2){
                    x--;
                    y++;
                }
                if(x>=0 && y<=7 && map[x][y]==1){ 
                    int jj = y , ii = x;
                    while(jj >= j && ii<= i){
                        map[ii][jj] = 1;
                        jj--;
                        ii++;
                    }
                }
            }
            if(i<6 && j>1 && map[i+1][j-1]==2){ //7
                x = i;
                y = j;
                x++;
                y--;
                while(x<7 && y>0 && map[x][y]==2){
                    x++;
                    y--;
                }
                if(x<=7 && y>=0 && map[x][y]==1){ 
                    int jj = y , ii = x ;
                    while(jj <= j && ii>=i){
                        map[ii][jj] = 1;
                        jj++;
                        ii--;
                    }
                }
                
            }
            if(i<6 && j<6 && map[i+1][j+1]==2){ //8
                x = i;
                y = j;
                x++;
                y++;
                while(x<7 && y<7 && map[x][y]==2){
                    x++;
                    y++;
                }
                if(x<=7 && y<=7 && map[x][y]==1){ 
                   
                    int jj = y , ii = x;
                    while( ii >= i && jj >= j ){
                        map[ii][jj] = 1; 
                        jj--;
                        ii--;
                    }
                }
            }
        }
    
        
        else{ //white turn 
            int i = x;
            int j = y;    
            if(i>1 && map[i-1][j]==1){  //1
                x--;
                while(x>0 && map[x][y]==1){
                    x--;
                }
                if(x>=0 && map[x][y]==2){
                    for(int ii = x+1 ; ii <= i ; ii++){
                        map[ii][j] = 2;
                      
                    }
                }
            }
            if(j>1 && map[i][j-1]==1){  //2
                x = i;
                y = j;
                y--;
                while(y>0 && map[x][y]==1){
                    y--;
                }
                if(y>=0 && map[x][y]==2){
                    for(int jj = y+1 ; jj <= j ; jj++){
                        map[i][jj] = 2;
                       
                    }
                }
            }
            if(i<6 && map[i+1][j]==1){  //3
                x = i;
                y = j;
                x++;
                while(x<7 && map[x][y]==1){
                    x++;
                }
                if(x<=7 && map[x][y]==2){
                    for(int ii = i ; ii < x ; ii++){
                        map[ii][j] = 2;
                       
                    }
                }
            }
            if(j<6 && map[i][j+1]==1){ //4
                x = i;
                y = j;
                y++;
                while(y<7 && map[x][y]==1){
                    y++;
                }
                if(y<=7 && map[x][y]==2){
                    for(int jj = j ; jj < y ; jj++){
                        map[i][jj] = 2;
                      
                    }
                }
            }
            if(i>1 && j>1 && map[i-1][j-1]==1){ //5
                x = i;
                y = j;
                x--;
                y--;
                while(x>0 && y>0 && map[x][y]==1){
                    x--;
                    y--;
                }
                if(x>=0 && y>=0 && map[x][y]==2){
                    for(int jj = y+1 , ii = x+1 ; ii <= i && jj <= j ; jj++ , ii++){
                        
                        map[ii][jj] = 2;
                        
                    }
                }
            }
            if(i>1 && j<6 && map[i-1][j+1]==1){ //6
                x = i;
                y = j;
                x--;
                y++;
                while(x>0 && y<7 && map[x][y]==1){
                    x--;
                    y++;
                }
                if(x>=0 && y<=7 && map[x][y]==2){ 
                    for(int jj = y , ii = x ; jj >= j && ii<=i ; jj-- , ii++){
                       
                        map[ii][jj] = 2;
                            
                    }
                }
            }
            if(i<6 && j>1 && map[i+1][j-1]==1){ //7
                x = i;
                y = j;
                x++;
                y--;
                while(x<7 && y>0 && map[x][y]==1){
                    x++;
                    y--;
                }
                if(x<=7 && y>=0 && map[x][y]==2){ 
                    for(int jj = y , ii = x ; jj <= j && ii >= i; jj++ , ii--){
                        map[ii][jj] = 2;
                    }
                }
                
            }
            if(i<6 && j<6 && map[i+1][j+1]==1){ //8
                x = i;
                y = j;
                x++;
                y++;
                while(x<7 && y<7 && map[x][y]==1){
                    x++;
                    y++;
                }
                if(x<=7 && y<=7 && map[x][y]==2){ 
                    for(int jj = y , ii = x ; jj >= j && ii >= i ; jj--, ii--){
                        
                        map[ii][jj] = 2;
                           
                        
                    }
                }
            }
        }
        turn++;
    }
    /**
     * return score of black player
     * @return score of black player
     */
    public int blackScore(){
        int score = 0;
        for(int i=0 ; i<8 ; i++){
            for(int j=0; j<8 ; j++){
                if(map[i][j]==1){
                    score++;
                }
            }
        }
        return score;
    }
    /**
     * return score of white player
     * @return score of white player
     */
    public int whiteScore(){
        int score = 0;
        for(int i=0 ; i<8 ; i++){
            for(int j=0; j<8 ; j++){
                if(map[i][j]==2){
                    score++;
                }
            }
        }
        return score;
    }


}