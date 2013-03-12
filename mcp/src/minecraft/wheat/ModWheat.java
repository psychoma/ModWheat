package wheat;

import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "mod_wheat", name = "ModWheat", version = "0.0.1")

public class ModWheat {

	public static Block blockwheat;
	
	@PreInit
	public void preinit(FMLPreInitializationEvent evt){
			
	}
	
	@Init
	public void init(FMLInitializationEvent evt){
		
	}
	
	@PostInit
	public void postinit(FMLPostInitializationEvent evt){

	}
	
	@Instance
	public static ModWheat instance;
}
