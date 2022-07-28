Feature: Create Lead
Background:
Given Launch the chrome browser
And Open the application url

Scenario Outline: Successful Login with Valid Credential
Given Enter the username as <username>
And Enter the password as <password>
When Click on Login button
Then Homepage should be displayed
Then Create login functionlity


Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
#|'DemoCSR'|'crmsfa'|




 




