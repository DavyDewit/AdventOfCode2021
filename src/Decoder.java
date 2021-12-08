import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

 public class Decoder {
     private List<String> input;
     private List<String> output;
     private String[] numbers;

     public void setNewInputOuput(String input) {
         this.input = Arrays.stream(input.split(" ")).sequential().filter(string -> !string.equals("|")).collect(Collectors.toList()).subList(0, 10);
         this.output = Arrays.stream(input.split(" ")).sequential().filter(string -> !string.equals("|")).collect(Collectors.toList()).subList(10, 14);
         numbers = new String[10];
     }

     public void reconizeNumbers() {
         Optional<String> number;
         int[][] lengthAndIndex = {{2, 1}, {4, 4}, {3, 7}, {7, 8}};
         for (int[] data : lengthAndIndex) {
             number = input.stream().filter(string -> string.length() == data[0]).findAny();
             if (number.isPresent()) {
                 numbers[data[1]] = number.get();
             }
         }
     }
     public int partTwo(){
         String outputLine = "";
         for (String line:output) {
             int correctCharacters=0;
             int counter = 0;
             for (String number:numbers) {
                 for (String character:line.split("")) {
                     if(number.contains(character)){
                         correctCharacters+=1;
                     }
                 }
                 if(number.length()==correctCharacters && line.length()==number.length()){
                   outputLine += counter;
                   break;
                 }else{
                     correctCharacters=0;
                 }
                 counter+=1;
             }
         }
         return Integer.parseInt(outputLine);
     }

     public int partOne() {
         int sum = 0;
         int[] indexes = {1, 4, 7, 8};
         for (int index : indexes) {
             List<String> test = output.stream()
                     .filter(string -> string.length() == numbers[index].length())
                     .filter(string -> {
                         int control = 0;
                         for (String character : string.split("")) {
                             if (numbers[index].contains(character)) {
                                 control++;
                             }
                         }
                         return control == numbers[index].length();
                     }).collect(Collectors.toList());
             for (String t : test)
                 sum += 1;
         }
         return sum;
     }


     public void findAllTheNumbers() {
         List<String> sixLength = input.stream().filter(string -> string.length()==6).collect(Collectors.toList());
         List<String> fiveLength = input.stream().filter(string -> string.length()==5).collect(Collectors.toList());

         //identifying 6
         for (String line : sixLength) {
             for (String character : numbers[8].split("")) {
                 if (!line.contains(character) && numbers[1].contains(character)) {
                     numbers[6] = line;
                     break;
                 }
             }
         }
         sixLength.remove(numbers[6]);

         //identifying 0
         for (String line : sixLength) {
             for (String character : numbers[8].split("")) {
                 if (!line.contains(character) && numbers[4].contains(character)) {
                     numbers[0] = line;
                     break;
                 }
             }
         }
         sixLength.remove(numbers[0]);

         //identifying 9
         numbers[9]=sixLength.get(0);

         //identifying 2
         for (String line : fiveLength) {
             for (String character : line.split("")) {
                 if (!numbers[9].contains(character)) {
                     numbers[2] = line;
                     break;
                 }
             }
         }
         fiveLength.remove(numbers[2]);

         //identifying 5
         for (String line : fiveLength) {
             for (String character : line.split("")) {
                 if (!numbers[2].contains(character) && !numbers[1].contains(character)) {
                     numbers[5] = line;
                     break;
                 }
             }
         }
         fiveLength.remove(numbers[5]);

         //identifying 3
         numbers[3] = fiveLength.get(0);
     }
 }




