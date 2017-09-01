/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.lexicon.test.demo.internal.instance.lifecycle;

import com.liferay.lexicon.test.service.ElementLocalService;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.util.PropsValues;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class AddElementDemoInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		long defaultUserId = _userLocalService.getDefaultUserId(
			company.getCompanyId());

		Group defaultGroup = _groupLocalService.getGroup(
			company.getCompanyId(),
			PropsValues.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);

		if (_elementLocalService.getElementsCount() > 0) {
			return;
		}

		ServiceContext serviceContext = new ServiceContext();

		for (int i = 0; i < _NAMES.length; i++) {
			String name = _NAMES[i];

			String url = _IMAGE_BASE_URL + "/images/" + _URLS[i] + "_xl.png";

			_elementLocalService.addElement(
				defaultUserId, defaultGroup.getGroupId(), name, url,
				serviceContext);
		}
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	private static final String _IMAGE_BASE_URL =
		"http://localhost:8080/o/lexicon-test-web";

	private static final String[] _NAMES = {
		"Batman", "Captain America", "Flash", "Green Lantern", "IronMan",
		"Robin", "SpiderMan", "Superman", "Wolverine", "WonderWoman"
	};

	private static final String[] _URLS = {
		"batman", "captainamerica", "flash", "greenlantern", "ironman", "robin",
		"spiderman", "superman", "wolverine", "wonderwoman"
	};

	@Reference
	private ElementLocalService _elementLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private UserLocalService _userLocalService;

}