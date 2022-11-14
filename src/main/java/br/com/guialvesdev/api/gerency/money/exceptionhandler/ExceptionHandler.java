package br.com.guialvesdev.api.gerency.money.exceptionhandler;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice //controla toda a aplicacao para pegar os erros
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;



    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String mensagemDev = ex.getCause().toString();
        List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario,mensagemDev));
        return handleExceptionInternal(ex, erros, headers,  HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleEmptyResultDataAcessException(EmptyResultDataAccessException ex, WebRequest request){
        String mensagemUsuario = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
        String mensagemDev = toString();
        List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDev));
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

    }






    private List<Erro> criarListaErro(BindingResult bindingResult){
        List<Erro> erros = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()){
            String mensagemUsuario = messageSource.getMessage(FieldError, LocaleContextHolder.getLocale());
            String mensagemDev = fieldError.toString();
            erros.add(new Erro(mensagemUsuario, mensagemDev));
        }
        return erros;
    }


    public static class Erro {
        private String mensagemUsuario;
        private String mensagemDev;


        public Erro(String mensagemUsuario, String mensagemDev) {
            this.mensagemUsuario = mensagemUsuario;
            this.mensagemDev = mensagemDev;
        }


        public String getMensagemUsuario() {
            return mensagemUsuario;
        }

        public String getMensagemDev() {
            return mensagemDev;
        }
    }






}
