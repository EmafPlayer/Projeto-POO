package main;

import main.projetoExtensao.controllers.ControllerInicio;

import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ControllerInicio controller = new ControllerInicio();
        controller.dessserializacao();
        controller.iniciarMenu();
        controller.serializacao();
    }

}