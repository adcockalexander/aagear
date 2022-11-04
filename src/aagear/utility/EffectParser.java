package aagear.utility;

import java.util.List;

public class EffectParser {

    public static int parseEffectMagnitude(List<String> lore, int magnitudePos, String textAfterMagnitude) {
        for (String effect : lore) {
            if (!effect.contains(textAfterMagnitude)) {
                continue;
            }

            char stopChar = textAfterMagnitude.charAt(0);
            int i = magnitudePos;
            int magnitude = 0;
            char currentChar = effect.charAt(i);

            while (currentChar != stopChar) {
                magnitude *= 10;
                magnitude += effect.charAt(i) - '0';

                currentChar = effect.charAt(++i);
            }

            return magnitude;
        }

        return -1;
    }

}
