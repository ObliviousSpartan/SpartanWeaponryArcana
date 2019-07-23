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

public class Reference
{
	// Mod information
	public static final String ModID = "spartanweaponryarcana";
	public static final String ModName = "Spartan Weaponry Arcana";
	public static final String ModVersion = "beta 1.0.1";
	public static final String ModDependencies = "required-after:spartanweaponry@[beta-1.3.0,);after:botania;after:thaumcraft;after:embers";
	public static final String McVersion = "[1.12.2]";
	
	// Classes
	public static final String ProxyClientClass = "com.oblivioussp.spartanweaponryarcana.proxy.ClientProxy";
	public static final String ProxyServerClass = "com.oblivioussp.spartanweaponryarcana.proxy.CommonProxy";
	public static final String GuiFactoryClass = "com.oblivioussp.spartanweaponryarcana.client.gui.GuiFactorySW";
}
