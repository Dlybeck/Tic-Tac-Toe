
/**
 * A Tic Tac Toe in Java
 *
 * @David Lybeck
 */
public class TicTacToe
{
    // instance variables - replace the example below with your own
    private int x;

        /**
         * Constructor for objects of class TicTacToe
         */
        
         public static void main() {//
            /// some variables probably go here
            int eX = 0;
            int Oh = 0;
            int both = eX|Oh; // do this whenever eX or Oh changes
            boolean Xwon = false;
            boolean Owon = false;
            
    
            
            for (int max=0;max<9;max++) { // default termination if game does not end normal//
              /// 1. Display the board..
              Xwon = false;
              Owon = false;
               int score = 0;
               int doing = 0;
               int aBit = 1;
               int best = -1;
               int chose = 0;
             
               for (int row = 1; row<=3;row++){//
                   System.out.println("");
                if (row>1) System.out.println("---+---+---");
                for (int col = 1; col<=3;col++){
                    if (col>1) System.out.print(" | ");
                    else System.out.print(" ");
                    
                    aBit = aBit<<1;
                    doing++;
                    if ((eX&aBit) != 0) System.out.print("X");
                    else if ((Oh&aBit) != 0) System.out.print("O");
                    else System.out.print(doing);
                }
               }
               System.out.println("");
               System.out.println("");
              
              /// 2. Is game over?
    
              
              // did X win?
              if ((eX&0xE)==0xE)    Xwon = true; //row 1
              else if ((eX&0x70)==0x70)   Xwon = true; //row 2
              else if ((eX&0x380)==0x380)Xwon = true; //row 3
              else if ((eX&0x92)==0x92)   Xwon = true; //column 1
              else if ((eX&0x124)==0x124) Xwon = true; //column 2
              else if ((eX&0x248)==0x248) Xwon = true; //column 3
              else if ((eX&0xA8)==0xA8) Xwon = true; //diagonal b->t
              else if ((eX&0x222)==0x222) Xwon = true; //diagonal t->b
              
              // did O win?
              if ((Oh&0xE)==0xE)     Owon = true; //row 1
              else if ((Oh&0x70)==0x70)   Owon = true; //row 2
              else if ((Oh&0x380)==0x380) Owon = true; //row 3
              else if ((Oh&0x92)==0x92)   Owon = true; //column 1
              else if ((Oh&0x124)==0x124) Owon = true; //column 2
              else if ((Oh&0x248)==0x248) Owon = true; //column 3
              else if ((Oh&0xA8)==0xA8) Owon = true; //diagonal b->t
              else if ((Oh&0x222)==0x222) Owon = true; //diagonal t->b
              
              
              if (Xwon){
                  System.out.println("X wins!");
                  break;
                }
              if (Owon){
                  System.out.println("O wins!");
                  break;
                } 
              if (eX+Oh == 1023){
                  System.out.println("Tie");
                  break;
                }
            
              /// 3. Accept X play
              while (true) {
                  System.out.println("Your play: ");
                  doing = Zystem.ReadInt();
                  if (doing>9) doing = 0; // so a single test catches all off-board plays
                  if (doing<1) break; // invalid input, user wants out
                  aBit = 1<<doing;
                  if (((eX|Oh)&aBit) == 0) { // valid play..
                      eX = eX|aBit; // mark X as having played this square
                      break;
                    }
                  System.out.println("Taken! Try Again"); // ..then go back for another input
                    } // end of input loop
              if (doing<1) break; // invalid input
              
              
              /// 4. Calculate O play
              //looking for win
               both = eX|Oh;
               aBit = 1;
               best = -1;
               chose = 0;
                if (eX+Oh != 0x3FE){
                   for (doing=1;doing<=9;doing++) {
                       aBit = aBit<<1;
                       if((both&aBit) !=0) continue;
                       int test = both|aBit;
                       score = 0;
                      
                       if (((Oh|aBit)&0x00E) == 0x00E) score = 99;
                       if (((Oh|aBit)&0x070) == 0x070) score = 99;
                       if (((Oh|aBit)&0x380) == 0x380) score = 99;
                       if (((Oh|aBit)&0x092) == 0x092) score = 99;
                       if (((Oh|aBit)&0x124) == 0x124) score = 99;
                       if (((Oh|aBit)&0x248) == 0x248) score = 99;
                       if (((Oh|aBit)&0xA8) == 0xA8) score = 99;
                       if (((Oh|aBit)&0x222) == 0x222) score = 99;
                       
                       //Calcuate Block
                       if (((eX|aBit)&0x00E) == 0x00E) score = score + 22;
                       if (((eX|aBit)&0x070) == 0x070) score = score + 22;
                       if (((eX|aBit)&0x380) == 0x380) score = score + 22;
                       if (((eX|aBit)&0x092) == 0x092) score = score + 22;
                       if (((eX|aBit)&0x124) == 0x124) score = score + 22;
                       if (((eX|aBit)&0x248) == 0x248) score = score + 22;
                       if (((eX|aBit)&0xA8) == 0xA8) score = score + 22;
                       if (((eX|aBit)&0x222) == 0x222) score = score + 22;
                       
                       //calculate if not empty or full
                        if((0x00E&aBit)!=0){
                         if(((both|aBit)&0x00E)!=0x00E){
                             if((both&0x00E)==0) score++;
                             else if((Oh&0x00E)==0) score = score + 2;
                             else if((eX&0x00E)==0) score = score + 4;
                            } 
                        }
                        if((0x070&aBit)!=0){
                         if(((both|aBit)&0x070)!=0x070){
                             if((both&0x070)==0) score++;
                             else if((Oh&0x070)==0) score = score + 2;
                             else if((eX&0x070)==0) score = score + 4;
                            } 
                        }
                        if((0x380&aBit)!=0){
                         if(((both|aBit)&0x380)!=0x380){
                             if((both&0x380)==0) score++;
                             else if((Oh&0x380)==0) score = score + 2;
                             else if((eX&0x380)==0) score = score + 4;
                            } 
                        }
                        if((0x124&aBit)!=0){
                         if(((both|aBit)&0x124)!=0x124){
                             if((both&0x124)==0) score++;
                             else if((Oh&0x124)==0) score = score + 2;
                             else if((eX&0x124)==0) score = score + 4;
                            } 
                        }
                        if((0x092&aBit)!=0){
                         if(((both|aBit)&0x092)!=0x00E){
                             if((both&0x092)==0) score++;
                             else if((Oh&0x092)==0) score = score + 2;
                             else if((eX&0x092)==0) score = score + 4;
                            } 
                        }
                        if((0x248&aBit)!=0){
                         if(((both|aBit)&0x248)!=0x248){
                             if((both&0x248)==0) score++;
                             else if((Oh&0x248)==0) score = score + 2;
                             else if((eX&0x248)==0) score = score + 4;
                            } 
                        }
                        if((0xA8&aBit)!=0){
                         if(((both|aBit)&0xA8)!=0xA8){
                             if((both&0xA8)==0) score++;
                             else if((Oh&0xA8)==0) score = score + 2;
                             else if((eX&0xA8)==0) score = score + 4;
                            } 
                        }
                        if((0x222&aBit)!=0){
                         if(((both|aBit)&0x222)!=0x222){
                             if((both&0x222)==0) score++;
                             else if((Oh&0x222)==0) score = score + 2;
                             else if((eX&0x222)==0) score = score + 4;
                            } 
                        }
                        
                       
                       
                       if (score > best){
                           best = score;
                           chose = doing;
                           System.out.println("chose = " + chose);
                        }
                    }//O
                
                   if (chose==0) { // huh? this shouldn't happen..
                       System.out.println("Something went wrong");
                       break;
                    }
                }
                    aBit = 1<<chose;
                    Oh = Oh|aBit; // mark O as having played this square
                    both = eX|Oh;
                    
                                  //
            
            
                                
            
            
        } // end of outer game loop
        /// congratulate winner
    }// end of main program
}
   
