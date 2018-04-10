package IV.Paradoxal.Main;

import org.bukkit.plugin.java.JavaPlugin;

import IV.Paradoxal.Chaos.Chaos;
import IV.Paradoxal.Exodus.Exodus;
import IV.Paradoxal.Ultima.Ultima;
import IV.Paradoxal.Zalera.Zalera;

public class main extends JavaPlugin{
	
	Exodus exodus = null;
	Zalera zalera = null;
	Chaos chaos = null;
	Ultima ultima = null;
	
	@Override
	public void onEnable() {
		Start_Zalera();
	}
	
	@Override
	public void onDisable() {

	}
	
	private void Start_Exodus() {
		exodus = new Exodus();
	}
	
	private void Start_Zalera() {
		zalera = new Zalera(this);
		zalera.Start_IA();
	}
	
	private void Start_Chaos() {
		chaos = new Chaos();
	}
	
	private void Start_Ultima() {
		ultima = new Ultima();
	}
	
}
