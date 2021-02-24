package kata.hard;

import java.util.List;

/**
 * Hard
 * Re-Space
 * CC: pg 188 Q: 17.13
 */
public class ReSpaceSolution {

    /**
     * Runtime O(2^N)
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String reSpcae(List<String> dictionary, String sentence) {
        ParsedResult result = split(dictionary, sentence, 0);
        return result.parsed;
    }

    private ParsedResult split(List<String> dictionary, String sentence, int start) {
        if (start >= sentence.length()) {
            return new ParsedResult(0, "");
        }
        int bestInvalid = Integer.MAX_VALUE;
        String bestParsing = null;
        String partial = "";
        int index = start;
        while (index < sentence.length()) {
            char c = sentence.charAt(index);
            partial += c;
            int invalid = dictionary.contains(partial) ? 0 : partial.length();
            if (index < bestInvalid) {
                ParsedResult result = split(dictionary, sentence, index + 1);
                if (invalid + result.invalid < bestInvalid) {
                    bestInvalid = invalid + result.invalid;
                    bestParsing = partial + " " + result.parsed;
                    if (bestInvalid == 0) break;
                }
            }
            index++;
        }

        return new ParsedResult(bestInvalid, bestParsing);
    }

    /**
     * Runtime O(n^2)
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String bestReSpace(List<String> dictionary, String sentence) {
        ParsedResult[] memo = new ParsedResult[sentence.length()];
        ParsedResult r = bestSplit(dictionary, sentence, 0, memo);
        return r == null ? null : r.parsed;
    }

    private ParsedResult bestSplit(List<String> dictionary, String sentence, int start, ParsedResult[] memo) {
        if (start >= sentence.length()) {
            return new ParsedResult(0, "");
        }
        if (memo[start] != null) {
            return memo[start];
        }

        int bestInvalid = Integer.MAX_VALUE;
        String bestParsing = null;
        String partial = "";
        int index = start;

        while (index < sentence.length()) {
            char c = sentence.charAt(index);
            partial += c;
            int invalid = dictionary.contains(partial) ? 0 : partial.length();
            if (invalid < bestInvalid) {
                ParsedResult result = bestSplit(dictionary, sentence, index + 1, memo);

                if (invalid + result.invalid < bestInvalid) {
                    bestInvalid = invalid + result.invalid;
                    bestParsing = partial + " " + result.parsed;
                    if (bestInvalid == 0) break;
                }
            }
            index++;
        }
        memo[start] = new ParsedResult(bestInvalid, bestParsing);
        return memo[start];
    }
}

class ParsedResult {
    int invalid;
    String parsed;

    public ParsedResult(int invalid, String parsed) {
        this.invalid = invalid;
        this.parsed = parsed;
    }
}