package IV.Paradoxal.Zalera.Panel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import IV.Paradoxal.Utils.Message_Control;

public class Panel implements CommandExecutor {

	Message_Control msg_crtl = new Message_Control();
	
	private Map<String,Long> cooldowwns = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		Server server = Bukkit.getServer();
		File Ulima_File = new File("Paradoxal"+File.separator+"Ultima"+File.separator+"config.yml");
		FileConfiguration config_ultima = YamlConfiguration.loadConfiguration(Ulima_File);
		
		String stat = "Panel";
		
		int Status_Ulltima = config_ultima.getInt("Ultima.status");
		if(arg0 instanceof Player) {
			Player player = (Player)arg0;
			if(arg1.getName().contentEquals("panel")) {
				if(player.hasPermission("iv.panel.use"))
				{
					if(Status_Ulltima==1) {
						if(cooldowwns.containsKey(player.getName()))
						{
							int seconds = 10;
							long timeleft = ((cooldowwns.get(player.getName())/1000)+seconds)-(System.currentTimeMillis()/1000);
							if(timeleft>0)
							{
								msg_crtl.send_player_error(player, "Vous devez attendre "+timeleft+" s pour réutiliser la commandes");
								return true;
							}
						}
						cooldowwns.put(player.getName(),System.currentTimeMillis());
						
						Inventory panel = server.createInventory(player,45, stat);
					}
					else
					{
						msg_crtl.send_player_error(player, "Commande imposible Ultima et désactiver");
					}
				}
				else
				{
					
				}
			}
			
		}
		return true;
	}

}
