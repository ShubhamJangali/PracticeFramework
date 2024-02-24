Feature: Login Functionality

Background:
Given user should be on login page

@smoke
Scenario: Valid Login1
When user enters valid user name
And and valid password
Then click on Login button

Scenario: Invalid Login
When user enters Invalid user name
And and valid password
And click on Login button
Then error massage should be displayed

