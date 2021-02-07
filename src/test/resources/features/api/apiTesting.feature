Feature: Api verifications scenarios

  @apiTest
  Scenario: Verify details about Pikachu pokemon
    When user calls get "pikachu" info Api
    Then user see that pokemon has move "thunder-punch"

  @apiTest
  Scenario: Verify that Pikachu could be received as gift in yellow game version of the Pokemon game