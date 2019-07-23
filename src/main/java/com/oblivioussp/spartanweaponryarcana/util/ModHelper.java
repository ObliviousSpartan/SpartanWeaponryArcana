package com.oblivioussp.spartanweaponryarcana.util;

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

import java.util.ArrayList;
import java.util.List;

import com.oblivioussp.spartanweaponryarcana.init.ItemRegistrySWA;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import thaumcraft.api.ThaumcraftApi;

public class ModHelper
{
	// External Mods
	public static final String MOD_ID_BOTANIA = "botania";
	public static final String MOD_ID_THAUMCRAFT = "thaumcraft";
	//public static final String MOD_ID_EMBERS = "embers";

	protected static boolean loadedBotania = false;
	protected static boolean loadedRF = false;
	protected static boolean loadedThaumcraft = false;
	//protected static boolean loadedEmbers = false;
	
	public static void preInit()
	{
		final ResourceLocation thaumiumWeaponsRecipe = new ResourceLocation(Reference.ModID, "thaumium_weaponry");
		final ResourceLocation voidWeaponsRecipe = new ResourceLocation(Reference.ModID, "void_weaponry");
		List<ResourceLocation> thaumiumRecipes = new ArrayList<ResourceLocation>();
		List<ResourceLocation> voidRecipes = new ArrayList<ResourceLocation>();
		
		loadedBotania = Loader.isModLoaded(MOD_ID_BOTANIA);
		loadedThaumcraft = Loader.isModLoaded(MOD_ID_THAUMCRAFT);
		//loadedEmbers = Loader.isModLoaded(MOD_ID_EMBERS);
		
		if(loadedThaumcraft)
		{
			ThaumcraftApi.registerResearchLocation(new ResourceLocation(Reference.ModID, "research/sw_arcana"));
			
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "dagger_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "longsword_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "katana_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "saber_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "rapier_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "greatsword_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "hammer_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "warhammer_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "spear_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "halberd_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "pike_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "lance_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "longbow_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "crossbow_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "throwing_knife_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "throwing_axe_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "javelin_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "boomerang_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "battleaxe_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "mace_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "glaive_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(Reference.ModID, "quarterstaff_thaumium"));

			voidRecipes.add(new ResourceLocation(Reference.ModID, "dagger_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "longsword_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "katana_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "saber_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "rapier_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "greatsword_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "hammer_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "warhammer_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "spear_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "halberd_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "pike_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "lance_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "longbow_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "crossbow_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "throwing_knife_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "throwing_axe_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "javelin_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "boomerang_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "battleaxe_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "mace_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "glaive_voidmetal"));
			voidRecipes.add(new ResourceLocation(Reference.ModID, "quarterstaff_voidmetal"));
			
			ThaumcraftApi.addFakeCraftingRecipe(thaumiumWeaponsRecipe, thaumiumRecipes);
			ThaumcraftApi.addFakeCraftingRecipe(voidWeaponsRecipe, voidRecipes);
		}
	}
	
	public static boolean isBotaniaLoaded()
	{
		return loadedBotania;
	}
	
	public static boolean isThaumcraftLoaded()
	{
		return loadedThaumcraft;
	}
	
