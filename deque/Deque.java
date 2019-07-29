import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class Deque {
    /* Raymond Hettinger's Double-Ended Queue:
     * user@computer$ python3
     * >>> import collections
     * >>> deque = collections.deque
     * >>> d = deque()
     * >>> d.
     * d.append(      d.copy(        d.extendleft(  d.maxlen       d.remove(
     * d.appendleft(  d.count(       d.index(       d.pop(         d.reverse(
     * d.clear(       d.extend(      d.insert(      d.popleft(     d.rotate( 
     *
     */
    Object[] values;
    Object[] prototype; 
    Deque(Object[] values) {
        this.values = values;
    }

    private void append(Object val) {
        // Create a new container[] with length = this.values.length() + 1.
        // Iterate over each of the values in `this.values` and assign them the 
        // first N slices of `object` 
        
        Object[] container = new Object[this.values.length + 1];
        
        for(int i = 0; i < this.values.length; i++)
            container[i] = this.values[i];
        
        container[this.values.length + 1] = val;
        
        this.values = container;
    } 

    private void appendleft(Object val) {
        // Create a new Object[] that copies this.values,
        // then create a new container[] with length = this.values.length() + 1.
        // Set the first value of the container to `val` and then serially
        // assign the remaining slices to those of this.values.
        // Finally, set this.values = container;
        
        Object[] container = new Object[this.values.length + 1];
        
        container[0] = val;
 
        for(int i = 1; i < this.values.length; i++)
            container[i] = this.values[i - 1];

        this.values = container;
 
    }

    private void clear() {
        // Clear out the double-ended queue
        Object[] replacement = {};
        this.values = replacement;
    }

    private Object[] copy() {
        // Return a shallow copy of a deque
        
        Object[] shallow_copy = new Object[this.values.length];
        
        for(int i=0; i < this.values.length; i++)
            shallow_copy[i] = this.values[i];

        return shallow_copy;
    }

    private int count(Object lookup_value) {
        // Return the number of times a particular value (passed as an argument)
        // is in the Double-Ended Queue's Range

        Map dict = new HashMap<Object, Integer>();
    
        // Iterate over each of the elements in this.values,
        // and set the new value of dict.get(key) via
        // dict.put(key, dict.get(key) + 1) to increment for each
        // instance encountering that value

        for(int i = 0; i < this.values.length; i++)
           if(!(dict.containsValue(lookup_value))){
                dict.put(this.values[i], 1);
            } else {
                dict.put(this.values[i], dict.get(this.values[i]) + 1);
            }
        Object member = dict.get(lookup_value);
        if (member != null) {
            return dict.get(lookup_value);
        } else {
            return 0;
        }
    }
            
    private void extend() {}

    private void extendleft() {}

    private int index() {}

    private void insert() {}

    private static int maxlen() {}

    private Object pop() {
        // *pops* off the right-most element from the deque
        Object[] newValues = new Object[this.values.length - 1];
        Object poppedValue = this.values[-1];

        if(this.values.length == 0) {
            return null;
        } else if(this.values.length == 1) {
            poppedValue = this.values[0]; // for clarity
            this.values = new Object[0];
            return poppedValue;
        } else{
            for(int i = 0; i < this.values.length - 1; i++)
                newValues[i] = this.values[i];
            this.values = newValues;
            return poppedValue;
        }
    }

    private Object popleft() {}

    private void remove() {}

    private Object[] reverse() {}

    private Object[] rotate() {}

}

/*
public class Append {
    
    public static void main(String[] args) {
        Object[] arr1 = {"4", "4", "2", "7"};
        Object[] arr2 = {"9", "5", "0", "0"};

        // Adding an element to `arr1`
        Object[] consumer = add(arr1, "9");
        System.out.println(Arrays.toString(consumer));

        // Adding two arrays
        consumer = add(arr1, arr2);
        System.out.println(Arrays.toString(consumer));
    }

    // Append elements to an array
    public static Object[] add(Object[] arr, Object... elements) {
        Object[] tempArr = new Object[arr.length + elements.length];
        
        // What are these positional parameters?
        System.arraycopy(arr, 0, tempArr, 0, arr.length);

        for(int index = 0;
                index < elements.length;
                index++)
            tempArr[arr.length + index] = elements[index];
        return tempArr;
    }
}*/
