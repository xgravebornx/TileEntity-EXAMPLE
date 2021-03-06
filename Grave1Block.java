package mods.cosmetica.common;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;



public class Grave1Block extends BlockContainer{
	
	

	/**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
            {
                b0 = 3;
            }

            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
            {
                b0 = 2;
            }

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
            {
                b0 = 5;
            }

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntityFurnace)par1World.getBlockTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
        }
    }

private static int getMetadataBasedOnRotation(int rotation) {
    if (rotation >= 315 || rotation < 45) {
        return 1;
    } else if (rotation >= 45 && rotation < 135) {
        return 2;
    } else if (rotation >= 135 && rotation < 225) {
        return 0;
    } else {
        return 3;
    }
}

	public Grave1Block(int id, Material mat) {
		super(id, mat);
		
		
		this.setHardness(1F);
		this.setResistance(1F);
		this.setLightValue(0F);
		//this.setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 1F, 0.9F); //min x y z max  x y z
		}
	
	
	
	
	    public boolean isOpaqueCube() {
		return false;
		}
	
	    public boolean renderAsNormalBlock() {
		return false;
		}
	    
	    public int getRenderType(){
	    	return -1;
	    }

	    private static void replaceGround(World world, int x, int y, int z) {
	        int botBlockID = world.getBlockId(x, y, z);
	        if (botBlockID == 2 || botBlockID == 110) {
	            world.setBlock(x, y, z, Block.dirt.blockID);
	        }
	    }
	    
	    public static int getMetaDirection(int direction) {
	        switch (direction) {
	          case 0: // S
	                return 0;
	            case 1: // N
	                return 2;
	            case 2: // E
	                return 3;
	            case 3: // W
	                return 1;
	            default:
	                return 2;
	        }
	    
	    }
	    
	    protected boolean bFull3D = false;
	    
		@Override
		public TileEntity createNewTileEntity(World world) {
			
			return new TileEntityGrave1();
		}

		
}

