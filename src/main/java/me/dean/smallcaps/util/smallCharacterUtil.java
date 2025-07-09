package me.dean.smallcaps.util;

public class smallCharacterUtil {
    public String simulateSmallCaps(String input) {
        StringBuilder builder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                builder.append(getSmallCapsChar(c));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private char getSmallCapsChar(char c) {
        return switch (c) {
            case 'a' -> 'ᴀ'; case 'b' -> 'ʙ'; case 'c' -> 'ᴄ'; case 'd' -> 'ᴅ';
            case 'e' -> 'ᴇ'; case 'f' -> 'ғ'; case 'g' -> 'ɢ'; case 'h' -> 'ʜ';
            case 'i' -> 'ɪ'; case 'j' -> 'ᴊ'; case 'k' -> 'ᴋ'; case 'l' -> 'ʟ';
            case 'm' -> 'ᴍ'; case 'n' -> 'ɴ'; case 'o' -> 'ᴏ'; case 'p' -> 'ᴘ';
            case 'q' -> 'ǫ'; case 'r' -> 'ʀ'; case 's' -> 's'; case 't' -> 'ᴛ';
            case 'u' -> 'ᴜ'; case 'v' -> 'ᴠ'; case 'w' -> 'ᴡ'; case 'x' -> 'x';
            case 'y' -> 'ʏ'; case 'z' -> 'ᴢ';
            default -> c;
        };
    }
}
