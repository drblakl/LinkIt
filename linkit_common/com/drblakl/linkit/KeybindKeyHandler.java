package com.drblakl.linkit;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeybindKeyHandler extends KeyHandler {

    public static boolean keyPressed = false;
    public static KeyBinding linkKey = new KeyBinding("Link Item", Keyboard.KEY_L);
    
    public static KeyBinding[] keybindArray = new KeyBinding[]{linkKey};
    public static boolean[] repeats = new boolean[keybindArray.length];    
    
    public KeybindKeyHandler(KeyBinding[] keyBindings, boolean[] repeatings) {
        super(keyBindings, repeatings);
        // TODO Auto-generated constructor stub
    }

    public KeybindKeyHandler(KeyBinding[] keyBindings) {
        super(keyBindings);
        // TODO Auto-generated constructor stub
    }

    public KeybindKeyHandler() {
        super(keybindArray, repeats);
    }

    @Override
    public String getLabel() {
        // TODO Auto-generated method stub
        return "linkitKeybinds";
    }

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
        World world = Minecraft.getMinecraft().theWorld;
        EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
        
        if(player == null || tickEnd){
            return;
        }
       
        if(player.openContainer.isPlayerNotUsingContainer(player)){
            if(ModLoader.isGUIOpen(GuiInventory.class)){
                if(kb.equals(linkKey)){
                    /*
                     * Make the magic happen here ;)
                     */
                    player.addChatMessage("Inventory open!");
                    player.addChatMessage("Linkit Key was pressed!");
                }
            }
        }
    }

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {

    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }

}
