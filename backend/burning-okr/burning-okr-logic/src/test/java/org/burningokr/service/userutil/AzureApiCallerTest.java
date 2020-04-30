package org.burningokr.service.userutil;

import java.util.ArrayList;
import java.util.List;
import org.burningokr.service.exceptions.AzureApiException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AzureApiCallerTest {

  private ExternalOAuthClientDetails externalOAuthClientDetails;
  private AzureAdProperties azureAdProperties;

  @Before
  public void setup() {
    externalOAuthClientDetails =
        new ExternalOAuthClientDetails("", "", "clientId", "clientSecret", "", "", "");
    List<AzureGroup> azureGroups = new ArrayList<>();
    azureGroups.add(AzureGroup.builder().id("groupId").name("groupIntern").build());
    azureAdProperties = new AzureAdProperties("tenantId", azureGroups);
  }

  @Test(expected = AzureApiException.class)
  public void getAccessToken_shouldFailForInvalidData() throws AzureApiException {
    externalOAuthClientDetails.setClientSecret("notSoSecret");
    AzureApiCaller caller = new AzureApiCaller(externalOAuthClientDetails, azureAdProperties);

    String accessToken = caller.getAccessToken();
  }
}
