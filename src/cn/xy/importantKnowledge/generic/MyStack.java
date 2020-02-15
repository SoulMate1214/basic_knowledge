package cn.xy.importantKnowledge.generic;

import cn.xy.model.Hero;

import java.util.LinkedList;

/**
 * 自己设计一个泛型栈
 *
 * @author Soul
 * @date 2020/2/11 19:58
 */
public class MyStack<T> {
    LinkedList<T> linkedList = new LinkedList<T>();

    public void push(T t) {
        linkedList.addLast(t);
    }

    public T pull() {
        return linkedList.removeLast();
    }

    public T peek() {
        return linkedList.getLast();
    }

    public static void main(String[] args) {
        MyStack<Hero> heroStack = new MyStack<>();
        heroStack.push(new Hero("钢铁雄心盖伦", (short) 50, (short) 150, 5000, 0));
    }
}
