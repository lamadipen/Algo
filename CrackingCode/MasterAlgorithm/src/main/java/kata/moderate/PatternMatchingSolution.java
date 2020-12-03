package kata.moderate;

/**
 * Moderate
 * Pattern Matching
 * CC: pg 183 Q: 16.18
 */
public class PatternMatchingSolution {
    boolean doesMatches(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        int size = value.length();

        for (int mainSize = 0; mainSize < size; mainSize++) {
            String main = value.substring(0, mainSize);
            for (int altStart = mainSize; altStart <= size; altStart++) {
                for (int altEnd = altStart; altEnd <= size; altEnd++) {
                    String alt = value.substring(altStart, altEnd);
                    String cand = buildFromPattern(pattern, main, alt);
                    if (cand.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String buildFromPattern(String pattern, String main, String alt) {
        StringBuffer sb = new StringBuffer();
        char first = pattern.charAt(0);

        for (char c : pattern.toCharArray()) {
            if (c == first) {
                sb.append(main);
            } else {
                sb.append(alt);
            }
        }
        return sb.toString();
    }

    boolean doesMatchesFirstOptimization(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        int size = value.length();
        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b' : 'a';

        int countOfMain = countOf(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;
        int firstAlt = pattern.indexOf(altChar);
        int maxMainSize = size / countOfMain;

        for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
            int remainingLength = size - mainSize * countOfMain;
            String first = value.substring(0, mainSize);
            if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
                int altIndex = firstAlt * mainSize;
                int altSize = countOfAlt == 0 ? 0 : remainingLength / countOfAlt;
                String second = countOfAlt == 0 ? "" : value.substring(altIndex, altSize + altIndex);

                String cand = buildFromPattern(pattern, first, second);

                if (cand.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int countOf(String pattern, char inputChar) {
        int count = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == inputChar) {
                count++;
            }
        }
        return count;
    }


}
