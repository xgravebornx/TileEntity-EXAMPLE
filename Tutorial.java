package mods.tutorial.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "Tutorial", name = "Tutorial", version = "Alpha 0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Tutorial {
  public static Block grave1 = new Grave1Block(1000, Material.wood).setUnlocalizedName("tutorial:graveone").setCreativeTab(CreativeTabs.tabBlock);
	
	
	
	@Init
	public void load(FMLInitializationEvent event){
		
		
			
		
		
		
	    GameRegistry.registerBlock(grave1, "Grave one");
	    
	    LanguageRegistry.addName(grave1, "Grave one");
	     
	   
	   ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrave1.class, new RenderGrave1());
	   			 
	   
	   
	}
	
	}
	
	
	
	
	
	
	
