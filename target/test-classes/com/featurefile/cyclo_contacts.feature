@cyclo
Feature: cyclo app

Background: login
Given launch the url
When I enter the username and password
And click the submit button and selecting contact option

@first
Scenario: In Contact list selecting Active Walking and requesting payment
When I select the Active Walking from the contact list
And Requesting for payment in the options
And enter the requested amount, requested date and also select payment method 
And enter the description and confirm
Then check whether request has been created successfully


Scenario: In Contact list selecting Active Walking 
When I select the references from the options
And by Clicking the Set reference 
And selecting very good from the options and adding the comments
Then click on the submit button


Scenario: Send a mail to Active Walking
When I select the Active Walking from Contacts
And Click on the send message option
And enter The Subject and select the font as Monospace and Bold
And enter the Message 
Then click on the send button

@pay
Scenario: Make payment to Active Walking
When I select the Active walking from contacts and select Make payment option
And enter The Amount to be sent and also schedule the payment as now
And enter The Description message and click on the next button and cofirm the same
Then check whether payment is done or exceeded the payment limit

@remove
Scenario: Remove Active Walking from Contacts
When I select the Active Walking from the contacts
And select Remove from the Contacts option
Then go back to Contacts and check whether the contact has been removed



