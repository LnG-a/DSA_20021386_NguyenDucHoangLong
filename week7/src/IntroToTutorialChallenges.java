import java.util.List;

public class IntroToTutorialChallenges {
    /**
     * This method is used to find index of a number in an array.
     *
     * @param arr an list of int in ascending order
     * @param V   an int variable that you want to find
     * @return the index of the number in array a
     */
    public static int introTutorial(int V, List<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int i = low + (high - low) / 2;
            if (V > arr.get(i)) {
                low = i + 1;
            } else if (V < arr.get(i)) {
                high = i - 1;
            } else {
                return i;
            }
        }
        return -1;
    }
}
