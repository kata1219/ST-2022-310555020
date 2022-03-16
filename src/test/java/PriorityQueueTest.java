import java.util.PriorityQueue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    public static Stream<Arguments> streamProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 1, 2}, new int[]{1, 2, 3}),
                Arguments.arguments(new int[]{-3, -1, -2, 5}, new int[]{-3, -2, -1, 5}),
                Arguments.arguments(new int[]{3, -2, -5, -1, 2}, new int[]{-5, -2, -1, 2, 3}),
                Arguments.arguments(new int[]{-3, 1, 11, 0, 9, 3}, new int[]{-3, 0, 1, 3, 9, 11}),
                Arguments.arguments(new int[]{3, 7, 2, -1, -2}, new int[]{-2, -1, 2, 3, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];

        for (int i: random_array){
            pq.add(i);
        }

        while((s = pq.poll()) != null){
            result[index] = s;
            index++;
        }

        assertArrayEquals(correct_array, result);
    }

    @Test
    public void numberFormatExceptionTest(){
        Exception exception = assertThrows(NumberFormatException.class, ()->{
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void nullPointerExceptionTest(){
        Exception exception = assertThrows(NullPointerException.class, ()->{
            String str = null;
            str.equals("hello");
        });

        String expectedMessage = "\"str\" is null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void arrayIndexOutOfBoundsExceptionTest(){
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            int[] a = new int[5];
            a[5] = 1;
        });

        String expectedMessage = "Index 5 out of bounds for length 5";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}
