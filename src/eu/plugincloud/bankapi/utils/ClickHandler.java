package eu.plugincloud.bankapi.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import eu.plugincloud.core.utils.ConfigManager;
import eu.plugincloud.core.utils.Language;

public class ClickHandler implements Listener{
	  @EventHandler
	  public static void onJoin(PlayerJoinEvent e) {
	    double bank = BankAPI.getCoins(e.getPlayer());
	  }

	  
	  @EventHandler
	  public static void onClick(InventoryClickEvent e) {
	    Player p = (Player)e.getWhoClicked();
	    
	    if (e.getView().getTitle().equalsIgnoreCase("ßbBank")) {
	      e.setCancelled(true);
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("ßaEinzahlen")) {
	        p.closeInventory();
	        ConfigManager.yml.set("Einzahlen." + p.getName(), Boolean.valueOf(true));
	        ConfigManager.yml.set("Auszahlen." + p.getName(), Boolean.valueOf(false));
	        ConfigManager.saveConfig();
	        p.sendMessage(Language.prefix + "ßbBitte schreibe jetzt den Betrag in den Chat.");
	      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("ßcAuszahlen")) {
	        p.closeInventory();
	        ConfigManager.yml.set("Einzahlen." + p.getName(), Boolean.valueOf(false));
	        ConfigManager.yml.set("Auszahlen." + p.getName(), Boolean.valueOf(true));
	        ConfigManager.saveConfig();
	        p.sendMessage(Language.prefix + "ßbBitte schreibe jetzt den Betrag in den Chat.");
	      } else {
	        return;
	      } 
	    } 
	  }
	}
