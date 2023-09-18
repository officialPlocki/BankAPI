package eu.plugincloud.bankapi.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import eu.plugincloud.bankapi.commands.bank;
import eu.plugincloud.bankapi.commands.ecoAdminBank;
import eu.plugincloud.bankapi.utils.ClickHandler;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("bank").setExecutor(new bank());
		getCommand("ecoadminbank").setExecutor(new ecoAdminBank());
		Bukkit.getPluginManager().registerEvents(new ClickHandler(), this);
	}
	
}
