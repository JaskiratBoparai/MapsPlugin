package com.oresomecraft.maps.battles.maps;

import org.bukkit.*;
import org.bukkit.inventory.*;
import com.oresomecraft.OresomeBattles.BattlePlayer;
import com.oresomecraft.OresomeBattles.gamemode.Gamemode;
import com.oresomecraft.OresomeBattles.map.annotations.*;
import com.oresomecraft.OresomeBattles.map.types.BattleMap;

@MapConfig(
        name = "template",
        fullName = "Template",
        creators = {"zachoz", "ScruffyRules"},
        gamemodes = {Gamemode.TDM, Gamemode.FFA, Gamemode.CTF, Gamemode.KOTH, Gamemode.LTS, Gamemode.LMS}
)
@Region(
        x1 = 1486,
        y1 = 87,
        z1 = 437,
        x2 = 1319,
        y2 = -4,
        z2 = 666
)
@Attributes(
        allowBuild = false,
        fireSpread = false,
        tdmTime = 10,
        disabledDrops = {Material.BOW, Material.WOOD_SWORD}
)
public class BattleTemplate extends BattleMap {

    public BattleTemplate() {
        super.initiate(this);
    }

    public void readyTDMSpawns() {
        redSpawns.add(new Location(w, 1451, 13, 545, 91, 0));
        redSpawns.add(new Location(w, 1436, 15, 557, 87, 0));
        redSpawns.add(new Location(w, 1453, 13, 526, 87, 0));

        blueSpawns.add(new Location(w, 1354, 12, 547, -92, 0));
        blueSpawns.add(new Location(w, 1365, 10, 524, -88, 0));
        blueSpawns.add(new Location(w, 1372, 12, 572, -98, 0));
    }

    public void readyFFASpawns() {
        FFASpawns.add(new Location(w, 1451, 13, 545, 91, 0));
        FFASpawns.add(new Location(w, 1354, 12, 547, -92, 0));
		FFASpawns.add(new Location(w, 1394, 17, 593, -177, 0));
		FFASpawns.add(new Location(w, 1415, 12, 480, 8, 0));
		FFASpawns.add(new Location(w, 1399, 11, 517, -36, 0));
		FFASpawns.add(new Location(w, 1415, 12, 539, 78, 0));
		FFASpawns.add(new Location(w, 1385, 11, 556, -131, 0));
    }

    public void applyInventory(final BattlePlayer p) {
        Inventory i = p.getInventory();

        ItemStack HEALTH_POTION = new ItemStack(Material.POTION, 1, (short) 16373);
        ItemStack IRON_HELMET = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack IRON_CHESTPLATE = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack IRON_PANTS = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemStack IRON_BOOTS = new ItemStack(Material.IRON_BOOTS, 1);
        ItemStack IRON_SWORD = new ItemStack(Material.IRON_SWORD, 1);

        p.getInventory().setBoots(IRON_BOOTS);
        p.getInventory().setLeggings(IRON_PANTS);
        p.getInventory().setChestplate(IRON_CHESTPLATE);
        p.getInventory().setHelmet(IRON_HELMET);

        // setItem() is a BattlePlayer method. Makes giving items a bit quicker.
        p.setItem(0, IRON_SWORD);
        p.setItem(1, Material.BOW, 1);
        p.setItem(2, Material.COOKED_BEEF, 1);

        // This is the Bukkit way of doing it
        i.setItem(3, HEALTH_POTION);
        p.setItem(8, Material.EXP_BOTTLE, 5);
        p.setItem(9, Material.ARROW, 64);
    }

}
