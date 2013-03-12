package wheat.block;

import net.minecraft.block.BlockSponge;
import net.minecraft.creativetab.CreativeTabs;

public class BlockWheat extends BlockSponge{

	public BlockWheat(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public String getTextureFile(){
		return "/wheat/textures/block.png";
	}
}
