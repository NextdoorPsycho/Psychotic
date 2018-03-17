package xyz.psydev;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Next extends JavaPlugin implements Listener
{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Next plugin;

	public void onEnable()
	{
		this.logger.info("IM DUMB AF");
	}

	public void onDisable()
	{
		PluginDescriptionFile pdfFile = getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
		getServer().getPluginManager().removePermission(new Permissions().PsyJoin);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("Psyleave"))
		{
			if(player.hasPermission(new Permissions().PsyLeave))
			{
				if(args.length == 0)
				{
					String playerName = player.getName();
					String message = getConfig().getString("PsyLeave");
					if(message.contains("%player%"))
					{
						message = message.replaceAll("%player%", playerName);
					}
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
				}
				else if(args.length == 1)
				{
					String message = getConfig().getString("PsyLeave");
					if(message.contains("%player%"))
					{
						message = message.replaceAll("%player%", args[0]);
					}
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
				}
				else if(args.length >= 2)
				{
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0|========- &cNextdoor Join &0-========|"));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/Psyjoin &c- &7Make it look like you joined the server."));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/Psyjoin <player> &c- &7Make it look like <player> joined the server."));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/Psyleave &c- &7Make it look like you left the server."));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/Psyleave <player> &c- &7Make it look like <player> left the server."));
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "&8[&cPsyLock&8] &cYou do not have permissions!");
			}
		}
		else if(commandLabel.equalsIgnoreCase("Psyjoin"))
		{
			if(player.hasPermission(new Permissions().PsyJoin))
			{
				if(args.length == 0)
				{
					String playerName = player.getName();
					String message = getConfig().getString("PsyJoin");
					if(message.contains("%player%"))
					{
						message = message.replaceAll("%player%", playerName);
					}
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
				}
				else if(args.length == 1)
				{
					String message = getConfig().getString("PsyJoin");
					if(message.contains("%player%"))
					{
						message = message.replaceAll("%player%", args[0]);
					}
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
				}
				else if(args.length >= 2)
				{
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0======== &cNextdoor Join &0========"));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/Psyjoin &c- &7Make it look like you joined the server."));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/Psyjoin <player> &c- &7Make it look like <player> joined the server."));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/Psyleave &c- &7Make it look like you left the server."));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/Psyleave <player> &c- &7Make it look like <player> left the server."));
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "&8[&cPsyLock&8] &cYou do not have permissions!");
			}
		}
		return false;
	}
}