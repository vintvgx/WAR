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
public interface StackInterface<Card>
{
    public void push(Card data);
    public void pop();
    public Card peek();
    public void clear();
    public int size();
    
    
}
