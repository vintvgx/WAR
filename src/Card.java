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
public class Card
{
    public static final String CLUBS = "Clubs";
    public static final String HEARTS = "Hearts";
    public static final String DIAMONDS = "Diamonds";
    public static final String SPADES = "Spades";
    public static final int ACE = 14;
    public static final int KING = 13;
    public static final int QUEEN = 12;
    public static final int JACK = 11;
    
    String suit;
    private int face;

    public Card(String suit, int face){
        this.suit = suit;
        this.face = face;
    }


    public String getSuit(){
        return suit;
    }

    public void setSuit(String suit){
        this.suit = suit;
    }

    public int getFace(){
        return face;
    }

    public void setFace(int face){
        this.face = face;
    }

    public String toString(){
        return "Card{" + "suit=" + suit + ", face=" + face + '}';
    }
   
    public boolean equals(Card other){
        boolean result = false;
        try{
            boolean suitMatch = this.suit.equals(other.getSuit());
            boolean faceMatch = this.face == other.getFace();
            
            if(suitMatch && faceMatch){
                result = true;
            }
        }
        catch (NullPointerException e){
                 result = false;
        }
        return result;
    }

   
}
