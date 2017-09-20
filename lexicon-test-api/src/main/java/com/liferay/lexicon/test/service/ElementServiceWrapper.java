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

package com.liferay.lexicon.test.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ElementService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElementService
 * @generated
 */
@ProviderType
public class ElementServiceWrapper implements ElementService,
	ServiceWrapper<ElementService> {
	public ElementServiceWrapper(ElementService elementService) {
		_elementService = elementService;
	}

	@Override
	public com.liferay.lexicon.test.model.Element addElement(long userId,
		long groupId, java.lang.String name, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _elementService.addElement(userId, groupId, name, url,
			serviceContext);
	}

	@Override
	public com.liferay.lexicon.test.model.Element deleteElement(long elementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _elementService.deleteElement(elementId);
	}

	@Override
	public void deleteElements(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_elementService.deleteElements(groupId);
	}

	@Override
	public com.liferay.lexicon.test.model.Element getElement(long elementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _elementService.getElement(elementId);
	}

	@Override
	public java.util.List<com.liferay.lexicon.test.model.Element> getElements(
		long groupId, int start, int end) {
		return _elementService.getElements(groupId, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _elementService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.lexicon.test.model.Element updateElement(
		long elementId, java.lang.String name, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _elementService.updateElement(elementId, name, url);
	}

	@Override
	public ElementService getWrappedService() {
		return _elementService;
	}

	@Override
	public void setWrappedService(ElementService elementService) {
		_elementService = elementService;
	}

	private ElementService _elementService;
}