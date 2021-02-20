package entities;

import java.util.Random;

public class NameGenarator {
    Random random;
    String vowels = "aeiou";
    String consonants = "bcdfghjklmnpqrstvwxxyz";

    public NameGenarator(){
        random = new Random();
    }
    public String randVowels(){
        return "" + vowels.charAt(random.nextInt(vowels.length()));
    }
    public String randConsonats(){
        return "" + consonants.charAt(random.nextInt(consonants.length()));
    }
    public String generate(int nLetters){
        String name = this.randConsonats().toUpperCase();
        for(int i=1;i<nLetters;i++){
            if(i % 2 == 0)
                name += randConsonats();
            else
                name += randVowels();
        }
        return name;
    }
}


