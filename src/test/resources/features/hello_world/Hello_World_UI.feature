Feature: Hello World UI

  Scenario Outline: Test Service Finder Tab
    Given user navigate to service finder page
    #And user select a tab "<service_finder_tab>"
    And user select search by "<location_or_name>" in step one
    And user enter location "<postcode_or_suburb>" in step one
    And user select service type "<service_type>" in step two
    And user click search button
    Then user should see search result shown for "<postcode_or_suburb>"

    Examples: 
      | service_finder_tab | location_or_name | postcode_or_suburb | service_type                       |
      | Help at home       | Location         | SYDNEY NSW, 2000   | Allied Health and Therapy Services |
