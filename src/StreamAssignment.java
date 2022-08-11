import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAssignment {
    @Test
    private void integerStream(){
        /*
        *Given values array
        *int[] values = {3,2,2,7,5,1,9,7}
        *print all unique numbers
        *sort array and print 3rd index
        **/

        Integer[] values = {3,2,2,7,5,1,9,7};

        //convert to list
        List<Integer> valuesList = Arrays.asList(values);

        //convert to stream
        Stream<Integer> valuesStream = valuesList.stream();

        //print out all distinct values
        //valuesStream.distinct().forEach(value->System.out.println(value));

        //sort the numbers
        List<Integer> sortedValues = valuesStream.distinct().sorted().toList();

        //print 3rd index
        System.out.println("Third Index Value: " + sortedValues.get(3));
    }

    @Test
    private void stringStream() {
        /*
        *Give an array of names
        * String[] names = {"Dan", "Rob", "Jill", "Tom", "Zack", "Jack", "Ruby", "Norma"}
        * Print all names starting with 'J'
        * search list for "Rob"
        * */

        //Given
        String[] names = {"Dan", "Rob", "Jill", "Tom", "Zack", "Jack", "Ruby", "Norma"};

        //convert to stream
        Stream<String> namesStream = Arrays.stream(names);

        //print all names starting with J
        namesStream.filter(name->name.startsWith("J")).forEach(name-> System.out.println(name));

        //create new stream
        Stream<String> namesStream2 = Arrays.stream(names);

        //search list for "Rob"
        Assert.assertTrue(namesStream2.anyMatch(name->name.equalsIgnoreCase("rob")), "Name not found in list!");
    }
}
