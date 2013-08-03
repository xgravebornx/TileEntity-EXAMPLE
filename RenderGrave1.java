package mods.tutorial.common;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RenderGrave1 extends TileEntitySpecialRenderer{
	
	public RenderGrave1(){
		aModel = new ModelGrave1();
	}
	
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        TileEntityGrave1 tileEntity = (TileEntityGrave1) te;
		
		   int meta;
	        if (tileEntity.worldObj != null) {
	            meta = tileEntity.getBlockMetadata();
	        } else {
	            meta = 0;
	        }
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.52F, (float)z + 0.5F);
		


		
		  switch (getmetaDirection(meta)) {
          case 0:
              GL11.glRotatef(-180, 0.0F, 1.0F, 0.0F);
              break;
          case 1:
              GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
              break;
          case 2:
              GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
              break;
          case 3:
              GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
              break;
      }
		
		
		
		
		GL11.glRotatef(180F, 0F, 0F, 1F);
		bindTextureByName("/mods/cosmetica/textures/blocks/grave1.png");
		GL11.glPushMatrix();
		aModel.renderAll(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	
	private static int getmetaDirection(int meta) {
        switch (meta) {
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


		
	private ModelGrave1 aModel;
	

}