	public static ItemStack getTerrasteelStack()
	{
		Item icon = ItemRegistrySWA.material;
		if(ItemRegistrySWA.longswordTerrasteel != null) 			icon = ItemRegistrySWA.longswordTerrasteel;
		else if(ItemRegistrySWA.greatswordTerrasteel != null)		icon = ItemRegistrySWA.greatswordTerrasteel;
		else if(ItemRegistrySWA.daggerTerrasteel != null)			icon = ItemRegistrySWA.daggerTerrasteel;
		else if(ItemRegistrySWA.katanaTerrasteel != null)			icon = ItemRegistrySWA.katanaTerrasteel;
		else if(ItemRegistrySWA.saberTerrasteel != null)			icon = ItemRegistrySWA.saberTerrasteel;
		else if(ItemRegistrySWA.rapierTerrasteel != null)			icon = ItemRegistrySWA.rapierTerrasteel;
		else if(ItemRegistrySWA.hammerTerrasteel != null)			icon = ItemRegistrySWA.hammerTerrasteel;
		else if(ItemRegistrySWA.warhammerTerrasteel != null)		icon = ItemRegistrySWA.warhammerTerrasteel;
		else if(ItemRegistrySWA.spearTerrasteel != null)			icon = ItemRegistrySWA.spearTerrasteel;
		else if(ItemRegistrySWA.halberdTerrasteel != null)			icon = ItemRegistrySWA.halberdTerrasteel;
		else if(ItemRegistrySWA.pikeTerrasteel != null)				icon = ItemRegistrySWA.pikeTerrasteel;
		else if(ItemRegistrySWA.lanceTerrasteel != null)			icon = ItemRegistrySWA.lanceTerrasteel;
		else if(ItemRegistrySWA.longbowTerrasteel != null)			icon = ItemRegistrySWA.longbowTerrasteel;
		else if(ItemRegistrySWA.crossbowTerrasteel != null)			icon = ItemRegistrySWA.crossbowTerrasteel;
		else if(ItemRegistrySWA.throwingKnifeTerrasteel != null)	icon = ItemRegistrySWA.throwingKnifeTerrasteel;
		else if(ItemRegistrySWA.throwingAxeTerrasteel != null)		icon = ItemRegistrySWA.throwingAxeTerrasteel;
		else if(ItemRegistrySWA.javelinTerrasteel != null)			icon = ItemRegistrySWA.javelinTerrasteel;
		else if(ItemRegistrySWA.boomerangTerrasteel != null)		icon = ItemRegistrySWA.boomerangTerrasteel;
		else if(ItemRegistrySWA.battleaxeTerrasteel != null)		icon = ItemRegistrySWA.battleaxeTerrasteel;
		else if(ItemRegistrySWA.maceTerrasteel != null)				icon = ItemRegistrySWA.maceTerrasteel;
		else if(ItemRegistrySWA.glaiveTerrasteel != null)			icon = ItemRegistrySWA.glaiveTerrasteel;
		else if(ItemRegistrySWA.staffTerrasteel != null)			icon = ItemRegistrySWA.staffTerrasteel;
		
		return new ItemStack(icon);
	}
	
	public static ItemStack getManasteelStack()
	{
		Item icon = ItemRegistrySWA.material;
		if(ItemRegistrySWA.longswordManasteel != null) 			icon = ItemRegistrySWA.longswordManasteel;
		else if(ItemRegistrySWA.greatswordManasteel != null)		icon = ItemRegistrySWA.greatswordManasteel;
		else if(ItemRegistrySWA.daggerManasteel != null)			icon = ItemRegistrySWA.daggerManasteel;
		else if(ItemRegistrySWA.katanaManasteel != null)			icon = ItemRegistrySWA.katanaManasteel;
		else if(ItemRegistrySWA.saberManasteel != null)			icon = ItemRegistrySWA.saberManasteel;
		else if(ItemRegistrySWA.rapierManasteel != null)			icon = ItemRegistrySWA.rapierManasteel;
		else if(ItemRegistrySWA.hammerManasteel != null)			icon = ItemRegistrySWA.hammerManasteel;
		else if(ItemRegistrySWA.warhammerManasteel != null)		icon = ItemRegistrySWA.warhammerManasteel;
		else if(ItemRegistrySWA.spearManasteel != null)			icon = ItemRegistrySWA.spearManasteel;
		else if(ItemRegistrySWA.halberdManasteel != null)			icon = ItemRegistrySWA.halberdManasteel;
		else if(ItemRegistrySWA.pikeManasteel != null)				icon = ItemRegistrySWA.pikeManasteel;
		else if(ItemRegistrySWA.lanceManasteel != null)			icon = ItemRegistrySWA.lanceManasteel;
		else if(ItemRegistrySWA.longbowManasteel != null)			icon = ItemRegistrySWA.longbowManasteel;
		else if(ItemRegistrySWA.crossbowManasteel != null)			icon = ItemRegistrySWA.crossbowManasteel;
		else if(ItemRegistrySWA.throwingKnifeManasteel != null)	icon = ItemRegistrySWA.throwingKnifeManasteel;
		else if(ItemRegistrySWA.throwingAxeManasteel != null)		icon = ItemRegistrySWA.throwingAxeManasteel;
		else if(ItemRegistrySWA.javelinManasteel != null)			icon = ItemRegistrySWA.javelinManasteel;
		else if(ItemRegistrySWA.boomerangManasteel != null)		icon = ItemRegistrySWA.boomerangManasteel;
		else if(ItemRegistrySWA.battleaxeManasteel != null)		icon = ItemRegistrySWA.battleaxeManasteel;
		else if(ItemRegistrySWA.maceManasteel != null)				icon = ItemRegistrySWA.maceManasteel;
		else if(ItemRegistrySWA.glaiveManasteel != null)			icon = ItemRegistrySWA.glaiveManasteel;
		else if(ItemRegistrySWA.staffManasteel != null)			icon = ItemRegistrySWA.staffManasteel;
		
		return new ItemStack(icon);
	}
	
