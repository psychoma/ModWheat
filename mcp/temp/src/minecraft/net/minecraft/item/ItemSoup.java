package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSoup extends ItemFood {

   public ItemSoup(int p_i3624_1_, int p_i3624_2_) {
      super(p_i3624_1_, p_i3624_2_, false);
      this.func_77625_d(1);
   }

   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
      super.func_77654_b(p_77654_1_, p_77654_2_, p_77654_3_);
      return new ItemStack(Item.field_77670_E);
   }
}
