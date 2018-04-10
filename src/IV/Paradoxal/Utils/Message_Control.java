package IV.Paradoxal.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Message_Control {
	
	public Message_Control() {
		
	}
	
	ConsoleCommandSender console_send = Bukkit.getConsoleSender();
	
	public void send_console_error(String msg,String IA) {
		console_send.sendMessage(ChatColor.GOLD+"["+IA+"] "+ChatColor.RED+"[Error] "+msg+ChatColor.RESET);
	}
	
	public void send_console_debug(String msg,String IA) {
		console_send.sendMessage(ChatColor.GOLD+"["+IA+"] "+ChatColor.AQUA+"[Debug] "+msg+ChatColor.RESET);
	}
	
	public void send_console_succes(String msg,String IA) {
		console_send.sendMessage(ChatColor.GOLD+"["+IA+"] "+ChatColor.GREEN+"[Sucess] "+msg+ChatColor.RESET);
	}
	
	public void send_player_error(Player player,String msg) {
		player.sendMessage(ChatColor.GOLD+"[Zalera] "+ChatColor.RED+msg+ChatColor.RESET);
	}
	
	public void send_player_debug(Player player,String msg) {
		player.sendMessage(ChatColor.GOLD+"[Zalera] "+ChatColor.AQUA+msg+ChatColor.RESET);
	}
	
	public void send_player_success(Player player, String msg) {
		player.sendMessage(ChatColor.GOLD+"[Zalera] "+ChatColor.GREEN+msg+ChatColor.RESET);	
	}
	
	public void send_player_message(Player player, String msg) {
		player.sendMessage(ChatColor.GOLD+"[Zalera] "+msg+ChatColor.RESET);
	}
	
	public void console_init(String msg) {
		console_send.sendMessage(ChatColor.LIGHT_PURPLE+"[Init] "+ChatColor.AQUA+msg+ChatColor.RESET);
	}
	
	public void console_load(String msg) {
		console_send.sendMessage(ChatColor.LIGHT_PURPLE+"[Load] "+ChatColor.AQUA+msg+ChatColor.RESET);
	}
}
