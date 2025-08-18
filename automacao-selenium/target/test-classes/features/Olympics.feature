# encoding: utf-8
Feature: Olympics

  @Jogos
  Scenario: Validate Jogos Page
    Given I am on olympics page
    Then the title should be "jogos olímpicos"

  @Athlete
  Scenario: Search Athlete
    Given I am on athletes page
    When I search the athlete
      | Athlete | Novak Djokovic |
    Then the gold medal quantity should be "1"

  @Athlete
  Scenario: Validate Athletes Quantity
    Given I am on athletes page
    Then the quantity should be 24

  @Noticias
  Scenario: Validate if podcast is on Spotify
    Given I am on podcast page
    Then the spotify is available

  @Noticias
  Scenario: Using move to Element On News
    Given I am openning the banner on Noticias
    Then the spotify is available
