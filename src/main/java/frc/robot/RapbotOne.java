package frc.robot;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class RapbotOne{

    public static void main(String[] args){
        Map<String, String> Rapbot;

        Scanner squarewave = new Scanner(System.in);
        Rapbot = new HashMap<>();

        Rapbot.put("What does GameBro start?", "He starts wicked sick fires dawg");
        Rapbot.put("Naysayin", "Too bad, hope you get el1t3 someday");
        Rapbot.put("What is GameBro dropping?", "hella bars my man");
        System.out.println("Do you want to know what GameBro starts?");
        String l = squarewave.nextLine();
        
        if(l.equals("totally brosiff") || l.equals("of course mixmaster")){
            System.out.println(Rapbot.get("What does GameBro start?"));
        }else if(l.equals("nah")){
            System.out.println(Rapbot.get("Naysayin"));
        }else{
            System.out.println("I don't get what the fiercewicked shizzledizzle you're saying bro");
        }

        squarewave.close();
    }

    /* (VSCode users) switch console in the json to "integratedTerminal" to give required input 
     to turn back to normal use "internalConsole" */
    
}

/* Big ol' note to self: try using neural networking and give this boy some flow to work with.
gotta get some fires started, know what i'm saying? */