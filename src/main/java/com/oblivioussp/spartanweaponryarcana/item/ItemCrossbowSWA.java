package com.oblivioussp.spartanweaponryarcana.item;

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

import com.oblivioussp.spartanweaponry.api.IWeaponCallback;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.item.ItemCrossbow;
import com.oblivioussp.spartanweaponryarcana.client.gui.CreativeTabsSWA;
import com.oblivioussp.spartanweaponryarcana.util.ModHelper;
import com.oblivioussp.spartanweaponryarcana.util.Reference;
import com.oblivioussp.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional;
import vazkii.botania.api.item.IPixieSpawner;
import vazkii.botania.api.mana.IManaUsingItem;

@Optional.Interface(iface="vazkii.botania.api.mana.IManaUsingItem", modid=ModHelper.MOD_ID_BOTANIA)
@Optional.Interface(iface="vazkii.botania.api.item.IPixieSpawner", modid=ModHelper.MOD_ID_BOTANIA)
public class ItemCrossbowSWA extends ItemCrossbow implements IManaUsingItem, IPixieSpawner
{
	protected boolean usesMana = false;
	float pixieChance = 0.0f;

	public ItemCrossbowSWA(String unlocName, ToolMaterialEx material)
	{
		super(unlocName, Reference.ModID, material);
		this.setCreativeTab(CreativeTabsSWA.TAB_SWA);
		
		usesMana = this.material.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_MANA_REGENERATE) != null;
		WeaponProperty prop = this.material.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
		if(prop != null)
			pixieChance = prop.getMagnitude() / 100.0f;
		else
		{
			prop = this.material.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
			if(prop != null)
				pixieChance = prop.getMagnitude() / 100.0f;
		}
	}
	
	public ItemCrossbowSWA(String unlocName, ToolMaterialEx material, IWeaponCallback weaponCallback)
	{
		super(unlocName, Reference.ModID, material);
		this.callback = weaponCallback;
	}

	@Override
	public float getPixieChance(ItemStack stack)
	{
		return pixieChance;
	}

	@Override
	public boolean usesMana(ItemStack stack) 
	{
		return usesMana;
	}
}
