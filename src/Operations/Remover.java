package Operations;

import java.util.ArrayList;
import java.util.List;

public class Remover {
    public static ArrayList<String> removeAllSlashes(String input) {
        String[] strings = input.split("/");
        return new ArrayList<>(List.of(strings));
    }
}
