package com.oblivioussp.spartanweaponryarcana;

/**
 * Copyright (C) 2019  ObliviousSpartan
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses.
*/

import com.oblivioussp.spartanweaponryarcana.network.NetworkHandler;
import com.oblivioussp.spartanweaponryarcana.proxy.CommonProxy;
import com.oblivioussp.spartanweaponryarcana.util.LexiconEntries;
import com.oblivioussp.spartanweaponryarcana.util.LogHelper;
import com.oblivioussp.spartanweaponryarcana.util.ModHelper;
import com.oblivioussp.spartanweaponryarcana.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thaumcraft.api.ThaumcraftApi;

@Mod(modid = Reference.ModID, name = Reference.ModName, version = Reference.ModVersion, dependencies = Reference.ModDependencies, acceptedMinecraftVersions = Reference.McVersion/*, guiFactory = Reference.GuiFactoryClass*/)
public class ModSpartanWeaponryArcana
{

	@Instance(Reference.ModID)
	public static ModSpartanWeaponryArcana instance;
	
	//public static JsonFile jsonConfig = new JsonFile();
	
	@SidedProxy(clientSide = Reference.ProxyClientClass, serverSide = Reference.ProxyServerClass)
	public static CommonProxy proxy;
	
	//@SuppressWarnings("unused")
	@EventHandler
	public static void preInit(FMLPreInitializationEvent ev)
	{
		/* Register the following here:
		 * - Config File
		 * - Event Bus registration
		 * - Keybindings
		 * - Network Handling
		 * - Block & Item Registration
		 */
		
		LogHelper.info("Starting up Spartan Weaponry Arcana!");
		
		// Register modded materials first
		//ItemRegistrySW.registerModdedMaterials();
		
		//JsonRecipeGenerator.generateRecipes();
		
		// Initialise Config
		//ConfigHandler.init(ev.getSuggestedConfigurationFile());
		//MinecraftForge.EVENT_BUS.register(new ConfigHandler());
		
		// Initialise other events
		
		//if(ConfigHandler.enableModdedMaterialWeapons)
		//	CreativeTabsSW.preInit();
		
		//ItemRegistrySW.registerItems();
		
		ModHelper.preInit();

		proxy.preInit(ev);
		LogHelper.debug("Finished preInit phase!");
	}
	
	//@SuppressWarnings("unused")
	@EventHandler
	public static void init(FMLInitializationEvent ev)
	{
		/* Register the following here:
		 * - Entities
		 * - Recipes
		 * Initialise Network handlers
		 */
		//EntityRegistrySW.registerEntities();
		//RecipeRegistry.addRecipes();
		NetworkHandler.init();
		//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		
		// Attempt to add custom advancement triggers.
		//AdvancementTrigger.registerTriggers();

		proxy.init(ev);
		LogHelper.debug("Finished init phase!");
	}
	
	//@SuppressWarnings("unused")
	@EventHandler
	public static void postInit(FMLPostInitializationEvent ev)
	{
		/* Register the following here:
		 * - Anything that requires other mods to be initialised first.
		 */
		if(ModHelper.isBotaniaLoaded())
			LexiconEntries.postInit();

		proxy.postInit(ev);
		LogHelper.debug("Finished postInit phase!");
	}
}
