package sample.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** AuthetificationSuccessHandler is the main entity we'll be using to . . .
 *
 * Please see the {@link com.baeldung.javadoc.SavedRequestAwareAuthenticationSuccessHandler} class for true identity
 * @author Goga Andrei
 *
 */

public class AuthetificationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public String determineTargetUrl(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication1.getAuthorities().toString();

        if (role.contains("Administrator"))
            return "/administratorHome";
        else if (role.contains("Doctor"))
            return "/doctorHome";
        else if (role.contains("Secretary"))
            return "/secretaryHome";
        return "";
    }
}
