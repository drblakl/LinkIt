package com.drblakl.linkit.client;

import com.drblakl.linkit.CommonProxy;
import com.drblakl.linkit.KeybindKeyHandler;
import com.drblakl.linkit.PlayerTickHandler;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
    
    private static PlayerTickHandler playerTickHandler;
    public static KeybindKeyHandler keybindHandler;
    
    @Override
    public void registerRenderers() {
        keybindHandler = new KeybindKeyHandler();
        KeyBindingRegistry.registerKeyBinding(keybindHandler);
    }
    
}
