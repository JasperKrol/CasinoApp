package hangman;

import java.util.List;

public class ImageFactory {
    //Maak een list van images, deze heeft een index 0 = geen fout 1 = 1 fout etc
    public static List<List<String>> IMAGES = List.of(
            List.of(),
            List.of(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "___|___"
            ),
            List.of(
                    "",
                    "   |",
                    "   |",
                    "   |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |",
                    "   |",
                    "   |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |       |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |       |",
                    "   |      / \\",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |      -|-",
                    "   |      / \\",
                    "___|___"
            )
    );

    //Renderen van het image die bij het foute aantal guesses hoort.
    static List<String> getImage(int index){
        return IMAGES.get(index);
    }

}
