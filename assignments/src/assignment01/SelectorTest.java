/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment01;
import java.util.Arrays;

/**
 *
 * @author Walker
 */
public class SelectorTest {
    
    public static void main(String[] args)
    {
        SelectorTest lol = new SelectorTest();
        int i = 0;
        while(i < 5)
        {
            i++;
            int[] o = lol.random();
            System.out.println("Min algorithm: " + Selector.min(o));
            System.out.println("Original: ");
            lol.printArray(o);
            System.out.println("");
        }
        i = 0;
        while(i < 5)
        {
            i++;
            int[] o = lol.random();
            int x = (int) (Math.random()*10);
            int y = (int) (Math.random() * 10);
            System.out.println("range algorithm: ");
            lol.printArray(Selector.range(o,x,y));
            System.out.println("");
            System.out.println("Original: ");
            lol.printArray(o);
            System.out.println("");
            System.out.println("X: " + x + " Y: " + y);
        }
        i = 0;
        while(i < 5)
        {
            i++;
            int x = (int) (Math.random()*5);
            int[] o = lol.random();
            System.out.println("kmax algorithm: " + Selector.kmax(o, x));
            System.out.println("Original: ");
            lol.printArray(o);
            System.out.println("");
            System.out.println("k = " + x);
        }
    }
    
    public int[] random()
    {
        int k = (int) (Math.random() * 10) + 1;
        int[] a = new int[k];
        for(int i = 0; i < a.length; i++)
        {
            a[i] = (int) (Math.random() * 20);
        }
        return a;
    }
    public void printArray(int[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}
