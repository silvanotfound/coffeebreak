package com.coffeebreak;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidadeCpfTest {

    @Test
    @DisplayName("Deve validar se o CPF foi informado")
    public void CpfWasInformed() {
        ValidateDocument validadeCpf = new ValidadeCpf();
        String cpf = "";
        assertFalse(validadeCpf.validade(cpf));
    }

    @Test
    @DisplayName("Deve validar se o CPF tem um tamanho válido")
    public void hasValidSize() {
        ValidateDocument validadeCpf = new ValidadeCpf();
        String cpf = "011.157.7339-09";
        assertFalse(validadeCpf.validade(cpf));
    }

    @Test
    @DisplayName("Deve validar se todos os Digitos são iguais")
    public void areAllDigitsTheSame() {
        ValidateDocument validadeCpf = new ValidadeCpf();
        String cpf = "111.111.111-11";
        assertFalse(validadeCpf.validade(cpf));
    }

    @Test
    @DisplayName("Deve validar se o CPF é valido")
    public void isValidCPF() {
        ValidateDocument validadeCpf = new ValidadeCpf();
        String cpf = "011.157.789-12";
        assertFalse(validadeCpf.validade(cpf));
    }
}
