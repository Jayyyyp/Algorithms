package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_1076_Resistor {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long ResistorResult = 0;

        for(int i = 0; i < 3; i++) {
            String color = br.readLine();
            int ResistorValue = 0;

            switch(color) {
                case "black" : ResistorValue = 0; break;
                case "brown" : ResistorValue = 1; break;
                case "red" : ResistorValue = 2; break;
                case "orange" : ResistorValue = 3; break;
                case "yellow" : ResistorValue = 4; break;
                case "green" : ResistorValue = 5; break;
                case "blue" : ResistorValue = 6; break;
                case "violet" : ResistorValue = 7; break;
                case "grey" : ResistorValue = 8; break;
                case "white" : ResistorValue = 9; break;
            }
            if(i < 2) {
                ResistorResult = ResistorResult * 10 + ResistorValue;
            }else {
                ResistorResult *= (long)Math.pow(10, ResistorValue);
            }
        }
        System.out.println(ResistorResult);
        br.close();
    }
}
