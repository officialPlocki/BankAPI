package eu.plugincloud.bankapi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eu.plugincloud.bankapi.utils.BankAPI;
import eu.plugincloud.core.utils.Language;

public class ecoAdminBank implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player)commandSender;
        if(commandSender.hasPermission("plugincloudcore.ecoadminmoney")){

            if(strings.length==0) {
                p.sendMessage(Language.prefix + "Bitte verwende: §a/ecoadminbank <show, give, take, reset> <Spieler>  [Anzahl]");
                return false;
            } else if(strings.length==1){
                p.sendMessage(Language.prefix + "Bitte verwende: §a/ecoadminbank <show, give, take, reset> <Spieler>  [Anzahl]");
                return false;
            } else if(strings.length==2){

                if(strings[0].equalsIgnoreCase("show")){
                    if(Bukkit.getPlayer(strings[1]).hasPlayedBefore()){
                        if(Bukkit.getPlayer(strings[1]).isOnline()==false){
                            p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat aktuell "+ BankAPI.getCoins(Bukkit.getOfflinePlayer(strings[1])) + " Euro.");
                            return true;
                        }
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat aktuell "+ BankAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Euro.");
                        return true;
                    } else {
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat den Server noch nie betreten.");
                        return false;
                    }
                } else if(strings[0].equalsIgnoreCase("reset")){
                    if(Bukkit.getPlayer(strings[1]).hasPlayedBefore()){
                        if(Bukkit.getPlayer(strings[1]).isOnline()==false){
                            BankAPI.resetCoins(Bukkit.getOfflinePlayer(strings[1]));
                            p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat nun "+ BankAPI.getCoins(Bukkit.getOfflinePlayer(strings[1])) + " Euro.");
                            return true;
                        }
                        BankAPI.resetCoins(Bukkit.getPlayer(strings[1]));
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat nun "+ BankAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Euro.");
                        return true;
                    } else {
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat den Server noch nie betreten.");
                        return false;
                    }
                }
            } else if(strings.length==3){
                if(strings[0].equalsIgnoreCase("give")){
                    if(Bukkit.getPlayer(strings[1]).hasPlayedBefore()){
                        if(Bukkit.getPlayer(strings[1]).isOnline()==false){
                            BankAPI.addCoins(Bukkit.getOfflinePlayer(strings[1]), Double.valueOf(strings[2]));
                            p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"$7 hat nun "+ BankAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Euro.");
                            return true;
                        }
                        BankAPI.addCoins(Bukkit.getPlayer(strings[1]), Integer.valueOf(strings[2]));
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat nun "+ BankAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Euro.");
                        return true;
                    } else {
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat den Server noch nie betreten.");
                        return false;
                    }
                } else if(strings[0].equalsIgnoreCase("take")){
                     if(Bukkit.getPlayer(strings[1]).hasPlayedBefore()){
                          if(Bukkit.getPlayer(strings[1]).isOnline()==false){
                              BankAPI.removeCoins(Bukkit.getOfflinePlayer(strings[1]), Double.valueOf(strings[2]));
                              p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"$7 hat nun "+ BankAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Euro.");
                              return true;
                          }
                          BankAPI.removeCoins(Bukkit.getPlayer(strings[1]), Double.valueOf(strings[2]));
                          p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat nun "+ BankAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Euro.");
                          return true;
                          } else {
                               p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat den Server noch nie betreten.");
                               return false;
                     }
                    } else {
                        p.sendMessage(Language.prefix + "Bitte verwende: §a/ecoadminbank <show, give, take, reset> <Spieler>  [Anzahl]");
                        return false;
                    }
            } else if(strings.length>=3){
                p.sendMessage(Language.prefix + "Bitte verwende: §a/ecoadminbank <show, give, take, reset> <Spieler>  [Anzahl]");
                return false;
            }
        } else {
            p.sendMessage(Language.noperm);
        }

        return false;
    }
}
