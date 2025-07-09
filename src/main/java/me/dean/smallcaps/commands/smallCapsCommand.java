package me.dean.smallcaps.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import me.dean.smallcaps.util.smallCharacterUtil;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class smallCapsCommand {
    MiniMessage mm = MiniMessage.miniMessage();
    private final smallCharacterUtil smallCharacter;

    public smallCapsCommand(smallCharacterUtil smallCharacter) {
        this.smallCharacter = smallCharacter;
    }

    public void register(){
        new CommandAPICommand("smallcaps")
                .withPermission("smallcaps.smallcapscommand")
                .withArguments(new GreedyStringArgument("text"))
                .executes((sender, args)->{
                    String original = (String) args.get("text");
                    String smallCaps = smallCharacter.simulateSmallCaps(original);
                    if (!(sender instanceof Player)){
                        sender.sendMessage(smallCaps);
                        return;
                    }
                    Player player = (Player) sender;
                    TextComponent message = (TextComponent) mm.deserialize("<#78c9ff>"+smallCaps)
                            .clickEvent(ClickEvent.copyToClipboard(smallCaps))
                            .hoverEvent(HoverEvent.showText(mm.deserialize("<#78c9ff>Press to copy")));
                    player.sendMessage(message);
                })
                .register();
    }
}
