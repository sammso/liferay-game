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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Element. This utility wraps
 * {@link com.liferay.lexicon.test.service.impl.ElementServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ElementService
 * @see com.liferay.lexicon.test.service.base.ElementServiceBaseImpl
 * @see com.liferay.lexicon.test.service.impl.ElementServiceImpl
 * @generated
 */
@ProviderType
public class ElementServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.lexicon.test.service.impl.ElementServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.lexicon.test.model.Element addElement(
		long userId, long groupId, java.lang.String name, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addElement(userId, groupId, name, url, serviceContext);
	}

	public static com.liferay.lexicon.test.model.Element deleteElement(
		long elementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteElement(elementId);
	}

	public static void deleteElements(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteElements(groupId);
	}

	public static com.liferay.lexicon.test.model.Element getElement(
		long elementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getElement(elementId);
	}

	public static java.util.List<com.liferay.lexicon.test.model.Element> getElements(
		long groupId, int start, int end) {
		return getService().getElements(groupId, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.lexicon.test.model.Element updateElement(
		long elementId, java.lang.String name, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updateElement(elementId, name, url);
	}

	public static ElementService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ElementService, ElementService> _serviceTracker =
		ServiceTrackerFactory.open(ElementService.class);
}