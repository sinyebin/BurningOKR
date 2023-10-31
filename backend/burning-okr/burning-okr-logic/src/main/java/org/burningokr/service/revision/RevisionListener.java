package org.burningokr.service.revision;

import lombok.RequiredArgsConstructor;
import org.burningokr.model.revision.RevisionInformation;
import org.burningokr.service.security.authenticationUserContext.AuthenticationUserContextService;
import org.burningokr.service.security.authenticationUserContext.AuthenticationUserContextServiceKeycloak;
import org.hibernate.envers.EntityTrackingRevisionListener;
import org.hibernate.envers.RevisionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RevisionListener
        implements org.hibernate.envers.RevisionListener, EntityTrackingRevisionListener {
  @Autowired
  private AuthenticationUserContextServiceKeycloak authenticationUserContextService;

  @Override
  public void newRevision(Object revisionEntity) {
    RevisionInformation r = (RevisionInformation) revisionEntity;
    // TODO Workaround entfernen nach Spring Upgrade (wegen fehlender DI). (MV)
    r.setUserId(authenticationUserContextService.getAuthenticatedUser().getId());
  }

  @Override
  public void entityChanged(Class entityClass, String entityName, Object entityId, RevisionType revisionType, Object revisionEntity) {
    // TODO Hierher gehört nach dem Spring Upgrade (wegen fehlender DI) der Vergleich, ob es Benutzeränderungen gegeben hat. Dazu den RevisionService befähigen und hier aufrufen dazu bzw. eine Klasse für Tasks. (MV)
  }
}
