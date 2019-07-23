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

import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithMagnitude;
import com.oblivioussp.spartanweaponryarcana.util.Reference;

public class WeaponPropertySWA
{
	public static final String TYPE_MANA_REGENERATE = "mana_regenerate";
	public static final String TYPE_TERRA_SLASH = "terra_slash";
	public static final String TYPE_PIXIELATED = "pixielated";
	public static final String TYPE_WARPED = "warped";
	
	public static final WeaponProperty ManaRegenerate = new WeaponPropertyManaRegen(TYPE_MANA_REGENERATE, Reference.ModID, 60.0f);
	public static final WeaponProperty ManaRegenerateTerra = new WeaponPropertyManaRegen(TYPE_MANA_REGENERATE, Reference.ModID, 100.0f);
	public static final WeaponProperty TerraSlash = new WeaponProperty(TYPE_TERRA_SLASH, Reference.ModID);
	public static final WeaponProperty Pixielated5P = new WeaponPropertyWithMagnitude(TYPE_PIXIELATED, Reference.ModID, 5.0f);
	public static final WeaponProperty Warped = new WeaponPropertyWarped(TYPE_WARPED, Reference.ModID);
}
