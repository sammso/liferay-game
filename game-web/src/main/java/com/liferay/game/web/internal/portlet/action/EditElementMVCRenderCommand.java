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

package com.liferay.game.web.internal.portlet.action;

import com.liferay.game.exception.NoSuchElementException;
import com.liferay.game.model.Element;
import com.liferay.game.service.ElementLocalService;
import com.liferay.game.web.internal.constant.GamePortletKeys;
import com.liferay.game.web.internal.constant.GameWebKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GamePortletKeys.GAME,
		"mvc.command.name=/game/edit_element"
	},
	service = MVCRenderCommand.class
)
public class EditElementMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		long elementId = ParamUtil.getLong(renderRequest, "elementId");

		try {
			Element element = _elementLocalService.fetchElement(elementId);

			renderRequest.setAttribute(
				GameWebKeys.GAME_ELEMENT, element);

			return "/edit_element.jsp";
		}
		catch (Exception e) {
			if (e instanceof NoSuchElementException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass());

				return "/error.jsp";
			}
			else {
				throw new PortletException(e);
			}
		}
	}

	@Reference
	private ElementLocalService _elementLocalService;

}