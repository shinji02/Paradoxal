package IV.Paradoxal.Zalera;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import IV.Paradoxal.Main.main;
import IV.Paradoxal.Utils.Message_Control;
import IV.Paradoxal.Zalera.Panel.Panel;
import IV.Paradoxal.Zalera.Panel.Panel_Listener;
import IV.Paradoxal.Zalera.Panel.chaos.Panel_Chaos_Listner;
import IV.Paradoxal.Zalera.Panel.chaos.chaos;

public class Zalera {
	
	main main2;
	Message_Control msg_ctrl = new Message_Control();
	int debug = 0;
	
	public Zalera(main main) {
		this.main2 = main;
	}
	
	private int create_config() {
		msg_ctrl.console_init("Configuration de Zalera en cours");
		File file_zalera = new File("Paradoxal"+File.separator+"Zalera"+File.separator+"config.yml");
		FileConfiguration config_Zalera = null;
		
		if(!file_zalera.exists())
		{
			try {
				file_zalera.createNewFile();
			}catch (IOException e) {
				msg_ctrl.send_console_error(e.getMessage(),"Zalera");
			}
			
			config_Zalera = YamlConfiguration.loadConfiguration(file_zalera);
			
			config_Zalera.set("Zalera.main.Status", 0);
			config_Zalera.set("Zalera.main.version","V1.0");
			config_Zalera.set("Zalera.main.debug",0);
			
			try {
				config_Zalera.save(file_zalera);
			}catch (IOException e) {
				msg_ctrl.send_console_error(e.getMessage(),"Zalera");
			}
		}
		msg_ctrl.console_load("Configuration de Zalera terminer");
		return 1;	
	}
	
	public int Start_IA() {
		msg_ctrl.send_console_debug("Activation de Zalera","Zalera");
		File file_zalera = new File("Paradoxal"+File.separator+"Zalera"+File.separator+"config.yml");
		FileConfiguration config_zalera= YamlConfiguration.loadConfiguration(file_zalera);
		
		if(config_zalera.getInt("Zalera.main.debug")==1)
		{
			msg_ctrl.send_console_debug("Mode DEBUG activer", "Zalera");
			debug=1;
		}
		
		int verf =0;
		int verif2 = 0;
		int verif3 = 0;
		verf=create_config();
		
		if(verf==1)
		{
			verif2=Create_Listener();
			if(verif2==1)
			{
				verif3=Create_Command();
				if(verif3==2)
				{
					config_zalera.set("Zalera.main.Status", 1);
					msg_ctrl.send_console_succes("Activation complétér ", "Zalera");
					return 1;
				}
				else
				{
					msg_ctrl.send_console_error("Une erreur c'est produit dans la création des commandes de Zalera", "Zalera");
					return 0;
				}
			}
			else
			{
				msg_ctrl.send_console_error("Une erreur c'est produit dans la création des listener de Zelara", "Zalera");
				return 0;
			}
		}
		else
		{
			msg_ctrl.send_console_error("Une erreur dans la configuration de Zalera", "Zalera");
			return 0;
		}
		
		
		
	}
	
	private int Create_Listener() {
		msg_ctrl.console_init("Création des listener");
		
		Bukkit.getServer().getPluginManager().registerEvents(new Connect(), main2);
		Bukkit.getServer().getPluginManager().registerEvents(new Disconnect(), main2);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockBreak(), main2);
		Bukkit.getServer().getPluginManager().registerEvents(new Death(), main2);
		msg_ctrl.console_load("Crétion des listener terminer");
		return 1;
	}
	
	private int Create_Command() {
		msg_ctrl.console_init("Création des commandes");
		msg_ctrl.send_console_debug("Création de la commande panel","Zelara");
		main2.getCommand("panel").setExecutor(new Panel());
		main2.getServer().getPluginManager().registerEvents(new Panel_Listener(), main2);
		msg_ctrl.send_console_debug("Création de la commande Chaos", "Zelera");
		main2.getCommand("chaos").setExecutor(new chaos());
		main2.getServer().getPluginManager().registerEvents(new Panel_Chaos_Listner(), main2);
		return 1;
	}
}
