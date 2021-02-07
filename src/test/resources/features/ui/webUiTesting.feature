Feature: Verification of search functionality

  Scenario: Verification of search and filtering
    When user opens main page and search "communities and events"
    Then user can click on "Advanced" and filter search results
    Then user see filtered search results


  Scenario: Verification of list of Pokemons by name
    When user opens page with list of Pokemons
    Then users see in section "Y" only Pokemons with name starting with this letter