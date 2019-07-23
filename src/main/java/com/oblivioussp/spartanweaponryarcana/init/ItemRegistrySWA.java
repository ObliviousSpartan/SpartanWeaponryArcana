package com.oblivioussp.spartanweaponryarcana.init;

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

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponryarcana.client.gui.CreativeTabsSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemBattleaxeSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemBoomerangSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemCrossbowSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemDaggerSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemGlaiveSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemGreatswordSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemHalberdSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemHammerSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemJavelinSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemKatanaSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemLanceSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemLongbowSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemLongswordSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemMaceSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemMultiSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemPikeSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemQuarterstaffSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemRapierSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemSaberSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemSpearSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemThrowingAxeSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemThrowingKnifeSWA;
import com.oblivioussp.spartanweaponryarcana.item.ItemWarhammerSWA;
import com.oblivioussp.spartanweaponryarcana.util.LogHelper;
import com.oblivioussp.spartanweaponryarcana.util.ModHelper;
import com.oblivioussp.spartanweaponryarcana.util.Reference;
import com.oblivioussp.spartanweaponryarcana.weaponproperty.WeaponCallbackElementium;
import com.oblivioussp.spartanweaponryarcana.weaponproperty.WeaponCallbackManaRegen;
import com.oblivioussp.spartanweaponryarcana.weaponproperty.WeaponCallbackWarped;
import com.oblivioussp.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.ThaumcraftMaterials;
import vazkii.botania.api.BotaniaAPI;

@EventBusSubscriber(modid = Reference.ModID)
public class ItemRegistrySWA 
{
	public static ToolMaterialEx materialManasteel,
								materialTerrasteel,
								materialElementium,
								materialThaumium,
								materialVoidmetal,
								materialDawnstone;
								//materialHardlight = new ToolMaterialEx("hardlight", "", Reference.ModID, 0x0, 0x0, 4, 9001, 8.0f, 5.0f, 0);
	
	public static ItemMultiSWA material = (ItemMultiSWA) new ItemMultiSWA("material", "handle_livingwood", "pole_livingwood", "handle_dreamwood", "pole_dreamwood", "crossbow_limb_dreamwood").setCreativeTab(CreativeTabsSWA.TAB_SWA);
	
	//public static ItemMultiSWA upgradeRune = (ItemMultiSWA) new ItemMultiSWA("upgrade_rune", "upgrade_rune_damage", "upgrade_rune_speed", "upgrade_rune_luck", "upgrade_rune_wither");
	
