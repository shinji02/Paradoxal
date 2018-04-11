package IV.Paradoxal.Zalera.Panel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import IV.Paradoxal.Utils.Message_Control;

public class Panel implements CommandExecutor {

	Message_Control msg_crtl = new Message_Control();
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg0 instanceof Player) {
			Player player = (Player)arg0;
			if(arg1.getName().contentEquals("panel")) {
				if(player.hasPermission("iv.panel.use"))
				{
					
				}
				else
				{
					
				}
			}
			
		}
		return true;
	}

}
