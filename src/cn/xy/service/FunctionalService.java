package cn.xy.service;

/**
 *  functional interface experience
 *
 * @author Soul
 * @date 2020/2/3 19:45
 */
@FunctionalInterface
public interface FunctionalService {
    /**
     * there can be only one abstract function
     *
     * @author Soul
     * @date 2020/1/29 16:44
     */
    void create();

    /**
     * there can be multiple default functions
     *
     * @author Soul
     * @date 2020/1/29 16:44
     */
    default void delete() {
    }

    /**
     * there can be multiple static functions
     *
     * @author Soul
     * @date 2020/1/29 16:46
     */
    static void update() {
    }

    /**
     * can have all public functions in the Object class
     * they are not abstract functions written by themselves
     *
     * @author Soul
     * @date 2020/1/29 16:47
     */
    boolean equals(Object object);

    String toString();

    int hashCode();
}
