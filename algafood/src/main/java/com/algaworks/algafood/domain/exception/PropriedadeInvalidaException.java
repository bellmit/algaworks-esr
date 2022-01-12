package com.algaworks.algafood.domain.exception;

public class PropriedadeInvalidaException extends NegocioException{

    private String nomeClasse;
    private String propriedade;
    private String mensagem;

    public PropriedadeInvalidaException(Class classe, String propriedade, String mensagem) {
        super(String.format("%s.%s : %s", classe.getSimpleName(), propriedade, mensagem));

        this.nomeClasse = classe.getSimpleName();
        this.propriedade = propriedade;
        this.mensagem = mensagem;
    }

}
