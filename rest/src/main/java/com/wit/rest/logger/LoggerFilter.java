package com.wit.rest.logger;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

import static com.wit.rest.utils.Constants.HEADER;
import static com.wit.rest.utils.Utils.generateUuid;
import static org.springframework.util.ObjectUtils.isEmpty;


@Component
public class LoggerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        MDC.clear();
        String operationHeader = generateRandomUuid(request);
        MDC.put(HEADER, operationHeader);

        filterChain.doFilter(request, response); // continues the operation
    }

    private String generateRandomUuid(HttpServletRequest request) {
        if (isEmpty(request.getHeader(HEADER))) {
            return generateUuid().toUpperCase(Locale.ROOT);
        }
        return request.getHeader(HEADER);
    }
}
