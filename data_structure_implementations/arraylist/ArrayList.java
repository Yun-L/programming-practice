//*******************************************************************
//  ArrayList
//
//  A simple ArrayList implementation. 
//*******************************************************************
import java.util.*;
import java.time.Instant;
import java.time.Duration;

public class ArrayList {
    // Instance Variables
    private int[] internal_array;
    private int internal_length;    
    // Constructors
    public ArrayList() {
        this.internal_array = new int[10];
        this.internal_length = 0;
    }

    // private methods
    private void resize() {
        int[] resized = new int[this.internal_length * 2];
        
        for (int i = 0; i < this.internal_length; i++) {
            resized[i] = this.internal_array[i];
        }

        this.internal_array = resized;
    }

    // public methods
    public boolean append(int value) {
        this.internal_array[this.internal_length] = value;
        this.internal_length++;
        if (this.internal_length == this.internal_array.length) {
            this.resize();
        }
        return true;
    }

    public boolean add(int index, int value) {
        if (index < 0 || index > this.internal_length) {
            return false;    
        } else {
            for (int i = this.internal_length; i > index; i--) {
                this.internal_array[i] = this.internal_array[i-1];
            }
            this.internal_array[index] = value;
            this.internal_length++;

            if (this.internal_length == this.internal_array.length) {
                this.resize();
            }
            
            return true;
        }
    }

    public boolean remove(int index) {
        if (index < 0 || index > this.internal_length - 1) {
            return false;
        } else {
            for (int i = index+1; i < this.internal_length; i++) {
                this.internal_array[i-1] = this.internal_array[i];
            }
            this.internal_length--;
            return true;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.internal_length; i++) {
            str.append(Integer.toString(this.internal_array[i]));
            str.append(" ");
        }
        return str.toString();
    }
    public static void main(String[] args) {
        // test functionality
        Instant time_start;
        Instant time_end;

        //ArrayList
        time_start = Instant.now();

        ArrayList myArray = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            myArray.append(i);
        }
        // System.out.println(myArray.toString());
        time_end = Instant.now();
        System.out.println("Using ArrayList: " +
                            Duration.between(time_start, time_end).toMillis() +
                            " milliseconds");

        //Normal Array
        time_start = Instant.now();

        int nums[] = {0};
        for (int i = 1; i < 100000; i++) {
            int temp[] = new int[i+1];
            for (int j = 0; j < i; j++) {
                temp[j] = nums[j];
            }
            temp[i] = i;
            nums = temp;
        }

        // StringBuilder str = new StringBuilder();
        // for (int num: nums) {
        //     str.append(Integer.toString(num));
        //     str.append(" ");
        // }
        // System.out.println(str.toString());
        time_end = Instant.now();
        System.out.println("Using array copying: " +
                            Duration.between(time_start, time_end).toMillis() + 
                            " milliseconds");

    }

}