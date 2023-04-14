package com.will.hexagonal.application.ports.out;

public interface SendCpfValidationOutPutPort {

    void send(String cpf);
}
