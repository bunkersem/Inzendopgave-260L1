package internationalization;

import java.util.HashMap;

/**
 * Created by Sem on 09-Jul-17.
 */
public class LanguageProvider {

    public static String welcomeFrameTitle(final Language lang){
        switch (lang){
            case NL:
                return "Welkom | CityTours";
            default:
                return "Welcome | CityTours";
        }
    }

    public static String loginBtn(final Language lang){
        switch (lang){
            case NL:
                return "In Loggen";
            default:
                return "Login";
        }
    }

    public static String logOutBtn(final Language lang){
        switch (lang)
        {
            case NL:
                return "Log Uit";
            default:
                return "Logout";
        }
    }

    public static String toolbarUserMenu(final Language lang){
        switch (lang)
        {
            case NL:
                return "Gebruiker";
            default:
                return "User";
        }
    }

    public static String toolbarUserMenuDecription(final Language lang){
        switch (lang)
        {
            case NL:
                return "Via dit menu kunt u sebmenu's bereiken zoals, inloggen en uitloggen.";
            default:
                return "Via this menu item, you can easily acces sub-items like, the login and logout sub-items.";
        }
    }

    public static String registerBtn(final Language lang){
        switch (lang)
        {
            case NL:
                return "Registreren";
            default:
                return "Register";
        }
    }

    public static String helpMenu(final Language lang){
        switch (lang)
        {
            case NL:
                return "Help";
            default:
                return "Help";
        }
    }

    public static String adminLogin(final Language lang){
        switch (lang)
        {
            case NL:
                return "Administrator";
            default:
                return "Administrator";
        }
    }

    public static String helpMenuDescription(final Language lang){
        switch (lang)
        {
            case NL:
                return "Gebruik het help menu om handleidingen en documentatie te vinden";
            default:
                return "Use the help menu, to get documentation and support.";
        }
    }

    public static String welcome(final Language lang){
        switch (lang)
        {
            case NL:
                return "Welkom";
            default:
                return "Welcome";
        }
    }

    public static String businessLogo(final Language lang){
        switch (lang)
        {
            case NL:
                return "Bedrijfs logo";
            default:
                return "Business logo";
        }
    }

    public static String reservationBtn(final Language lang){
        switch (lang)
        {
            case NL:
                return "Reserveren";
            default:
                return "Order a Reservation";
        }
    }

    public static String reservationsListBtn(final Language lang){
        switch (lang)
        {
            case NL:
                return "Bekijk Reserveringen";
            default:
                return "View Reservations";
        }
    }

    public static String offersListBtn(final Language lang){
        switch (lang)
        {
            case NL:
                return "Bekijk Offertes";
            default:
                return "View Offers";
        }
    }

    public static String more(final Language lang){
        switch (lang)
        {
            case NL:
                return "Meer";
            default:
                return "More";
        }
    }

    public static String brochureType(final Language lang){
        switch (lang)
        {
            case NL:
                return "Welke brochure wilt de klant ontvangen?";
            default:
                return "Which brochure type would the client like to receive?";
        }
    }

    public static String brochureTypeOneDay(final Language lang){
        switch (lang)
        {
            case NL:
                return "Een dagje uit";
            default:
                return "A day out";
        }
    }

    public static String brochureTypeMultipleDays(final Language lang){
        switch (lang)
        {
            case NL:
                return "Meerdaagse reizen";
            default:
                return "Multi-day trip";
        }
    }

    public static String brochureTypeWinterSports(final Language lang){
        switch (lang)
        {
            case NL:
                return "Wintersport groepenpendel";
            default:
                return "Winter sports, shuttle bus.";
        }
    }

    public static String name(final Language lang){
        switch (lang)
        {
            case NL:
                return "Naam";
            default:
                return "Name";
        }
    }

    public static String adress(final Language lang){
        switch (lang)
        {
            case NL:
                return "Adres";
            default:
                return "Adress";
        }
    }

    public static String postalCode(final Language lang){
        switch (lang)
        {
            case NL:
                return "Postcode";
            default:
                return "Postal code";
        }
    }

    public static String placeOfResidence(final Language lang){
        switch (lang)
        {
            case NL:
                return "Woonplaats";
            default:
                return "Place of residence";
        }
    }

    public static String phone(final Language lang){
        switch (lang)
        {
            case NL:
                return "Telefoon";
            default:
                return "Phone";
        }
    }

    public static String mobilePhone(final Language lang){
        switch (lang)
        {
            case NL:
                return "Mobiele telefoon";
            default:
                return "Mobile phone";
        }
    }

