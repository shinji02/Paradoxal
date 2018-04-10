package IV.Paradoxal.Zalera;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import IV.Paradoxal.Utils.Message_Control;

public class Connect implements Listener {
	Message_Control msg_crl = new Message_Control();
	
	public void onjoin(PlayerJoinEvent event) {
		File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+event.getPlayer().getName()+".yml");
		FileConfiguration config_file = null;
		
		if(!file_player.exists())
		{
			msg_crl.send_console_error("Le fichier de "+event.getPlayer().getName()+"n'a pas été trouver","Zalera");
			msg_crl.send_console_debug("Création du fichier de "+file_player.getAbsolutePath(),"Zalera");
			try {
				file_player.createNewFile();
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
			config_file = YamlConfiguration.loadConfiguration(file_player);
			
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			int hours = LocalDateTime.now().getHour();
			int minute = LocalDateTime.now().getMinute();
			
			config_file.set("Player.Name",event.getPlayer().getName());
			config_file.set("Player.ID",event.getPlayer().getUniqueId());
			config_file.set("Player.Stats.death", 0);
			config_file.set("Player.Stats.kill", 0);
			config_file.set("Player.Time.Date",date);
			config_file.set("Player.Time.Hours", hours);
			config_file.set("Player.Time.Minute", minute);
			config_file.set("Player.Cord.World", event.getPlayer().getWorld());
			config_file.set("Player.Cord.x", event.getPlayer().getLocation().getBlockX());
			config_file.set("Player.Cord.Y", event.getPlayer().getLocation().getBlockY());
			config_file.set("Player.Cord.Z", event.getPlayer().getLocation().getBlockZ());
			config_file.set("Player.Block.Diamond_Ore",0);
			config_file.set("Player.Block.Emerload_ore", 0);
			config_file.set("Player.Block.Redstone_ore", 0);
			config_file.set("Player.Block.Lapis_ore", 0);
			config_file.set("Player.Block.Golden_ore", 0);
			config_file.set("Player.Block.Iron_Ore", 0);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
			
			msg_crl.msg_connect_first(event.getPlayer());
		}
		else
		{
			File file_zalera = new File("Paradoxal"+File.separator+"Zalera"+File.separator+"config.yml");
			FileConfiguration config_zalera= YamlConfiguration.loadConfiguration(file_zalera);
			
			if(config_zalera.getInt("Zalera.main.debug")==1) {
				msg_crl.send_console_debug("Lecture du fichier de "+event.getPlayer().getName(),"Zalera");
			}
			String date_de_last_connect = config_zalera.getString("Player.Time.Date");
			int hours_last_connect = config_zalera.getInt("Player.Time.Hours");
			int minute_last_connect = config_zalera.getInt("Player.Time.Minute");
			String time_last = hours_last_connect + " h "+minute_last_connect;
			
			msg_crl.msg_connect(event.getPlayer(), date_de_last_connect, time_last);
		}
	}
}
