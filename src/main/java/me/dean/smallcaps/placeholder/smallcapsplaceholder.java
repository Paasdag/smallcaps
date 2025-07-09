package me.dean.smallcaps.placeholder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.dean.smallcaps.Smallcaps;
import me.dean.smallcaps.util.smallCharacterUtil;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class smallcapsplaceholder extends PlaceholderExpansion {

    private final smallCharacterUtil smallCharacter;

    public smallcapsplaceholder(smallCharacterUtil smallCharacter) {
        this.smallCharacter = smallCharacter;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "smallcaps";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Dean";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params){
        if (params.startsWith("text_")){
            String input = params.substring(5);
            return smallCharacter.simulateSmallCaps(input.toLowerCase());
        }
        return null;
    }
}
