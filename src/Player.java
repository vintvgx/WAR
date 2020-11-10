/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;

/**
 *   Copyright [2018] <Kareem Saygbe>
 *
 *   WAR Card Game
 *   Java
 */

public class Player{


    //initializes variables
    protected String name;
    public LinkedStack<Card> discardStack = new LinkedStack();
    public LinkedStack<Card> drawStack = new LinkedStack();
    
    public Card tempCard;
    public Card temp;
    public Card tempHolder;
    public Card tempCard2;
    public int ctr = 26;
    CardDeckArraylist deck = new CardDeckArraylist();



    public String Player (String name)
    {
        //sets user name and initializes
        this.name = name;
      
        return name;
    }

    public Card draw() {

        //draws a card stored in a variable that is pushed onto the draw stack
        tempCard = drawStack.peek(); //gets the card from drawStack and save it into tempCard
        drawStack.pop(); //removes card from drawStack because the card was drawn
        ctr++;
        return tempCard;

    }


    public void discard(Card temp)
    {
        //a card is stored in the variable using peek from the draw stack and then removed from the stack
        
        temp = drawStack.peek();
        discardStack.push(temp);

    }
    
    public void replenishDrawStack()
    {
        //replenishes the drawStakc with whats in the discard stack if drawstack is empty or
        
            while(!discardStack.isEmpty())
            {
              tempCard = discardStack.peek();
              drawStack.push(tempCard);
              discardStack.pop();
            }
             
        
       
    }

    public boolean hasCards()
    {
        //checks to see if player has any cards in either of their stacks
        if(drawStack.isEmpty() && discardStack.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }


    }
    
    public int deckSize(int size)
    {
        
        
        if(size == 0)
        {
            size = drawStack.size();
        }
        if(size == 1)
        {
             size = discardStack.size();
        }
        return size;
    }


    public String toString() {
        //prints out the user and card in the drawstack
        //tried to store card into variable and have peek show the card, but it did not work and came back with an error
        
       
        tempCard = drawStack.peek();
        this.name = name;

       // System.out.print(name + ": " + tempCard3 + ", Draw Stack = " + drawStack.size() + ", Discard Stack = " + discardStack.size());
        return name + ", Card=" + tempCard + "}" + ", Draw Stack = " + drawStack.size() + ", Discard Stack = " + discardStack.size() + " ";
    }







}

