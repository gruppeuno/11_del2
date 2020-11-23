package Test;

import Game.Die;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {

    @Test
    public void valueDiceTest() {
        Die DiceTest = new Die();
        DiceTest.roll();
        assertTrue(1 <= DiceTest.getDiceValue() && DiceTest.getDiceValue() <= 6);
    }

    @Test
    public void isDiceRandomTest(){

        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int totalValue;

        Die DiceTest = new Die();

            for (int i = 0; i < 10000; i++){
                DiceTest.roll();
                int x = DiceTest.getDiceValue();

                switch (x) {
                    case 1:
                        one++;
                        break;
                    case 2:
                        two++;
                        break;
                    case 3:
                        three++;
                        break;
                    case 4:
                        four++;
                        break;
                    case 5:
                        five++;
                        break;
                    case 6:
                        six++;
                        break;

                    default:
                        System.out.println("oops");
                }

            }

            System.out.println("ones: " + one);
            System.out.println("twos: " + two);
            System.out.println("threes: " + three);
            System.out.println("fours: " + four);
            System.out.println("fives: " + five);
            System.out.println("sixes: " + six);

            int ones = one * 1;
            int twos = two * 2;
            int threes = three * 3;
            int fours = four * 4;
            int fives = five * 5;
            int sixes = six * 6;

            totalValue = ones + twos + threes + fours + fives + sixes;
            double averageEyesIn10000Rolls = getAverage(totalValue,10000);

            System.out.println("\n" + "average eyes per die roll: " + averageEyesIn10000Rolls);

        }


        public double getAverage(double totalValue, double numbers){
        return (totalValue)/(numbers);
        }

        }



