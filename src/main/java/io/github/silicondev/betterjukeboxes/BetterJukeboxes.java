package io.github.silicondev.betterjukeboxes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.silicondev.siliconmccli.*;

public class BetterJukeboxes extends JavaPlugin {
	
	public static String pluginName = "Better Jukeboxes";
	public static boolean debugMode = false;
	public static String version = "Alpha 0.0.1";
	public static YamlConfiguration langConfig;
	private static File langFile;
	
	static List<Cmd> commands = new ArrayList<Cmd>();
	static List<Run> runnables = new ArrayList<Run>();
	
	@Override
	public void onEnable() {
		getLogger().info("Startup Initialized!");
		
		//getServer().getPluginManager().registerEvents(new EventManager(), this);
		
		int errNum = 0;
		try {
			
			//command, required params, optional params, player only, has children, has parent, id, perm node, description.
			commands.add(new Cmd("betterjuke", 0, -1, false, true, false, 0, "default", " | Base command for " + pluginName));
			
			this.getCommand("betterjuke").setExecutor(new CmdExec(commands, runnables));
			
		} catch(NullPointerException e) {
			errNum++;
			getLogger().info("Error loading commands!");
		}
		
		//helpPage = new Help(commands);
		
		//errNum += load();
		//loadLang();
		
		getLogger().info("Initialization complete with " + Integer.toString(errNum) + " errors.");
	}
	
	@Override
	public void onDisable() {
		
	}
}
