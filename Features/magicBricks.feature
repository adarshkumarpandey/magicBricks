Feature: Sell Functionallity of Magic Bricks Site.
  I want to use this template for my feature file
  
@postAd
  Scenario: Post Free Ad
    When user click on Sell and Select Post Property
    And user is able to select Free Ad Package
    And user select Sale option
    And user select Property Type
    And user enters the Property Location details
    And user select the Property Features
    And user click on Continue to Post
    Then user is able to post a add
    
@PropertyValuation
  Scenario: To validate the functionality of Property Valuation in Property Services
    When user click on Property Services and select Property Valuation
    And user click on Request a Valuation
    Then user redirected to Packages for Property Valuation Services
    Then user click on Download Sample Report of Property Valuation
    Then A sample report should get downloaded for Property Valuation
    
@LegalTitleCheck
  Scenario: To validate the functionality of Legal Title Check in Property Services
    When user click on Property Services and select Legal Title Check
    And user click on Verify Property Documents
    Then user redirects to Packages for Property Legal Title Check
    
@Vastu
  Scenario: To validate the functionality of Vastu in Property Services
    When user click on Property Services and select Vastu
    And user is able to Select Consultant
    And user is able to view details of Consultant
    And user is able to download sample report of Consultant
    Then A sample report should get downloaded of Consultant
