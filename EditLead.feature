Feature: Edit Lead
Background:
Given Open the chrome browser
And Launch the application url

Scenario Outline: Successful Login with Valid Credential

Given Enter the username as <username> and Enter the password as <password>
When Press the Login button
Then Edit Lead Functionality
And Edit Company Name as 'Capgemini'
And Press Submit Button
And Close the Browser


Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|


