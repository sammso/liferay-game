Feature: Setup greature: Get userId, groupId and companyId and authenticate

	Background:

		* def screenName = 'test'
		* def user = screenName + '@liferay.com'
		* def pwd = 'test'
		* def creds = { username: '#(user)', password: '#(pwd)' }
		* def authHeaderValue = call read('../../plugins/basic-auth.js') creds

	Scenario: Get companyId

		Given url companyURL
		And path 'get-company-by-virtual-host'
		And header Authorization = authHeaderValue
		And param virtualHost = 'localhost'
		When method get
		Then status 200

		* def companyId = response.companyId

	Scenario: Get groupId

		Given url groupURL
		And path 'get-groups'
		And header Authorization = authHeaderValue
		And param companyId = companyId
		And param parentGroupId = 0
		And param site = true
		When method get
		Then status 200

		* def groupId = response[0].groupId

	Scenario: Get userId

		Given url userURL
		And path 'get-user-by-screen-name'
		And header Authorization = authHeaderValue
		And param companyId = companyId
		And param screenName = screenName
		When method get
		Then status 200

		* def userId = response.userId

	Scenario: Authenticate

		* def authHeaderValue = callonce read('../../plugins/basic-auth.js') creds