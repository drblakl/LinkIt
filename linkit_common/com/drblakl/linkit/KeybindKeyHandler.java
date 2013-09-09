package com.drblakl.linkit;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MouseHelper;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeybindKeyHandler extends KeyHandler {

    public static boolean keyPressed = false;
    public static KeyBinding linkKey = new KeyBinding("Link Item", Keyboard.KEY_L);
    
    public static KeyBinding[] keybindArray = new KeyBinding[]{linkKey};
    public static boolean[] repeats = new boolean[keybindArray.length];  
    
    Slot theSlot;
       
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
                   
                    
                    
                    player.addChatMessage(Minecraft.getMinecraft().currentScreen.toString()); 
                    
                    
                    for (int j1 = 0; j1 < this.inventorySlots.inventorySlots.size(); ++j1)
                    {
                        Slot slot = (Slot)this.inventorySlots.inventorySlots.get(j1);
                        this.drawSlotInventory(slot);

                        Container test = player.inventoryContainer;
                        
                        if (this.isMouseOverSlot(slot, Mouse.getX(), Mouse.getY()))
                        {
                            this.theSlot = slot;
                            GL11.glDisable(GL11.GL_LIGHTING);
                            GL11.glDisable(GL11.GL_DEPTH_TEST);
                            int k1 = slot.xDisplayPosition;
                            i1 = slot.yDisplayPosition;
                            this.drawGradientRect(k1, i1, k1 + 16, i1 + 16, -2130706433, -2130706433);
                            GL11.glEnable(GL11.GL_LIGHTING);
                            GL11.glEnable(GL11.GL_DEPTH_TEST);
                        }
                    }                    
                    
                    
                    
                    if (player.inventory.getItemStack() == null && theSlot != null && this.theSlot.getHasStack())
                    {
                        ItemStack itemstack1 = this.theSlot.getStack();
                        //this.drawItemStackTooltip(itemstack1, par1, par2);
                        
                        player.addChatMessage("" + itemstack1.itemID);
                        
                    }                    /*
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
