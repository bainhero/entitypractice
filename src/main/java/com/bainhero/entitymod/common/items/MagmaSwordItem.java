package com.bainhero.entitymod.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class MagmaSwordItem extends SwordItem implements IAnimatable{
	
	public AnimationFactory factory = new AnimationFactory(this);
	private String controllerName = "spinControl";

	public MagmaSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(!worldIn.isRemote) {
			return super.onItemRightClick(worldIn, playerIn, handIn);
		}
		
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		AnimationController controller = GeckoLibUtil.getControllerForStack(factory, stack, controllerName);
		
		if (controller.getAnimationState() == AnimationState.Stopped) {
			controller.markNeedsReload();
			
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.magma_sword.spin", false));
			
		}
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) {
		AnimationController controller = new AnimationController(this, controllerName, 20, this::predicate);
		
		data.addAnimationController(controller);
		
	}

	@Override
	public AnimationFactory getFactory() {
		// TODO Auto-generated method stub
		return this.factory;
	}
	
	private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event){
		return PlayState.CONTINUE;
	}
	
}
