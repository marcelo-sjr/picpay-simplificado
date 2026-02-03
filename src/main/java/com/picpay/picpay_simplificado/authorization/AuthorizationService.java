package com.picpay.picpay_simplificado.authorization;

import com.picpay.picpay_simplificado.dto.TransactionRequest;
import com.picpay.picpay_simplificado.exception.NotAuthorizedException;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizationService {

    private RestClient restClient;

    public AuthorizationService() {
        restClient = RestClient.builder().baseUrl("http://localhost:8080/mock/authorization").build();
    }

    public void authorize(TransactionRequest request) {
        var authorizationResponse = restClient.method(HttpMethod.GET).accept(MediaType.APPLICATION_JSON).retrieve().body(Authorization.class);
        if (!authorizationResponse.authorization()) {
            throw new NotAuthorizedException("transaction not authorized: payer: %s, payee %s, amount %s".formatted(request.payer(),request.payee(), request.value()));
        }
    }
}
