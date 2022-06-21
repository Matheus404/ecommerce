package br.com.gubee.ecommerce.enumerations;

public enum MercadoAlvo {
	
    ECOMMERCE("Ecommerce"), 
    ERP("ERP"), 
    LOGISTA_NAO_POSSUI_ECOMMERCE("Lojista que não desejam possuir ecommerce"), 
    LOJA_FISICA("Loja fisica"), 
    VENDA_DIRETA("Venda direta"),
    MOBILE_FIRST("Mobile First"),
    DIGITAL_ONBOARDING("Digital Onboarding");
	
    private String descricao;

    MercadoAlvo(String valor) {
        descricao = valor;
    }

    public String getDescricao() {
        return descricao;
    }
	
}
