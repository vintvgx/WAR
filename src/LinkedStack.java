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

public class LinkedStack<T> implements StackInterface<T>
{
    public LinkedNode<T> top; //reference to top of stack
    int ctr = 0;


    public LinkedStack()
    {
        //assigning top to null creates the empty stack
        top = null;
    }

    public void push(T data)
    {
        //this.data = data;
        LinkedNode<T> newNode = new LinkedNode<>(data);
        //newNode.setData(top);
        newNode.setNext(top);
        top = newNode;
        ctr++;
        //return true;
    }


    public void pop()
    {
        if (isEmpty())
            System.out.println("Pop attempted on an empty stack");
        else
            top = top.getNext();//takes top of stack
        ctr--;
    }

    @Override
    public T peek()
    {
        if (isEmpty())
            System.out.println("Peek attempted on an empty stack");
        
        return top.getData();
    }

    public void clear()
    {
            
    }


    //figure this one out
    public int size()
    {
        //System.out.println(ctr);
        return ctr;
    }

    public boolean isEmpty()
    {
        return (top == null);
    }

}
