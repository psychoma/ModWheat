package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.world.World;

public class BlockEnchantmentTable extends BlockContainer
{
    protected BlockEnchantmentTable(int par1)
    {
        super(par1, 166, Material.rock);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

        for (int var6 = par2 - 2; var6 <= par2 + 2; ++var6)
        {
            for (int var7 = par4 - 2; var7 <= par4 + 2; ++var7)
            {
                if (var6 > par2 - 2 && var6 < par2 + 2 && var7 == par4 - 1)
                {
                    var7 = par4 + 2;
                }

                if (par5Random.nextInt(16) == 0)
                {
                    for (int var8 = par3; var8 <= par3 + 1; ++var8)
                    {
                        if (par1World.getBlockId(var6, var8, var7) == Block.bookShelf.blockID)
                        {
                            if (!par1World.isAirBlock((var6 - par2) / 2 + par2, var8, (var7 - par4) / 2 + par4))
                            {
                                break;
                            }

                            par1World.spawnParticle("enchantmenttable", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return this.getBlockTextureFromSide(par1);
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int par1)
    {
        return par1 == 0 ? this.blockIndexInTexture + 17 : (par1 == 1 ? this.blockIndexInTexture : this.blockIndexInTexture + 16);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World)
    {
        return new TileEntityEnchantmentTable();
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            par5EntityPlayer.displayGUIEnchantment(par2, par3, par4);
            return true;
        }
    }
}
