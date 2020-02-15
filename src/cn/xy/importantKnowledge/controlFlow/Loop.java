package cn.xy.importantKnowledge.controlFlow;

public class Loop {
    private Loop(int i, int j){
        // for loop
        outloop:
        for (int p = 0;p<j;p++){
            for (int q = 20;q>i;q--){
                p+=q;
                if (p == 10){
                    break;
                }else if(p == 15){
                    continue;
                }else {
                    break outloop;
                }
            }
        }

        // while loop
        while (i>10){
            System.out.println(j);
        }

        // do-while loop
        do {
            System.out.println(i);
        }while (j<10);
    }
}
