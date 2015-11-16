package com.davewhoyt.bg.controller.advice;

import com.davewhoyt.bg.common.Logging;
import com.davewhoyt.bg.common.exception.NoSuchUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller advice implementation, containing a simple exception handling strategy.
 */
@ControllerAdvice
public class ErrorAdvice implements Logging {

    @ExceptionHandler(value = RestClientException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleRuntimeException(RestClientException restException) {
        getLogger().warn("An error was encountered fetching rest data: ", restException);
        return new ModelAndView("error", "restException", restException);
    }


    @ExceptionHandler(value = {ServletRequestBindingException.class, NoSuchUserException.class})
    public ModelAndView notLoggedIn(Exception e, HttpServletRequest request) {
        if (e instanceof NoSuchUserException || e.getMessage().toLowerCase().contains("missing cookie")) {
            return new ModelAndView("login");
        }
        throw new RuntimeException(e);
    }

//    @ExceptionHandler(value = SnaFooException.class)
//    public @ResponseBody String handleSnaFooException(SnaFooException se, HttpServletResponse response) {
//        response.setStatus(500);
//        return se.snaFooErrorType.toString();
//    }
}
