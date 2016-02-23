/*
 * 
 *  Open Universities Australia 
 */

package com.oua.tm.common.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class holds the mapping constants used in controller and jsp pages.
 * 
 * @author praveenkumar.a
 */

@Component
public final class OUAMappingConstants {

	/** Constant representing dash board view. */
	@Value("${path.home.dashboard}")
	public String DASHBOARD;

	/** Constant representing activity list view. */
	@Value("${path.user.activity.view}")
	public String ACTIVITY_VIEW;

	/** Instance instantiated at the class loading. */
	private static OUAMappingConstants constantsInstance = new OUAMappingConstants();

	/** Private constructor to prevent Instantiation. */
	private OUAMappingConstants() {

	}

	/**
	 * Returns the instance.
	 * 
	 * @return OUAMappingConstants
	 */
	public static OUAMappingConstants getInstance() {
		return constantsInstance;
	}
}
