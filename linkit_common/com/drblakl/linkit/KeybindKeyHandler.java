package com.drblakl.linkit;

import java.awt.Color;
import java.awt.Point;
import java.util.EnumSet;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import net.minecraft.block.BlockChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.Mod.Block;
import cpw.mods.fml.common.TickType;

public class KeybindKeyHandler extends KeyHandler {

    public static boolean keyPressed = false;
    public static KeyBinding linkKey = new KeyBinding("Link Item", Keyboard.KEY_L);
    
    public static KeyBinding[] keybindArray = new KeyBinding[]{linkKey};
    public static boolean[] repeats = new boolean[keybindArray.length];  
    
    public GuiContainer window;
    
    IInventory inventory;
    Container inventorySlots;
    
    /** The X size of the inventory window in pixels. */
    protected int xSize = 176;

    /** The Y size of the inventory window in pixels. */
    protected int ySize = 166;    
    
    /**
     * Starting X position for the Gui. Inconsistent use for Gui backgrounds.
     */
    protected int guiLeft;

    /**
     * Starting Y position for the Gui. Inconsistent use for Gui backgrounds.
     */
    protected int guiTop;
    private Slot theSlot;
    private boolean isOver;    
       
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
        Minecraft mc = Minecraft.getMinecraft();
        
        if(player == null || tickEnd){
            return;
        }
               
        if(player.inventory.isUseableByPlayer(player)){
            if(ModLoader.isGUIOpen(GuiInventory.class)){
                if(kb.equals(linkKey)){
                         
                        
                    
                    
                    for (int j1 = 0; j1 < player.inventoryContainer.inventorySlots.size(); ++j1)
                    {
                        Slot slot = (Slot)player.inventoryContainer.inventorySlots.get(j1);
                    }
                }
            }

        }
    }         
    
    /**
     * Returns the slot at the given coordinates or null if there is none.
     */
    private Slot getSlotAtPosition(Minecraft mc, int par1, int par2)
    {
        for (int k = 0; k < mc.thePlayer.inventoryContainer.inventorySlots.size(); ++k)
        {
            Slot slot = (Slot)mc.thePlayer.inventoryContainer.inventorySlots.get(k);

            if (this.isMouseOverSlot(slot, par1, par2))
            {
                return slot;
            }
        }

        return null;
    }
    
    /**
     * Returns if the passed mouse position is over the specified slot.
     */
    private boolean isMouseOverSlot(Slot par1Slot, int par2, int par3)
    {
        return this.isPointInRegion(par1Slot.xDisplayPosition, par1Slot.yDisplayPosition, 16, 16, par2, par3);
    }

    /**
     * Args: left, top, width, height, pointX, pointY. Note: left, top are local to Gui, pointX, pointY are local to
     * screen
     */
    protected boolean isPointInRegion(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        int k1 = this.guiLeft;
        int l1 = this.guiTop;
        par5 -= k1;
        par6 -= l1;
        return par5 >= par1 - 1 && par5 < par1 + par3 + 1 && par6 >= par2 - 1 && par6 < par2 + par4 + 1;
    }    

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {

    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }

}
