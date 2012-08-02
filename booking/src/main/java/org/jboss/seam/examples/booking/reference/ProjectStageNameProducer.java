package org.jboss.seam.examples.booking.reference;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

/**
 *
 * @author rsmeral
 */
public class ProjectStageNameProducer {

    @Inject
    @Default
    private ProjectStage stage;

    @Produces
    @Named("currentProjectStage")
    public String currentProjectStage() {
        return stage.toString();
    }
}
