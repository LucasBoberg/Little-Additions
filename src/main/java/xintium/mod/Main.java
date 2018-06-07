package xintium.mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xintium.mod.proxy.CommonProxy;
import xintium.mod.tabs.LittleAdditionsTab;
import xintium.mod.util.Reference;
import xintium.mod.util.handlers.RegistryHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	public static final CreativeTabs LITTLEADDITIONSTAB = new LittleAdditionsTab("littleadditionstab");
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInitRegistries();
	}
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		RegistryHandler.initRegistries();
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {}
}
