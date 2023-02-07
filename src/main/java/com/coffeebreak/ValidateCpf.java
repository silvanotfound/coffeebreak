package com.coffeebreak;

public class ValidateCpf implements ValidateDocument {

    private Integer CPF_VALID_LENGTH = 11;
    private Integer FIRST_DIGIT_FACTOR = 10;
    private Integer SECOND_DIGIT_FACTOR = 11;

    public Boolean validate(String document) {
        if (document.isEmpty()) {
            return false;
        }
        String cpf = this.cleanFormatting(document);
        if (cpf.length() != this.CPF_VALID_LENGTH) {
            return false;
        }
        if (this.AreAllDigitsTheSame(cpf)) {
            return false;
        }
        return this.isValidCpf(cpf);
    }

    private Boolean isValidCpf(String cpf) {
        String cpfWhitOutDigits = cpf.substring(0, 9);
        Integer firstDigit = this.calculateDigit(cpfWhitOutDigits, this.FIRST_DIGIT_FACTOR);
        Integer seconsdDigit = this.calculateDigit(cpfWhitOutDigits, this.SECOND_DIGIT_FACTOR);
        String calulatedDigits = firstDigit.toString() + seconsdDigit.toString();
        String cpfDigits = cpf.substring(9, 11);
        return cpfDigits.equals(calulatedDigits);
    }

    private Integer calculateDigit(String cpf, int factor) {
        Integer total = 0;
        for (char digit : cpf.toCharArray()) {
            total += Integer.valueOf(Character.getNumericValue(digit)) * factor--;
        }
        Integer rest = total % 11;
        return (rest < 2) ? 0 : 11 - rest;
    }

    private Boolean AreAllDigitsTheSame(String document) {
        int totalEquals = 0;
        for (char digit : document.toCharArray()) {
            totalEquals += digit == document.charAt(0) ? 1 : 0;
        }
        return totalEquals == this.CPF_VALID_LENGTH ? true : false;
    }

    private String cleanFormatting(String document) {
        return document.replaceAll("\\D", "");
    }
}
