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

import com.oblivioussp.spartanweaponryarcana.client.gui.CreativeTabsSWA;
import com.oblivioussp.spartanweaponryarcana.util.StringHelper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSWA extends Item
{
	
	public ItemSWA(String unlocName)
	{
		super();
		this.setCreativeTab(CreativeTabsSWA.TAB_SWA);
		this.setRegistryName(unlocName);
		this.setTranslationKey(unlocName);
	}
	
	@Override
	public String getTranslationKey()
	{
		return StringHelper.getItemUnlocalizedName(super.getTranslationKey());
	}
	
	@Override
	public String getTranslationKey(ItemStack itemStack)
	{
		return StringHelper.getItemUnlocalizedName(super.getTranslationKey());
	}
}