	public static Item 			daggerManasteel, daggerTerrasteel, daggerElementium, daggerThaumium, daggerVoidmetal, daggerDawnstone,
								longswordManasteel, longswordTerrasteel, longswordElementium, longswordThaumium, longswordVoidmetal, longswordDawnstone,
								katanaManasteel, katanaTerrasteel, katanaElementium, katanaThaumium, katanaVoidmetal, katanaDawnstone,
								saberManasteel, saberTerrasteel, saberElementium, saberThaumium, saberVoidmetal, saberDawnstone,
								rapierManasteel, rapierTerrasteel, rapierElementium, rapierThaumium, rapierVoidmetal, rapierDawnstone,
								greatswordManasteel, greatswordTerrasteel, greatswordElementium, greatswordThaumium, greatswordVoidmetal, greatswordDawnstone,
								hammerManasteel, hammerTerrasteel, hammerElementium, hammerThaumium, hammerVoidmetal, hammerDawnstone,
								warhammerManasteel, warhammerTerrasteel, warhammerElementium, warhammerThaumium, warhammerVoidmetal, warhammerDawnstone,
								spearManasteel, spearTerrasteel, spearElementium, spearThaumium, spearVoidmetal, spearDawnstone,
								halberdManasteel, halberdTerrasteel, halberdElementium, halberdThaumium, halberdVoidmetal, halberdDawnstone,
								pikeManasteel, pikeTerrasteel, pikeElementium, pikeThaumium, pikeVoidmetal, pikeDawnstone,
								lanceManasteel, lanceTerrasteel, lanceElementium, lanceThaumium, lanceVoidmetal, lanceDawnstone,
								longbowManasteel, longbowTerrasteel, longbowElementium, longbowThaumium, longbowVoidmetal, longbowDawnstone,
								crossbowManasteel, crossbowTerrasteel, crossbowElementium, crossbowThaumium, crossbowVoidmetal, crossbowDawnstone,
								throwingKnifeManasteel, throwingKnifeTerrasteel, throwingKnifeElementium, throwingKnifeThaumium, throwingKnifeVoidmetal, throwingKnifeDawnstone,
								throwingAxeManasteel, throwingAxeTerrasteel, throwingAxeElementium, throwingAxeThaumium, throwingAxeVoidmetal, throwingAxeDawnstone,
								javelinManasteel, javelinTerrasteel, javelinElementium, javelinThaumium, javelinVoidmetal, javelinDawnstone,
								boomerangManasteel, boomerangTerrasteel, boomerangElementium, boomerangThaumium, boomerangVoidmetal, boomerangDawnstone,
								battleaxeManasteel, battleaxeTerrasteel, battleaxeElementium, battleaxeThaumium, battleaxeVoidmetal, battleaxeDawnstone,
								maceManasteel, maceTerrasteel, maceElementium, maceThaumium, maceVoidmetal, maceDawnstone,
								glaiveManasteel, glaiveTerrasteel, glaiveElementium, glaiveThaumium, glaiveVoidmetal, glaiveDawnstone,
								staffManasteel, staffTerrasteel, staffElementium, staffThaumium, staffVoidmetal, staffDawnstone;
								
