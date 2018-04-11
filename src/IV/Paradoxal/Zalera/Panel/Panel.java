package IV.Paradoxal.Zalera.Panel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import IV.Paradoxal.Utils.Message_Control;
import net.minecraft.server.v1_12_R1.DataWatcher.Item;
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
							}
						}
						cooldowwns.put(player.getName(),System.currentTimeMillis());
						
						Inventory panel = server.createInventory(player,45, stat);
						
						ItemStack border = new ItemStack(Material.STAINED_GLASS_PANE,1,(byte) 15);
						
						for(int i = 0; i <panel.getContents().length; i++) {
							if((i>=0 && i <= 8) || (i >=36 && i <=44) || (i % 9 ==0) || ((i-8) % 9 ==0)) {
								panel.setItem(i, border);
							}
						}
						
						//block Help 
						ItemStack help = new ItemStack(Material.BOOK);
						ItemMeta Material_help = help.getItemMeta();
						ArrayList<String> Lore_help = new ArrayList<String>();
						Lore_help.add("§2Accéder aux menu");
						Lore_help.add("§2d'aide");
						Material_help.setLore(Lore_help);
						Material_help.setDisplayName("§5§lMenu d'aide");
						help.setItemMeta(Material_help);
						panel.setItem(10,help);
						
						//block player
						ItemStack playerP = new ItemStack(Material.SKULL_ITEM,1,(short) 3);
						ItemMeta Material_playerP = playerP.getItemMeta();
						ArrayList<String> Lore_playerP = new ArrayList<String>();
						Lore_playerP.add("§2Accéder à votre");
						Lore_playerP.add("§2Profils");
						Material_playerP.setLore(Lore_playerP);
						Material_playerP.setDisplayName("§5§lProfils");
						playerP.setItemMeta(Material_playerP);
						panel.setItem(12, playerP);
						
						//block world 
						ItemStack world = new ItemStack(Material.WOOL,1,(byte)15);
						ItemMeta Material_World = world.getItemMeta();
						ArrayList<String> Lore_world = new ArrayList<String>();
						Lore_world.add("§2Accéder aux menu");
						Lore_world.add("§2des mondes");
						Material_World.setLore(Lore_world);
						Material_World.setDisplayName("§5§lMenu des mondes");
						world.setItemMeta(Material_World);
						panel.setItem(14, world);
						
						//block Effect
						ItemStack effect = new ItemStack(Material.POTION);
						ItemMeta Material_Effect = effect.getItemMeta();
						ArrayList<String> Lore_Effect = new ArrayList<String>();
						Lore_Effect.add("§2Accéder aux menu");
						Lore_Effect.add("§2des effect ");
						Material_Effect.setLore(Lore_Effect);
						Material_Effect.setDisplayName("§5§1Menu des effects");
						effect.setItemMeta(Material_Effect);
						panel.setItem(16, effect);
					}
					else
					{
						msg_crtl.send_player_error(player, "Commande imposible Ultima et désactiver");
						return false;
					}
				}
				else
				{
					msg_crtl.send_player_error(player, "Vous avez pas les permisison");
					return false;
					
				}
			}
			
		}
		else
		{
			msg_crtl.send_console_error("Cette commande doit être utiliser que par des joueur", "Zalera");
			return false;
		}
		return true;
	}
}
