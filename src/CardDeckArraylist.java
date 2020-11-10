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

import java.util.ArrayList;
import java.util.Collections;

public class CardDeckArraylist implements CardDeckInterface{

    

        private ArrayList<Card> deckOfCards = new ArrayList<>();
        
    
        public CardDeckArraylist() {
            
                for (int i = 2; i <=14;i++){
                    
                    deckOfCards.add(new Card(Card.HEARTS, i));
                     deckOfCards.add(new Card(Card.DIAMONDS, i));
                      deckOfCards.add(new Card(Card.CLUBS, i));
                       deckOfCards.add(new Card(Card.SPADES, i));
                }
                
             }
    public Card draw() {
       Card temp = deckOfCards.get(deckOfCards.size()-1);
       deckOfCards.remove(deckOfCards.size() -1);
       
        return temp;
    }

   
    public void shuffle() {
        Collections.shuffle(deckOfCards);
    }

    
    public int size() {
        return deckOfCards.size();
    }
    

    
}