	public static ArrayList<Item> weapons = new ArrayList<Item>();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> ev)
	{
		IForgeRegistry<Item> registry = ev.getRegistry();
		
		if(ModHelper.isBotaniaLoaded())
		{
			materialManasteel = new ToolMaterialEx("manasteel", BotaniaAPI.manasteelToolMaterial, "ingotManasteel", Reference.ModID, 2.0f, WeaponPropertySWA.ManaRegenerate);
			materialTerrasteel = new ToolMaterialEx("terrasteel", BotaniaAPI.terrasteelToolMaterial, "ingotTerrasteel", Reference.ModID, 3.0f, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash);
			materialElementium = new ToolMaterialEx("elementium", BotaniaAPI.elementiumToolMaterial, "ingotElvenElementium", Reference.ModID, 2.0f, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P);
		}
		else
		{
			materialManasteel = new ToolMaterialEx("manasteel", "ingotManasteel", Reference.ModID, 0x0, 0x0, 3, 300, 6.2f, 2.0f, 20, WeaponPropertySWA.ManaRegenerate);
			materialTerrasteel = new ToolMaterialEx("terrasteel", "ingotTerrasteel", Reference.ModID, 0x0, 0x0, 4, 2300, 9.0f, 3.0f, 26, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash);
			materialElementium = new ToolMaterialEx("elementium", "ingotElvenElementium", Reference.ModID, 0x0, 0x0, 3, 720, 6.2f, 2.0f, 20, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P);
		}
		
		if(ModHelper.isThaumcraftLoaded())
		{
			materialThaumium = new ToolMaterialEx("thaumium", ThaumcraftMaterials.TOOLMAT_THAUMIUM, "ingotThaumium", Reference.ModID);
			materialVoidmetal = new ToolMaterialEx("voidmetal", ThaumcraftMaterials.TOOLMAT_VOID, "ingotVoid", Reference.ModID, 3.0f, WeaponPropertySWA.Warped);
		}
		else
		{
			materialThaumium = new ToolMaterialEx("thaumium", "ingotThaumium", Reference.ModID, 0x0, 0x0, 3, 500, 7.0f, 2.5f, 22);
			materialVoidmetal = new ToolMaterialEx("voidmetal", "ingotVoid", Reference.ModID, 0x0, 0x0, 4, 150, 8.0f, 3.0f, 10);
		}
		
		materialDawnstone = new ToolMaterialEx("dawnstone", "ingotDawnstone", Reference.ModID, 0x0, 0x0, 2, 644, 7.5f, 2.5f, 18);
			
		registry.register(material);
		//registry.register(upgradeRune);
		
		daggerManasteel = new ItemDaggerSWA("dagger_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		daggerTerrasteel = new ItemDaggerSWA("dagger_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		daggerElementium = new ItemDaggerSWA("dagger_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		daggerThaumium = SpartanWeaponryAPI.createDagger(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		daggerVoidmetal = SpartanWeaponryAPI.createDagger(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		daggerDawnstone = SpartanWeaponryAPI.createDagger(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(daggerManasteel, daggerTerrasteel, daggerElementium, daggerThaumium, daggerVoidmetal, daggerDawnstone);
	
		longswordManasteel =  new ItemLongswordSWA("longsword_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		longswordTerrasteel =  new ItemLongswordSWA("longsword_terrasteel",materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		longswordElementium = new ItemLongswordSWA("longsword_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		longswordThaumium = SpartanWeaponryAPI.createLongsword(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		longswordVoidmetal = SpartanWeaponryAPI.createLongsword(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		longswordDawnstone = SpartanWeaponryAPI.createLongsword(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(longswordManasteel, longswordTerrasteel, longswordElementium, longswordThaumium, longswordVoidmetal, longswordDawnstone);

		katanaManasteel = new ItemKatanaSWA("katana_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		katanaTerrasteel = new ItemKatanaSWA("katana_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		katanaElementium = new ItemKatanaSWA("katana_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		katanaThaumium = SpartanWeaponryAPI.createKatana(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		katanaVoidmetal = SpartanWeaponryAPI.createKatana(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		katanaDawnstone = SpartanWeaponryAPI.createKatana(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(katanaManasteel, katanaTerrasteel, katanaElementium, katanaThaumium, katanaVoidmetal, katanaDawnstone);
	
		saberManasteel = new ItemSaberSWA("saber_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		saberTerrasteel = new ItemSaberSWA("saber_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		saberElementium = new ItemSaberSWA("saber_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		saberThaumium = SpartanWeaponryAPI.createSaber(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		saberVoidmetal = SpartanWeaponryAPI.createSaber(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		saberDawnstone = SpartanWeaponryAPI.createSaber(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(saberManasteel, saberTerrasteel, saberElementium, saberThaumium, saberVoidmetal, saberDawnstone);
	
		rapierManasteel = new ItemRapierSWA("rapier_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		rapierTerrasteel = new ItemRapierSWA("rapier_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		rapierElementium = new ItemRapierSWA("rapier_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		rapierThaumium = SpartanWeaponryAPI.createRapier(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		rapierVoidmetal = SpartanWeaponryAPI.createRapier(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		rapierDawnstone = SpartanWeaponryAPI.createRapier(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(rapierManasteel, rapierTerrasteel, rapierElementium, rapierThaumium, rapierVoidmetal, rapierDawnstone);
	
		
		greatswordManasteel = new ItemGreatswordSWA("greatsword_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		greatswordTerrasteel = new ItemGreatswordSWA("greatsword_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		greatswordElementium = new ItemGreatswordSWA("greatsword_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		greatswordThaumium = SpartanWeaponryAPI.createGreatsword(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		greatswordVoidmetal = SpartanWeaponryAPI.createGreatsword(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA, WeaponPropertySWA.Warped);
		greatswordDawnstone = SpartanWeaponryAPI.createGreatsword(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(greatswordManasteel, greatswordTerrasteel, greatswordElementium, greatswordThaumium, greatswordVoidmetal, greatswordDawnstone);
		
		hammerManasteel = new ItemHammerSWA("hammer_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		hammerTerrasteel = new ItemHammerSWA("hammer_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		hammerElementium = new ItemHammerSWA("hammer_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		hammerThaumium = SpartanWeaponryAPI.createHammer(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		hammerVoidmetal = SpartanWeaponryAPI.createHammer(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		hammerDawnstone = SpartanWeaponryAPI.createHammer(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(hammerManasteel, hammerTerrasteel, hammerElementium, hammerThaumium, hammerVoidmetal, hammerDawnstone);
		
		warhammerManasteel = new ItemWarhammerSWA("warhammer_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		warhammerTerrasteel = new ItemWarhammerSWA("warhammer_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		warhammerElementium = new ItemWarhammerSWA("warhammer_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		warhammerThaumium = SpartanWeaponryAPI.createWarhammer(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		warhammerVoidmetal = SpartanWeaponryAPI.createWarhammer(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		warhammerDawnstone = SpartanWeaponryAPI.createWarhammer(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(warhammerManasteel, warhammerTerrasteel, warhammerElementium, warhammerThaumium, warhammerVoidmetal, warhammerDawnstone);
		
		spearManasteel = new ItemSpearSWA("spear_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		spearTerrasteel = new ItemSpearSWA("spear_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		spearElementium = new ItemSpearSWA("spear_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		spearThaumium = SpartanWeaponryAPI.createSpear(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		spearVoidmetal = SpartanWeaponryAPI.createSpear(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		spearDawnstone = SpartanWeaponryAPI.createSpear(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(spearManasteel, spearTerrasteel, spearElementium, spearThaumium, spearVoidmetal, spearDawnstone);
		
		halberdManasteel = new ItemHalberdSWA("halberd_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		halberdTerrasteel = new ItemHalberdSWA("halberd_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		halberdElementium = new ItemHalberdSWA("halberd_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		halberdThaumium = SpartanWeaponryAPI.createHalberd(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		halberdVoidmetal = SpartanWeaponryAPI.createHalberd(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		halberdDawnstone = SpartanWeaponryAPI.createHalberd(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(halberdManasteel, halberdTerrasteel, halberdElementium, halberdThaumium, halberdVoidmetal, halberdDawnstone);
		
		pikeManasteel = new ItemPikeSWA("pike_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		pikeTerrasteel = new ItemPikeSWA("pike_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		pikeElementium = new ItemPikeSWA("pike_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		pikeThaumium = SpartanWeaponryAPI.createPike(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		pikeVoidmetal = SpartanWeaponryAPI.createPike(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		pikeDawnstone = SpartanWeaponryAPI.createPike(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(pikeManasteel, pikeTerrasteel, pikeElementium, pikeThaumium, pikeVoidmetal, pikeDawnstone);

		lanceManasteel = new ItemLanceSWA("lance_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		lanceTerrasteel = new ItemLanceSWA("lance_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		lanceElementium = new ItemLanceSWA("lance_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		lanceThaumium = SpartanWeaponryAPI.createLance(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		lanceVoidmetal = SpartanWeaponryAPI.createLance(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		lanceDawnstone = SpartanWeaponryAPI.createLance(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(lanceManasteel, lanceTerrasteel, lanceElementium, lanceThaumium, lanceVoidmetal, lanceDawnstone);
		
		longbowManasteel = new ItemLongbowSWA("longbow_manasteel", materialManasteel, new WeaponCallbackManaRegen(60.0f));
		longbowTerrasteel = new ItemLongbowSWA("longbow_terrasteel", materialTerrasteel, new WeaponCallbackManaRegen(100.0f));
		longbowElementium = new ItemLongbowSWA("longbow_elementium", materialElementium, new WeaponCallbackElementium(60.0f));
		longbowThaumium = SpartanWeaponryAPI.createLongbow(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA, null);
		longbowVoidmetal = SpartanWeaponryAPI.createLongbow(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA, new WeaponCallbackWarped());
		longbowDawnstone = SpartanWeaponryAPI.createLongbow(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA, null);
		addWeaponsToRegister(longbowManasteel, longbowTerrasteel, longbowElementium, longbowThaumium, longbowVoidmetal, longbowDawnstone);
		
		crossbowManasteel = new ItemCrossbowSWA("crossbow_manasteel", materialManasteel, new WeaponCallbackManaRegen(60.0f));
		crossbowTerrasteel = new ItemCrossbowSWA("crossbow_terrasteel", materialTerrasteel, new WeaponCallbackManaRegen(100.0f));
		crossbowElementium = new ItemCrossbowSWA("crossbow_elementium", materialElementium, new WeaponCallbackElementium(60.0f));
		crossbowThaumium = SpartanWeaponryAPI.createCrossbow(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA, null);
		crossbowVoidmetal = SpartanWeaponryAPI.createCrossbow(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA, new WeaponCallbackWarped());
		crossbowDawnstone = SpartanWeaponryAPI.createCrossbow(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA, null);
		addWeaponsToRegister(crossbowManasteel, crossbowTerrasteel, crossbowElementium, crossbowThaumium, crossbowVoidmetal, crossbowDawnstone);
		
		throwingKnifeManasteel = new ItemThrowingKnifeSWA("throwing_knife_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		throwingKnifeTerrasteel = new ItemThrowingKnifeSWA("throwing_knife_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		throwingKnifeElementium = new ItemThrowingKnifeSWA("throwing_knife_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		throwingKnifeThaumium = SpartanWeaponryAPI.createThrowingKnife(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		throwingKnifeVoidmetal = SpartanWeaponryAPI.createThrowingKnife(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		throwingKnifeDawnstone = SpartanWeaponryAPI.createThrowingKnife(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(throwingKnifeManasteel, throwingKnifeTerrasteel, throwingKnifeElementium, throwingKnifeThaumium, throwingKnifeVoidmetal, throwingKnifeDawnstone);
		
		throwingAxeManasteel = new ItemThrowingAxeSWA("throwing_axe_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		throwingAxeTerrasteel = new ItemThrowingAxeSWA("throwing_axe_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		throwingAxeElementium = new ItemThrowingAxeSWA("throwing_axe_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		throwingAxeThaumium = SpartanWeaponryAPI.createThrowingAxe(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		throwingAxeVoidmetal = SpartanWeaponryAPI.createThrowingAxe(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		throwingAxeDawnstone = SpartanWeaponryAPI.createThrowingAxe(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(throwingAxeManasteel, throwingAxeTerrasteel, throwingAxeElementium, throwingAxeThaumium, throwingAxeVoidmetal, throwingAxeDawnstone);
		
		javelinManasteel = new ItemJavelinSWA("javelin_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		javelinTerrasteel = new ItemJavelinSWA("javelin_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		javelinElementium = new ItemJavelinSWA("javelin_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		javelinThaumium = SpartanWeaponryAPI.createJavelin(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		javelinVoidmetal = SpartanWeaponryAPI.createJavelin(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		javelinDawnstone = SpartanWeaponryAPI.createJavelin(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(javelinManasteel, javelinTerrasteel, javelinElementium, javelinThaumium, javelinVoidmetal, javelinDawnstone);
		
		boomerangManasteel = new ItemBoomerangSWA("boomerang_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		boomerangTerrasteel = new ItemBoomerangSWA("boomerang_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		boomerangElementium = new ItemBoomerangSWA("boomerang_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		boomerangThaumium = SpartanWeaponryAPI.createBoomerang(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		boomerangVoidmetal = SpartanWeaponryAPI.createBoomerang(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		boomerangDawnstone = SpartanWeaponryAPI.createBoomerang(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(boomerangManasteel, boomerangTerrasteel, boomerangElementium, boomerangThaumium, boomerangVoidmetal, boomerangDawnstone);
		
		battleaxeManasteel = new ItemBattleaxeSWA("battleaxe_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		battleaxeTerrasteel = new ItemBattleaxeSWA("battleaxe_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		battleaxeElementium = new ItemBattleaxeSWA("battleaxe_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		battleaxeThaumium = SpartanWeaponryAPI.createBattleaxe(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		battleaxeVoidmetal = SpartanWeaponryAPI.createBattleaxe(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		battleaxeDawnstone = SpartanWeaponryAPI.createBattleaxe(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(battleaxeManasteel, battleaxeTerrasteel, battleaxeElementium, battleaxeThaumium, battleaxeVoidmetal, battleaxeDawnstone);
		
		maceManasteel = new ItemMaceSWA("mace_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		maceTerrasteel = new ItemMaceSWA("mace_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		maceElementium = new ItemMaceSWA("mace_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		maceThaumium = SpartanWeaponryAPI.createMace(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		maceVoidmetal = SpartanWeaponryAPI.createMace(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		maceDawnstone = SpartanWeaponryAPI.createMace(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(maceManasteel, maceTerrasteel, maceElementium, maceThaumium, maceVoidmetal, maceDawnstone);

		glaiveManasteel = new ItemGlaiveSWA("glaive_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		glaiveTerrasteel = new ItemGlaiveSWA("glaive_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		glaiveElementium = new ItemGlaiveSWA("glaive_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		glaiveThaumium = SpartanWeaponryAPI.createGlaive(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		glaiveVoidmetal = SpartanWeaponryAPI.createGlaive(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		glaiveDawnstone = SpartanWeaponryAPI.createGlaive(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(glaiveManasteel, glaiveTerrasteel, glaiveElementium, glaiveThaumium, glaiveVoidmetal, glaiveDawnstone);

		staffManasteel = new ItemQuarterstaffSWA("staff_manasteel", materialManasteel/*, WeaponPropertySWA.ManaRegenerate*/);
		staffTerrasteel = new ItemQuarterstaffSWA("staff_terrasteel", materialTerrasteel/*, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash*/);
		staffElementium = new ItemQuarterstaffSWA("staff_elementium", materialElementium/*, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P*/);
		staffThaumium = SpartanWeaponryAPI.createQuarterstaff(materialThaumium, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		staffVoidmetal = SpartanWeaponryAPI.createQuarterstaff(materialVoidmetal, Reference.ModID, CreativeTabsSWA.TAB_SWA/*, WeaponPropertySWA.Warped*/);
		staffDawnstone = SpartanWeaponryAPI.createQuarterstaff(materialDawnstone, Reference.ModID, CreativeTabsSWA.TAB_SWA);
		addWeaponsToRegister(staffManasteel, staffTerrasteel, staffElementium, staffThaumium, staffVoidmetal, staffDawnstone);
		
		// Parrying Daggers are experimental because of bugs with blocking behaviour
		// Will be considered non-experimental when Minecraft Forge adds custom
		// blocking events.
		/*if(ConfigHandler.enableExperimentalWeapons && !ConfigHandler.disableParryingDagger)
		{
//			registry.register(parryingDaggerWood);
		}
		
		*/
		
		for(Item weapon : weapons)
		{
			registry.register(weapon);
			//String modelLoc = StringHelper.stripUnlocalizedName(weapon.getUnlocalizedName());
			//ModelRenderRegistry.addItemToRegistry(weapon, modelLoc);
			//SpartanWeaponryAPI.registerItemModelRender(weapon);
			SpartanWeaponryAPI.addItemModelToRegistry(weapon);
		}
		
		LogHelper.info("Items Registered!");
	}
	
	protected static void addWeaponsToRegister(Item... weaponsToAdd)
	{
		for(Item weapon : weaponsToAdd)
		{
			if(weapon != null)
				weapons.add(weapon);
		}
	}
}
