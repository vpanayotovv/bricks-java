package core;

public interface Engine extends Runnable {

    /*
    Method that start the program and must enter input

    4 6
1 1 2 2 3 3
4 4 5 5 6 6
7 7 8 8 9 9
10 10 11 11 12 12

this is the first input that I check

6 8
1 1 2 2 3 3 4 4
5 5 6 6 7 7 8 8
9 9 10 10 11 11 12 12
13 13 14 14 15 15 16 16
17 17 18 18 19 19 20 20
21 21 22 22 23 23 24 24

this is the second

     */
    @Override
    void run();
}
