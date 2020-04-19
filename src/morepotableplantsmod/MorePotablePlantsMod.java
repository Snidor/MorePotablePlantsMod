package morepotableplantsmod;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.ItemTemplateFactory;
import com.wurmonline.server.items.ItemTypes;

public class MorePotablePlantsMod implements WurmServerMod, ItemTemplatesCreatedListener
{
	private static final Logger mLogger = Logger.getLogger( MorePotablePlantsMod.class.getName() );
	private static final short[] mPotableTypes = new short[] { ItemTypes.ITEM_TYPE_POTABLE, ItemTypes.ITEM_TYPE_POTTED };
	private static final short[] mHerbType = new short[] { ItemTypes.ITEM_TYPE_HERB };
	private static final short[] mSpiceType = new short[] { ItemTypes.ITEM_TYPE_SPICE };
	private static final short[] mFoodType = new short[] { ItemTypes.ITEM_TYPE_USES_FOOD_STATE, ItemTypes.ITEM_TYPE_FOOD };	
	
	private final int[] mNewPotableIds = { 246, 247, 248, 249, 250, 251, 365, 366, 440 };/*246-251 Mushrooms 365 Nettles, 366 Sassafras, 440 Woad*/
	private final int[] mNewHerbIds = { 246, 247, 248, 249, 250, 251 }; 
	private final int[] mNewSpiceIds = { 440 };
	
	@Override
	public void onItemTemplatesCreated() 
	{
		mLogger.log( Level.INFO, "Adding types to Items." );
		for ( int i = 0; i < mNewPotableIds.length; i ++ )		
		{
			ItemTemplate lTemplate = ItemTemplateFactory.getInstance().getTemplateOrNull( mNewPotableIds[i] );
			lTemplate.assignTypes( mPotableTypes );			
		}	

		for ( int i = 0; i < mNewHerbIds.length; i ++ )		
		{
			ItemTemplate lTemplate = ItemTemplateFactory.getInstance().getTemplateOrNull( mNewHerbIds[i] );
			lTemplate.assignTypes( mHerbType );			
		}		

		for ( int i = 0; i < mNewSpiceIds.length; i ++ )		
		{
			ItemTemplate lTemplate = ItemTemplateFactory.getInstance().getTemplateOrNull( mNewSpiceIds[i] );
			lTemplate.assignTypes( mSpiceType );
			lTemplate.assignTypes( mFoodType );
		}
		mLogger.log( Level.INFO, "Added types to Items." );
	}
}
