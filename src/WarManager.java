/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vintvgx
 */


/**
 *   Copyright [2018] <Kareem Saygbe>
 *
 *   WAR Card Game
 *   Java
 */

import java.util.Scanner;


public class WarManager {

    Player player1 = new Player();
    Player player2 = new Player();
    //private CardDeckArray   deck ;
    CardDeckArraylist deck = new CardDeckArraylist();
    //private Card[] deckOfCards;
    Card playerCard;
    int p1totalStack = 0;
    int p2totalStack = 0;
    boolean tester=true;
    Scanner scnr = new Scanner(System.in);

    public void setup()
    {
        System.out.println("Please enter player one's name");
        String name = scnr.nextLine();
         //sets up player's
        player1.Player(name);
        
        System.out.println("Please enter player one's name");
        String name2 = scnr.nextLine();
        player2.Player(name2);
    }

    public void deal()
    {
       
        
        deck.shuffle();
        System.out.println("Setting up deck...");
        //deals card to player1 and player 2
        
        for (int i = 1; i <= 26; i++)
        {
            // System.out.print("Player 1 Card: ");
            player1.drawStack.push(deck.draw());
            
            //System.out.print("Player 2 Card: ");
            player2.drawStack.push(deck.draw());
           
        }
                


        System.out.println("Deck Complete. Ready to play.");

    }
    
    public void testForWinner()
    {
        if(player1.hasCards() == false)
        {
            System.out.println(player1.name + " won the WAR.");
            tester = false;
        }
        else if(player2.hasCards() == false)
        {
            System.out.println(player2.name + " won the WAR.");
            tester = false;
        }
        
        
    }

    public void play()
    {
      
        

        //while statement that allows players to play until someone wins
         while( tester == true)
        {
            testForWinner();
            
            p1totalStack = player1.drawStack.size() + player1.discardStack.size();
            p2totalStack = player2.drawStack.size() + player2.discardStack.size();
            //takes cards from player 1's stack and player 2's stack and puts them in variable
            System.out.println(player1.toString() + "Total in stack = " + p1totalStack);
            System.out.println(player2.toString() + "Total in stack = " + p2totalStack);
            
            Card player1Card = player1.drawStack.peek();
            Card player2Card = player2.drawStack.peek();

            //outputs card to string
            player1.drawStack.pop();
            player2.drawStack.pop();
            
            
            

            //removes card from draw stack

            //if player 1's card is higher in value, player 1 wins, takes away player 2's card and throws card on player 1's discard deck
            if(player1Card.getFace() > player2Card.getFace())
            {
                System.out.println(player1.name + " wins round");
              
                
                player1.discard(player2Card);
                player1.discard(player1Card);
               
                
            }
            //if player 2's card is higher in value, player 2 wins, takes away player 1's card and throws card on player 2's discard deck
            else if (player1Card.getFace() < player2Card.getFace())
            {
                System.out.println(player2.name + " wins round");
                //player1.discard();
                player2.discard(player1Card);
                player2.discard(player2Card);
                
                
            }
            //if users have the same card then these line of code initializes the war
            else if (player1Card.getFace() == player2Card.getFace())
            {
                System.out.println("WAR");
             
                
                if(p1totalStack < 4 || p2totalStack < 4)
                {
                   System.out.println( player1.name + " does not have enough cards for war. " + player2.name + " has won the game");
                   tester = false;
                }
                else{
                    
                     player1.replenishDrawStack();
                     player2.replenishDrawStack();
                
                //array of 3 card objects are held
                  Card[] p1cards = new Card[3];
                  Card[] p2cards = new Card[3];
                  
                  //loop that stores object in array
                  for(int i = 0; i <= 2; i++)
                  {
                      p1cards[i] = player1.drawStack.peek();
                      System.out.println(p1cards[i] + " drawn");
                      player1.drawStack.pop();
                      p2cards[i] = player2.drawStack.peek();
                      System.out.println(p2cards[i] + " drawn");
                      player2.drawStack.pop();
                  }
                  
                  //lines that draw final card for players
                  Card p1Decider = player1.drawStack.peek();
                  System.out.println("WAR: " + player1.name + " 3 cards drawn.");
                  player1.drawStack.pop();
                  Card p2Decider = player2.drawStack.peek();
                  System.out.println("WAR: " + player2.name + " 3 cards drawn.");
                  player2.drawStack.pop();
                  
                  
                  //if player 1'svalue is higher then player 2 then they win and push all cards onto discard stack
                   if(p1Decider.getFace() > p2Decider.getFace())
                {
                    System.out.println(player1.name + " won the WAR.");
                    
                    player1.discard(p1Decider);
                    player1.discard(p2Decider);
                    player1.discard(player2Card);
                    player1.discard(player1Card);
                    //player1.discardStack.push(p1Decider);
                    //player1.discardStack.push(p2Decider);
                     
                     for(int i = 0; i <= 2; i++)
                  {
                      player1.discard(p1cards[i]);
                      //player1.discardStack.push(p1cards[i]);
                      System.out.println(p1cards[i] + "has been pushed onto player1 discard stack +");
                      player1.discard(p2cards[i]);
                      //player1.discardStack.push(p2cards[i]);
                      System.out.println(p2cards[i] + "has been pushed onto player1 discard stack ++");
                  }
                     
                   
                }
                   //if player 2'svalue is higher then player 1 then they win and push all cards onto discard stack
                   else if (p2Decider.getFace() > p1Decider.getFace())
                   {
                       System.out.println(player2.name + " won the WAR.");
                       
                       player2.discard(p2Decider);
                       player2.discard(p1Decider);
                       player2.discard(player1Card);
                       player2.discard(player2Card);
                       //player2.discardStack.push(p2Decider);
                       //player2.discardStack.push(p1Decider);
                       for(int i = 0; i <= 2; i++)
                     {
                      player2.discard(p2cards[i]);
                      //player2.discardStack.push(p2cards[i]);
                      System.out.println(p2cards[i] + "has been pushed onto player2 discard stack +");
                      player2.discard(p1cards[i]);
                      //player2.discardStack.push(p1cards[i]);
                      System.out.println(p1cards[i] + "has been pushed onto player2 discard stack ++");
                     }
                      
                   }
                }
            }

            test();


        }

    }
    
    public void test()
    {
        if(player1.drawStack.size() == 0 || player1.drawStack.size() == 1)
               {
                   //testes to see if player has cards, if empty then game is over
                   if(player1.hasCards() == false)
                   {
                       tester = false;
                       System.out.println(player1.name + " is out of cards. " + player2.name + " has WON THE GAME.");
                       
                   }
                   //replenishes stack method
                   else
                   {
                       player1.replenishDrawStack();
                      }
                   
               }
               
               if(player2.drawStack.size() == 0 || player2.drawStack.size() == 1)
               {
                   //testes to see if player has cards, if empty then game is over
                   if(player2.hasCards() == false)
                   {
                       tester = false;
                       System.out.println(player2.name + " is out of cards. " + player1.name + " has WON THE GAME.");
                       
                   }
                   //replenishes stack method
                   else
                   {
                      player2.replenishDrawStack();
                      
                   }
               }
    }


    public static void main(String[] args) {
        // TODO code application logic here

        
        WarManager w1 = new WarManager();
        
         w1.setup();
        w1.deal();
        w1.play();


    }
}

