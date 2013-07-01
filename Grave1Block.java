package mods.tutorial.common;


import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;



public class Grave1Block extends BlockContainer{

  
	
	public Grave1Block(int id, Material mat) {
		super(id, mat);
			
		this.setHardness(1F);
		this.setResistance(1F);
		this.setLightValue(0F);
		
		//this.setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 1F, 0.9F); //min x y z max  x y z
		}
	
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
/**
     * Called when the block is placed in the world.
     */
public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
{
     int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
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

	    	    
		@Override
		public TileEntity createNewTileEntity(World world) {
			
			return new TileEntityGrave1();
		}

		//below adds particles to block
		/* public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
		    {
		        double d0 = (double)((float)par2 + 0.4F + par5Random.nextFloat() * 0.2F);
		        double d1 = (double)((float)par3 + 0.7F + par5Random.nextFloat() * 0.3F);
		        double d2 = (double)((float)par4 + 0.4F + par5Random.nextFloat() * 0.2F);
		        par1World.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		    }*/
		 
	
			    
		}

