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

package com.liferay.lexicon.test.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.lexicon.test.service.ElementServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link ElementServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.lexicon.test.model.ElementSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.lexicon.test.model.Element}, that is translated to a
 * {@link com.liferay.lexicon.test.model.ElementSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementServiceHttp
 * @see com.liferay.lexicon.test.model.ElementSoap
 * @see ElementServiceUtil
 * @generated
 */
@ProviderType
public class ElementServiceSoap {
	public static com.liferay.lexicon.test.model.ElementSoap addElement(
		long userId, long groupId, java.lang.String name, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.lexicon.test.model.Element returnValue = ElementServiceUtil.addElement(userId,
					groupId, name, url, serviceContext);

			return com.liferay.lexicon.test.model.ElementSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.lexicon.test.model.ElementSoap deleteElement(
		long elementId) throws RemoteException {
		try {
			com.liferay.lexicon.test.model.Element returnValue = ElementServiceUtil.deleteElement(elementId);

			return com.liferay.lexicon.test.model.ElementSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteElements(long groupId) throws RemoteException {
		try {
			ElementServiceUtil.deleteElements(groupId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.lexicon.test.model.ElementSoap getElement(
		long elementId) throws RemoteException {
		try {
			com.liferay.lexicon.test.model.Element returnValue = ElementServiceUtil.getElement(elementId);

			return com.liferay.lexicon.test.model.ElementSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.lexicon.test.model.ElementSoap[] getElements(
		long groupId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.lexicon.test.model.Element> returnValue = ElementServiceUtil.getElements(groupId,
					start, end);

			return com.liferay.lexicon.test.model.ElementSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.lexicon.test.model.ElementSoap updateElement(
		long elementId, java.lang.String name, java.lang.String url)
		throws RemoteException {
		try {
			com.liferay.lexicon.test.model.Element returnValue = ElementServiceUtil.updateElement(elementId,
					name, url);

			return com.liferay.lexicon.test.model.ElementSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ElementServiceSoap.class);
}