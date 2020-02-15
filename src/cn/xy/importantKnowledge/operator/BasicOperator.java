package cn.xy.importantKnowledge.operator;

public class BasicOperator {
    int intNumber1 = 1;
    int intNumber2 = 2;
    int intNumber3 = 3;
    int intNumber4 = 4;
    int intNumber5 = 5;
    int count;
    private BasicOperator(){
        count = intNumber2 + intNumber1;
        count = intNumber3 - intNumber2;
        count = intNumber4 * intNumber3;
        count = intNumber5 / intNumber4;
        count = intNumber1 % intNumber5;
        count += intNumber1;
        count -= intNumber2;
        count *= intNumber3;
        count /= intNumber4;
        count ++;
        count --;
        // contain&&,||,&,|,>=,<=,==,!=
        if (intNumber1>=intNumber2||intNumber2<=intNumber3&&intNumber3==intNumber4&intNumber4!=intNumber5|intNumber5!=intNumber1){
            count += count;
        }
        // this "&,|,^,~" is different from above
        System.out.println(intNumber1&intNumber2);
        System.out.println(intNumber1|intNumber2);
        System.out.println(intNumber1^intNumber2);
        System.out.println(~intNumber2);
        System.out.println(count>>1);
        System.out.println(count<<1);
        System.out.println(count>>>2);

        // trinocular operator
        count = intNumber1>intNumber2?1:2;
    }
}
