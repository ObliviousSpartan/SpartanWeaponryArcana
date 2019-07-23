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

import com.oblivioussp.spartanweaponryarcana.item.ItemMultiSWA;
import com.oblivioussp.spartanweaponryarcana.util.LogHelper;
import com.oblivioussp.spartanweaponryarcana.util.Reference;
import com.oblivioussp.spartanweaponryarcana.util.StringHelper;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Reference.ModID)
public class ModelRenderRegistry 
{
	
	@SubscribeEvent
	public static void registerItemRenders(ModelRegistryEvent ev)
	{
		// Manually register Item Models here
		registerMultiItemRender(ItemRegistrySWA.material);
		
		LogHelper.info("Registered all item renders!");
	}
	
	public static void registerMultiItemRender(ItemMultiSWA item)
	{
		String[] localizedNames = item.getAllUnlocalizedNames();
		if(localizedNames == null)
			return;
		for(int i = 0; i < localizedNames.length; i++)
		{
			String unlocName = localizedNames[i];
			LogHelper.debug("Registering model of item: " + item.getRegistryName().toString() + ":" + i);
			ModelResourceLocation modelLoc = new ModelResourceLocation(Reference.ModID + ":" + StringHelper.stripUnlocalizedName(unlocName), "inventory");
			ModelLoader.setCustomModelResourceLocation(item, i, modelLoc);
		}
	}
}
