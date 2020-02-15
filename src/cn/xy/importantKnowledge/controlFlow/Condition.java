package cn.xy.importantKnowledge.controlFlow;

public class Condition {
    private Condition(int i, int j){
        // if condition
        if (i>j){
            System.out.println(i);
        }else if (i<j){
            System.out.println(j);
        } else {
            System.out.println(i+j);
        }

        // switch condition
        switch (i){
            case 0: i = i + j;break;
            case 1: j = i + j;break;
            case 2: i = i - j;break;
            case 3: j = j - i;break;
        }
    }
}
