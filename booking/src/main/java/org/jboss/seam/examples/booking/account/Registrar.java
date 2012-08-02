/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.seam.examples.booking.account;

import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.jboss.seam.examples.booking.i18n.ApplicationMessages;

import org.jboss.seam.examples.booking.model.User;
import org.jboss.seam.international.status.Messages;

/**
 * The view controller for registering a new user
 *
 * @author <a href="http://community.jboss.org/people/dan.j.allen">Dan Allen</a>
 */
@Stateful
@Model
public class Registrar {
    
    @Inject
    ApplicationMessages appMsg;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    private Messages messages;

    @Inject
    private FacesContext facesContext;

    private UIInput usernameInput;

    private final User newUser = new User();

    @NotNull
    @Size(min = 5, max = 15)
    private String confirmPassword;

    private boolean registered;

    private boolean registrationInvalid;

    public void register() {
        if (verifyUsernameIsAvailable()) {
            registered = true;
            em.persist(newUser);

            messages.info(appMsg.registrationRegistered(newUser.getUsername()));
        } else {
            registrationInvalid = true;
        }
    }

    public boolean isRegistrationInvalid() {
        return registrationInvalid;
    }

    /**
     * This method just shows another approach to adding a status message.
     * <p>
     * Invoked by:
     * </p>
     * <p/>
     * <pre>
     * &lt;f:event type="preRenderView" listener="#{registrar.notifyIfRegistrationIsInvalid}"/>
     * </pre>
     */
    public void notifyIfRegistrationIsInvalid() {
        if (facesContext.isValidationFailed() || registrationInvalid) {
            messages.warn(appMsg.registrationInvalid());
        }
    }

    @Produces
    @Named
    public User getNewUser() {
        return newUser;
    }

    public boolean isRegistered() {
        return registered;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(final String password) {
        confirmPassword = password;
    }

    public UIInput getUsernameInput() {
        return usernameInput;
    }

    public void setUsernameInput(final UIInput usernameInput) {
        this.usernameInput = usernameInput;
    }

    private boolean verifyUsernameIsAvailable() {
        User existing = em.find(User.class, newUser.getUsername());
        if (existing != null) {
            messages.warn(appMsg.accountUsernameTaken(newUser.getUsername()))
                    .targets(usernameInput.getClientId());
            return false;
        }

        return true;
    }

}