	public static ItemStack getElementiumStack()
	{
		Item icon = ItemRegistrySWA.material;
		if(ItemRegistrySWA.longswordElementium != null) 			icon = ItemRegistrySWA.longswordElementium;
		else if(ItemRegistrySWA.greatswordElementium != null)		icon = ItemRegistrySWA.greatswordElementium;
		else if(ItemRegistrySWA.daggerElementium != null)			icon = ItemRegistrySWA.daggerElementium;
		else if(ItemRegistrySWA.katanaElementium != null)			icon = ItemRegistrySWA.katanaElementium;
		else if(ItemRegistrySWA.saberElementium != null)			icon = ItemRegistrySWA.saberElementium;
		else if(ItemRegistrySWA.rapierElementium != null)			icon = ItemRegistrySWA.rapierElementium;
		else if(ItemRegistrySWA.hammerElementium != null)			icon = ItemRegistrySWA.hammerElementium;
		else if(ItemRegistrySWA.warhammerElementium != null)		icon = ItemRegistrySWA.warhammerElementium;
		else if(ItemRegistrySWA.spearElementium != null)			icon = ItemRegistrySWA.spearElementium;
		else if(ItemRegistrySWA.halberdElementium != null)			icon = ItemRegistrySWA.halberdElementium;
		else if(ItemRegistrySWA.pikeElementium != null)				icon = ItemRegistrySWA.pikeElementium;
		else if(ItemRegistrySWA.lanceElementium != null)			icon = ItemRegistrySWA.lanceElementium;
		else if(ItemRegistrySWA.longbowElementium != null)			icon = ItemRegistrySWA.longbowElementium;
		else if(ItemRegistrySWA.crossbowElementium != null)			icon = ItemRegistrySWA.crossbowElementium;
		else if(ItemRegistrySWA.throwingKnifeElementium != null)	icon = ItemRegistrySWA.throwingKnifeElementium;
		else if(ItemRegistrySWA.throwingAxeElementium != null)		icon = ItemRegistrySWA.throwingAxeElementium;
		else if(ItemRegistrySWA.javelinElementium != null)			icon = ItemRegistrySWA.javelinElementium;
		else if(ItemRegistrySWA.boomerangElementium != null)		icon = ItemRegistrySWA.boomerangElementium;
		else if(ItemRegistrySWA.battleaxeElementium != null)		icon = ItemRegistrySWA.battleaxeElementium;
		else if(ItemRegistrySWA.maceElementium != null)				icon = ItemRegistrySWA.maceElementium;
		else if(ItemRegistrySWA.glaiveElementium != null)			icon = ItemRegistrySWA.glaiveElementium;
		else if(ItemRegistrySWA.staffElementium != null)			icon = ItemRegistrySWA.staffElementium;
		
		return new ItemStack(icon);
	}
	
	/*public static boolean isEmbersLoaded()
	{
		return loadedEmbers;
	}*/
}
