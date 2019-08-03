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

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.item.ItemHammer;
import com.oblivioussp.spartanweaponryarcana.client.gui.CreativeTabsSWA;
import com.oblivioussp.spartanweaponryarcana.util.ManaBurstHelper;
import com.oblivioussp.spartanweaponryarcana.util.ModHelper;
import com.oblivioussp.spartanweaponryarcana.util.Reference;
import com.oblivioussp.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.Optional;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.api.item.IPixieSpawner;
import vazkii.botania.api.mana.BurstProperties;
import vazkii.botania.api.mana.ILensEffect;
import vazkii.botania.api.mana.IManaUsingItem;

@Optional.Interface(iface="vazkii.botania.api.mana.IManaUsingItem", modid=ModHelper.MOD_ID_BOTANIA)
@Optional.Interface(iface="vazkii.botania.api.item.IPixieSpawner", modid=ModHelper.MOD_ID_BOTANIA)
@Optional.Interface(iface="vazkii.botania.api.mana.ILensEffect", modid=ModHelper.MOD_ID_BOTANIA)
public class ItemHammerSWA extends ItemHammer implements IManaUsingItem, IPixieSpawner, ILensEffect
{
	protected boolean usesMana = false;
	float pixieChance = 0.0f;

	public ItemHammerSWA(String unlocName, ToolMaterialEx material) 
	{
		super(unlocName, Reference.ModID, material);
		this.setCreativeTab(CreativeTabsSWA.TAB_SWA);
		
		usesMana = this.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_MANA_REGENERATE) != null ? true : this.materialEx.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_MANA_REGENERATE) != null;
		WeaponProperty prop = this.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
		if(prop != null)
			pixieChance = prop.getMagnitude() / 100.0f;
		else
		{
			prop = this.materialEx.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
			if(prop != null)
				pixieChance = prop.getMagnitude() / 100.0f;
		}
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

	@Override
	public void apply(ItemStack stack, BurstProperties props) {}

	@Override
	public boolean collideBurst(IManaBurst burst, RayTraceResult pos, boolean isManaBlock, boolean dead, ItemStack stack) 
	{
		return dead;
	}

	@Override
	public void updateBurst(IManaBurst burst, ItemStack stack)
	{
		ManaBurstHelper.updateBurst(burst, stack, this.getDirectAttackDamage() + 1.0f);
	}

	@Override
	public boolean doParticles(IManaBurst burst, ItemStack stack) 
	{
		return true;
	}
}
