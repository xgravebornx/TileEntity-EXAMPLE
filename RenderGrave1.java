package mods.tutorial.common;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RenderGrave1 extends TileEntitySpecialRenderer{
  
	

	private static final float par2 = 0;

	public RenderGrave1(){
		aModel = new ModelGrave1();
	}
	
	public void renderAModelAt(TileEntityGrave1 tileentity1, double d, double d1, double d2, float f){
		

    
		//
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.52F, (float)d2 + 0.5F);
		GL11.glRotatef(180F, 0F, 0F, 1F);
		bindTextureByName("/mods/tutorial/textures/blocks/grave1.png");
		GL11.glPushMatrix();
		aModel.renderAll(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		//
	}

	
	
	  
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1,
			double d2, float f) {
		renderAModelAt((TileEntityGrave1)tileentity, d, d1, d2, f);
		
        
	}
		
	private ModelGrave1 aModel;
	

}
