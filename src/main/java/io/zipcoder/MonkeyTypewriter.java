package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        UnsafeCopier monke = new UnsafeCopier(introduction);
        Thread unsafe1 = new Thread(monke);
        Thread unsafe2 = new Thread(monke);
        Thread unsafe3 = new Thread(monke);
        Thread unsafe4 = new Thread(monke);
        Thread unsafe5 = new Thread(monke);
        unsafe1.start();
        unsafe2.start();
        unsafe3.start();
        unsafe4.start();
        unsafe5.start();

        SafeCopier monkey = new SafeCopier(introduction);
        Thread safe1 = new Thread(monkey);
        Thread safe2 = new Thread(monkey);
        Thread safe3 = new Thread(monkey);
        Thread safe4 = new Thread(monkey);
        Thread safe5 = new Thread(monkey);
        safe1.start();
        safe2.start();
        safe3.start();
        safe4.start();
        safe5.start();



        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println("Unsafe: vvvvvvvvvvvvvv");
        System.out.println(monke.copied);
        System.out.println("Unsafe: ^^^^^^^^^^^^^^");

        System.out.println("safe: vvvvvvvvvvvvvv");
        System.out.println(monkey.copied);
        System.out.println("safe: ^^^^^^^^^^^^^^");
    }
}