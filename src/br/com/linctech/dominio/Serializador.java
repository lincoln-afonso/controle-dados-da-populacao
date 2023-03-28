package br.com.linctech.dominio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {
    public static void gravar(Object object, String caminho) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(caminho);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            objectOutput.writeObject(object);
            objectOutput.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Object recuperar(String caminho) {
        Object objeto;
        try {
            FileInputStream fileInput = new FileInputStream(caminho);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            objeto = objectInput.readObject();
            objectInput.close();
            return objeto;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}