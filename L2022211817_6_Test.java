import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class L2022211817_6_Test {

    @Test
    public void testPeopleIndexes_EmptyInput() {
        Solution6 solution = new Solution6();
        List<List<String>> input = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        List<Integer> result = solution.peopleIndexes(input);
        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_NoSubsets() {
        Solution6 solution = new Solution6();
        List<List<String>> input = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("amazon"),
                Arrays.asList("microsoft")
        );
        List<Integer> expected = Arrays.asList(0, 1, 2);
        List<Integer> result = solution.peopleIndexes(input);
        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_WithSubsets() {
        Solution6 solution = new Solution6();
        List<List<String>> input = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "facebook"),
                Arrays.asList("facebook"),
                Arrays.asList("amazon")
        );
        List<Integer> expected = Arrays.asList(0, 3);
        List<Integer> result = solution.peopleIndexes(input);
        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_AllSubsets() {
        Solution6 solution = new Solution6();
        List<List<String>> input = Arrays.asList(
                Arrays.asList("leetcode"),
                Arrays.asList("leetcode", "google"),
                Arrays.asList("leetcode", "google", "facebook")
        );
        List<Integer> expected = Collections.singletonList(2);
        List<Integer> result = solution.peopleIndexes(input);
        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_SingleElementLists() {
        Solution6 solution = new Solution6();
        List<List<String>> input = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"),
                Arrays.asList("c")
        );
        List<Integer> expected = Arrays.asList(0, 1, 2);
        List<Integer> result = solution.peopleIndexes(input);
        assertEquals(expected, result);
    }
}