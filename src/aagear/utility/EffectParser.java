package aagear.utility;

import java.util.List;

public class EffectParser {

    /** Given a list of lore, a start point for where the magnitude of the effect should begin,
     * and the effect 'body' in textAfterMagnitude, figures out the magnitude of the effect
     * specified in textAfterMagnitude. Returns -1 if the effect is not found.
     */
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
