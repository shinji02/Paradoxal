package IV.Paradoxal.Zalera;


import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import IV.Paradoxal.Utils.Message_Control;

public class Death implements Listener {

	Message_Control msg_crl = new Message_Control();
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event ) {
		Entity player = event.getEntity();
		if(player instanceof Zombie)
		{
			msg_crl.msg_death(player.getName(), "Zombie");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof Skeleton)
		{
			msg_crl.msg_death(player.getName(), "Squelette");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof Creeper)
		{
			msg_crl.msg_death(player.getName(), "Creeper");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof Spider)
		{
			msg_crl.msg_death(player.getName(), "Araignée");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof Enderman)
		{
			msg_crl.msg_death(player.getName(), "Enderman");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof CaveSpider)
		{
			msg_crl.msg_death(player.getName(), "Araignée venimeuse");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof EnderDragon) {
			msg_crl.msg_death(player.getName(), "l'EnderDragon");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof Ghast) {
			msg_crl.msg_death(player.getName(), "Ghast");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof Golem) {
			msg_crl.msg_death(player.getName(), "Golem");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
			
		}
		if(player instanceof Guardian) {
			msg_crl.msg_death(player.getName(), "Guardian");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof PigZombie) {
			msg_crl.msg_death(player.getName(), "Cochons-zombies");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof Shulker) {
			msg_crl.msg_death(player.getName(), "Shulker");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof Silverfish) {
			msg_crl.msg_death(player.getName(), "Silverfish");
			File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
			FileConfiguration config_file= YamlConfiguration.loadConfiguration(file_player);
			int last_death = config_file.getInt("Player.Stats.death");
			int new_death = last_death+1;
			
			config_file.set("Player.Stats.death", new_death);
			
			try {
				config_file.save(file_player);
			}catch (IOException e) {
				msg_crl.send_console_error(e.getMessage(), "Zalera");
			}
		}
		if(player instanceof Slime) {
			
		}
		if(player instanceof Wither) {
			
		}
		if(player instanceof WitherSkeleton) {
			
		}
		if(player instanceof Player) {
			
		}
	}
}
