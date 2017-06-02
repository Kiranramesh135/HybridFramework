Feature: Test 

Scenario Outline: Add user 
	Given I am on login page 
	And enter login credentials 
	When I am on homepage 
	And navigate to system users page 
	Then I enter "<emplName>", "<uName>", "<pwd>", "<confirmPwd>" details 
	
	Examples: 
		|emplName|uName|pwd|confirmPwd|
		|Cecil Bonaparte|Cecil.Bonaparte2|abcd|abcd|
		|Daniel Upton|Daniel.Upton2|abcd|abcd|
		|Fiona Grace|Fiona.Grace2|abcd|abcd|
		|Fabienne Gabor|Fabienne.Gabor2|abcd|abcd|
		
		
		
		
