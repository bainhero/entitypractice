package com.bainhero.entitymod.client.render;

import com.bainhero.entitymod.client.model.MagmaSwordModel;
import com.bainhero.entitymod.common.items.MagmaSwordItem;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class MagmaSwordRenderer extends GeoItemRenderer<MagmaSwordItem>{

	public MagmaSwordRenderer() {
		super(new MagmaSwordModel());
	}

}
