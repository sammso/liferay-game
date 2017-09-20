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

package com.liferay.game.service.impl;

import com.liferay.game.model.Element;
import com.liferay.game.service.base.ElementServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the element remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.game.service.ElementService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementServiceBaseImpl
 * @see com.liferay.game.service.ElementServiceUtil
 */
public class ElementServiceImpl extends ElementServiceBaseImpl {

	@Override
	public Element addElement(
			long userId, long groupId, String name, String url,
			ServiceContext serviceContext)
		throws PortalException {

		return elementLocalService.addElement(
			userId, groupId, name, url, serviceContext);
	}

	@Override
	public Element deleteElement(long elementId) throws PortalException {
		return elementLocalService.deleteElement(elementId);
	}

	@Override
	public void deleteElements(long groupId) throws PortalException {
		elementLocalService.deleteElements(groupId);
	}

	@Override
	public Element getElement(long elementId) throws PortalException {
		return elementLocalService.getElement(elementId);
	}

	@Override
	public List<Element> getElements(long groupId, int start, int end) {
		return elementLocalService.getElements(groupId, start, end);
	}

	@Override
	public Element updateElement(long elementId, String name, String url)
		throws PortalException {

		return elementLocalService.updateElement(elementId, name, url);
	}

}