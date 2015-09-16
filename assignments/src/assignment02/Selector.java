//package assignment03;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Defines a library of selection methods
* on Collections.
*
* @author   Walker Wood (whw0011)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2015-08-28
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
 * Selects the minimum value from the Collection c, as defined by
 * the supplied Comparator comp. This method throws an IllegalArgumentException
 * if either c or comp is null, and it throws a NoSuchElementException
 * if c is empty. The Collection c is not changed by this method.
 *
 * @param c     the Collection to be searched through
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      minimum value in c
 *
 */
   public static <T> T min(Collection<T> c, Comparator<T> comp) {
      if(c == null || comp == null)
          throw new IllegalArgumentException("C or comp cannot be null");
      if(c.isEmpty())
          throw new NoSuchElementException("C is empty!");
      T min = null;
      for(T o : c)
      {
          if(min == null)
              min = o;
          if(comp.compare(o, min) < 0)
              min = o;
      }
      
      return min;
   }


/**
 * Selects the maximum value from the Collection c, as defined by
 * the supplied Comparator comp. This method throws an IllegalArgumentException
 * if either c or comp is null, and it throws a NoSuchElementException
 * if c is empty. The Collection c is not changed by this method.
 *
 * @param c     the Collection to be searched through
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      maximum value in c
 *
 */
   public static <T> T max(Collection<T> c, Comparator<T> comp) {
       if(c == null || comp == null)
           throw new IllegalArgumentException("Input cannot be null or of length '0'");
       if(c.isEmpty())
           throw new NoSuchElementException("C is empty!");
      T max = null;
      for(T o : c)
      {
          if(max == null)
              max = o;
          if(comp.compare(o, max) > 0)
              max = o;
      }
      return max;
    //return null;
   }


/**
 * Selects the kth minimum value from the Collection c, as defined by
 * the supplied Comparator comp. This method throws an IllegalArgumentException
 * if either c or comp is null, and it throws a NoSuchElementException
 * if either c is empty or if there is no kth minimum value. Note that there
 * is no kth minimum value if k < 1, k > c.size(), or if k is larger than
 * the number of distinct values in c. The Collection c is not changed by
 * this method.
 *
 * @param c     the Collection to be searched through
 * @param k     the k-selection value
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      kth minimum value in c
 *
 */
   public static <T> T kmin(Collection<T> c, int k, Comparator<T> comp) {
      if(c == null || comp == null)
        throw new IllegalArgumentException("Something went wrong");
      if(k < 1 || k > c.size())
        throw new NoSuchElementException("there is no kmin");
      
      //create new collection
      //iterate over collection to delete duplicates
        //do this by ordering, and then iterating over to find the duplicates
        //until they are gone and then move on to next value
      //use same array logic to return kth min
      ArrayList<T> c2 = new ArrayList(c);
      java.util.Collections.sort(c2, comp);
     // Iterator<T> i = c2.iterator();
      //T[] b = c2.toArray(new T[c2.size()]);
      int counter = 0;
      for(int i = 0; i < c2.size(); i++)
      {
        boolean isOriginal = false;
        for(int x = 0; x < i; x++)
        {
            if(c2.get(i) == c2.get(x))
            {
                isOriginal = true;
                break;
            }
        }
        if(!isOriginal)
            counter++;
       }
       if(k > counter)
        throw new IllegalArgumentException("it's still broken");
       ArrayList<T> reduced = new ArrayList();
       int place = 0;
       for(int i = 0; i < c2.size() ;i++)
       {
            boolean isOriginal = false;
           for(int x = 0; x < i; x++)
           {
               if(c2.get(i) == c2.get(x))
               {
                   isOriginal = true;
                   break;
               }
           }
           if(!isOriginal)
           {
               reduced.add(c2.get(i));
               place++;
           }
       }
       return reduced.get(k-1);
      //return null;
   }


