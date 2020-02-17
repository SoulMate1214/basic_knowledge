package cn.xy.importantKnowledge.lambda;

public class DemoImpl implements Demo<Integer> {
    @Override
    public Integer delete(int a, int b) {
        return a - b;
    }
}
