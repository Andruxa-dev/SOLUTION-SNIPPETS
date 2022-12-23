import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class hang_man {

    public static void main (String[] args) {

        // Create a list of words from which one word will be selceted at random
        ArrayList <String> word_list = new ArrayList<String>();
        word_list.add("aardvark");
        word_list.add("baboon");
        word_list.add("camel");
        int list_size = word_list.size();
        // Printing the lenght(size) of the list
        System.out.println(list_size);

        // create a random number that is derived from the size of the list of words
        // Random from 0 to size of the list
        Random random_number = new Random();
        int number = random_number.nextInt(list_size);
        // Printing the random number
        System.out.println(number);

        // create an obscuring template that imitates the word that was chosen at random
        String chosen_word = word_list.get(number); 
        // Print out randomly selected word
        // Example : System.out.println(word_list.get(number)); or do this below
        System.out.println(chosen_word);

        // Creating an obs template this will have "-" placeholders that will later be replaced by correctly guessed letters
        ArrayList<Object> obs_template = new ArrayList<Object>();

        // Creating a string builder object wich will be used with indexes to compare values between collections
        StringBuilder sb = new StringBuilder();

        // Filling up string builder object with characters fromt he chosen word and filling up obscured template with "-"
        for (char ch : chosen_word.toCharArray()) {
            sb.append(ch);
            obs_template.add("-");
        }

        // making a string out of the string builder object
        String temp_string = sb.toString();

        System.out.println(obs_template);

        // Informing the user of the number of tries
        System.out.println("You have 5 tries to guess the entire word, letter by letter");
        int tries = 5;
        while (tries != 0) {

            System.out.println('\n' + "Please guess a letter:");
            Scanner scan = new Scanner(System.in);
            Character user_input;
            user_input = scan.next().charAt(0);
            System.out.println("This is the letter that was chosen: " +  user_input);

            for (int i = 0; i < temp_string.length();i++)

            {   char result = temp_string.charAt(i);

                if (user_input == result)

                {   System.out.println('\n' + "This letter matches");

                    //int index = template.indexOf(user_input,i);//this doesnt work and only returns the index of the first occurance
                    obs_template.set(i,user_input);
        
                }
            }

            System.out.println(obs_template);

            if (temp_string.indexOf(user_input) !=-1)
            {  System.out.println('\n' + "You guessed a correct letter");}
            
            else
            {   tries -=1;
                System.out.println('\n' + "You guessed an incorrect letter");
                System.out.print('\n' + "You have " + tries +  " number of tries left");}
     
        
            if (tries == 0)
            {   System.out.print('\n' + "You have no more tries left, thank you for playing!");}  

            System.out.print(System.lineSeparator() +  obs_template); 
           
            //String temp_string2;
            String temp_string2 = chosen_word.toString();
          
            StringBuilder sb1 = new StringBuilder();

            for (Object obj : obs_template) 
            {   sb1.append(obj);}

            //String temp_string3 
            String temp_string3 = sb1.toString();

            //Assigning value to boolean
            boolean match = temp_string2.equals(temp_string3);

            if (match == true) // if boolean is true

            {    System.out.print('\n' + "Match, you guessed all the letters correctly!");
                 tries =0;
        }            
            else // if boolean is false

            {System.out.print('\n' + "You didnt guess all the letter yet");}
        }
            }
        }

    

    

