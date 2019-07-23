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

import net.minecraft.util.text.translation.I18n;

public class StringHelper
{
	public static String getItemUnlocalizedName(String locName)
	{
		return getItemUnlocalizedName(locName, Reference.ModID);
	}
	
	public static String getItemUnlocalizedName(String locName, String modId)
	{
		return String.format("item.%s:%s", modId.toLowerCase(), stripUnlocalizedName(locName));
	}
	
	public static String stripUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public static String translateString(String unlocalizedStr, String type)
	{
		return translateString(unlocalizedStr, type, Reference.ModID);
	}

	public static String translateString(String unlocalizedStr, String type, String modIdStr)
	{
		String modId = modIdStr;
		if(modId == null || modId == "")
			modId = Reference.ModID;
		if (type == null || type == "")
			return I18n.translateToLocalFormatted(modId.toLowerCase() + ":" + unlocalizedStr);
		return I18n.translateToLocalFormatted(String.format("%s.%s:%s", type, modId.toLowerCase(),
				unlocalizedStr));
	}
	
	public static String translateFormattedString(String unlocalizedStr, String type, String modIdStr, Object... parameters)
	{
		String modId = modIdStr;
		if(modId == null || modId == "")
			modId = Reference.ModID;
		if (type == null || type == "")
			return I18n.translateToLocalFormatted(modId.toLowerCase() + ":" + unlocalizedStr, parameters);
		return I18n.translateToLocalFormatted(String.format("%s.%s:%s", type, modId.toLowerCase(),
				unlocalizedStr), parameters);
	}
}
