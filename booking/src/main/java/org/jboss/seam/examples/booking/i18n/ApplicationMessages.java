/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.seam.examples.booking.i18n;

import org.apache.deltaspike.core.api.message.annotation.MessageBundle;
import org.apache.deltaspike.core.api.message.annotation.MessageTemplate;

/**
 *
 * @author rsmeral
 */

@MessageBundle
public interface ApplicationMessages {
    
    @MessageTemplate("{booking_initiated}")
    String bookingInitiated(String hotelName);

    @MessageTemplate("{booking_checkInNotFutureDate}")
    String bookingCheckInNotFutureDate();

    @MessageTemplate("{booking_checkOutBeforeCheckIn}")
    String bookingCheckOutBeforeCheckIn();

    @MessageTemplate("{booking_confirmed}")
    String bookingConfirmed(String hotelName, String date);

    @MessageTemplate("{booking_canceled}")
    String bookingCanceled(String hotelName, String date);

    @MessageTemplate("{booking_doesNotExist}")
    String bookingDoesNotExist();

    @MessageTemplate("{account_passwordChanged}")
    String accountPasswordChanged();

    @MessageTemplate("{account_passwordNotConfirmed}")
    String accountPasswordNotConfirmed();

    @MessageTemplate("{account_passwordsDoNotMatch}")
    String accountPasswordsDoNotMatch();

    @MessageTemplate("{account_usernameTaken}")
    String accountUsernameTaken(String userName);

    @MessageTemplate("{registration_registered}")
    String registrationRegistered(String userName);

    @MessageTemplate("{registration_invalid}")
    String registrationInvalid();

    @MessageTemplate("{identity_loggedOut}")
    String identityLoggedOut();

    @MessageTemplate("{identity_loggedIn}")
    String identityLoggedIn(String userName);

    @MessageTemplate("{identity_loginFailed}")
    String identityLoginFailed();

    @MessageTemplate("{home_header}")
    String homeHeader();

    @MessageTemplate("{home_body}")
    String homeBody();

    @MessageTemplate("{home_note}")
    String homeNote();

    @MessageTemplate("{home_usernameLabel}")
    String homeUsernameLabel();

    @MessageTemplate("{home_passwordLabel}")
    String homePasswordLabel();

    @MessageTemplate("{home_loginAction}")
    String homeLoginAction();

    @MessageTemplate("{home_registerAction}")
    String homeRegisterAction();

    @MessageTemplate("{home_useDemoAccount}")
    String homeUseDemoAccount();

    @MessageTemplate("{template_linkHome}")
    String templateLinkHome();

    @MessageTemplate("{template_linkHotels}")
    String templateLinkHotels();

    @MessageTemplate("{template_linkLogin}")
    String templateLinkLogin();

    @MessageTemplate("{template_linkAccount}")
    String templateLinkAccount();

    @MessageTemplate("{template_linkLogout}")
    String templateLinkLogout();

    @MessageTemplate("{template_linkReset}")
    String templateLinkReset();

    @MessageTemplate("{template_createdWith}")
    String templateCreatedWith();

    @MessageTemplate("{template_currentConversation}")
    String templateCurrentConversation();

    @MessageTemplate("{template_projectStage}")
    String templateProjectStage();

    @MessageTemplate("{template_title}")
    String templateTitle();
}
