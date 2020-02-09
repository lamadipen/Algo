package com.cdk.bowlinggamekata;

import java.util.Iterator;
import java.util.LinkedList;

public class BowlingGame {
    private int player1Score = 0;
    private int player2Score = 0;
    private LinkedList<Integer> scoreSequence = new LinkedList();

    public int rollDice(int score) {
        scoreSequence.add(score);
        return score;
    }

    public String getScore() {
        Iterator<Integer> it = scoreSequence.iterator();
        int scoreSum = 0;
        for(int i =0; i < scoreSequence.size(); i++){
            for(int j =i; j < scoreSequence.size(); j++){
                if(j == 0){
                    scoreSum = scoreSequence.get(j);
                }else {
                    scoreSum += scoreSequence.get(j);
                }
                if (scoreSum >= 5){
                        player1Score++;
                        scoreSum =0;
                        break;
                }
            }
        }

        return "Player_1:" + player1Score + " Player_2=" + player2Score;
    }


//    public String getScore() {
//        int size = scoreSequence.size();
//
//        Integer first = scoreSequence.getFirst();
//
//        while(size > 0){
//            scoreSequence.forEach(new Consumer<Integer>() {
//                private int scoreSum = 0;
//                @Override
//                public void accept(Integer integer) {
//                    scoreSum+= integer;
//                    if(scoreSum >= 5){
//                        player1Score++;
//                        scoreSum =0;
//                        //scoreSequence.remove(integer);
//                    }
//                }
//            });
//            size--;
//        }

//        Iterator<Integer> it = scoreSequence.iterator();
//        int score = 0;
//        while (it.hasNext()) {
//            Integer current = it.next();
//            score += current;
//            if(score >= 5){
//                player1Score++;
//                score =0;
//            }
//        }
//        return "Player_1:"+ player1Score +" Player_2="+ player2Score;
//    }

}
