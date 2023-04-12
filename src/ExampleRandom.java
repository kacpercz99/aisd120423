import lib.TQueueArray;

import java.util.Random;

public class ExampleRandom {
    public static void run(){

        TQueueArray<String> stringTQueueArray = new TQueueArray<>(4);

        String[] strings = new String[]{
                "ene", "due", "rike","fake", "torba" , "borba", "ósmesmake" };
        int actualIndex = 0;
        Random rand = new Random();


        do{
            if( rand.nextInt(2) == 0 ){
                //dodawanie danych do kolejki
                if( actualIndex < strings.length ){
                    if( !stringTQueueArray.isFull() ){
                        System.out.println("Dodano element :" + strings[actualIndex] );
                        stringTQueueArray.put( strings[actualIndex] );
                        actualIndex++;
                    }
                }

            }



            if( rand.nextInt(2) == 0 ){
                //usuwanie danych z kolejki
                if( !stringTQueueArray.isEmpty() ){
                    System.out.println( "Usunięto element: " + stringTQueueArray.top() );
                    stringTQueueArray.pop();
                }
            }

        }while( actualIndex < strings.length || !stringTQueueArray.isEmpty() );

    }
}
