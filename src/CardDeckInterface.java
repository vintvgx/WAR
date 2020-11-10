/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *   Copyright [2018] <Kareem Saygbe>
 *
 *   WAR Card Game
 *   Java
 */
    
public interface CardDeckInterface
{
    //return the top card on the deck
    public Card draw();

    //shuffle the deck
    public void shuffle();
   
    //the number of cards remaining in the deck
     public int size();
}
    


