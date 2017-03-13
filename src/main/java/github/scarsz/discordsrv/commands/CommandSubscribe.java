package github.scarsz.discordsrv.commands;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Made by Scarsz
 *
 * @in /dev/hell
 * @on 3/12/2017
 * @at 3:06 PM
 */
public class CommandSubscribe {

    @Command(commandNames = { "subscribe" },
            helpMessage = "Subscribes yourself to Discord messages",
            permission = "discordsrv.subscribe")
    public static void execute(Player sender, String[] args) {
        DiscordSRV.getPlugin().setIsSubscribed(sender.getUniqueId(), true);

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', DiscordSRV.getPlugin().getConfig().getString("MinecraftSubscriptionMessagesOnSubscribe")));
    }

}