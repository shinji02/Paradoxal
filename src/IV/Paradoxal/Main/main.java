package IV.Paradoxal.Main;

import org.bukkit.plugin.java.JavaPlugin;

import IV.Paradoxal.Exodus.Exodus;

public class main extends JavaPlugin{
	
	Exodus exodus = null;
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {

	}
	
	private void Start_Exodus() {
		exodus = new Exodus();
	}
	
}
