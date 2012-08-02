/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.seam.examples.booking.i18n;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Typed;
import javax.inject.Named;

/**
 * Provides ApplicationMessages for use in EL.
 * 
 * @author rsmeral
 */
public class NamedApplicationMessagesProducer {
    
    @Produces
    @Typed()
    @Named("appMsg")
    public ApplicationMessages produce(ApplicationMessages appMessages) {
        return appMessages;
    }
    
}
