package IV.Paradoxal.Main;

import org.bukkit.plugin.java.JavaPlugin;

import IV.Paradoxal.Exodus.Exodus;
import IV.Paradoxal.Zalera.Zalera;

public class main extends JavaPlugin{
	
	Exodus exodus = null;
	Zalera zalera = null;
	
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {

	}
	
	private void Start_Exodus() {
		exodus = new Exodus();
	}
	
	private void Start_Zalera() {
		zalera = new Zalera();
	}
	
}
