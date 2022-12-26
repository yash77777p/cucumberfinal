#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
#I want to use this template for my feature file
#
#@tag1
#Scenario: Title of your scenario
#Given I want to write a step with precondition
#And some other precondition
#When I complete action
#And some other action
#And yet another action
#Then I validate the outcomes
#And check more outcomes
#
#@tag2
#Scenario Outline: Title of your scenario outline
#Given I want to write a step with <name>
#When I check for the <value> in step
#Then I verify the <status> in step
#
#Examples:
#| name  | value | status  |
#| name1 |     5 | success |
#| name2 |     7 | Fail    |
Feature: Ticket.com Home Page

  Background: 
    Given I am on home page

  @p1 @sanity
  Scenario: Login with valid credentials
    When I click on the login link
    And I entered the valid 'username' and 'password' and clicked on the login button
      | cvstestuipath@gmail.com | Expert768$* |
    Then I validate the 'usernameshortcut' on home page
      | YP |
	@p2 @smoke
  Scenario Outline: Login with invalid credentials
    When I click on the login link
    And I entered the invalid "<username>" and "<password>" and clicked on the login button
    Then I validate the "<error>" or "<error1>" on screen

    Examples: 
      | username                | password | error                            | error1  |
      | cvstestuipath@gmail.com | Test@123 | Email or password doesn't match. | reached |
      | cvstestuipath@gmail.com | Test@876 | Email or password doesn't match. | reached |
