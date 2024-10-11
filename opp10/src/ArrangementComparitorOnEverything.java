import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrangementComparitorOnEverything implements Comparator<Arrangement> {
    private int asciiValueOfCharacter(char inputChar) {
        int asciiValue = (int) inputChar;
        return asciiValue;
    }
    private List<Integer> asciiArrayOfString(String inputString) {
        List<Integer> arrayOfAsciiValues = new ArrayList<Integer>();
        for (char character : inputString.toCharArray()) {
            arrayOfAsciiValues.add(asciiValueOfCharacter(character));
        }
        return arrayOfAsciiValues;
    }
    public int compare(Arrangement a1, Arrangement a2) {
        if (a1.skaffSted() != a2.skaffSted()) {
            boolean isA1LargerThanA2 = false;
            List<Integer> a1StedNavnAsciiArray = asciiArrayOfString(a1.skaffSted());
            List<Integer> a2StedNavnAsciiArray = asciiArrayOfString(a2.skaffSted());
            for (int i = 0; i < Math.min(a1StedNavnAsciiArray.size(), a2StedNavnAsciiArray.size()); i++) {
                if (a1StedNavnAsciiArray.get(i) > a2StedNavnAsciiArray.get(i)) {
                    isA1LargerThanA2 = true;
                    break;
                }
                if (a1StedNavnAsciiArray.get(i) < a2StedNavnAsciiArray.get(i)) {
                    isA1LargerThanA2 = false;
                    break;
                }
            }
            return Integer.compare(isA1LargerThanA2 ? 1 : 0, isA1LargerThanA2 ? 0 : 1);
        }
        else {
            return Long.compare(a1.skaffTidspunkt(), a2.skaffTidspunkt());
        }
    }
}


// TODO: switch to radix sort