    public static String email(final Language lang){
        switch (lang)
        {
            case NL:
                return "E-Mail";
            default:
                return "E-Mail";
        }
    }

    public static String whichDestination(final Language lang){
        switch (lang)
        {
            case NL:
                return "Welke vakantiebestemming";
            default:
                return "Which destination";
        }
    }

    public static String remarksOrSupplements(final Language lang){
        switch (lang)
        {
            case NL:
                return "Opmerkingen en/of aanvullingen";
            default:
                return "Remarks and/or supplements";
        }
    }

    public static String clientCallback(final Language lang){
        switch (lang)
        {
            case NL:
                return "Klant terugbellen?";
            default:
                return "Call client back?";
        }
    }

    public static String requestBrochure(final Language lang){
        switch (lang)
        {
            case NL:
                return "Vraag een brochure aan.";
            default:
                return "Request a brochure.";
        }
    }

    public static String paris(final Language lang){
        switch (lang)
        {
            case NL:
                return "Parijs";
            default:
                return "Paris";
        }
    }

    public static String berlin(final Language lang){
        switch (lang)
        {
            case NL:
                return "Berlijn";
            default:
                return "Berlin";
        }
    }

    public static String london(final Language lang){
        switch (lang)
        {
            case NL:
                return "London";
            default:
                return "London";
        }
    }

    public static String submit(final Language lang){
        switch (lang)
        {
            case NL:
                return "Verzenden";
            default:
                return "Submit";
        }
    }

    public static String alreadyLoggedIn(final Language lang){
        switch (lang)
        {
            case NL:
                return "Je bent al ingelogd. Log alstublieft eerst uit.";
            default:
                return "You are already logged in. Please logout first.";
        }
    }

    public static String logginFailed(final Language lang){
        switch (lang)
        {
            case NL:
                return "Login mislukt. Er heeft een interne fout plaatsgevonden";
            default:
                return "Failed to login, an internal error occurred.";
        }
    }

    public static String internalError(final Language lang){
        switch (lang)
        {
            case NL:
                return "Er heeft een interne fout plaatsgevonden";
            default:
                return "An internal error occurred.";
        }
    }

    public static String logoutFailedNoUserLoggedIn(final Language lang){
        switch (lang)
        {
            case NL:
                return "Uitloggen mislukt. Er was niemand ingelogd.";
            default:
                return "Failed to logout. No user was logged in.";
        }
    }

    public static String unautheticatedFrameRequest(final Language lang){
        switch (lang)
        {
            case NL:
                return "Kan deze window niet openen. Je moest eerst ingelogd zijn. Klik op de menubalk -> inloggen. Om in te loggen.";
            default:
                return "Can not open this window. You have to be logged in first. Press the menubar -> login to login.";
        }
    }

    public static String password(final Language lang){
        switch (lang)
        {
            case NL:
                return "Wachtwoord";
            default:
                return "Password";
        }
    }

    public static String loginFrameTitle(final Language lang){
        switch (lang)
        {
            case NL:
                return "Inloggen";
            default:
                return "Login";
        }
    }

    public static String incorrectCredentials(final Language lang){
        switch (lang)
        {
            case NL:
                return "Onjuiste inloggegevens.";
            default:
                return "Incorrect login credentials.";
        }
    }

    public static String orderReservation(final Language lang){
        switch (lang)
        {
            case NL:
                return "Reserveren";
            default:
                return "Order";
        }
    }

    public static String notLoggedIn(final Language lang){
        switch (lang)
        {
            case NL:
                return "U moet eerst inloggen.";
            default:
                return "You have to be logged in first.";
        }
    }

    public static String remove(final Language lang){
        switch (lang)
        {
            case NL:
                return "Verwijderen";
            default:
                return "Remove";
        }
    }

    public static String unauthorized(final Language lang){
        switch (lang)
        {
            case NL:
                return "U hebt niet de juiste gebruikers rechten om deze operatie te voltooien.";
            default:
                return "You do not have the right credentials to complete this operation.";
        }
    }

    public static String language(final Language lang){
        switch (lang)
        {
            case NL:
                return "Taal";
            default:
                return "Language";
        }
    }

    public static String restartFirstBeforeLanguageChange(final Language lang){
        switch (lang)
        {
            case NL:
                return "Om het Nederlands als standaard taal de gebruiken moet u eerst de applicatie opnieuw opstarten.";
            default:
                return "To use English as a your standard language, you need to restart the application.";
        }
    }




}
