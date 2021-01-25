package kata.hard;


/**
 * Hard
 * Shuffle
 * CC: pg 186 Q: 17.2
 */
public class Shuffle {

    public int randomGen(int low, int high) {
        return low + (int) (Math.random() * (high - low + 1));
    }

    public int[] shuffleArrayRecursively(int[] cards, int index) {
        if (index == 0) {
            return cards;
        }
        shuffleArrayRecursively(cards, index - 1);
        int randomIndex = randomGen(0, index);

        int temp = cards[randomIndex];
        cards[randomIndex] = cards[index];
        cards[index] = temp;

        return cards;
    }


    public int[] shuffleArrayIterative(int[] cards) {
        for (int index = 0; index < cards.length; index++) {
            int randomIndex = randomGen(0, index);
            int temp = cards[randomIndex];
            cards[randomIndex] = cards[index];
            cards[index] = temp;
        }
        return cards;
    }

}
