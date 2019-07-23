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

import com.oblivioussp.spartanweaponryarcana.util.StringHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMultiSWA extends ItemSWA 
{
	protected String[] unlocNames;
	
	public ItemMultiSWA(String registryName, String... unlocalizedNames) 
	{
		super(registryName);
		this.unlocNames = unlocalizedNames;
		this.hasSubtypes = true;
	}
	
	public String[] getAllUnlocalizedNames()
	{
		return unlocNames;
	}

	/**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	if(tab == this.getCreativeTab())
    	{
	    	if(unlocNames == null)
	    	{
	    		super.getSubItems(tab, subItems);
	    		return;
	    	}
	    	for(int i = 0; i < unlocNames.length; i++)
	    	{
	    		subItems.add(new ItemStack(this, 1, i));
	    	}
    	}
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
    	if(stack.getItemDamage() >= unlocNames.length)
    		return super.getItemStackDisplayName(stack);
    	
    	String unlocName = unlocNames[stack.getItemDamage()];
        return StringHelper.translateString(unlocName + ".name", "item");
    }
}
