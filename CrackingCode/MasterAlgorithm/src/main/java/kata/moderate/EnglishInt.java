package kata.moderate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EnglishInt {
    Map<Integer, String> numberMap = new HashMap<>();
    String negative = "negative";
    String[] bigs = {"", "thousand", "million", "billion"};

    public EnglishInt() {
        numberMap.put(0, "zero");
        numberMap.put(1, "one");
        numberMap.put(2, "two");
        numberMap.put(3, "three");
        numberMap.put(4, "four");
        numberMap.put(5, "five");
        numberMap.put(6, "six");
        numberMap.put(7, "seven");
        numberMap.put(8, "eight");
        numberMap.put(9, "nine");
        numberMap.put(10, "ten");
        numberMap.put(11, "eleven");
        numberMap.put(12, "twelve");
        numberMap.put(13, "thirteen");
        numberMap.put(14, "fourteen");
        numberMap.put(15, "fifteen");
        numberMap.put(16, "sixteen");
        numberMap.put(17, "seventeen");
        numberMap.put(18, "eighteen");
        numberMap.put(19, "nineteen");
        numberMap.put(20, "twenty");
        numberMap.put(30, "thirty");
        numberMap.put(40, "forty");
        numberMap.put(50, "fifty");
        numberMap.put(60, "sixty");
        numberMap.put(70, "seventy");
        numberMap.put(80, "eighty");
        numberMap.put(90, "ninety");
        numberMap.put(100, "hundred");
        numberMap.put(100, "thousand");
        numberMap.put(100000000, "million");
    }

    public void printEnglishInt(int num) {
        if (num < 19) {

        }
        if (num / 10 < 1) {
            System.out.print(numberMap.get(num));
        } else if (num / 10 < 10) {
            System.out.println("tens");
        } else if (num / 10 < 100) {
            printEnglishInt(num / 100);
            System.out.print("hundred");
        } else if (num / 10 < 1000) {
            printEnglishInt(num / 1000);
            System.out.print("thousand");
            printEnglishInt(num / 100);
        }
    }

    public String deviSolution(int num) {
        String outputString = "";

        if (num == 0) {
            return "";
        }

        if (numberMap.containsKey(num) && num < 100) {
            return numberMap.get(num);
        }

        int divider = 10;
        int quotient = 0;
        int remainder = 0;

        if (num > 19 && num < 100) {
            remainder = num / divider;
            int tempKeyToSearch = num - remainder;

            outputString = numberMap.get(tempKeyToSearch) + numberMap.get(remainder);
            return outputString;
        } else if (num >= 100 && num < 1000) {
            divider = 100;
        } else if (num >= 1000 && num < 1000000) {
            divider = 1000;
        }
        remainder = num % divider;
        quotient = num / divider;

        outputString = deviSolution(quotient) + " " + numberMap.get(divider) + " " + deviSolution(remainder);
        return outputString;
    }

    public String convert(int num) {
        if (num == 0) {
            return numberMap.get(0);
        } else if (num < 0) {
            return negative + convert(-1 * num);
        }
        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                String chunk = covertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            num /= 1000;
            chunkCount++;
        }
        return listToString(parts);
    }

    private String covertChunk(int num) {
        LinkedList<String> parts = new LinkedList<>();

        if (num >= 100) {
            parts.addLast(numberMap.get(num / 100));
            parts.addLast(numberMap.get(100));
            num %= 100;
        }
        if (num >= 10 && num <= 19) {
            parts.addLast(numberMap.get(num));
        } else if (num >= 20) {
            int remainder = num - num % 10;
            parts.addLast(numberMap.get(remainder));
            num %= 10;
        }

        if (num >= 1 && num <= 9) {
            parts.add(numberMap.get(num));
        }
        return listToString(parts);
    }


    private String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();
        while (parts.size() > 1) {
            sb.append(parts.pop());
            sb.append(" ");
        }
        sb.append(parts.pop());
        return sb.toString();
    }

    static class BookSolution {
        String[] smalls = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String[] bigs = {"", "thousand", "million", "billion"};

        String hundred = "hundred";
        String negative = "negative";

        public String convert(int num) {
            if (num == 0) {
                return smalls[0];
            } else if (num < 0) {
                return negative + convert(-1 * num);
            }
            LinkedList<String> parts = new LinkedList<>();
            int chunkCount = 0;

            while (num > 0) {
                if (num % 1000 != 0) {
                    String chunk = covertChunk(num % 1000) + " " + bigs[chunkCount];
                    parts.addFirst(chunk);
                }
                num /= 1000;
                chunkCount++;
            }
            return listToString(parts);
        }

        private String covertChunk(int num) {
            LinkedList<String> parts = new LinkedList<>();

            if (num >= 100) {
                parts.addLast(smalls[num / 100]);
                parts.addLast(hundred);
                num %= 100;
            }
            if (num >= 10 && num <= 19) {
                parts.addLast(smalls[num]);
            } else if (num >= 20) {
                parts.addLast(tens[num / 10]);
                num %= 10;
            }

            if (num >= 1 && num <= 9) {
                parts.add(smalls[num]);
            }
            return listToString(parts);
        }


        private String listToString(LinkedList<String> parts) {
            StringBuilder sb = new StringBuilder();
            while (parts.size() > 1) {
                sb.append(parts.pop());
                sb.append(" ");
            }
            sb.append(parts.pop());
            return sb.toString();
        }

    }
}
