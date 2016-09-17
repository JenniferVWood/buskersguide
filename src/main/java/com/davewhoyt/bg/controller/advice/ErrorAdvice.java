package com.davewhoyt.bg.controller.advice;

import com.davewhoyt.bg.common.Logging;
import com.davewhoyt.bg.common.exception.NoSuchUserException;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.util.ThrowableAnalyzer;
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

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleRuntimeException(Throwable exception) {
        getLogger().error("An error was encountered fetching rest data: ", exception);
        return new ModelAndView("error", "restException", exception);
    }



}
