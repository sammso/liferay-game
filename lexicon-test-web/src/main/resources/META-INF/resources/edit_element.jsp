<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(lexiconTestDisplayContext.getRedirect());

renderResponse.setTitle(LanguageUtil.get(request, "add-new-super-hero"));
%>

<aui:form action="" cssClass="container-fluid-1280">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input name="title" />
		</aui:fieldset>
	</aui:fieldset-group>
</aui:form>

<aui:button-row>
	<aui:button cssClass="btn-lg" type="submit" />

	<aui:button cssClass="btn-lg" type="cancel" />
</aui:button-row>