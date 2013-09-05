package com.drblakl.linkit;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyBindHandler extends KeyHandler {

    public static boolean keyPressed = false;
    public static KeyBinding linkKey = new KeyBinding("Link Item", Keyboard.KEY_L);
    
    public KeyBindHandler(KeyBinding[] keyBindings, boolean[] repeatings) {
        super(keyBindings, repeatings);
        // TODO Auto-generated constructor stub
    }

    public KeyBindHandler(KeyBinding[] keyBindings) {
        super(keyBindings);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getLabel() {
        // TODO Auto-generated method stub
        return "linkitKeybinds";
    }

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb,
            boolean tickEnd, boolean isRepeat) {
        World world = Minecraft.getMinecraft().theWorld;
        
        EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
        
        if(kb.equals(linkKey)){
            player.openGui(null, 1, world, 0, 0, 0);
            player.addChatMessage("TESTING");
        }
        
        keyPressed = true;
    }

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
        // TODO Auto-generated method stub
        keyPressed = false;
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }

}
