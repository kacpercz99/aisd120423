import lib.TQueueArray;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //ExampleRandom.run();
        TQueueArray<Integer> que = new TQueueArray<>(4);
        que.put(1);
        que.put(3);
        que.put(5);
        que.put(2);
        System.out.println(que);

    }
}