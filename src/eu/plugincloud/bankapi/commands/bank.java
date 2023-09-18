package eu.plugincloud.bankapi.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import eu.plugincloud.bankapi.utils.BankAPI;

public class bank implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
	    Player p = (Player)sender;
	    Inventory inv = Bukkit.createInventory(null, 27, "§bBank");
	    
	    ItemStack einzahlen = new ItemStack(Material.GREEN_SHULKER_BOX);
	    ItemMeta einzahlenmeta = einzahlen.getItemMeta();
	    einzahlenmeta.setDisplayName("§aEinzahlen");
	    einzahlen.setItemMeta(einzahlenmeta);
	    
	    ItemStack kontostand = new ItemStack(Material.PAPER);
	    ItemMeta kontostandmeta = kontostand.getItemMeta();
	    kontostandmeta.setDisplayName("§eDein Kontostand: " + BankAPI.getCoins(p) + " Euro");
	    kontostand.setItemMeta(kontostandmeta);
	    
	    ItemStack auszahlen = new ItemStack(Material.RED_SHULKER_BOX);
	    ItemMeta auszahlenmeta = auszahlen.getItemMeta();
	    auszahlenmeta.setDisplayName("§cAuszahlen");
	    auszahlen.setItemMeta(auszahlenmeta);
	    
	    inv.setItem(10, einzahlen);
	    
	    inv.setItem(13, kontostand);
	    
	    inv.setItem(16, auszahlen);
	    
	    p.openInventory(inv);
	    return false;
	  }

}
