package example;

public class entry {
    public static void main(String[] args) throws InterruptedException{
        if (args[0].equals("producer")) {
            producer.main(args);
        } else if (args[0].equals("consumer")) {
            consumer.main(args);
        }
	else {
            throw new IllegalArgumentException("Wrong arguments:" + args[0]);
        }
    }
}
