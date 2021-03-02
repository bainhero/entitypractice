package com.bainhero.entitymod.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap.MutableAttribute;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CowFuckerEntity extends CowEntity implements IAnimatable {
	
	
	public static final Ingredient TEMPT_ITEMS = Ingredient.fromItems(Items.BEEF, Items.COOKED_BEEF);
	AnimationFactory factory = new AnimationFactory(this);

	public CowFuckerEntity(EntityType<? extends CowEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public static MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 10000D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, .5D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 20000D);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new BreedGoal(this, .6D));
		this.goalSelector.addGoal(3, new TemptGoal(this, .5D, TEMPT_ITEMS, false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, .5D));
		this.goalSelector.addGoal(2, new LookAtGoal(this, CowEntity.class, 1.0F));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, .75F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
	}
	
	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return 100 + this.world.rand.nextInt(500);
	}
	
	@Override
	protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_VILLAGER_AMBIENT;	}
	
	@Override
	protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_VILLAGER_DEATH; }
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_VILLAGER_HURT; }
	
	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) {
		// TODO Auto-generated method stub
		data.addAnimationController(new AnimationController(this, "controller", 20, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		// TODO Auto-generated method stub
		return factory;
	}
	
	private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		if (!(event.getLimbSwingAmount() > -0.01F && event.getLimbSwingAmount() < 0.01F)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cow_fucker.creep", true));
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cow_fucker.look", false));
		}
		return PlayState.CONTINUE;
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.BEEF || stack.getItem() == Items.COOKED_BEEF;
	}
}
