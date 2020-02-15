package cn.xy.importantKnowledge.thread.demo1;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *  multi thread 3.3：implements Callable
 *  implemented as lambda expression
 *
 * @author Soul
 * @date 2020/2/3 20:10
 */
public class PeopleCallableLambda {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>((Callable<String>) () -> {
            try {
                Set<PeopleCallable> peopleCallableSet = new HashSet<>();
                peopleCallableSet.add(new PeopleCallable("张三", 18));
                peopleCallableSet.add(new PeopleCallable("李四", 20));
                peopleCallableSet.add(new PeopleCallable("王五", 25));
                Optional.of(peopleCallableSet).orElse(new HashSet<>()).forEach(System.out::println);
                return peopleCallableSet.toString();
            } catch (Exception e) {
                throw new Exception("set集合异常");
            }
        });
        Thread thread = new Thread(futureTask, "FirstTread");
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
