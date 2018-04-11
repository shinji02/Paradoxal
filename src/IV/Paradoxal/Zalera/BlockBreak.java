package IV.Paradoxal.Zalera;

import java.io.File;
import java.io.IOException;

import javax.swing.text.StyleContext.SmallAttributeSet;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import IV.Paradoxal.Utils.Message_Control;

public class BlockBreak implements Listener {

	Message_Control msg_crtl = new Message_Control();
	
	@EventHandler
	public void onbreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block_break = event.getBlock();
		
		File file_player = new File("Paradoxal"+File.separator+"Players"+File.separator+player.getName()+".yml");
		FileConfiguration config_player = YamlConfiguration.loadConfiguration(file_player);
		
		if(block_break.getType()==Material.IRON_ORE) {
			int last_iron_ore_break = config_player.getInt("Player.Block.Iron_Ore");
			int new_iron_break = last_iron_ore_break+1;
			
			config_player.set("Player.Block.Iron_Ore",new_iron_break );
			//XP +1
			
			try {
				config_player.save(file_player);
			}catch (IOException e) {
				msg_crtl.send_console_error(e.getMessage(),"Zalera");
			}
			
		}
		if(block_break.getType()==Material.GOLD_ORE) {
			int last_gold_ore = config_player.getInt("Player.Block.Golden_ore");
			int new_gold_ore = last_gold_ore+1;
			
			config_player.set("Player.Block.Golden_ore", new_gold_ore);
			
			try {
				config_player.save(file_player);
			} catch (IOException e) {
				msg_crtl.send_console_error(e.getMessage(),"Zalera");
			}
		}
		if(block_break.getType()==Material.LAPIS_ORE) {
			
		}
		if(block_break.getType()==Material.REDSTONE_ORE) {
			
		}
		if(block_break.getType()==Material.EMERALD_ORE) {
			
		}
		if(block_break.getType()==Material.DIAMOND_ORE) {
			
		}
	}
}
