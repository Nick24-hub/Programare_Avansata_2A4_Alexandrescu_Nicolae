package app;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

import static com.DisplayLocales.displayLocales;
import static com.Info.info;
import static com.SetLocale.setLocale;

public class LocaleExplore {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String command = null;
        String[] words;
        Locale locale = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);

        while(!Objects.equals(command, "stop")) {
            command = scan.nextLine();
            words = command.split(" ");

            if(command.equals("display locales"))
            {
                System.out.println(messages.getString("prompt"));
                System.out.println(command);
                System.out.println(messages.getString("locales"));
                displayLocales();
            }

            else if(words[0].equals("set") && words[1].equals("locale"))
            {
                System.out.println(messages.getString("prompt"));
                System.out.println(command);
                locale=setLocale(words[2]);
                messages = ResourceBundle.getBundle("Messages", locale);
                System.out.println(messages.getString("locale.set"));
            }

            else if(command.equals("info")){
                System.out.println(messages.getString("prompt"));
                System.out.println(command);
                System.out.println(messages.getString("info"));
                info(locale);
            }
            else if(!command.equals("stop")){
                System.out.println(messages.getString("invalid"));
            }
        }
    }
}
