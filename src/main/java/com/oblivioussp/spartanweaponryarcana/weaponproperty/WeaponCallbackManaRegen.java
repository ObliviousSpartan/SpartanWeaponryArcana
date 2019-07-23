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
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponryarcana.util.ModHelper;
import com.oblivioussp.spartanweaponryarcana.util.Reference;
import com.oblivioussp.spartanweaponryarcana.util.StringHelper;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import vazkii.botania.api.mana.ManaItemHandler;

public class WeaponCallbackManaRegen implements IWeaponCallback 
{
	protected float manaCost;
	
	public WeaponCallbackManaRegen(float manaCostPerDurability)
	{
		manaCost = manaCostPerDurability;
	}

	@Override
	public void onTooltip(ToolMaterialEx material, ItemStack stack, World world, List<String> tooltip,
			ITooltipFlag flag) 
	{
		tooltip.add(TextFormatting.DARK_AQUA  + StringHelper.translateString("mana_regenerate", "tooltip", Reference.ModID));
		if(GuiScreen.isShiftKeyDown())
		{
			tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString("mana_regenerate.desc", "tooltip", Reference.ModID));
		}
	}

	@Override
	public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) 
	{
		if(!world.isRemote && ModHelper.isBotaniaLoaded() && stack.isItemDamaged() && entity instanceof EntityPlayer && requestManaForRepair(stack, (EntityPlayer)entity, MathHelper.floor(manaCost * 2)))
		{
			stack.setItemDamage(stack.getItem().getDamage(stack) - 1);
		}
	}
	
	@Optional.Method(modid = ModHelper.MOD_ID_BOTANIA)
	protected boolean requestManaForRepair(ItemStack stack, EntityPlayer player, int manaRequested)
	{
		return ManaItemHandler.requestManaExactForTool(stack, player, manaRequested, true);
	}
}
