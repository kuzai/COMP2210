//package assignment01;
import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Walker Wood (whw0011@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2015-08-17
*
*/
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }


/**
 * Selects the minimum value from the array a. This method
 * throws IllegalArgumentException if a is null or has zero
 * length. The array a is not changed by this method.
 */
   public static int min(int[] a) {
       if(a == null || a.length == 0)
       {
           throw new IllegalArgumentException("Input cannot be null or of length '0' ");
       }
       //int l = a.length;
       int[] m = a;
       int min = m[0];
       for(int i = 0; i < m.length; i++)
       {
           if(m[i] < min)
               min = m[i];
       }
       return min;
   }


/**
 * Selects the maximum value from the array a. This method
 * throws IllegalArgumentException if a is null or has zero
 * length. The array a is not changed by this method.
 */
   public static int max(int[] a) {
      if(a == null || a.length == 0)
       {
           throw new IllegalArgumentException("Input cannot be null or of length '0' ");
       }
      int max = a[0];
      for(int i = 0; i < a.length; i++)
      {
          if(a[i] > max)
              max = a[i];
      }
      return max;
   }


/**
 * Selects the kth minimum value from the array a. This method
 * throws IllegalArgumentException if a is null, has zero length,
 * or if there is no kth minimum value. Note that there is no kth
 * minimum value if k < 1, k > a.length, or if k is larger than
 * the number of distinct values in the array. The array a is not
 * changed by this method.
 */
   public static int kmin(int[] a, int k) {
       if(a == null || a.length == 0 || k < 1 || k > a.length)
           throw new IllegalArgumentException("Something went wrong");
       int[] b = Arrays.copyOf(a,a.length);
       Arrays.sort(b);
       int counter = 0;
       for(int i = 0; i < b.length;i++)
       {
           boolean isOriginal = false;
           for(int x = 0; x < i; x++)
           {
               if(b[i] == b[x])
               {
                   isOriginal = true;
                   break;
               }
           }
           if(!isOriginal)
               counter++;
       }
       if(k > counter)
           throw new IllegalArgumentException("");
       int[] reduced = new int[counter];
       int place = 0;
       for(int i = 0; i < b.length;i++)
       {
           boolean isOriginal = false;
           for(int x = 0; x < i; x++)
           {
               if(b[i] == b[x])
               {
                   isOriginal = true;
                   break;
               }
           }
           if(!isOriginal)
           {
               reduced[place] = b[i];
               place++;
           }
       }
       return reduced[k-1];
   }


/**
 * Selects the kth maximum value from the array a. This method
 * throws IllegalArgumentException if a is null, has zero length,
 * or if there is no kth maximum value. Note that there is no kth
 * maximum value if k < 1, k > a.length, or if k is larger than
 * the number of distinct values in the array. The array a is not
 * changed by this method.
 */
   public static int kmax(int[] a, int k) {
      if(a == null || a.length == 0 || k < 1 || k > a.length)
           throw new IllegalArgumentException("Something went wrong");
       int[] b = Arrays.copyOf(a,a.length);
       Arrays.sort(b);     
       int counter = 0;
       for(int i = 0; i < b.length;i++)
       {
           boolean isOriginal = false;
           for(int x = 0; x < i; x++)
           {
               if(b[i] == b[x])
               {
                   isOriginal = true;
                   break;
               }
           }
           if(!isOriginal)
               counter++;
       }
       if(k > counter)
           throw new IllegalArgumentException("");
       int[] reduced = new int[counter];
       int place = 0;
       for(int i = 0; i < b.length;i++)
       {
           boolean isOriginal = false;
           for(int x = 0; x < i; x++)
           {
               if(b[i] == b[x])
               {
                   isOriginal = true;
                   break;
               }
           }
           if(!isOriginal)
           {
               reduced[place] = b[i];
               place++;
           }
       }
       return reduced[reduced.length-k];
   }


/**
 * Returns an array containing all the values in a in the
 * range [low..high]; that is, all the values that are greater
 * than or equal to low and less than or equal to high,
 * including duplicate values. The length of the returned array
 * is the same as the number of values in the range [low..high].
 * If there are no qualifying values, this method returns a
 * zero-length array. Note that low and high do not have
 * to be actual values in a. This method throws an
 * IllegalArgumentException if a is null or has zero length.
 * The array a is not changed by this method.
 */
   public static int[] range(int[] a, int low, int high) {
      if(a == null || a.length == 0)
          throw new IllegalArgumentException("Invalid Input");
      //int[] b = a;
      int counter = 0;
      for(int i = 0;i < a.length;i++)
      {
          if(a[i] >= low && a[i] <= high)
              counter++;
      }
      int[] b = new int[counter];
      int pos = 0;
      for(int i = 0; i < a.length; i++)
      {
          if(a[i] >= low && a[i] <= high)
          {
              b[pos] = a[i];
              pos++;
          }
          
      }
       return b;
   }


/**
 * Returns the smallest value in a that is greater than or equal to
 * the given key. This method throws an IllegalArgumentException if
 * a is null or has zero length, or if there is no qualifying
 * value. Note that key does not have to be an actual value in a.
 * The array a is not changed by this method.
 */
   public static int ceiling(int[] a, int key) {
      if(a == null || a.length == 0)
          throw new IllegalArgumentException("");
      int[] b = Arrays.copyOf(a,a.length);
      Arrays.sort(b);
      for(int i = 0; i < b.length; i++)
      {
          if(b[i] >= key)
              return b[i];
      }
       
       throw new IllegalArgumentException("No such value in Array");
   }


/**
 * Returns the largest value in a that is less than or equal to
 * the given key. This method throws an IllegalArgumentException if
 * a is null or has zero length, or if there is no qualifying
 * value. Note that key does not have to be an actual value in a.
 * The array a is not changed by this method.
 */
   public static int floor(int[] a, int key) {
      if(a == null || a.length == 0)
          throw new IllegalArgumentException("");
      int[] b = Arrays.copyOf(a,a.length);
      Arrays.sort(b);
      for(int i = b.length-1; i >= 0; i--)
      {
          if(b[i] <= key)
              return b[i];
      }
       
       throw new IllegalArgumentException("No such value in Array");
   }

}
