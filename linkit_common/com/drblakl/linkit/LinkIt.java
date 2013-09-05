package com.drblakl.linkit;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraftforge.event.ServerChatEvent;

import com.drblakl.linkit.lib.Reference;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import org.lwjgl.input.Keyboard;

@Mod(modid=Reference.MOD_ID , name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class LinkIt {

    @Instance("LinkIt")
    public static LinkIt instance;

    /*
     * Variable Declaration and Item Creation
     */    
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="com.drblakl.linkit.client.ClientProxy", serverSide="com.drblakl.linkit.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
        /*
         * PreInit is before turning on
         */ 
    }
    
    @Init
    public void init(FMLInitializationEvent event){
        proxy.registerRenderers();
        /*
         * Init is when turning on
         */   
        TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);        
        
        if(KeyBindHandler.keyPressed){
            
        }
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event){
        /*
         * PostInit is after all of the mods have been loaded
         * 
         * Good to interact with other mods
         */
    }
}


