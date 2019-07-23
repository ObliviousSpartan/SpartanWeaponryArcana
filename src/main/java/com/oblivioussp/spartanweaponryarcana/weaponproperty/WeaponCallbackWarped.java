package com.oblivioussp.spartanweaponryarcana.weaponproperty;

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

import java.util.List;

import com.oblivioussp.spartanweaponry.api.IWeaponCallback;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponryarcana.util.EventHandler;
import com.oblivioussp.spartanweaponryarcana.util.Reference;
import com.oblivioussp.spartanweaponryarcana.util.StringHelper;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class WeaponCallbackWarped implements IWeaponCallback {

	@Override
	public void onTooltip(ToolMaterialEx material, ItemStack stack, World world, List<String> tooltip,
			ITooltipFlag flag) 
	{
		tooltip.add(TextFormatting.DARK_PURPLE + StringHelper.translateString("warped", "tooltip", Reference.ModID));
		if(GuiScreen.isShiftKeyDown())
		{
			tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString("warped.desc", "tooltip", Reference.ModID));
		}
	}
	
	@Override
	public void onCreateItem(ToolMaterialEx material, ItemStack stack)
	{
		if(!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		
		// Set this for Warping
		stack.getTagCompound().setByte("TC.WARP", (byte)1);
	}

	@Override
	public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity,
			int itemSlot, boolean isSelected) 
	{
		if(EventHandler.getTickCounter() == 0)
		{
			if(stack.getItemDamage() >= 0)
				stack.setItemDamage(stack.getItemDamage() - 1);
		}
	}
}