/**
 * Selects the kth minimum value from the Collection c, as defined by
 * the supplied Comparator comp. This method throws an IllegalArgumentException
 * if either c or comp is null, and it throws a NoSuchElementException
 * if either c is empty or if there is no kth minimum value. Note that there
 * is no kth minimum value if k < 1, k > c.size(), or if k is larger than
 * the number of distinct values in c. The Collection c is not changed by
 * this method.
 *
 * @param c     the Collection to be searched through
 * @param k     the k-selection value
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      kth minimum value in c
 *
 */
   public static <T> T kmax(Collection<T> c, int k, Comparator<T> comp) {
      if(c == null || comp == null)
           throw new IllegalArgumentException("Something went wrong");
      if(c.isEmpty() || k < 1 || k > c.size())
           throw new NoSuchElementException("...");
      ArrayList<T> c2 = new ArrayList(c);
      java.util.Collections.sort(c2, comp);
     // Iterator<T> i = c2.iterator();
      //T[] b = (T[])c2.toArray();
       //int[] b = Arrays.copyOf(a,a.length);
       //Arrays.sort(b);     
       int counter = 0;
      for(int i = 0; i < c2.size(); i++)
      {
        boolean isOriginal = false;
        for(int x = 0; x < i; x++)
        {
            if(c2.get(i) == c2.get(x))
            {
                isOriginal = true;
                break;
            }
        }
        if(!isOriginal)
            counter++;
       }
       if(k > counter)
        throw new IllegalArgumentException("it's still broken");
       ArrayList<T> reduced = new ArrayList();
       int place = 0;
       for(int i = 0; i < c2.size() ;i++)
       {
            boolean isOriginal = false;
           for(int x = 0; x < i; x++)
           {
               if(c2.get(i) == c2.get(x))
               {
                   isOriginal = true;
                   break;
               }
           }
           if(!isOriginal)
           {
               reduced.add(c2.get(i));
               place++;
           }
       }
       return reduced.get(reduced.size()-k);
   }


/**
 * Returns a Collection containing all the values in the supplied
 * Collection c that are in the range [low..high]; that is, all the
 * values that are greater than or equal to low and less than or
 * equal to high, including duplicate values, as determined by the
 * supplied Comparator comp. The returned Collection contains only
 * values in the range [low..high], and no others. Note that low and
 * high do not have to be actual values in c. If there are no
 * qualifying values, including the case where c is empty, this method
 * throws a NoSuchElementException. This method throws an
 * IllegalArgumentException if either c or comp is null. The Collection c
 * is not changed by this method.
 *
 * @param c     the Collection to be searched through
 * @param low   the lower bound value of the range
 * @param high  the upper bound value of the range
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      a Collection of elements in the range [low..high]
 *
 */
   public static <T> Collection<T> range(Collection<T> c, T low, T high,
                                         Comparator<T> comp) {
      if(c == null || comp == null)
          throw new IllegalArgumentException("Invalid Input");
      if(c.isEmpty())
          throw new NoSuchElementException("empty");
      //int[] b = a;
      ArrayList<T> a = new ArrayList(c);
      int counter = 0;
       for (T a1 : a) {
           if (comp.compare(a1, low) >= 0 && comp.compare(a1, high) <= 0) {
               counter++;
           }
       }
      ArrayList<T> b = new ArrayList();
      int pos = 0;
       for (T a1 : a) {
           if (comp.compare(a1, low) >= 0 && comp.compare(a1, high) <= 0) {
               b.add(a1);
               pos++;
           }
       }
       return b;
   }


/**
 * Returns the smallest value in the Collection c that is greater than
 * or equal to the given key, as defined by the supplied Comparator
 * comp. This method throws an IllegalArgumentException if either c
 * or comp is null, and throws a NoSuchElementException if c is empty
 * or if there is no qualifying value. Note that key does not have to
 * be an actual value in c.
 *
 * @param c     the Collection to be searched through
 * @param key   the reference value
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      the next greater value in c
 *
 */
   public static <T> T ceiling(Collection<T> c, T key, Comparator<T> comp) {
      if(c == null || comp == null)
          throw new IllegalArgumentException("");
      if(c.isEmpty())
          throw new NoSuchElementException("");
      T ret = null;
      for(T o : c)
      {
          if(comp.compare(o, key) >= 0 && comp.compare(o, ret) <= 0)
            ret = o;
      }
      if(ret == null)
          throw new NoSuchElementException("");
      else return ret;
   }


/**
 * Returns the largest value in the Collection c that is less than
 * or equal to the given key, as defined by the supplied Comparator
 * comp. This method throws an IllegalArgumentException if either c
 * or comp is null, and throws a NoSuchElementException if c is empty
 * or if there is no qualifying value. Note that key does not have to
 * be an actual value in c.
 *
 * @param c     the Collection to be searched through
 * @param key   the reference value
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      the next smaller value in c
 *
 */
   public static <T> T floor(Collection<T> c, T key, Comparator<T> comp) {
      if(c == null || comp == null)
          throw new IllegalArgumentException("");
      if(c.isEmpty())
          throw new NoSuchElementException("");
      T ret = null;
      boolean isValue = false;
      for(T o : c)
      {
          if(ret == null)
              ret = o;
          if(comp.compare(o, key) <= 0 && comp.compare(o, ret) >= 0)
          {
            ret = o;
            isValue = true;
          }
      }
      if(!isValue)
          throw new NoSuchElementException("");
      else return ret;
   }

}
