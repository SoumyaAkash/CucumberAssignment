Feature: Delete Lead Functionality
Background:
Given Open the chrome browser for DeleteLead
And Launch the application Webbrower URL

Scenario Outline: Successful Login with Valid Credential
And Enter the username as <username> and Enter the password as <password>
When Press the Login button
Then Find the Lead details to be deleted
And Delete the Lead with LeadId

And Press Submit Button
And Close the Browser


Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|