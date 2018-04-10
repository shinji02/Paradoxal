package IV.Paradoxal.Zalera;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import IV.Paradoxal.Utils.Message_Control;

public class Disconnect implements Listener {

	Message_Control msg_crtl = new Message_Control();
	
	public void onQuit(PlayerQuitEvent event) {
		File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+event.getPlayer().getName()+".yml");
		FileConfiguration config_file = null;
		config_file = YamlConfiguration.loadConfiguration(file_player);
		
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		int hours = LocalDateTime.now().getHour();
		int minute = LocalDateTime.now().getMinute();
		
		config_file.set("Player.Time.Date",date);
		config_file.set("Player.Time.Hours", hours);
		config_file.set("Player.Time.Minute", minute);
		
		try {
			config_file.save(file_player);
		}catch (IOException e) {
			msg_crtl.send_console_error(e.getMessage(), "Zalera");
		}
		msg_crtl.msg_deconnect(event.getPlayer());
		
	}
}
