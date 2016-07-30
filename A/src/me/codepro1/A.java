package me.codepro1;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class A
  extends Command
{

public A()
  {
    super("h", "capvp.a", new String[0]);
  }
  
  public void execute(CommandSender cs, String[] args)
  {
    if (args.length == 0)
    {
      cs.sendMessage(new TextComponent(ChatColor.GREEN + "Please enter text"));
    }
    else
    {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < args.length; i++) {
        builder.append(args[i]).append(" ");
      }
      String message = ChatColor.translateAlternateColorCodes('&', builder.toString().trim());
      
      for (ProxiedPlayer pl : BungeeCord.getInstance().getPlayers()) {
        if (pl.hasPermission("capvp.a.see"))
        {
          pl.sendMessage(new TextComponent(ChatColor.RED + "<--" + " " + ChatColor.AQUA + "Player: " + cs.getName() + ": " + " " + ChatColor.BLUE + "Message: " + message));
        }
      }
    }
  }
}
