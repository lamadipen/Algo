package kata.moderate.livingpeople;

/**
 * Moderate
 * Living People
 * CC: pg 182 Q: 16.10
 */
public class LivingPeopleSolution {

    /**
     * Brute force implementation
     * Runtime  O(YP) where Y -> number of year and P-> number of people
     */
    public int maxAliveYear(Person[] people, int minY, int maxY) {
        int maxAlive = 0;
        int maxYear = maxY;

        for (int year = minY; year <= maxY; year++) {
            int liveCount = 0;
            for (Person person : people) {
                if (person.bDate <= year && person.dDate >= year) {
                    liveCount++;
                }
            }
            if (liveCount > maxAlive) {
                maxAlive = liveCount;
                maxYear = year;
            }
        }
        return maxYear;
    }


    /**
     * Runtime O(P logP) as that what we can improve sorting.
     */
    public int maxAliveYearImprovement1(Person[] people, int minY, int maxY) {
        int[] bDates = getSortedDates(people, true);
        int[] dDates = getSortedDates(people, true);

        int bIndex = 0;
        int dIndex = 0;
        int currentAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = minY;

        while (bIndex < people.length) {
            if (bDates[bIndex] <= dDates[dIndex]) {
                currentAlive++;
                if (currentAlive > maxAlive) {
                    maxAlive = currentAlive;
                    maxAliveYear = bDates[bIndex];
                }
                bIndex++;
            } else if (bDates[bIndex] > dDates[dIndex]) {
                currentAlive--;
                dIndex++;
            }
        }
        return maxAliveYear;
    }

    private int[] getSortedDates(Person[] people, boolean isBirthdate) {
        int[] dates = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            dates[i] = isBirthdate ? people[i].bDate : people[i].dDate;
        }
        return dates;
    }

    /**
     * Runtime O(P + R)
     * where P is number of person and R is range of dates
     */
    public int maxAliveYearImprovement2(Person[] people, int minY, int maxY) {

        int[] populationDeltas = getPopulationDeltas(people, minY, maxY);
        int maxAliveYear = getMaxAliveYear(populationDeltas);
        return minY + maxAliveYear;
    }

    private int[] getPopulationDeltas(Person[] people, int minY, int maxY) {
        int[] populationDeltas = new int[maxY - minY + 2];

        for (Person person : people) {
            int birth = person.bDate - minY;
            populationDeltas[birth]++;

            int death = person.dDate - minY;
            populationDeltas[death + 1]--;
        }
        return populationDeltas;
    }

    private int getMaxAliveYear(int[] populationDeltas) {
        int maxAliveYear = 0;
        int maxAlive = 0;
        int currentAlive = 0;

        for (int year = 0; year < populationDeltas.length; year++) {
            currentAlive += populationDeltas[year];
            if (currentAlive > maxAlive) {
                maxAlive = currentAlive;
                maxAliveYear = year;
            }
        }
        return maxAliveYear;
    }
}

class Person {
    int bDate;
    int dDate;

    public Person(int bDate, int dDate) {
        this.bDate = bDate;
        this.dDate = dDate;
    }
}