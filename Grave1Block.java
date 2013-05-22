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

